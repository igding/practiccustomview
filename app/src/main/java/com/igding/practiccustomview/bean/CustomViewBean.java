package com.igding.practiccustomview.bean;

/**
 * <pre>
 *     author : handler
 *     e-mail : dingchao314@gmail.com
 *     time   : 2018/09/08
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class CustomViewBean {
    private String name;
    private String id;

    public CustomViewBean(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
