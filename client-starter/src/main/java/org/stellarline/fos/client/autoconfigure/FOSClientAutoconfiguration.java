package org.stellarline.fos.client.autoconfigure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.stellarline.fos.client.core.FOSClient;
import org.stellarline.fos.client.core.FOSClientBuilder;

/**
 * @author leanderlee
 * @since 1.0.0
 */
@Configuration
@EnableConfigurationProperties(FOSClientProperties.class)
@ConditionalOnClass(FOSClient.class)
public class FOSClientAutoconfiguration {

    final private FOSClientProperties properties;

    public FOSClientAutoconfiguration(FOSClientProperties properties) {
        this.properties = properties;
    }

    @Bean
    public FOSClient fosClient() {
        FOSClientBuilder fosClientBuilder = new FOSClientBuilder();
        fosClientBuilder.setServerUrl(properties.getServerUrl());
        fosClientBuilder.setAccessKey(properties.getAccessKey());
        fosClientBuilder.setAccessSecret(properties.getAccessSecret());
        fosClientBuilder.setConnectionTimeout(properties.getConnectionTimeout());
        fosClientBuilder.setLogEnabled(properties.getLogEnabled());
        return fosClientBuilder.build();
    }
}
