package cn.connxun.train.di.module;

import javax.inject.Singleton;

import cn.connxun.train.api.AppApi;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module
public class ApiModule {

    @Provides
    @Singleton
    public AppApi provideAppApi(  OkHttpClient okHttpClient) {
        return new AppApi( okHttpClient);
    }

}
