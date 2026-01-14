package com.axl.backend.service;

import com.axl.backend.model.Attribute;
import com.axl.backend.dto.AttributeDTO;
import com.axl.backend.repository.AttributeRepository;
import org.springframework.stereotype.*;

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

    public Attribute findAttributeId(Long id){
        Attribute attribute = this.attributeRepository.findById(id).orElseThrow(() -> new RuntimeException("Attribute not found"));
        return attribute;
    }

}
