package es.iridiobis.nonconfiguration.domain.usecases.salutation;


public interface LastNameUseCase {
    void giveLastName(String lastName, Listener listener);

    interface Listener {
        void showSalutation(String fullName);
    }
}
