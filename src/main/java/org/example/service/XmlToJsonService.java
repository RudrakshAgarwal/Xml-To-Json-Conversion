package org.example.service;
import org.example.converter.XmlToJsonConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XmlToJsonService {
    private static final Logger logger = LoggerFactory.getLogger(XmlToJsonService.class);
    private final XmlToJsonConverter converter;

    public XmlToJsonService() {
        this.converter = new XmlToJsonConverter();
    }

    /**
     * Processes the XML input and returns the converted JSON
     */
    public String processXml(String xmlInput) {
        logger.info("Processing XML input");
        try {
            return converter.convertXmlToJson(xmlInput);
        } catch (XmlToJsonConverter.XmlToJsonConverterException e) {
            logger.error("Error processing XML", e);
            throw new RuntimeException("Failed to process XML: " + e.getMessage(), e);
        }
    }
}
