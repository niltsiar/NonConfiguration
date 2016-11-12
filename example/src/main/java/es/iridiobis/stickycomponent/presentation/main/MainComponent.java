package es.iridiobis.stickycomponent.presentation.main;

import android.content.Context;

import dagger.Component;
import es.iridiobis.stickycomponent.ApplicationComponent;
import es.iridiobis.stickycomponent.ExampleApplication;
import es.iridiobis.stickycomponent.core.injection.ActivityScope;

@ActivityScope
@Component(dependencies = ApplicationComponent.class, modules = MainModule.class)
public interface MainComponent {
    final class Initializer {
        private Initializer() {
            //Only static methods, do not allow instances
        }

        public static MainComponent init(final Context context) {
            return DaggerMainComponent.builder()
                    .applicationComponent(ExampleApplication.getApplicationComponent(context))
                    .mainModule(new MainModule())
                    .build();
        }
    }

    void inject(MainActivity activity);
}
