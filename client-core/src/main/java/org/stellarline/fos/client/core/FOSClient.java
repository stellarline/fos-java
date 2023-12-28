package org.stellarline.fos.client.core;

import com.alibaba.cola.dto.PageResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.dtflys.forest.Forest;
import com.dtflys.forest.callback.OnProgress;
import com.dtflys.forest.config.ForestConfiguration;
import com.dtflys.forest.http.ForestResponse;
import com.dtflys.forest.utils.StringUtils;
import org.stellarline.fos.client.core.api.BucketClient;
import org.stellarline.fos.client.core.api.ObjectClient;
import org.stellarline.fos.client.core.model.request.*;
import org.stellarline.fos.client.core.model.response.*;
import org.stellarline.fos.client.core.rest.BucketRestClient;
import org.stellarline.fos.client.core.rest.ObjectRestClient;
import org.stellarline.fos.client.core.utils.HttpUtils;

import java.io.File;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

/**
 * @author leanderlee
 * @since 1.0.0
 */
public class FOSClient implements BucketClient, ObjectClient {
    final static public String CONF_SERVER_URL = "serverUrl";
    final static public String CONF_ACCESS_KEY = "accessKey";
    final static public String CONF_ACCESS_SECRET = "accessSecret";

    final private BucketRestClient bucketRestClient;
    final private ObjectRestClient objectRestClient;

    FOSClient(FOSClientBuilder builder) {
        validateConf(builder);

        ForestConfiguration configuration = Forest.config();
        configuration.setVariableValue(CONF_SERVER_URL, builder.getServerUrl());
        configuration.setVariableValue(CONF_ACCESS_KEY, builder.getAccessKey());
        configuration.setVariableValue(CONF_ACCESS_SECRET, builder.getAccessSecret());
        configuration.setLogEnabled(builder.getLogEnabled());
        configuration.setConnectTimeout(builder.getConnectionTimeout(), TimeUnit.SECONDS);

        bucketRestClient = Forest.client(BucketRestClient.class);
        objectRestClient = Forest.client(ObjectRestClient.class);
    }

    private void validateConf(FOSClientBuilder builder) {
        if (StringUtils.isBlank(builder.getServerUrl())) {
            throw new FOSClientException("FOS server url must be not empty");
        }
        if (StringUtils.isBlank(builder.getAccessKey())) {
            throw new FOSClientException("FOS access key must be not empty");
        }
        if (StringUtils.isBlank(builder.getAccessSecret())) {
            throw new FOSClientException("FOS access secret must be not empty");
        }
        // validate server url
        boolean isValidUrl = HttpUtils.isValidUrl(builder.getServerUrl());
        if (!isValidUrl) {
            throw new FOSClientException("FOS serverUrl is invalid");
        }
    }

    @Override
    public PageResponse<BucketCO> listBuckets(BucketListQry qry) {
        return bucketRestClient.listBuckets(qry);
    }

    @Override
    public Response createBucket(BucketCreateReq req) {
        return bucketRestClient.createBucket(req);
    }

    @Override
    public SingleResponse<BucketCO> getBucket(BucketGetQry qry) {
        return bucketRestClient.getBucket(qry);
    }

    @Override
    public Response updateBucket(BucketUpdateReq req) {
        return bucketRestClient.updateBucket(req);
    }

    @Override
    public Response removeBucket(String bucketName) {
        return bucketRestClient.removeBucket(bucketName);
    }

    @Override
    public PageResponse<ObjectInfoListCO> listObjects(ObjectListQry qry) {
        return objectRestClient.listObjects(qry);
    }

    @Override
    public Response putObject(ObjectPutReq req, byte[] file, OnProgress progress) {
        return objectRestClient.putObject(req, file, progress);
    }

    @Override
    public Response putObject(ObjectPutReq req, InputStream stream, OnProgress progress) {
        return objectRestClient.putObject(req, stream, progress);
    }

    @Override
    public Response putObject(ObjectPutReq req, File file, OnProgress progress) {
        return objectRestClient.putObject(req, file, progress);
    }

    @Override
    public SingleResponse<ObjectInfoCO> getObject(ObjectGetQry qry) {
        return objectRestClient.getObject(qry);
    }

    @Override
    public ObjectContentCO getObjectContent(ObjectGetQry qry) throws Exception {
        ForestResponse<?> response = objectRestClient.getObjectContent(qry);
        return new ObjectContentCO(response.getFilename(), response.getByteArray());
    }

    @Override
    public SingleResponse<PresignedUrlCO> getPresignedUrl(PresignedUrlGetQry qry) {
        return objectRestClient.getPresignedUrl(qry);
    }

    @Override
    public Response removeObject(ObjectRemoveReq req) {
        return objectRestClient.removeObject(req);
    }
}
