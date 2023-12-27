package org.stellarline.fos.client.core.rest;

import com.alibaba.cola.dto.PageResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.dtflys.forest.annotation.*;
import org.stellarline.fos.client.core.RestClientInterceptor;
import org.stellarline.fos.client.core.model.request.BucketCreateReq;
import org.stellarline.fos.client.core.model.request.BucketListQry;
import org.stellarline.fos.client.core.model.response.BucketCO;

/**
 * @author leanderlee
 * @since 1.0.0
 */
@BaseRequest(
        baseURL = "${serverUrl}/v1/api/buckets",
        interceptor = {RestClientInterceptor.class},
        headers = {
                "X-Access-Key: ${accessKey}",
                "X-Access-Secret: ${accessSecret}"
        }
)
public interface BucketRestClient {

    @Get(value = "/listBuckets")
    PageResponse<BucketCO> listBuckets(@Query BucketListQry qry);

    @Post(value = "/createBucket")
    Response createBucket(@JSONBody BucketCreateReq req);

    @Get(value = "/getBucket")
    SingleResponse<BucketCO> getBucket(@Var("bucketName") String bucketName);

    @Put(value = "/updateBucket")
    Response updateBucket(@Var("bucketName") String bucketName);

    @Delete(value = "/removeBucket")
    Response removeBucket(@Var("bucketName") String bucketName);
}
