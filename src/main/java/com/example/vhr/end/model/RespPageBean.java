package com.example.vhr.end.model;

import java.util.List;

/**
 * @date:2020/5/16 11:08
 * @destription:
 */

public class RespPageBean {
    private Long total;
    private List<?> data;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
