package org.stellarline.fos.client.core.model.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.stellarline.fos.client.core.model.PageReq;

/**
 * @author leanderlee
 * @since 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder(toBuilder = true)
public class BucketListQry extends PageReq {

    private String bucketName;
}
