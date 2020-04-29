package com.example.vhr.end.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * position
 * @author 
 */
@Data
@ApiModel(value = "职位实体类" ,description = "职位创建")
public class Position implements Serializable {
    private Integer id;

    /**
     * 职位
     */
    @ApiModelProperty(value = "职位名字")
    private String name;

    @JsonFormat(pattern = "yyyy-MM hh:hh",timezone = "Asia/Shanghai")
    @ApiModelProperty(value = "职位创建时间")
    private Date createdate;

    @ApiModelProperty(value = "是否启用")
    private Boolean enabled;

    private static final long serialVersionUID = 1L;

}