package com.redhat.demo;

import java.nio.charset.StandardCharsets;

import org.apache.camel.component.kafka.serde.KafkaHeaderDeserializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HeaderDeserializer implements KafkaHeaderDeserializer {

	private static final Logger LOGGER = LoggerFactory.getLogger(HeaderDeserializer.class);

    @Override
    public Object deserialize(String key, byte[] value) {
        LOGGER.info("Deserializer received key: " + key);
        if ("uber-trace-id".equals(key) || "kafka.TOPIC".equals(key)) {
            LOGGER.info("Deserializing {}", key);
            return new String(value, StandardCharsets.UTF_8);
        } else {
            return value;
        }
    }
}