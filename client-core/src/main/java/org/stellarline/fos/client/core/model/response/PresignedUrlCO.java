package org.stellarline.fos.client.core.model.response;

import com.alibaba.cola.dto.ClientObject;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author leanderlee
 * @since 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PresignedUrlCO extends ClientObject {

    private String presignedUrl;

    private Date expiresAt;

    private Integer availableTimes;
}
