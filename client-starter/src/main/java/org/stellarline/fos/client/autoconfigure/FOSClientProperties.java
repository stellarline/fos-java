package org.stellarline.fos.client.autoconfigure;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author leanderlee
 * @since 1.0.0
 */
@ConfigurationProperties(prefix = "org.stellarline.fos.client")
@Data
public class FOSClientProperties {

    private String serverUrl;

    private String accessKey;

    private String accessSecret;
    /**
     * 连接超时时间，单位秒
     */
    private Integer connectionTimeout = 10;

    private Boolean logEnabled = true;
}
