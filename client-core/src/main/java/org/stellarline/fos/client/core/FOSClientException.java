package org.stellarline.fos.client.core;

/**
 * @author leanderlee
 * @since 1.0.0
 */
public class FOSClientException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String errCode;

    public FOSClientException(String errMessage) {
        super(errMessage);
    }

    public FOSClientException(String errCode, String errMessage) {
        super(errMessage);
        this.errCode = errCode;
    }

    public FOSClientException(String errMessage, Throwable e) {
        super(errMessage, e);
    }

    public FOSClientException(String errCode, String errMessage, Throwable e) {
        super(errMessage, e);
        this.errCode = errCode;
    }

    public String getErrCode() {
        return this.errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }
}
