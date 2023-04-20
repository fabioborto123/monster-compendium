package org.openrpg.monstercompendium.service;

import ch.qos.logback.core.html.IThrowableRenderer;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.hibernate.action.internal.EntityUpdateAction;
import org.openrpg.monstercompendium.dto.MonsterDto;
import org.openrpg.monstercompendium.entity.Field;
import org.openrpg.monstercompendium.entity.Monster;
import org.openrpg.monstercompendium.entity.MonsterField;
import org.openrpg.monstercompendium.entity.Template;
import org.openrpg.monstercompendium.repository.FieldRepository;
import org.openrpg.monstercompendium.repository.MonsterFieldRepository;
import org.openrpg.monstercompendium.repository.MonsterRepository;
import org.openrpg.monstercompendium.repository.TemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class MonsterService {

    @Autowired
    private MonsterFieldRepository monsterFieldRepository;
    @Autowired
    private FieldRepository fieldRepository;

    @Autowired
    private MonsterRepository monsterRepository;

    @Autowired
    private TemplateRepository templateRepository;

    public Monster save(Monster monster) {
        Template template = templateRepository.getReferenceById(monster.getTemplate().getId());
        monster.setTemplate(template);

        for (MonsterField monsterField : monster.getMonsterFields()) {
            monsterField.setMonster(monster);
            monsterField.setField(fieldRepository.getReferenceById(monsterField.getField().getId()));
            if (monsterField.getField().getActive()) {
                monsterFieldRepository.save(monsterField);
            }
        }
       return monsterRepository.save(monster);
    }

    public Monster findById(BigInteger id) {
        return monsterRepository.getReferenceById(id);
    }


    public void update(BigInteger id, Monster newMonster) {
        Monster savedMonster = monsterRepository.getReferenceById(id);
        savedMonster.setName(newMonster.getName());

        for (MonsterField newMonsterField: newMonster.getMonsterFields()) {
            Field field = fieldRepository.getReferenceById(newMonsterField.getField().getId());
            if (newMonsterField.getId() == null && field.getActive()) {
                newMonsterField.setField(field);
                newMonsterField.setMonster(savedMonster);
                monsterFieldRepository.save(newMonsterField);
            } else
                savedMonster.getMonsterFields().stream()
                        .filter(mf -> mf.getId().equals(newMonsterField.getId()))
                        .forEach(mf -> mf.setValue(newMonsterField.getValue()));
        }
        monsterRepository.save(savedMonster);
    }

    public void deleteMonsterById(BigInteger id) {
        monsterRepository.deleteById(id);
    }
}
