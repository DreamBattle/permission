package com.mmall.param;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

public class TestVo {

    @NotBlank
    private String msg;

    @NotNull
    private Integer id;

}
