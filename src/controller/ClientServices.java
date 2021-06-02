/*
 * Created By Raed Attia
 * Github : https://github.com/raed-logong
 */

/*
 * Created By Raed Attia
 * Github : https://github.com/raed-logong
 */

/*
 * Created By Raed Attia
 */

package controller;

import java.util.ArrayList;

public interface ClientServices<Partner> {
    Boolean add(Partner E);

    Boolean edit(Partner E);

    Boolean delete(String code);

    ArrayList<Partner> getAll();

    Partner getByName(String name);
}
