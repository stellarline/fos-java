package org.stellarline.fos.client.core;

import com.alibaba.cola.dto.PageResponse;
import com.alibaba.cola.dto.Response;
import com.dtflys.forest.Forest;
import com.dtflys.forest.config.ForestConfiguration;
import org.stellarline.fos.client.core.request.BucketCreateReq;
import org.stellarline.fos.client.core.response.BucketCO;
import org.stellarline.fos.client.core.utils.HttpUtils;

/**
 * @author leanderlee
 * @since 1.0.0
 */
public class FOSClient implements FOSClientInterface {
    final static public String CONF_SERVER_URL = "serverUrl";
    final static public String CONF_ACCESS_KEY = "accessKey";
    final static public String CONF_ACCESS_SECRET = "accessSecret";

    final private FOSRestClient restClient;

    FOSClient(FOSClientBuilder builder) {
        // validate server url
        boolean isValidUrl = HttpUtils.isValidUrl(builder.getServerUrl());
        if (!isValidUrl) {
            throw new FOSClientException("FOS serverUrl is invalid ");
        }
        ForestConfiguration configuration = Forest.config();
        configuration.setVariableValue(CONF_SERVER_URL, builder.getServerUrl());
        configuration.setVariableValue(CONF_ACCESS_KEY, builder.getAccessKey());
        configuration.setVariableValue(CONF_ACCESS_SECRET, builder.getAccessSecret());

        restClient = Forest.client(FOSRestClient.class);
    }

    @Override
    public PageResponse<BucketCO> listBuckets(String bucketName) {
        return restClient.listBuckets(bucketName);
    }

    @Override
    public Response createBucket(BucketCreateReq req) {
        return restClient.createBucket(req);
    }



}
