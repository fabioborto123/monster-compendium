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
import java.util.stream.Collectors;

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

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTemplateById(@PathVariable BigInteger id) {
        templateService.deleteTemplateById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<TemplateDto> updateTemplate(@RequestParam BigInteger id, @RequestBody TemplateDto templateDto){
        templateService.update(id, templateMapper.toEntity(templateDto));
        return ResponseEntity.ok().build();
    }

}










