package fl.site.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class SimpleSessionAttributeListener implements HttpSessionAttributeListener {

    public void attributeAdded(HttpSessionBindingEvent se) {
        HttpSession session = se.getSession();
        System.out.println("session (" + session.getId() + ") added attr: " + se.getName() + "=" + se.getValue());
    }

    public void attributeRemoved(HttpSessionBindingEvent se) {
        HttpSession session = se.getSession();
        System.out.println("session (" + session.getId() + ") removed attr: " + se.getName() + "=" + se.getValue());
    }

    public void attributeReplaced(HttpSessionBindingEvent se) {
        HttpSession session = se.getSession();
        System.out.println("session (" + session.getId() + ") replaced attr: " + se.getName() + "=" + se.getValue());
    }
}
