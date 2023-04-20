package org.openrpg.monstercompendium.controller;
import org.openrpg.monstercompendium.dto.MonsterDto;
import org.openrpg.monstercompendium.entity.Monster;
import org.openrpg.monstercompendium.mapper.MonsterMapper;
import org.openrpg.monstercompendium.service.MonsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/monsters")
public class MonsterController{

    @Autowired
    private MonsterMapper monsterMapper;
    @Autowired
    private MonsterService monsterService;


    @PostMapping
    public ResponseEntity<?> createMonster(@RequestBody MonsterDto monsterDto){
        Monster monster = monsterService.save(monsterMapper.toEntity(monsterDto));
        return ResponseEntity.created(URI.create("/monsters/" + monster.getId())).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MonsterDto> getMonster(@PathVariable BigInteger id) {
        return ResponseEntity.ok(monsterMapper.toDto(monsterService.findById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MonsterDto> updateMonster(@PathVariable BigInteger id, @RequestBody(required = false) MonsterDto monsterDto){
        monsterService.update(id, monsterMapper.toEntity(monsterDto));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMonster(@PathVariable BigInteger id){
        monsterService.deleteMonsterById(id);
        return ResponseEntity.ok().build();
    }

}
