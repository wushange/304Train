package cn.connxun.train.entity;

/**
 * Created by wushange on 2017/8/30.
 */

public class AppInfo {

    /**
     * id : 1
     * title : 中国航天科工集团公司
     * content : 中国航天科工集团公司（简称“中国航天科工”）是特大型高科技企业,现有职工约15万余人,其中各类专业人员约占70%，涉及学科与专业领域近200个，共有600余户企业和机构，分布于国内各省市自治区以及20余国家。
     * datetime : null
     * state : 0
     */

    private int id;
    private String title;
    private String content;
    private Object datetime;
    private int    state;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        return "AppInfo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", datetime=" + datetime +
                ", state=" + state +
                '}';
    }
}
