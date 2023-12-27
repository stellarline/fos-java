package org.stellarline.fos.client.core;

import com.alibaba.cola.dto.PageResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.stellarline.fos.client.core.model.request.BucketCreateReq;
import org.stellarline.fos.client.core.model.request.BucketListQry;
import org.stellarline.fos.client.core.model.response.BucketCO;

/**
 * @author leanderlee
 * @since
 */
@TestMethodOrder(MethodOrderer.DisplayName.class)
@Slf4j
class FOSClientTest {

    private static FOSClient fosClient;

    @BeforeAll
    public static void beforeAll() {
        fosClient = new FOSClientBuilder()
                .setServerUrl("http://localhost:9111")
                .setAccessKey("ut_test_key")
                .setAccessSecret("QUtfM0YzOTU3MDUtNTNENy00M0VDLTlCODktNkFERUEwMTc0NDkyXzE3MDM2OTA1MjA5NDY=")
                .build();
    }

    @Test
    void test1_listBuckets() {
        BucketListQry qry = BucketListQry.builder().build();
        qry.setPageSize(20);
        PageResponse<BucketCO> response = fosClient.listBuckets(qry);
        Assertions.assertTrue(response.isSuccess());
        log.info("{}", JSON.toJSON(response));
    }

    @Test
    void test2_createBucket() {
        BucketCreateReq req = BucketCreateReq.builder()
                .bucketName("test-bucket-1228-1")
                .quotaSize(100)
                .build();
        Response response = fosClient.createBucket(req);
        Assertions.assertTrue(response.isSuccess());
        log.info("{}", JSON.toJSON(response));
    }
}