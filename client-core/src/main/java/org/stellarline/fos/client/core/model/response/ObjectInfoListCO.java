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
public class ObjectInfoListCO extends ClientObject {

    private String id;

    private String bucketName;

    private String objectName;

    private String objectPath;

    private String objectType;

    private String contentType;

    private String extensionName;

    private String contentLength;

    private Date created;

    private Date modified;

    private String creator;

    private String modifier;
}
