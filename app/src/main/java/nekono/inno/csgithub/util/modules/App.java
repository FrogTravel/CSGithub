package nekono.inno.csgithub.util.modules;

import android.app.Application;

/**
 * Created by ekaterina on 3/22/18.
 * Some dagger 2 magic
 */

public class App extends Application {
    private NetComponent netComponent;

    @Override
    public void onCreate(){
        super.onCreate();

        netComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("https://api.github.com"))///repos/ReactiveX/RxJava/issues
                .build();
    }

    public NetComponent getNetComponent(){
        return netComponent;
    }
}
