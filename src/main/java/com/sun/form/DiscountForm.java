package com.sun.form;

import lombok.Data;

import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class DiscountForm {

    private Integer id;
    @NotNull(message = "最低价不能为空")
    private Integer priceRange;
    @NotNull(message = "折扣不能为空")
    private Integer favourable;
    @NotEmpty(message = "游戏名不能为空")
    private String gameName;

}
