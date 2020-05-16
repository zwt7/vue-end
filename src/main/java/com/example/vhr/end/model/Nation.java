package com.example.vhr.end.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * nation
 * @author 
 */
public class Nation implements Serializable {
    private Integer id;

    private String name;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}