package org.stellarline.fos.client.core.rest;

import com.alibaba.cola.dto.PageResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.dtflys.forest.annotation.*;
import com.dtflys.forest.callback.OnProgress;
import com.dtflys.forest.http.ForestResponse;
import org.stellarline.fos.client.core.model.request.*;
import org.stellarline.fos.client.core.model.response.ObjectInfoCO;
import org.stellarline.fos.client.core.model.response.ObjectInfoListCO;
import org.stellarline.fos.client.core.model.response.PresignedUrlCO;

import java.io.File;
import java.io.InputStream;

/**
 * @author leanderlee
 * @since 1.0.0
 */
@BaseRequest(
        baseURL = "${serverUrl}/v1/api/objects",
        headers = {
                "X-Access-Key: ${accessKey}",
                "X-Access-Secret: ${accessSecret}"
        }
)
public interface ObjectRestClient {

    @Get(value = "listObjects")
    PageResponse<ObjectInfoListCO> listObjects(@Query ObjectListQry qry);

    @Post(value = "putObject")
    Response putObject(@Query ObjectPutReq req, @DataFile("file")byte[] file, OnProgress progress);

    @Post(value = "putObject")
    Response putObject(@Query ObjectPutReq req, @DataFile("file")InputStream stream, OnProgress progress);

    @Post(value = "putObject")
    Response putObject(@Query ObjectPutReq req, @DataFile("file")File file, OnProgress progress);

    @Get(value = "getObject")
    SingleResponse<ObjectInfoCO> getObject(@Query ObjectGetQry qry);

    @Get(value = "getObjectContent")
    ForestResponse<?> getObjectContent(@Query ObjectGetQry qry);

    @Get(value = "getPresignedUrl")
    SingleResponse<PresignedUrlCO> getPresignedUrl(@Query PresignedUrlGetQry qry);

    @Delete(value = "removeObject")
    Response removeObject(@Query ObjectRemoveReq req);
}
