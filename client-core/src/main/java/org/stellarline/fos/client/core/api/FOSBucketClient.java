package org.stellarline.fos.client.core.api;

import com.alibaba.cola.dto.Response;
import org.stellarline.fos.client.core.model.PageReq;
import org.stellarline.fos.client.core.model.PageResp;
import org.stellarline.fos.client.core.model.request.BucketCreateReq;
import org.stellarline.fos.client.core.model.request.BucketListQry;
import org.stellarline.fos.client.core.model.response.BucketCO;

/**
 * @author leanderlee
 * @since 1.0.0
 */
public interface FOSBucketClient {

    PageResp<BucketCO> listBuckets(BucketListQry qry);

    Response createBucket(BucketCreateReq req);
}
