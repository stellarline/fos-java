package org.stellarline.fos.client.core.model.request;

import com.alibaba.cola.dto.Command;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author leanderlee
 * @since 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BucketUpdateReq extends Command {

    private String id;

    private String bucketName;

    private String encryptionType;

    private Integer quotaSize;
}
