package org.openrpg.monstercompendium.service;

import org.aspectj.apache.bcel.generic.InstructionList;
import org.aspectj.apache.bcel.generic.ObjectType;
import org.openrpg.monstercompendium.entity.Field;
import org.openrpg.monstercompendium.entity.Template;
import org.openrpg.monstercompendium.repository.FieldRepository;
import org.openrpg.monstercompendium.repository.TemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TemplateService {

    @Autowired
    private TemplateRepository templateRepository;
    private FieldRepository fieldRepository;

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


    public void deleteById(Field field) {
    }


    public void update(BigInteger id, Template newTemplate) {
        Template savedTemplate = templateRepository.getReferenceById(id);

        for (Field savedField: savedTemplate.getFields()){
            savedField.setActive(false);
        }
        for (Field newField: newTemplate.getFields()){
            newField.setTemplate(savedTemplate);
            newField.setActive(true);
        }
        savedTemplate.setName(newTemplate.getName());
        savedTemplate.setFields(newTemplate.getFields());
        savedTemplate.setShowDisabledFields(newTemplate.getShowDisabledFields());
        templateRepository.save(savedTemplate);
    }
}

