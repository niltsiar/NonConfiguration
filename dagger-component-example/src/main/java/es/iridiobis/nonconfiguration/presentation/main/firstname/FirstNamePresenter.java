package es.iridiobis.nonconfiguration.presentation.main.firstname;

import javax.inject.Inject;

import es.iridiobis.nonconfiguration.core.BasePresenter;
import es.iridiobis.nonconfiguration.core.injection.FragmentScope;
import es.iridiobis.nonconfiguration.domain.usecases.salutation.FirstNameUseCase;
import hugo.weaving.DebugLog;

@FragmentScope
public class FirstNamePresenter
        extends BasePresenter<FirstName.View>
        implements FirstName.Presenter,
        FirstNameUseCase.Listener {

    private final FirstName.Navigator navigator;
    private final FirstNameUseCase useCase;
    private String firstName;

    @DebugLog
    @Inject
    public FirstNamePresenter(
            final FirstName.Navigator navigator,
            final FirstNameUseCase useCase) {

        this.navigator = navigator;
        this.useCase = useCase;
    }

    @Override
    public void updateFirstName(final String firstName) {
        this.firstName = firstName;
        updateNextButton();
    }

    @Override
    public void confirmFirstName() {
        useCase.giveFirstName(firstName, this);
    }

    @Override
    public void askForLastName(final String firstName) {
        navigator.goToLastNameScreen(firstName);
    }

    @Override
    protected void onViewAttached() {
        showFirstName();
        updateNextButton();
    }

    private void showFirstName() {
        getView().showFirstName(firstName);
    }

    private void updateNextButton() {
        if (hasView()) {
            getView().enableNextButton(firstName != null && !firstName.isEmpty());
        }
    }
}
