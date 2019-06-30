package views;

import io.dropwizard.views.View;

/**
 * Author milesd on 2019-06-30.
 */
public class HelloView extends View {
    private final String name;

    public HelloView(String name) {
        super("helloWorld.ftl");
        this.name = name;
    }

    public String getName() {
        return name;
    }
}