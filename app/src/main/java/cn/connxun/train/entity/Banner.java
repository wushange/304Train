package cn.connxun.train.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mr.Jude on 2016/1/6.
 */
public class Banner {
    /**
     * id : 2
     * title : shan2`
     * content : jun2`
     * bannerUrl :  http://dwz.cn/6qs59X
     * state : 0
     */
    private int    id;
    private String title;
    private String content;
    private String bannerUrl;
    private int    state;
    /**
     * sort : 2
     * bannerUrl : null
     * bannerPic : 1504508178432.jpg
     */
    private String sort;
    private String bannerPic;


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

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }


    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getBannerPic() {
        return bannerPic;
    }

    public void setBannerPic(String bannerPic) {
        this.bannerPic = bannerPic;
    }

    @Override
    public String toString() {
        return "Banner{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", bannerUrl='" + bannerUrl + '\'' +
                ", state=" + state +
                ", sort='" + sort + '\'' +
                ", bannerPic='" + bannerPic + '\'' +
                '}';
    }
}
