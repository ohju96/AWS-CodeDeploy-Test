package com.api.test.NameConfiguration;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NameConfiguration {

    public CloseableHttpClient httpClient() {
        return HttpClients.createDefault();
    }
}
