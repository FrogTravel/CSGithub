package nekono.inno.csgithub.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ekaterina on 3/22/18.
 * Serializable because the object will be passed through intent
 */

public class Issue implements Serializable {
    private String title;
    private String body;
    private String created_at;
    private String state;

    private List<Labels> labels;
    private User user;

    public Issue(String title, String body, String created_at, String state) {
        this.title = title;
        this.body = body;
        this.created_at = created_at;
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<Labels> getLabels() {
        return labels;
    }

    public void setLabels(List<Labels> labels) {
        this.labels = labels;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
