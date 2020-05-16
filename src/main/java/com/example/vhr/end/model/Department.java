package com.example.vhr.end.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * department
 * @author 
 */
public class Department implements Serializable {
    private Integer id;

    /**
     * 部门名称
     */
    private String name;

    private Integer parentid;

    @Override
    public boolean equals(Object o) {

        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Department that = (Department) o;
        return Objects.equals(name, that.name);
    }

    private String deppath;

    private Boolean enabled;

    private Boolean isparent;

    private List<Department> children = new ArrayList<>();
    private Integer result;

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public List<Department> getChildren() {
        return children;
    }

    public void setChildren(List<Department> children) {
        this.children = children;
    }

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

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public String getDeppath() {
        return deppath;
    }

    public void setDeppath(String deppath) {
        this.deppath = deppath;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getIsparent() {
        return isparent;
    }

    public void setIsparent(Boolean isparent) {
        this.isparent = isparent;
    }
}