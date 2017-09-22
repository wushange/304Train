package cn.connxun.train.entity;

/**
 * Created by wushange on 2017/9/21.
 */

public class MyCourse {


    /**
     * id : 34
     * courseid : null
     * groupid : null
     * userid : null
     * datetime : 1504251061000
     * state : null
     * mosCourse : {"id":34,"coursename":"质量管理","coursedesc":null,"coursepic":"1505043525173.jpg","coursetype":null,"datetime":1504251061000,"ishot":null,"hotsort":null,"state":null,"statesort":null,"isnew":null,"newsort":null,"mosCourseType":null,"mosDissertation":null,"dissertationid":null,"dissertationsort":null}
     * mosUser : {"createBy":null,"createtime":null,"updatetime":null,"updateBy":null,"id":34,"username":null,"password":null,"usertype":null,"remark":null,"datetime":1504251061000,"state":null,"idcard":null,"pinyin":null,"noGroup":null,"page":1,"rows":10,"order":null}
     * mosUserGroup : {"id":34,"groupname":null,"grouptype":null,"datetime":1504251061000,"state":null}
     */

    private int id;
    private Object           courseid;
    private Object           groupid;
    private Object           userid;
    private long             datetime;
    private Object           state;
    private MosCourseBean    mosCourse;
    private MosUserBean      mosUser;
    private MosUserGroupBean mosUserGroup;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getCourseid() {
        return courseid;
    }

    public void setCourseid(Object courseid) {
        this.courseid = courseid;
    }

    public Object getGroupid() {
        return groupid;
    }

    public void setGroupid(Object groupid) {
        this.groupid = groupid;
    }

    public Object getUserid() {
        return userid;
    }

    public void setUserid(Object userid) {
        this.userid = userid;
    }

    public long getDatetime() {
        return datetime;
    }

    public void setDatetime(long datetime) {
        this.datetime = datetime;
    }

    public Object getState() {
        return state;
    }

    public void setState(Object state) {
        this.state = state;
    }

    public MosCourseBean getMosCourse() {
        return mosCourse;
    }

    public void setMosCourse(MosCourseBean mosCourse) {
        this.mosCourse = mosCourse;
    }

    public MosUserBean getMosUser() {
        return mosUser;
    }

    public void setMosUser(MosUserBean mosUser) {
        this.mosUser = mosUser;
    }

    public MosUserGroupBean getMosUserGroup() {
        return mosUserGroup;
    }

    public void setMosUserGroup(MosUserGroupBean mosUserGroup) {
        this.mosUserGroup = mosUserGroup;
    }

    public static class MosCourseBean {
        /**
         * id : 34
         * coursename : 质量管理
         * coursedesc : null
         * coursepic : 1505043525173.jpg
         * coursetype : null
         * datetime : 1504251061000
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
        private Object coursedesc;
        private String coursepic;
        private Object coursetype;
        private long   datetime;
        private Object ishot;
        private Object hotsort;
        private Object state;
        private Object statesort;
        private Object isnew;
        private Object newsort;
        private Object mosCourseType;
        private Object mosDissertation;
        private Object dissertationid;
        private Object dissertationsort;

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

        public Object getCoursedesc() {
            return coursedesc;
        }

        public void setCoursedesc(Object coursedesc) {
            this.coursedesc = coursedesc;
        }

        public String getCoursepic() {
            return coursepic;
        }

        public void setCoursepic(String coursepic) {
            this.coursepic = coursepic;
        }

        public Object getCoursetype() {
            return coursetype;
        }

        public void setCoursetype(Object coursetype) {
            this.coursetype = coursetype;
        }

        public long getDatetime() {
            return datetime;
        }

        public void setDatetime(long datetime) {
            this.datetime = datetime;
        }

        public Object getIshot() {
            return ishot;
        }

        public void setIshot(Object ishot) {
            this.ishot = ishot;
        }

        public Object getHotsort() {
            return hotsort;
        }

        public void setHotsort(Object hotsort) {
            this.hotsort = hotsort;
        }

        public Object getState() {
            return state;
        }

        public void setState(Object state) {
            this.state = state;
        }

        public Object getStatesort() {
            return statesort;
        }

        public void setStatesort(Object statesort) {
            this.statesort = statesort;
        }

        public Object getIsnew() {
            return isnew;
        }

        public void setIsnew(Object isnew) {
            this.isnew = isnew;
        }

        public Object getNewsort() {
            return newsort;
        }

        public void setNewsort(Object newsort) {
            this.newsort = newsort;
        }

        public Object getMosCourseType() {
            return mosCourseType;
        }

        public void setMosCourseType(Object mosCourseType) {
            this.mosCourseType = mosCourseType;
        }

        public Object getMosDissertation() {
            return mosDissertation;
        }

        public void setMosDissertation(Object mosDissertation) {
            this.mosDissertation = mosDissertation;
        }

        public Object getDissertationid() {
            return dissertationid;
        }

        public void setDissertationid(Object dissertationid) {
            this.dissertationid = dissertationid;
        }

        public Object getDissertationsort() {
            return dissertationsort;
        }

        public void setDissertationsort(Object dissertationsort) {
            this.dissertationsort = dissertationsort;
        }
    }

    public static class MosUserBean {
        /**
         * createBy : null
         * createtime : null
         * updatetime : null
         * updateBy : null
         * id : 34
         * username : null
         * password : null
         * usertype : null
         * remark : null
         * datetime : 1504251061000
         * state : null
         * idcard : null
         * pinyin : null
         * noGroup : null
         * page : 1
         * rows : 10
         * order : null
         */

        private Object createBy;
        private Object createtime;
        private Object updatetime;
        private Object updateBy;
        private int    id;
        private Object username;
        private Object password;
        private Object usertype;
        private Object remark;
        private long   datetime;
        private Object state;
        private Object idcard;
        private Object pinyin;
        private Object noGroup;
        private int    page;
        private int    rows;
        private Object order;

        public Object getCreateBy() {
            return createBy;
        }

        public void setCreateBy(Object createBy) {
            this.createBy = createBy;
        }

        public Object getCreatetime() {
            return createtime;
        }

        public void setCreatetime(Object createtime) {
            this.createtime = createtime;
        }

        public Object getUpdatetime() {
            return updatetime;
        }

        public void setUpdatetime(Object updatetime) {
            this.updatetime = updatetime;
        }

        public Object getUpdateBy() {
            return updateBy;
        }

        public void setUpdateBy(Object updateBy) {
            this.updateBy = updateBy;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Object getUsername() {
            return username;
        }

        public void setUsername(Object username) {
            this.username = username;
        }

        public Object getPassword() {
            return password;
        }

        public void setPassword(Object password) {
            this.password = password;
        }

        public Object getUsertype() {
            return usertype;
        }

        public void setUsertype(Object usertype) {
            this.usertype = usertype;
        }

        public Object getRemark() {
            return remark;
        }

        public void setRemark(Object remark) {
            this.remark = remark;
        }

        public long getDatetime() {
            return datetime;
        }

        public void setDatetime(long datetime) {
            this.datetime = datetime;
        }

        public Object getState() {
            return state;
        }

        public void setState(Object state) {
            this.state = state;
        }

        public Object getIdcard() {
            return idcard;
        }

        public void setIdcard(Object idcard) {
            this.idcard = idcard;
        }

        public Object getPinyin() {
            return pinyin;
        }

        public void setPinyin(Object pinyin) {
            this.pinyin = pinyin;
        }

        public Object getNoGroup() {
            return noGroup;
        }

        public void setNoGroup(Object noGroup) {
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

        public Object getOrder() {
            return order;
        }

        public void setOrder(Object order) {
            this.order = order;
        }
    }

    public static class MosUserGroupBean {
        /**
         * id : 34
         * groupname : null
         * grouptype : null
         * datetime : 1504251061000
         * state : null
         */

        private int id;
        private Object groupname;
        private Object grouptype;
        private long   datetime;
        private Object state;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Object getGroupname() {
            return groupname;
        }

        public void setGroupname(Object groupname) {
            this.groupname = groupname;
        }

        public Object getGrouptype() {
            return grouptype;
        }

        public void setGrouptype(Object grouptype) {
            this.grouptype = grouptype;
        }

        public long getDatetime() {
            return datetime;
        }

        public void setDatetime(long datetime) {
            this.datetime = datetime;
        }

        public Object getState() {
            return state;
        }

        public void setState(Object state) {
            this.state = state;
        }
    }
}
