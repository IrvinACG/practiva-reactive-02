package com.iacg.app.app.utils;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JsonMapper {

	@Autowired
	private ObjectMapper mapper;
	
	public <T> T stringToClazz(String json, Class<T> clazz){
		T generic = null;
		if(Objects.nonNull(json)) {
			try {
				generic = mapper.readValue(json, clazz);
			} catch (JsonProcessingException e) {
				log.error("Error al procesar String(Json) a Clase, error: {}",e.getMessage());
			}
		}
		return generic;
	}
	
}
