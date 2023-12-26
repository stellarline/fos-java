package org.stellarline.fos.client.core;

import com.alibaba.cola.dto.PageResponse;
import com.alibaba.cola.dto.Response;
import org.stellarline.fos.client.core.request.BucketCreateReq;
import org.stellarline.fos.client.core.response.BucketCO;

/**
 * @author leanderlee
 * @since 1.0.0
 */
public interface FOSClientInterface {

    PageResponse<BucketCO> listBuckets(String bucketName);

    Response createBucket(BucketCreateReq req);
}
