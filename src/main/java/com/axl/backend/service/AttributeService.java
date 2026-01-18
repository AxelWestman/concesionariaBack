package com.axl.backend.service;

import com.axl.backend.model.Attribute;
import com.axl.backend.dto.AttributeDTO;
import com.axl.backend.repository.AttributeRepository;
import org.springframework.stereotype.*;
import java.util.List;
import org.w3c.dom.Attr;

@Service
public class AttributeService {

    private final AttributeRepository attributeRepository;

    public AttributeService(AttributeRepository attributeRepository){
        this.attributeRepository = attributeRepository;
    }

    public Attribute createAttribute(AttributeDTO dto){
        Attribute attribute = new Attribute(
                dto.getName(),
                dto.getData_type()
        );

        return this.attributeRepository.save(attribute);

    }

    public List<Attribute> findAllAttributes(){
        return attributeRepository.findAll();
    }

    public Attribute findAttributeId(Long id){
        Attribute attribute = this.attributeRepository.findById(id).orElseThrow(() -> new RuntimeException("Attribute not found"));
        return attribute;
    }

    public Attribute deleteAttribute(Long id){
        Attribute attribute = this.findAttributeId(id);
        attributeRepository.delete(attribute);
        return attribute;
    }



}
