package cn.connxun.train.entity;

import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

import java.io.Serializable;

/**
 * Created by wushange on 2017/8/27.
 */


@Entity
public class VideoClass implements Serializable {
    static final long serialVersionUID  = 42L;

    /**
     * id : 16
     * coursename : 123
     * coursedesc : 123
     * coursepic : null
     * coursetype : 123
     * datetime : 1503301894000
     * state : 1
     */

    @Id
    private long id;
    private String coursename;
    private String coursedesc;
    private String coursepic;
    private int    coursetype;
    private long   datetime;
    private int    state;
    private int userid;
    private int courseid;


    public VideoClass(String coursename, String coursedesc, String coursepic) {
        this.coursename = coursename;
        this.coursedesc = coursedesc;
        this.coursepic = coursepic;
    }

    @Generated(hash = 216651033)
    public VideoClass(long id, String coursename, String coursedesc,
            String coursepic, int coursetype, long datetime, int state, int userid,
            int courseid) {
        this.id = id;
        this.coursename = coursename;
        this.coursedesc = coursedesc;
        this.coursepic = coursepic;
        this.coursetype = coursetype;
        this.datetime = datetime;
        this.state = state;
        this.userid = userid;
        this.courseid = courseid;
    }

    @Generated(hash = 240525264)
    public VideoClass() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getCoursedesc() {
        return coursedesc;
    }

    public void setCoursedesc(String coursedesc) {
        this.coursedesc = coursedesc;
    }

    public String getCoursepic() {
        return coursepic;
    }

    public void setCoursepic(String coursepic) {
        this.coursepic = coursepic;
    }

    public int getCoursetype() {
        return coursetype;
    }

    public void setCoursetype(int coursetype) {
        this.coursetype = coursetype;
    }

    public long getDatetime() {
        return datetime;
    }

    public void setDatetime(long datetime) {
        this.datetime = datetime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }


    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    @Override
    public String toString() {
        return "VideoClass{" +
                "id=" + id +
                ", coursename='" + coursename + '\'' +
                ", coursedesc='" + coursedesc + '\'' +
                ", coursepic='" + coursepic + '\'' +
                ", coursetype=" + coursetype +
                ", datetime=" + datetime +
                ", state=" + state +
                ", userid=" + userid +
                ", courseid=" + courseid +
                '}';
    }
}
