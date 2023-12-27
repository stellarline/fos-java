package org.stellarline.fos.client.core.rest;

import com.dtflys.forest.annotation.BaseRequest;
import org.stellarline.fos.client.core.RestClientInterceptor;

/**
 * @author leanderlee
 * @since 1.0.0
 */
@BaseRequest(
        baseURL = "${serverUrl}/v1/presigned-api",
        interceptor = {RestClientInterceptor.class}
)
public interface PresignedRestClient {
}
