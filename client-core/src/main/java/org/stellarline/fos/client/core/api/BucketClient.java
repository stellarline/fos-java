package org.stellarline.fos.client.core.api;

import com.alibaba.cola.dto.PageResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.stellarline.fos.client.core.model.request.BucketCreateReq;
import org.stellarline.fos.client.core.model.request.BucketGetQry;
import org.stellarline.fos.client.core.model.request.BucketListQry;
import org.stellarline.fos.client.core.model.request.BucketUpdateReq;
import org.stellarline.fos.client.core.model.response.BucketCO;

/**
 * @author leanderlee
 * @since 1.0.0
 */
public interface BucketClient {

    PageResponse<BucketCO> listBuckets(@Valid BucketListQry qry);

    Response createBucket(@Valid BucketCreateReq req);

    SingleResponse<BucketCO> getBucket(@Valid BucketGetQry qry);

    Response updateBucket(@Valid BucketUpdateReq req);

    Response removeBucket(@NotBlank String bucketName);
}
