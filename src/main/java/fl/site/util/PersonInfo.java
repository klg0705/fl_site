package fl.site.util;

import java.io.Serializable;

public class PersonInfo {

    private Serializable id;

    private String account;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Serializable getId() {
        return id;
    }

    public void setId(Serializable id) {
        this.id = id;
    }

    public String toString() {
        return account;
    }

}
