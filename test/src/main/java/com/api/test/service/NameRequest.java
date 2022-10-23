package com.api.test.service;

import com.api.test.NameConfiguration.NameConfiguration;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@RequiredArgsConstructor
@Service
public class NameRequest {

    private final NameConfiguration nameConfiguration;
    private final static Logger log = LoggerFactory.getLogger(NameConfiguration.class);

    @Value("${test.url}")
    String testUrl;

    public String getName() throws URISyntaxException, IOException {
        log.info("### .getName start : " + testUrl);
        return requestName(testUrl);
    }

    private String requestName(String testUrl) throws URISyntaxException, IOException {
        log.info("### .requestName");

        HttpGet requestName = new HttpGet();
        requestName.setURI(new URI(testUrl));
        requestName.addHeader("content-type", "application/json");
        requestName.setHeader("Accept", "application/json");
        log.info("### requestName : {}", requestName);

        CloseableHttpResponse response = nameConfiguration.httpClient().execute(requestName);
        log.info("### response : {}", response);

        HttpEntity responseEntity = response.getEntity();
        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode nameData = objectMapper.readTree(responseEntity.getContent()).get("name");

        return nameData.toString();
    }
}
