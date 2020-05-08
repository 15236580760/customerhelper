package com.sun.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author Shou
 * @Title:
 * @Package
 * @Description:
 * @date 2020/4/2813:26
 */
@Data
public class SpeechcraftForm {

    private Integer id;
    @NotEmpty(message = "游戏名不能为空.")
    private String name;
    @NotEmpty(message = "话术不能为空.")
    private String speechcraft;

}