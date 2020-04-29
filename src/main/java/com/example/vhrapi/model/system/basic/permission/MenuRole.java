package com.example.vhrapi.model.system.basic.permission;

import lombok.Data;

import java.io.Serializable;

/**
 * menu_role
 * @author 
 */
@Data
public class MenuRole implements Serializable {
    private Integer id;

    private Integer mid;

    private Integer rid;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }
}