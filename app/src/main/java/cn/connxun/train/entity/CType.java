package cn.connxun.train.entity;

import java.io.Serializable;

/**
 * Created by wushange on 2017/9/5.
 */

public class CType  implements Serializable{


    /**
     * id : 3
     * typename : 专业课程
     * datetime : null
     * state : 0
     * typepic : 1504574781422.png
     */

    private int id;
    private String typename;
    private Object datetime;
    private int state;
    private String typepic;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
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

    public String getTypepic() {
        return typepic;
    }

    public void setTypepic(String typepic) {
        this.typepic = typepic;
    }

    @Override
    public String toString() {
        return "CType{" +
                "id=" + id +
                ", typename='" + typename + '\'' +
                ", datetime=" + datetime +
                ", state=" + state +
                ", typepic='" + typepic + '\'' +
                '}';
    }
}
