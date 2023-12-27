package org.stellarline.fos.client.core;

import lombok.Getter;

/**
 * @author leanderlee
 * @since 1.0.0
 */
@Getter
public class FOSClientBuilder {

    private String serverUrl;
    private String accessKey;
    private String accessSecret;

    public FOSClientBuilder setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
        return this;
    }

    public FOSClientBuilder setAccessKey(String accessKey) {
        this.accessKey = accessKey;
        return this;
    }

    public FOSClientBuilder setAccessSecret(String accessSecret) {
        this.accessSecret = accessSecret;
        return this;
    }

    public FOSClient build() {
        return new FOSClient(this);
    }


}
