package com.sun.form.customer;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UserForm {

    private String  id;
    @NotNull(message = "名字不能为空")
    private String  username;
    @NotNull(message = "电话不能为空")
    private Integer phone;
    @NotNull(message = "密码不能为空")
    private String  pass;
    @NotNull(message = "邮箱不能为空")
    private String  email;

    private String repass;

}
