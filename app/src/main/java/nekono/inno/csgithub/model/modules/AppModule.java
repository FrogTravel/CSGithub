package nekono.inno.csgithub.model.modules;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ekaterina on 3/22/18.
 */

@Module
public class AppModule {
    Application mApplication;

    public AppModule(Application mApplication){
        this.mApplication = mApplication;
    }

    @Provides
    @Singleton
    Application provideApplication(){
        return mApplication;
    }
}
