package com.api.filters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.json.JSONObject;
import reporting.ExtentReportManager;

public class LoggingFilter implements Filter {

    private static final Logger logger = LogManager.getLogger(LoggingFilter.class);
    private static final String MASK = "****";

    @Override
    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
                           FilterContext ctx) {
        logRequest(requestSpec);
        Response response = ctx.next(requestSpec, responseSpec); // Execute the request
        logResponse(response);

        return response; // Return the response for assertion
    }

    public void logRequest(FilterableRequestSpecification requestSpec) {
        String maskedBody = maskSensitiveData(requestSpec.getBody());
        logger.info("BASE URI: " + requestSpec.getBaseUri());
        logger.info("Request Header: " + requestSpec.getHeaders());
        logger.info("Request PayLoad: " + maskedBody);

        ExtentReportManager.logInfo("BASE URI: " + requestSpec.getBaseUri());
        ExtentReportManager.logInfo("Request Header: " + requestSpec.getHeaders());
        ExtentReportManager.logInfo("Request PayLoad: " + maskedBody);
    }

    public void logResponse(Response response) {
        String maskedBody = maskSensitiveData(response.getBody().asString());
        logger.info("STATUS CODE: " + response.getStatusCode());
        logger.info("Response Header: " + response.headers());
        logger.info("Response Body: " + response.getBody().prettyPrint());

        ExtentReportManager.logInfo("STATUS CODE: " + response.getStatusCode());
        ExtentReportManager.logInfo("Response Header: " + response.headers());
        ExtentReportManager.logInfo("Response Body: " + maskedBody);
    }

    private String maskSensitiveData(Object body) {
        if (body == null || !(body instanceof String)) {
            return String.valueOf(body); // Return as is if body is not a string
        }

        try {
            JSONObject json = new JSONObject((String) body);
            // List of keys to mask
            String[] sensitiveKeys = {"password", "token", "secret"};

            for (String key : sensitiveKeys) {
                if (json.has(key)) {
                    json.put(key, MASK); // Replace sensitive data with mask
                }
            }
            return json.toString(2); // Pretty-print the JSON
        } catch (Exception e) {
            logger.warn("Failed to parse request body for masking. Returning original body.");
            return (String) body; // Return original body if parsing fails
        }
    }
}
