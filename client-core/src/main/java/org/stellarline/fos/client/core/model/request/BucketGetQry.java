package org.stellarline.fos.client.core.model.request;

import com.alibaba.cola.dto.Query;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author leanderlee
 * @since 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class BucketGetQry extends Query {

    private String id;

    private String bucketName;
}
