package com.github.dragonhht.rmi.client.stub;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * .
 *
 * @author: huang
 * @Date: 2019-4-29
 */
@Getter
@Setter
@ToString
public class UrlParam implements Serializable {
    private static final long serialVersionUID = 4638747326862480667L;

    private String protocol;
    private String host;
    private int port;
    private String url;

    public UrlParam(String url) {
        this.url = url;
        parseUrl();
    }

    private void parseUrl() {
        String tempUrl = url;
        int index = url.indexOf("://");
        if (index != -1) {
            this.protocol = url.substring(0, index);
            tempUrl = this.url.substring(index + 3);
        }
        index = tempUrl.indexOf(":");
        if (index != -1) {
            this.host = tempUrl.substring(0, index);
            tempUrl = tempUrl.substring(index + 1);
        }
        index = tempUrl.indexOf("/");
        if (index != -1) {
            String p = tempUrl.substring(0, index);
            this.port = Integer.parseInt(p);
        }
    }
}
