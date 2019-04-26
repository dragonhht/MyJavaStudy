package com.github.dragonhht.ws;

import javax.jws.WebMethod;

/**
 * .
 *
 * @author: huang
 * @Date: 2019-3-17
 */
@javax.jws.WebService
public interface WebService {

    @WebMethod
    String sayHello(String name);

}
