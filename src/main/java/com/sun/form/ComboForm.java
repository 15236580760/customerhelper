package com.sun.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author Shou
 * @Title:
 * @Package
 * @Description:
 * @date 2020/4/2715:45
 */
@Data
public class ComboForm {
    private Integer id;
    @NotEmpty(message = "最低价不能为空")
    private String comboName;
    @NotNull(message = "折扣不能为空")
    private Double comboAddition;
}