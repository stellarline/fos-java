package org.stellarline.fos.client.core.rest;

import com.alibaba.cola.dto.PageResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.dtflys.forest.annotation.*;
import com.dtflys.forest.callback.OnProgress;
import org.stellarline.fos.client.core.RestClientInterceptor;
import org.stellarline.fos.client.core.model.response.ObjectInfoCO;
import org.stellarline.fos.client.core.model.response.ObjectInfoListCO;

import java.io.File;
import java.io.InputStream;

/**
 * @author leanderlee
 * @since 1.0.0
 */
@BaseRequest(
        baseURL = "${serverUrl}/v1/api/objects",
        interceptor = {RestClientInterceptor.class},
        headers = {
                "X-Access-Key: ${accessKey}",
                "X-Access-Secret: ${accessSecret}"
        }
)
public interface ObjectRestClient {

    @Get(value = "{bucketName}/objects?objectPath={objectPath}")
    PageResponse<ObjectInfoListCO> listObjects(@Var("bucketName") String bucketName, @Var("objectPath") String objectPath);

    @Post(value = "{bucketName}/{objectPath}")
    Response pubObject(@Var("bucketName") String bucketName, @Var("objectPath") String objectPath, @DataFile("file")byte[] file, OnProgress progress);

    @Post(value = "{bucketName}/{objectPath}")
    Response pubObject(@Var("bucketName") String bucketName, @Var("objectPath") String objectPath, @DataFile("file")File file, OnProgress progress);

    @Post(value = "{bucketName}/{objectPath}")
    Response pubObject(@Var("bucketName") String bucketName, @Var("objectPath") String objectPath, @DataFile("file")InputStream stream, OnProgress progress);

    @Get(value = "{bucketName}/{objectPath}")
    SingleResponse<ObjectInfoCO> getObject(@Var("bucketName") String bucketName, @Var("objectPath") String objectPath);

    @Delete(value = "{bucketName}/{objectPath}")
    Response removeObject(@Var("bucketName") String bucketName, @Var("objectPath") String objectPath);

}
