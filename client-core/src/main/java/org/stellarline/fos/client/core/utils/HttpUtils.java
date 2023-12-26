package org.stellarline.fos.client.core.utils;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * @author leanderlee
 * @since 1.0.0
 */
public class HttpUtils {

    public static boolean isValidUrl(String url) {
        try {
            new URL(url).toURI();
            return true;
        } catch (URISyntaxException | MalformedURLException ignored) {
        }
        return false;
    }
}
