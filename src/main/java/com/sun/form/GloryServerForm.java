package com.sun.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author Shou
 * @Title:
 * @Package
 * @Description:
 * @date 2020/4/2811:22
 */
@Data
public class GloryServerForm {


    private Integer id;
    @NotEmpty(message = "区服名称不能为空")
    private String serverName;
    @NotNull(message = "区服加成不能为空")
    private Double serverAddition;
}