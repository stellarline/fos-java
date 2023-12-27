package org.stellarline.fos.client.core;

import com.dtflys.forest.http.ForestRequest;
import com.dtflys.forest.http.ForestResponse;
import com.dtflys.forest.interceptor.Interceptor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author leanderlee
 * @since 1.0.0
 */
@Slf4j
public class RestClientInterceptor implements Interceptor {

    @Override
    public boolean beforeExecute(ForestRequest request) {
        return Interceptor.super.beforeExecute(request);
    }

    @Override
    public void onSuccess(Object data, ForestRequest request, ForestResponse response) {
        Interceptor.super.onSuccess(data, request, response);
    }
}
