package org.stellarline.fos.client.core;

import com.alibaba.cola.dto.PageResponse;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
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
                .setAccessKey("testkey")
                .setAccessSecret("testSecret")
                .build();
    }

    @Test
    void test1_listBuckets() {
        PageResponse<BucketCO> response = fosClient.listBuckets(null);
        log.info("{}", JSON.toJSON(response));
    }

    @Test
    void test2_createBucket() {
    }
}