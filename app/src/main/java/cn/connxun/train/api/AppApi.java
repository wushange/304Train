package cn.connxun.train.api;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.List;

import cn.connxun.train.constants.Constants;
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
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.http.Field;

/**
 * Created by wushange on 2017/7/11.
 */

public class AppApi implements  AppApiService {
    public static final String BASE_URL = Constants.HOST + "FHBE/api/";
    private AppApiService service;

    public AppApi(OkHttpClient mOkHttpClient) {
        Retrofit retrofit =
                new Retrofit.Builder()
                        .client(mOkHttpClient)
                        .baseUrl(BASE_URL)
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .addConverterFactory( cn.connxun.train.components.retrofit.GsonConverterFactory.create())
                        .build();
        service = retrofit.create(AppApiService.class);
    }
    @Override
    public Observable<PUser> login(String userName, String pwd) {
        return service.login(userName, pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<String> regist(@Field("username") String username, @Field("password") String password, @Field("idcard") String idcard, @Field("isAndroid") String isAndroid) {
        return null;
    }

    public Observable<String> regist(String userName, String pwd, String userCard) {
        return service.regist(userName, pwd, userCard,"1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }

    @Override
    public Observable<List<VideoClass>> list() {
        return service.list()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
    @Override
    public Observable<List<SubClass>> getSublist(String pid) {
        return service.getSublist(pid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
    @Override
    public Observable<AppInfo> getAboutInfo(String id) {
        return service.getAboutInfo("1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
    @Override
    public Observable<List<Banner>> getBannerList() {
        return service.getBannerList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
    @Override
    public Observable<Object> like(String userid, String cid) {
        return service.like(userid, cid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {

                    }
                });
    }

    @Override
    public Observable<String> isLike(@Field("userid") String userid, @Field("courseid") String courseid) {
        return service.isLike(userid,courseid)  .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<Object> unLike(@Field("userid") String userid, @Field("courseid") String courseid) {
        return service.unLike(userid,courseid)  .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<List<VideoClass>> getMyClassList(@Field("userid") String userid, @Field("state") String state) {
        return service.getMyClassList(userid, state)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<List<VideoClass>> search(String pname,String string) {
        return service.search(pname,"1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<List<QuestBean>> getQuestList() {
        return service.getQuestList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<List<CType>> getTypeList() {
        return service.getTypeList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
    @Override
    public Observable<List<VideoClass>> getListByType(String tid) {
        return service.getListByType(tid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
    @Override
    public Observable<List<VideoClass>> getListSB(String uid) {
        return service.getListSB(uid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<Integer> insertLog(@Field("userid") String userid, @Field("partid") String partid, @Field("state") Integer state) {
        return service.insertLog(userid,partid,state).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<List<MyCourse>> getMyPushClassList(@Field("userid") String userid, @Field("groupid") String groupid) {
        return service.getMyPushClassList(userid,groupid).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<List<Course>> getJingXuan() {
        return service.getJingXuan().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<List<Course>> getHistorys(@Field("userid") String userId, @Field("rows") int rows) {
        return service.getHistorys(userId,rows).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<List<Course>> getHotList() {
        return service.getHotList().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<List<Course>> getNewList() {
        return service.getNewList().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<List<Course>> getSpecList() {
        return service.getSpecList().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<List<BrowserHistory>> getBrowseHistory(@Field("userid") String userid) {
        return service.getBrowseHistory(userid).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<List<CourseType>> getCourseTypeList() {
        return service.getCourseTypeList().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<List<CourseType>> getCourseListByType(@Field("courseid") String cid) {
        return service.getCourseListByType(cid).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }


}
