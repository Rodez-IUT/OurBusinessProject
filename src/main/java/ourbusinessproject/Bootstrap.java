package ourbusinessproject;

import org.springframework.beans.factory.annotation.Autowired;

public class Bootstrap {

    private InitializationService initializationService;

    public Bootstrap(@Autowired InitializationService initializationService) {
        this.initializationService = initializationService;
    }

    public void init() {

    }

    public InitializationService getInitializationService() {
        return initializationService;
    }
}
