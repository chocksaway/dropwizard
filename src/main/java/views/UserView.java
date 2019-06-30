package views;

import com.automationrhapsody.reststub.data.User;
import io.dropwizard.views.View;

/**
 * Author milesd on 2019-06-30.
 */
public class UserView extends View {
    private final User user;

    public UserView(User user) {
        super("form.ftl");
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}