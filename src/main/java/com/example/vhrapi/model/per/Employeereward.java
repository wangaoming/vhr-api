package com.example.vhrapi.model.per;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * employeereward
 * @author 
 */

@Data
public class Employeereward implements Serializable {
    /**
     * id
     */
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private String gender;

    /**
     * 惩罚日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd hh:hh", timezone = "Asia/Shanghai")
    private Date punishmentdate;

    /**
     * 惩罚类别


     */
    private String punishmentclasses;

    /**
     * 次数
     */
    private Integer times;

    /**
     * 工资奖罚
     */
    private Integer punishmentpay;

    /**
     * 提案人
     */
    private String proposer;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getPunishmentdate() {
        return punishmentdate;
    }

    public void setPunishmentdate(Date punishmentdate) {
        this.punishmentdate = punishmentdate;
    }

    public String getPunishmentclasses() {
        return punishmentclasses;
    }

    public void setPunishmentclasses(String punishmentclasses) {
        this.punishmentclasses = punishmentclasses;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public Integer getPunishmentpay() {
        return punishmentpay;
    }

    public void setPunishmentpay(Integer punishmentpay) {
        this.punishmentpay = punishmentpay;
    }

    public String getProposer() {
        return proposer;
    }

    public void setProposer(String proposer) {
        this.proposer = proposer;

    }
    private Date createDate;

    private Boolean enabled;
}