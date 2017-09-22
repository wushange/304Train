package cn.connxun.train.api;

import java.util.List;

import cn.connxun.train.entity.AppInfo;
import cn.connxun.train.entity.Banner;
import cn.connxun.train.entity.BrowserHistory;
import cn.connxun.train.entity.CType;
import cn.connxun.train.entity.Course;
import cn.connxun.train.entity.CourseType;
import cn.connxun.train.entity.MyCourse;
import cn.connxun.train.entity.PUser;
import cn.connxun.train.entity.QuestBean;
import cn.connxun.train.entity.SubClass;
import cn.connxun.train.entity.VideoClass;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by wushange on 2017/7/11.
 */

public interface AppApiService {
    /**
     * 获取当前用户信息
     *
     * @return
     */
    @FormUrlEncoded
    @POST("usr/login.api")
    Observable<PUser> login(@Field("pinyin") String pinyin, @Field("password") String password);

    /**
     * 修改密码
     *
     * @return
     */
    @FormUrlEncoded
    @POST("usr/reg.api")
    Observable<String> regist(@Field("username") String username, @Field("password") String password, @Field("idcard") String idcard
            , @Field("isAndroid") String isAndroid);


    /**
     * 获取当前用户信息
     *
     * @return
     */
    @POST("course/list.api")
    Observable<List<VideoClass>> list();

    /**
     * 获取当前用户信息
     *
     * @return
     */
    @FormUrlEncoded
    @POST("coursePart/byCourseidList.api")
    Observable<List<SubClass>> getSublist(@Field("courseid") String courseid);


    /**
     * 获取当前用户信息
     *
     * @return
     */

    @FormUrlEncoded
    @POST("about/info.api")
    Observable<AppInfo> getAboutInfo(@Field("id") String id);

    /**
     * 获取当前用户信息
     *
     * @return
     */
    @POST("banner/getList.api")
    Observable<List<Banner>> getBannerList();

    @FormUrlEncoded
    @POST("course/favorite.api")
    Observable<Object> like(@Field("userid") String userid, @Field("courseid") String courseid);

    @FormUrlEncoded
    @POST("course/isFavorite.api")
    Observable<String> isLike(@Field("userid") String userid, @Field("courseid") String courseid);

    @FormUrlEncoded
    @POST("course/favoriteDel.api")
    Observable<Object> unLike(@Field("userid") String userid, @Field("courseid") String courseid);

    @FormUrlEncoded
    @POST("course/favorite/list.api")
    Observable<List<VideoClass>> getMyClassList(@Field("userid") String userid, @Field("state") String state);


    @FormUrlEncoded
    @POST("course/selList.api")
    Observable<List<VideoClass>> search(@Field("coursename") String coursename, @Field("isAndroid") String isAndroid);


    @POST("help/list.api")
    Observable<List<QuestBean>> getQuestList();

    @POST("courseType/list.api")
    Observable<List<CType>> getTypeList();

    @FormUrlEncoded
    @POST("course/listByType.api")
    Observable<List<VideoClass>> getListByType(@Field("typeid") String typeid);

    @FormUrlEncoded
    @POST("pushed/findCourseByGroupId.api")
    Observable<List<VideoClass>> getListSB(@Field("groupid") String groupid);

    @FormUrlEncoded
    @POST("userCourseLog/insert.api")
    Observable<Integer> insertLog(@Field("userid") String userid, @Field("partid") String partid, @Field("state") Integer state);


    @FormUrlEncoded
    @POST("pushed/findCourseByGroupIdAndUserId.api")
    Observable<List<MyCourse>> getMyPushClassList(@Field("userid") String userid, @Field("groupid") String groupid);


    @POST("course/list.api?state=1")
    Observable<List<Course>> getJingXuan();


    @FormUrlEncoded
    @POST("userCourseLog/getListByUserId.api")
    Observable<List<Course>> getHistorys(@Field("userid") String userId, @Field("rows") int rows);


    @POST("course/list.api?ishot=1")
    Observable<List<Course>> getHotList();

    @POST("course/list.api?isnew=1")
    Observable<List<Course>> getNewList();


    @POST("course/list.api?dissertationid=0")
    Observable<List<Course>> getSpecList();


    @FormUrlEncoded
    @POST("userCourseLog/getList.api")
    Observable<List<BrowserHistory>> getBrowseHistory(@Field("userid") String userid);

    @POST("courseType/courseTypeList.api")
    Observable<List<CourseType>> getCourseTypeList();

    @FormUrlEncoded
    @POST("type/byCourseidList.api")
    Observable<List<CourseType>> getCourseListByType(@Field("courseid") String cid);

}
