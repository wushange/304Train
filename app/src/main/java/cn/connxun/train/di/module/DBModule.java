package cn.connxun.train.di.module;

import android.content.Context;

import javax.inject.Singleton;

import cn.connxun.train.db.DaoMaster;
import cn.connxun.train.db.DaoSession;
import cn.connxun.train.db.MyOpenHelper;
import cn.connxun.train.db.VideoClassDao;
import dagger.Module;
import dagger.Provides;

/**
 * Created by sll on 2015/3/4.
 */
@Module
public class DBModule {

    @Provides
    @Singleton
    MyOpenHelper provideMyOpenHelper(Context context) {
        return new MyOpenHelper(context, "app.db", null);
    }

    @Provides
    @Singleton
    DaoMaster provideDaoMaster(MyOpenHelper helper) {
        return new DaoMaster(helper.getWritableDatabase());
    }

    @Provides
    @Singleton
    DaoSession provideDaoSession(DaoMaster master) {
        return master.newSession();
    }

    @Provides
    @Singleton
    VideoClassDao getVideoClassDao(DaoSession session) {
        return session.getVideoClassDao();
    }

}
