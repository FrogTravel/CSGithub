package nekono.inno.csgithub.util.modules;

import javax.inject.Singleton;

import dagger.Component;
import nekono.inno.csgithub.ui.main.view.MainActivity;

/**
 * Created by ekaterina on 3/22/18.
 */

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    void inject(MainActivity activity);
}

