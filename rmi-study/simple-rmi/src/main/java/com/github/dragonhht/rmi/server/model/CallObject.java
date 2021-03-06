package com.github.dragonhht.rmi.server.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 用于处理传输主要调用信息.
 *
 * @author: huang
 * @Date: 2019-4-28
 */
@Getter
@Setter
@ToString
public class CallObject implements Serializable {
    private static final long serialVersionUID = 8550043646573165259L;

    private String url;
    private String method;
    private Object[] params;

    private boolean callMethod = true;

}
