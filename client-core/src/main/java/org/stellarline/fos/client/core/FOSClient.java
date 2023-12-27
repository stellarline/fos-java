package org.stellarline.fos.client.core;

import com.alibaba.cola.dto.PageResponse;
import com.alibaba.cola.dto.Response;
import com.dtflys.forest.Forest;
import com.dtflys.forest.config.ForestConfiguration;
import org.stellarline.fos.client.core.api.FOSBucketClient;
import org.stellarline.fos.client.core.api.FOSObjectClient;
import org.stellarline.fos.client.core.api.FOSPresignedClient;
import org.stellarline.fos.client.core.model.PageResp;
import org.stellarline.fos.client.core.model.request.BucketCreateReq;
import org.stellarline.fos.client.core.model.request.BucketListQry;
import org.stellarline.fos.client.core.model.response.BucketCO;
import org.stellarline.fos.client.core.rest.BucketRestClient;
import org.stellarline.fos.client.core.rest.ObjectRestClient;
import org.stellarline.fos.client.core.rest.PresignedRestClient;
import org.stellarline.fos.client.core.utils.HttpUtils;

/**
 * @author leanderlee
 * @since 1.0.0
 */
public class FOSClient implements FOSBucketClient, FOSObjectClient, FOSPresignedClient {
    final static public String CONF_SERVER_URL = "serverUrl";
    final static public String CONF_ACCESS_KEY = "accessKey";
    final static public String CONF_ACCESS_SECRET = "accessSecret";

    final private BucketRestClient bucketRestClient;
    final private ObjectRestClient objectRestClient;
    final private PresignedRestClient presignedRestClient;

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

        bucketRestClient = Forest.client(BucketRestClient.class);
        objectRestClient = Forest.client(ObjectRestClient.class);
        presignedRestClient = Forest.client(PresignedRestClient.class);
    }

    @Override
    public PageResp<BucketCO> listBuckets(BucketListQry qry) {
        PageResponse<BucketCO> response = bucketRestClient.listBuckets(
                qry.getBucketName(), qry.getPageIndex(), qry.getPageSize(), qry.getOrderBy(), qry.getOrderDirection());
        return PageResp.of(response.getData(), response.getTotalCount(), response.getPageSize(), response.getPageIndex());
    }

    @Override
    public Response createBucket(BucketCreateReq req) {
        return bucketRestClient.createBucket(req);
    }
}
