package org.example;
import org.example.service.XmlToJsonService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App 
{
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        logger.info("Starting XML to JSON conversion application");

        // Sample XML input
        String xmlInput = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<Response>\n" +
                "<ResultBlock>\n" +
                "<ErrorWarnings>\n" +
                "<Errors errorCount=\"0\" />\n" +
                "<Warnings warningCount=\"1\">\n" +
                "<Warning>\n" +
                "<Number>102001</Number>\n" +
                "<Message>Minor mismatch in address</Message>\n" +
                "<Values>\n" +
                "<Value>Bellandur</Value>\n" +
                "<Value>Bangalore</Value>\n" +
                "</Values>\n" +
                "</Warning>\n" +
                "</Warnings>\n" +
                "</ErrorWarnings>\n" +
                "<MatchDetails>\n" +
                "<Match>\n" +
                "<Entity>John</Entity>\n" +
                "<MatchType>Exact</MatchType>\n" +
                "<Score>35</Score>\n" +
                "</Match>\n" +
                "<Match>\n" +
                "<Entity>Doe</Entity>\n" +
                "<MatchType>Exact</MatchType>\n" +
                "<Score>50</Score>\n" +
                "</Match>\n" +
                "</MatchDetails>\n" +
                "<API>\n" +
                "<RetStatus>SUCCESS</RetStatus>\n" +
                "<ErrorMessage />\n" +
                "<SysErrorCode />\n" +
                "<SysErrorMessage />\n" +
                "</API>\n" +
                "</ResultBlock>\n" +
                "</Response>";

        XmlToJsonService service = new XmlToJsonService();

        try {
            String jsonOutput = service.processXml(xmlInput);
            logger.info("Conversion completed successfully");
            System.out.println("\n--- Converted JSON Output ---");
            System.out.println(jsonOutput);
        } catch (Exception e) {
            logger.error("Error in XML to JSON conversion", e);
            System.err.println("Error converting XML to JSON: " + e.getMessage());
        }

    }
}
