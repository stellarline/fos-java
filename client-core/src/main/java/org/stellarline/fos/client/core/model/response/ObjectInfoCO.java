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
public class ObjectInfoCO extends ClientObject {

    private String id;

    private String bucketName;

    private String objectName;

    private String objectPath;

    private String contentType;

    private Long contentLength;

    private String extensionName;

    private String signature;

    private Date created;

    private Date modified;

    private String creator;

    private String modifier;
}
