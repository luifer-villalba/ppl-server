package com.swnat.dto;

import java.io.Serializable;
import java.util.List;

public class PaginationResponse<T extends Serializable> implements Serializable {

    private static final long serialVersionUID = 1620916850610428597L;

    private List<T> content;
    private Long count;

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
