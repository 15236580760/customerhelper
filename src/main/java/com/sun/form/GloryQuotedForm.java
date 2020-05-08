package com.sun.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author Shou
 * @Title:
 * @Package
 * @Description:
 * @date 2020/4/2813:39
 */
@Data
public class GloryQuotedForm {

    private Integer id;
    @NotEmpty(message = "段位别名不能为空")
    private String name;
    @NotNull(message = "价格不能为空")
    private Double price;
   // @NotEmpty(message = "父级id不能为空")
    private String parent;
   // @NotNull(message = "代练耗时不能为空")
    private String time;
    @NotEmpty(message = "当前段位数不能为空")
    private String intervalValue;
    @NotNull(message = "段位总星数不能为空")
    private Integer starNum;
   // @NotEmpty(message = "")
    private String serverMultiplier;
    @NotEmpty(message = "段位区间不能为空")
    private String levelName;
}