package org.openrpg.monstercompendium.service;

import org.openrpg.monstercompendium.repository.MonsterFieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonsterFieldService {

    @Autowired
    MonsterFieldRepository monsterFieldRepository;
}
