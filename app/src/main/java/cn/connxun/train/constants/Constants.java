package cn.connxun.train.constants;


import cn.connxun.train.utils.util.SDCardUtils;

/**
 * Created by wushange on 2017/7/12.
 */

public class Constants {
    //    public static String SERVER_IP    = "117.78.50.48";
    public static String SERVER_IP = "117.78.47.50";
    public static String SERVER_PORT = "8080";
    public static String HOST = "http://" + SERVER_IP + ":" + SERVER_PORT + "/";//服务器地址
    public static String BASE_URL = HOST + "FHBE";
    public static String BASE_API_URL = HOST + "/FHBE/api/";
    public static String BASE_IMAGE_URL = HOST + "/FHBE/course_resourses/";
    public static String BASE_FILE_URL = HOST + "/FHBE/course_part";


    public static String BUGLY_APPID = "2a15f71038";//buglyid
    public static String DCS_KEY = "http://dcsapi.com/?k=181751184&url=";//永中云转换
    public static int ROLE_MANAGER = 4;//管理人员
    public static int ROLE_WORKER = 3;//巡检员

    public static String NIGHT_THEME = "THEME";
    public static String USER_NAME = "USER_NAME";
    public static String USER_PWD = "USER_PWD";
    public static String USER_ID = "USER_ID";

    /**
     * 项目根SD卡目录
     **/
    public static final String PROJECT_ROOT = "304";
    public static final String SDPATH = SDCardUtils.getSDCardPath()
            + PROJECT_ROOT + "/";
    public static final String DOWNLOAD_PATH = SDPATH + "download" + "/";
}
