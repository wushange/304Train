package cn.connxun.train.entity;

import java.io.Serializable;

/**
 * Created by wushange on 2017/8/29.
 */

public class SubClass implements Serializable {

    /**
     * id : 2
     * courseid : 20
     * partname : 2
     * parturl : 2
     * datetime : null
     * state : 0
     */

    private int id;
    private int    courseid;
    private String partname;
    private String parturl;
    private Object datetime;
    private int    state;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public String getPartname() {
        return partname;
    }

    public void setPartname(String partname) {
        this.partname = partname;
    }

    public String getParturl() {
        return parturl;
    }

    public void setParturl(String parturl) {
        this.parturl = parturl;
    }

    public Object getDatetime() {
        return datetime;
    }

    public void setDatetime(Object datetime) {
        this.datetime = datetime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "SubClass{" +
                "id=" + id +
                ", courseid=" + courseid +
                ", partname='" + partname + '\'' +
                ", parturl='" + parturl + '\'' +
                ", datetime=" + datetime +
                ", state=" + state +
                '}';
    }
}
