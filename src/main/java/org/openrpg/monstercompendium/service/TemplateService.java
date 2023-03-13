package org.openrpg.monstercompendium.service;

import org.openrpg.monstercompendium.entity.Field;
import org.openrpg.monstercompendium.entity.Template;
import org.openrpg.monstercompendium.repository.TemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class TemplateService {

    @Autowired
    private TemplateRepository templateRepository;
    public Template save(Template template) {
        return templateRepository.save(template);
    }

    public Template findById(BigInteger id) {
        return templateRepository.getReferenceById(id);
    }

    public void deleteTemplateById(BigInteger id) {templateRepository.deleteById(id);}


    public void deleteById(Field field) {
    }
}

