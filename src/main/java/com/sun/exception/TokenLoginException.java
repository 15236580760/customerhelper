package com.sun.exception;

/**
 *
* @Class TokenLoginException  自定义的RuntimeException
* @Description: tokenlogin过期时抛出
 */
public class TokenLoginException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    
    private String msg;

    public TokenLoginException(String msg) {
        super();
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}