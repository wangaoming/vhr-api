package com.example.vhrapi.model.system.joblevel;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@ApiModel(value = "职称实体类", description = "职称信息描述")
public class Joblevel implements Serializable {

    /**
     * 职称名称
     */
    @ApiModelProperty(value = "职称id")
    private Integer id;
    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "职位级别")
    private String titleLevel;
    @ApiModelProperty(value = "时间")
    @JsonFormat(pattern = "yyyy-MM-dd hh:hh", timezone = "Asia/Shanghai")
    private Date createDate;
    @ApiModelProperty(value = "操作")
    private Boolean enabled;

    private static final long serialVersionUID = 1L;

}