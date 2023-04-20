package org.openrpg.monstercompendium.service;

import jakarta.transaction.Transactional;
import org.openrpg.monstercompendium.entity.Field;
import org.openrpg.monstercompendium.entity.MonsterField;
import org.openrpg.monstercompendium.entity.Template;
import org.openrpg.monstercompendium.repository.FieldRepository;
import org.openrpg.monstercompendium.repository.MonsterFieldRepository;
import org.openrpg.monstercompendium.repository.TemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TemplateService {

    @Autowired
    private MonsterFieldRepository monsterFieldRepository;

    @Autowired
    private TemplateRepository templateRepository;

    @Autowired FieldRepository fieldRepository;

    public Template save(Template template) {
        List<Field> templateFields = template.getFields();
        for (Field field : templateFields) {
            field.setTemplate(template);
        }
        return templateRepository.save(template);
    }

    public Template findById(BigInteger id) {
        Template template = templateRepository.getReferenceById(id);
        if (template.getShowDisabledFields().equals(false)){
            List<Field> fields = template.getFields()
                .stream()
                .filter(field -> field.getActive().equals(true))
                .collect(Collectors.toList());
                template.setFields(fields);
        }
        return template;
    }

    public void deleteTemplateById(BigInteger id) {
        templateRepository.deleteById(id);
    }


    public void update(BigInteger id, Template newTemplate) {
        Template savedTemplate = templateRepository.getReferenceById(id);
        savedTemplate.getFields().forEach(savedField -> savedField.setActive(false));

        for (Field newField: newTemplate.getFields()) {
            if (newField.getId() == null) {
                savedTemplate.getFields().add(newField);
                newField.setTemplate(savedTemplate);
                newField.setActive(true);
            } else
                savedTemplate.getFields().stream()
                        .filter(savedField -> savedField.getId().equals(newField.getId()))
                        .forEach(savedField -> {
                            savedField.setActive(true);
                            savedField.setName(newField.getName());
                        });
        }
        savedTemplate.setName(newTemplate.getName());
        savedTemplate.setFields(savedTemplate.getFields());
        savedTemplate.setShowDisabledFields(newTemplate.getShowDisabledFields());

        savedTemplate.getFields().stream()
                .filter(field -> !field.getActive())
                .forEach(field -> monsterFieldRepository.deleteByFieldId(field.getId()));

        templateRepository.save(savedTemplate);
    }

}

