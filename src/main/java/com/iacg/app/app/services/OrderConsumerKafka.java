package com.iacg.app.app.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.iacg.app.app.services.dto.OrderDTO;
import com.iacg.app.app.utils.JsonMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderConsumerKafka implements IConsumerKafka{
	
	private final JsonMapper mapper;
	
	public OrderConsumerKafka(JsonMapper mapper) {
		this.mapper = mapper;
	}

	@KafkaListener(topics = "topic-prueba", groupId = "group_prueba")
	@Override
	public void consume(String message) {
		
		OrderDTO order = mapper.stringToClazz(message, OrderDTO.class);
		log.info("Orden recibida: {}", order.toString());
	}

}
