package org.openrpg.monstercompendium.controller;

import org.openrpg.monstercompendium.mapper.MonsterMapper;
import org.openrpg.monstercompendium.repository.MonsterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/monster_field")
public class MonsterFieldController {

    @Autowired
    private MonsterMapper monsterMapper;
    @Autowired
    private MonsterRepository monsterRepository;


}
