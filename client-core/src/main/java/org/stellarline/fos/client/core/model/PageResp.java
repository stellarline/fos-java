package org.stellarline.fos.client.core.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author leanderlee
 * @since 1.0.0
 */
public class PageResp<T> implements Serializable {

    private int totalCount = 0;

    private int pageSize = 1;

    private int pageIndex = 1;

    private Collection<T> data;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageSize() {
        if (pageSize < 1) {
            return 1;
        }
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        if (pageSize < 1) {
            this.pageSize = 1;
        } else {
            this.pageSize = pageSize;
        }
    }

    public int getPageIndex() {
        if (pageIndex < 1) {
            return 1;
        }
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        if (pageIndex < 1) {
            this.pageIndex = 1;
        } else {
            this.pageIndex = pageIndex;
        }
    }

    public List<T> getData() {
        if (null == data) {
            return Collections.emptyList();
        }
        if (data instanceof List) {
            return (List<T>) data;
        }
        return new ArrayList<>(data);
    }

    public void setData(Collection<T> data) {
        this.data = data;
    }

    public int getTotalPages() {
        return this.totalCount % this.pageSize == 0 ? this.totalCount
                / this.pageSize : (this.totalCount / this.pageSize) + 1;
    }

    public boolean isEmpty() {
        return data == null || data.isEmpty();
    }

    public boolean isNotEmpty() {
        return !isEmpty();
    }

    public static <T> PageResp<T> of(int pageSize, int pageIndex) {
        PageResp<T> response = new PageResp<>();
        response.setData(Collections.emptyList());
        response.setTotalCount(0);
        response.setPageSize(pageSize);
        response.setPageIndex(pageIndex);
        return response;
    }

    public static <T> PageResp<T> of(Collection<T> data, int totalCount, int pageSize, int pageIndex) {
        PageResp<T> response = new PageResp<>();
        response.setData(data);
        response.setTotalCount(totalCount);
        response.setPageSize(pageSize);
        response.setPageIndex(pageIndex);
        return response;
    }

}
