package com.axl.backend.controller;

import com.axl.backend.model.Attribute;
import com.axl.backend.dto.AttributeDTO;
import com.axl.backend.service.AttributeService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/attribute")
public class AttributeController {

    private final AttributeService attributeService;

    public AttributeController(AttributeService attributeService){
        this.attributeService = attributeService;
    }

    @PostMapping("/crearAtributo")
    public ResponseEntity<?> createAttribute(@RequestBody AttributeDTO dto){
        try{
            Attribute attribute = this.attributeService.createAttribute(dto);
            return ResponseEntity.ok(attribute);
        }
        catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
        }
    }

    @GetMapping("/obtenerTodosLosAtributos")
    public ResponseEntity<List<Attribute>> getAllAttributes(){
       return ResponseEntity.ok(attributeService.findAllAttributes());
    }

    @GetMapping("/obtenerAtributoPorId/{id}")
    public ResponseEntity<?> getAttribute(@PathVariable Long id){
        try{
            Attribute attribute = this.attributeService.findAttributeId(id);
            return ResponseEntity.ok(attribute);
        }
        catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
        }
    }

    @DeleteMapping("/eliminarAtributo/{id}")
    public ResponseEntity<?> deleteAttribute(@PathVariable Long id){
        try{
            Attribute attribute = this.attributeService.deleteAttribute(id);
            return ResponseEntity.ok(attribute);
        }
        catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.getMessage());
        }
    }

}
