package cn.connxun.train.utils;

import cn.connxun.train.data.ACache;
import cn.connxun.train.entity.PUser;

import static cn.connxun.train.constants.Constants.USER_ID;

/**
 * Created by wushange on 2017/9/9.
 */

public class UserUtil {
    public static PUser getUser() {
        return (PUser) ACache.get(cn.connxun.train.utils.util.Utils.getContext()).getAsObject(USER_ID);
    }
}
