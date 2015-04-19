package org.lyao.ocs_commonlistview.bean;

/**
 * Created by lyao on 2015/4/18.
 */
public class New {
    private static final String TAG = "New";
    public String avator;
    public String title;
    public String datail;
    public String follow;

    public New(String avator, String datail, String follow, String title) {
        this.avator = avator;
        this.datail = datail;
        this.follow = follow;
        this.title = title;
    }

    public New() {

    }

}
