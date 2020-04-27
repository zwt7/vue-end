package com.example.vhr.end.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * position
 * @author 
 */
@Data
public class Position implements Serializable {
    private Integer id;

    /**
     * 职位
     */
    private String name;

    @JsonFormat(pattern = "yyyy-MM hh:hh",timezone = "Asia/Shanghai")
    private Date createdate;

    private Boolean enabled;

    private static final long serialVersionUID = 1L;

}