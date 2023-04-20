package org.openrpg.monstercompendium.controller;

import org.openrpg.monstercompendium.entity.Field;
import org.openrpg.monstercompendium.entity.Template;
import org.openrpg.monstercompendium.mapper.FieldMapper;
import org.openrpg.monstercompendium.repository.FieldRepository;
import org.openrpg.monstercompendium.service.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@RequestMapping("/fields")
public class FieldController {

    @Autowired
    private FieldMapper fieldMapper;

    @Autowired
    private FieldService fieldService;

    }

