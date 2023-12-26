package org.stellarline.fos.client.core;

import com.alibaba.cola.dto.PageResponse;
import com.alibaba.cola.dto.Response;
import com.dtflys.forest.annotation.*;
import com.dtflys.forest.http.ForestResponse;
import org.stellarline.fos.client.core.request.BucketCreateReq;
import org.stellarline.fos.client.core.response.BucketCO;

/**
 * @author leanderlee
 * @since 1.0.0
 */
@BaseRequest(baseURL = "${serverUrl}/object-api", interceptor = {RestClientInterceptor.class})
public interface FOSRestClient {

    @Get(value = "/buckets")
    PageResponse<BucketCO> listBuckets(@Query String bucketName);

    @Post(value = "/bucket")
    Response createBucket(@JSONBody BucketCreateReq req);
}
