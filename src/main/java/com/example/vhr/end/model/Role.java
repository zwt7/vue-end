package com.example.vhr.end.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * role
 * @author 
 */
@Data
@ApiModel(value = "角色名称实体类")
public class Role implements Serializable {
    private Integer id;

    private String name;

    /**
     * 角色名称
     */
    private String namezh;

    private static final long serialVersionUID = 1L;
}