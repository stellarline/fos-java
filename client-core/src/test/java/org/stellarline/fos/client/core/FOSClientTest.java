package org.stellarline.fos.client.core;

import com.alibaba.cola.dto.PageResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;
import org.stellarline.fos.client.core.model.request.*;
import org.stellarline.fos.client.core.model.response.*;

import java.io.File;

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

    @Test
    void test_listObjects() {
        ObjectListQry qry = ObjectListQry.builder()
                .bucketName("test")
                .build();
        PageResponse<ObjectInfoListCO> response = fosClient.listObjects(qry);
        Assertions.assertTrue(response.isSuccess());
        log.info("{}", JSON.toJSON(response));
    }

    @Test
    void test_putObject() {
        ObjectPutReq req = ObjectPutReq.builder()
                .bucketName("test")
                .objectPath("/1228/content-type2.txt")
                .filename("content-type2.txt")
                .build();
        Response response = fosClient.putObject(req, new File("C:\\Users\\TDH\\Downloads\\content-type.txt"), null);
        log.info("{}", JSON.toJSON(response));
        Assertions.assertTrue(response.isSuccess());
    }

    @Test
    void test_getObject() {
        ObjectGetQry qry = ObjectGetQry.builder()
                .bucketName("test")
                .objectPath("/1228/content-type2.txt")
                .build();
        SingleResponse<ObjectInfoCO> response = fosClient.getObject(qry);
        log.info("{}", JSON.toJSON(response));
        Assertions.assertTrue(response.isSuccess());
    }

    @Test
    void test_getObjectContent() throws Exception {
        ObjectGetQry qry = ObjectGetQry.builder()
                .bucketName("test")
                .objectPath("/1228/content-type2.txt")
                .build();
        ObjectContentCO contentCO = fosClient.getObjectContent(qry);
        FileUtils.writeByteArrayToFile(new File("D:\\Tmp\\fos-client\\" + contentCO.getFilename()), contentCO.getBytes());
    }

    @Test
    void test_getPresignedUrl() {
        PresignedUrlGetQry qry = PresignedUrlGetQry.builder()
                .bucketName("test")
                .objectPath("/1228/content-type2.txt")
                .method("GET")
                .build();
        SingleResponse<PresignedUrlCO> response = fosClient.getPresignedUrl(qry);
        log.info("{}", JSON.toJSON(response));
        Assertions.assertTrue(response.isSuccess());
    }
}