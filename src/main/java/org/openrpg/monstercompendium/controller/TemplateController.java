package org.openrpg.monstercompendium.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/templates")
public class TemplateController {


    @GetMapping
    public ResponseEntity getTemplates(){
        return ResponseEntity.ok("Teste");
    }

}
