package cn.connxun.train.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wushange on 2017/9/21.
 */

public class CourseType implements Serializable{


    /**
     * id : 7
     * typename : 微课堂
     * datetime : null
     * state : 0
     * typepic : 1504574729528.jpg
     * mosCourseList : [{"id":51,"coursename":"精品课程测试","coursedesc":"精品课程测试","coursepic":null,"coursetype":7,"datetime":1505451839000,"ishot":1,"hotsort":1,"state":1,"statesort":1,"isnew":0,"newsort":0,"mosCourseType":{"id":51,"typename":null,"datetime":1505451839000,"state":1,"typepic":null,"mosCourseList":null},"mosDissertation":{"id":51,"typename":null,"datetime":1505451839000,"state":1,"typepic":null},"dissertationid":0,"dissertationsort":0},{"id":40,"coursename":"\u201c两学一做\u201c微课堂","coursedesc":"\u201c两学一做\u201c微课堂","coursepic":"1504494774363.jpg","coursetype":7,"datetime":1504251276000,"ishot":0,"hotsort":0,"state":0,"statesort":0,"isnew":0,"newsort":0,"mosCourseType":{"id":40,"typename":null,"datetime":1504251276000,"state":0,"typepic":null,"mosCourseList":null},"mosDissertation":{"id":40,"typename":null,"datetime":1504251276000,"state":0,"typepic":null},"dissertationid":0,"dissertationsort":0},{"id":39,"coursename":"技术微课堂","coursedesc":"304所技术微课堂","coursepic":"1504494816869.jpg","coursetype":7,"datetime":1504251227000,"ishot":0,"hotsort":0,"state":0,"statesort":0,"isnew":0,"newsort":0,"mosCourseType":{"id":39,"typename":null,"datetime":1504251227000,"state":0,"typepic":null,"mosCourseList":null},"mosDissertation":{"id":39,"typename":null,"datetime":1504251227000,"state":0,"typepic":null},"dissertationid":0,"dissertationsort":0},{"id":38,"coursename":"管理微课堂","coursedesc":"管理微课堂","coursepic":"1504494832772.jpg","coursetype":7,"datetime":1504251214000,"ishot":0,"hotsort":0,"state":0,"statesort":0,"isnew":0,"newsort":0,"mosCourseType":{"id":38,"typename":null,"datetime":1504251214000,"state":0,"typepic":null,"mosCourseList":null},"mosDissertation":{"id":38,"typename":null,"datetime":1504251214000,"state":0,"typepic":null},"dissertationid":0,"dissertationsort":0}]
     */

    private int id;
    private String                  typename;
    private Object                  datetime;
    private int                     state;
    private String                  typepic;
    private List<MosCourseListBean> mosCourseList;

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

    public List<MosCourseListBean> getMosCourseList() {
        return mosCourseList;
    }

    public void setMosCourseList(List<MosCourseListBean> mosCourseList) {
        this.mosCourseList = mosCourseList;
    }

    public static class MosCourseListBean implements Serializable {
        /**
         * id : 51
         * coursename : 精品课程测试
         * coursedesc : 精品课程测试
         * coursepic : null
         * coursetype : 7
         * datetime : 1505451839000
         * ishot : 1
         * hotsort : 1
         * state : 1
         * statesort : 1
         * isnew : 0
         * newsort : 0
         * mosCourseType : {"id":51,"typename":null,"datetime":1505451839000,"state":1,"typepic":null,"mosCourseList":null}
         * mosDissertation : {"id":51,"typename":null,"datetime":1505451839000,"state":1,"typepic":null}
         * dissertationid : 0
         * dissertationsort : 0
         */

        private int id;
        private String              coursename;
        private String              coursedesc;
        private String              coursepic;
        private int                 coursetype;
        private long                datetime;
        private int                 ishot;
        private int                 hotsort;
        private int                 state;
        private int                 statesort;
        private int                 isnew;
        private int                 newsort;
        private MosCourseTypeBean   mosCourseType;
        private MosDissertationBean mosDissertation;
        private int                 dissertationid;
        private int                 dissertationsort;

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

        public int getIshot() {
            return ishot;
        }

        public void setIshot(int ishot) {
            this.ishot = ishot;
        }

        public int getHotsort() {
            return hotsort;
        }

        public void setHotsort(int hotsort) {
            this.hotsort = hotsort;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public int getStatesort() {
            return statesort;
        }

        public void setStatesort(int statesort) {
            this.statesort = statesort;
        }

        public int getIsnew() {
            return isnew;
        }

        public void setIsnew(int isnew) {
            this.isnew = isnew;
        }

        public int getNewsort() {
            return newsort;
        }

        public void setNewsort(int newsort) {
            this.newsort = newsort;
        }

        public MosCourseTypeBean getMosCourseType() {
            return mosCourseType;
        }

        public void setMosCourseType(MosCourseTypeBean mosCourseType) {
            this.mosCourseType = mosCourseType;
        }

        public MosDissertationBean getMosDissertation() {
            return mosDissertation;
        }

        public void setMosDissertation(MosDissertationBean mosDissertation) {
            this.mosDissertation = mosDissertation;
        }

        public int getDissertationid() {
            return dissertationid;
        }

        public void setDissertationid(int dissertationid) {
            this.dissertationid = dissertationid;
        }

        public int getDissertationsort() {
            return dissertationsort;
        }

        public void setDissertationsort(int dissertationsort) {
            this.dissertationsort = dissertationsort;
        }

        public static class MosCourseTypeBean implements Serializable {
            /**
             * id : 51
             * typename : null
             * datetime : 1505451839000
             * state : 1
             * typepic : null
             * mosCourseList : null
             */

            private int id;
            private String typename;
            private long   datetime;
            private int    state;
            private String typepic;
            private Object mosCourseList;

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

            public String getTypepic() {
                return typepic;
            }

            public void setTypepic(String typepic) {
                this.typepic = typepic;
            }

            public Object getMosCourseList() {
                return mosCourseList;
            }

            public void setMosCourseList(Object mosCourseList) {
                this.mosCourseList = mosCourseList;
            }
        }

        public static class MosDissertationBean implements Serializable{
            /**
             * id : 51
             * typename : null
             * datetime : 1505451839000
             * state : 1
             * typepic : null
             */

            private int id;
            private String typename;
            private long   datetime;
            private int    state;
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

            public String getTypepic() {
                return typepic;
            }

            public void setTypepic(String typepic) {
                this.typepic = typepic;
            }
        }
    }
}
