package es.iridiobis.stickycomponent.core.injection.main.lastname;


import dagger.Component;
import es.iridiobis.stickycomponent.core.injection.FragmentScope;
import es.iridiobis.stickycomponent.core.injection.HasComponent;
import es.iridiobis.stickycomponent.core.injection.main.MainComponent;
import es.iridiobis.stickycomponent.presentation.main.lastname.LastNameFragment;

@FragmentScope
@Component(dependencies = MainComponent.class, modules = LastNameModule.class)
public interface LastNameComponent {

    void inject(LastNameFragment fragment);

    final class Initializer {
        private Initializer() {
            //Only static methods, do not allow instances
        }

        public static LastNameComponent init(
                final String firstName,
                final HasComponent<MainComponent> componentOwner) {
            return DaggerLastNameComponent.builder()
                    .mainComponent(componentOwner.getComponent())
                    .lastNameModule(new LastNameModule(firstName))
                    .build();
        }
    }
}
