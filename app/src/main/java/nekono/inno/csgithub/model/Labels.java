package nekono.inno.csgithub.model;

import java.io.Serializable;

/**
 * Created by ekaterina on 3/23/18.
 */

public class Labels implements Serializable {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
