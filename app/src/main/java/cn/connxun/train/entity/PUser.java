package cn.connxun.train.entity;

import java.io.Serializable;

/**
 * Created by wushange on 2017/8/27.
 */

public class PUser  implements Serializable{


    /**
     * createBy : null
     * createtime : null
     * updatetime : null
     * updateBy : null
     * id : 17
     * username : 王子健
     * password : md5
     * usertype : null
     * remark : null
     * datetime : 1503452705000
     * state : 1
     * idcard : 110
     * pinyin : wangzijian
     */

    private String createBy;
    private String createtime;
    private String updatetime;
    private String updateBy;
    private int    id;
    private String username;
    private String password;
    private String usertype;
    private String remark;
    private long   datetime;
    private int    state;
    private String idcard;
    private String pinyin;


    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    @Override
    public String toString() {
        return "PUser{" +
                "createBy='" + createBy + '\'' +
                ", createtime='" + createtime + '\'' +
                ", updatetime='" + updatetime + '\'' +
                ", updateBy='" + updateBy + '\'' +
                ", id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", usertype='" + usertype + '\'' +
                ", remark='" + remark + '\'' +
                ", datetime=" + datetime +
                ", state=" + state +
                ", idcard='" + idcard + '\'' +
                ", pinyin='" + pinyin + '\'' +
                '}';
    }
}
