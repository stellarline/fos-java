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
public class BucketCO extends ClientObject {

    private String id;

    private String bucketName;
    /**
     * 已使用空间
     */
    private Long usageSize;
    /**
     * SSE-FOS(AES256)
     */
    private String encryptionType;
    /**
     * 限额
     */
    private Integer quotaSize;

    private Date created;

    private Date modified;

    private String creator;

    private String modifier;
}
