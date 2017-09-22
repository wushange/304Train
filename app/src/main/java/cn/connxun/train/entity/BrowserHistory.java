package cn.connxun.train.entity;

/**
 * Created by wushange on 2017/9/21.
 */

public class BrowserHistory {


    /**
     * id : 72
     * userid : null
     * partid : null
     * courseid : null
     * datetime : 1505983255000
     * state : null
     * mosUser : {"createBy":null,"createtime":null,"updatetime":null,"updateBy":null,"id":72,"username":"尚晓忠","password":null,"usertype":null,"remark":null,"datetime":1505983255000,"state":null,"idcard":null,"pinyin":null,"noGroup":null,"page":1,"rows":10,"order":null}
     * mosCourse : {"id":72,"coursename":"\u201c两学一做\u201c微课堂","coursedesc":null,"coursepic":null,"coursetype":null,"datetime":1505983255000,"ishot":null,"hotsort":null,"state":null,"statesort":null,"isnew":null,"newsort":null,"mosCourseType":null,"mosDissertation":null,"dissertationid":null,"dissertationsort":null}
     * mosCoursePart : {"id":72,"courseid":null,"partname":"精品课程的课件1","parturl":null,"datetime":1505983255000,"state":null,"mosCourse":null,"mosType":null}
     * rows : null
     */

    private int id;
    private String            userid;
    private String            partid;
    private String            courseid;
    private long              datetime;
    private String            state;
    private MosUserBean       mosUser;
    private MosCourseBean     mosCourse;
    private MosCoursePartBean mosCoursePart;
    private String            rows;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPartid() {
        return partid;
    }

    public void setPartid(String partid) {
        this.partid = partid;
    }

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    public long getDatetime() {
        return datetime;
    }

    public void setDatetime(long datetime) {
        this.datetime = datetime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public MosUserBean getMosUser() {
        return mosUser;
    }

    public void setMosUser(MosUserBean mosUser) {
        this.mosUser = mosUser;
    }

    public MosCourseBean getMosCourse() {
        return mosCourse;
    }

    public void setMosCourse(MosCourseBean mosCourse) {
        this.mosCourse = mosCourse;
    }

    public MosCoursePartBean getMosCoursePart() {
        return mosCoursePart;
    }

    public void setMosCoursePart(MosCoursePartBean mosCoursePart) {
        this.mosCoursePart = mosCoursePart;
    }

    public String getRows() {
        return rows;
    }

    public void setRows(String rows) {
        this.rows = rows;
    }

    public static class MosUserBean {
        /**
         * createBy : null
         * createtime : null
         * updatetime : null
         * updateBy : null
         * id : 72
         * username : 尚晓忠
         * password : null
         * usertype : null
         * remark : null
         * datetime : 1505983255000
         * state : null
         * idcard : null
         * pinyin : null
         * noGroup : null
         * page : 1
         * rows : 10
         * order : null
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
        private String state;
        private String idcard;
        private String pinyin;
        private String noGroup;
        private int    page;
        private int    rows;
        private String order;

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

        public String getState() {
            return state;
        }

        public void setState(String state) {
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

        public String getNoGroup() {
            return noGroup;
        }

        public void setNoGroup(String noGroup) {
            this.noGroup = noGroup;
        }

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getRows() {
            return rows;
        }

        public void setRows(int rows) {
            this.rows = rows;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }
    }

    public static class MosCourseBean {
        /**
         * id : 72
         * coursename : “两学一做“微课堂
         * coursedesc : null
         * coursepic : null
         * coursetype : null
         * datetime : 1505983255000
         * ishot : null
         * hotsort : null
         * state : null
         * statesort : null
         * isnew : null
         * newsort : null
         * mosCourseType : null
         * mosDissertation : null
         * dissertationid : null
         * dissertationsort : null
         */

        private int id;
        private String coursename;
        private String coursedesc;
        private String coursepic;
        private String coursetype;
        private long   datetime;
        private String ishot;
        private String hotsort;
        private String state;
        private String statesort;
        private String isnew;
        private String newsort;
        private String mosCourseType;
        private String mosDissertation;
        private String dissertationid;
        private String dissertationsort;

        public int getId() {
            return id;
        }

        public void setId(int id) {
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

        public String getCoursetype() {
            return coursetype;
        }

        public void setCoursetype(String coursetype) {
            this.coursetype = coursetype;
        }

        public long getDatetime() {
            return datetime;
        }

        public void setDatetime(long datetime) {
            this.datetime = datetime;
        }

        public String getIshot() {
            return ishot;
        }

        public void setIshot(String ishot) {
            this.ishot = ishot;
        }

        public String getHotsort() {
            return hotsort;
        }

        public void setHotsort(String hotsort) {
            this.hotsort = hotsort;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getStatesort() {
            return statesort;
        }

        public void setStatesort(String statesort) {
            this.statesort = statesort;
        }

        public String getIsnew() {
            return isnew;
        }

        public void setIsnew(String isnew) {
            this.isnew = isnew;
        }

        public String getNewsort() {
            return newsort;
        }

        public void setNewsort(String newsort) {
            this.newsort = newsort;
        }

        public String getMosCourseType() {
            return mosCourseType;
        }

        public void setMosCourseType(String mosCourseType) {
            this.mosCourseType = mosCourseType;
        }

        public String getMosDissertation() {
            return mosDissertation;
        }

        public void setMosDissertation(String mosDissertation) {
            this.mosDissertation = mosDissertation;
        }

        public String getDissertationid() {
            return dissertationid;
        }

        public void setDissertationid(String dissertationid) {
            this.dissertationid = dissertationid;
        }

        public String getDissertationsort() {
            return dissertationsort;
        }

        public void setDissertationsort(String dissertationsort) {
            this.dissertationsort = dissertationsort;
        }
    }

    public static class MosCoursePartBean {
        /**
         * id : 72
         * courseid : null
         * partname : 精品课程的课件1
         * parturl : null
         * datetime : 1505983255000
         * state : null
         * mosCourse : null
         * mosType : null
         */

        private int id;
        private String courseid;
        private String partname;
        private String parturl;
        private long   datetime;
        private String state;
        private String mosCourse;
        private String mosType;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCourseid() {
            return courseid;
        }

        public void setCourseid(String courseid) {
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

        public long getDatetime() {
            return datetime;
        }

        public void setDatetime(long datetime) {
            this.datetime = datetime;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getMosCourse() {
            return mosCourse;
        }

        public void setMosCourse(String mosCourse) {
            this.mosCourse = mosCourse;
        }

        public String getMosType() {
            return mosType;
        }

        public void setMosType(String mosType) {
            this.mosType = mosType;
        }
    }
}
