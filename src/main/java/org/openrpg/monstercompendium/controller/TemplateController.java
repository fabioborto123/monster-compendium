package org.openrpg.monstercompendium.controller;

import org.openrpg.monstercompendium.dto.TemplateDto;
import org.openrpg.monstercompendium.entity.Field;
import org.openrpg.monstercompendium.entity.Template;
import org.openrpg.monstercompendium.mapper.TemplateMapper;
import org.openrpg.monstercompendium.service.FieldService;
import org.openrpg.monstercompendium.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/templates")
public class TemplateController {


    @Autowired
    private TemplateMapper templateMapper;

    @Autowired
    private TemplateService templateService;


    @PostMapping
    public ResponseEntity<?> createTemplate(@RequestBody TemplateDto templateDto){
        Template template = templateService.save(templateMapper.toEntity(templateDto));
        return ResponseEntity.created(URI.create("/templates/" + template.getId())).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TemplateDto> getTemplateById(@PathVariable BigInteger id) {
        return ResponseEntity.ok(templateMapper.toDto(templateService.findById(id)));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteTemplateById(@PathVariable BigInteger id) {
        templateService.deleteTemplateById(id);
        return ResponseEntity.ok().build();
    }



    @PutMapping
    public ResponseEntity<TemplateDto> updateTemplateName(@RequestParam BigInteger id, @RequestParam String newName){
        Template template = templateService.findById(id);
        template.setName(newName);
        templateService.save(template);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{templateId}/{fieldId}")
    public ResponseEntity<?> deleteTemplateField(@RequestParam BigInteger templateId, @RequestParam Integer fieldId){
        Template template = templateService.findById(templateId);
        Field field = template.getFields().get(fieldId);
        templateService.deleteById(field);
        return ResponseEntity.ok().build();
    }



}










