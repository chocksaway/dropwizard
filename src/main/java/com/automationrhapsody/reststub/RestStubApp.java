package com.automationrhapsody.reststub;

import com.automationrhapsody.reststub.controller.PersonController;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;

public class RestStubApp extends Application<RestStubConfig> {

    @Override
    public void initialize(Bootstrap<RestStubConfig> bootstrap) {
        bootstrap.addBundle(new ViewBundle<RestStubConfig>());
    }

    public static void main(String[] args) throws Exception {
        new RestStubApp().run(args);
    }

    @Override
    public void run(RestStubConfig config, Environment env) {
        final PersonController PersonController = new PersonController();
        env.jersey().register(PersonController);

        env.healthChecks().register("template",
                new RestStubCheck(config.getVersion()));
    }
}