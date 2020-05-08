package com.sun.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author Shou
 * @Title:
 * @Package
 * @Description:
 * @date 2020/4/2811:37
 */
@Data
public class InscriptionForm {

    private Integer id;
    @NotEmpty(message = "段位不能为空")
    private String etc;
    @NotEmpty(message = "铭文加成不能为空")
    private String addition;
    @NotEmpty(message = "铭文数不能为空")
    private String inscriptionNum;
}