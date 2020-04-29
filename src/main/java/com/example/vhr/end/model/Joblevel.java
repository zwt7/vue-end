package com.example.vhr.end.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * joblevel
 * @author 
 */
@Data
@ApiModel(value = "职称实体类" ,description = "职称信息描述")
public class Joblevel implements Serializable {
    @ApiModelProperty("职位id")
    private Integer id;

    /**
     * 职称名称
     */
  @ApiModelProperty(value = "职称名称")
    private String name;

    private String titlelevel;

    @JsonFormat(pattern = "yyyy-MM hh:hh",timezone = "Asia/Shanghai")
    @ApiModelProperty(value = "职称创建时间")
    private Date createdate;

    @ApiModelProperty(value = "是否启用")
    private Boolean enabled;

    private static final long serialVersionUID = 1L;

}