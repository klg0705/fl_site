package fl.site.listener;

import java.io.Serializable;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import fl.core.domain.Deity;
import fl.core.service.DeityService;
import fl.site.util.PersonInfo;
import fl.site.util.PersonSessionUtil;
import fl.user.domain.Person;
import fl.user.service.PersonService;

public class LoginEventListener implements HttpSessionAttributeListener {

    private DeityService deityService;

    private PersonService personService;

    public void attributeAdded(HttpSessionBindingEvent se) {
        HttpSession session = se.getSession();
        initService(session.getServletContext());

        PersonInfo personInfo = (PersonInfo) session.getAttribute(PersonSessionUtil.PERSON_INFO);
        Serializable deityId = (Serializable) session.getAttribute("DEITY_ID");
        if (personInfo != null && deityId == null) {
            Person person = personService.get(personInfo.getId());
            createDefaultDeity(session, person);
        }
    }

    private void initService(ServletContext servletContext) {
        if (deityService == null) {
            ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
            deityService = (DeityService) ctx.getBean("deityServiceImpl");
            personService = (PersonService) ctx.getBean("personServiceImpl");
        }
    }

    public void attributeRemoved(HttpSessionBindingEvent se) {
    }

    public void attributeReplaced(HttpSessionBindingEvent se) {
    }

    private void createDefaultDeity(HttpSession session, Person person) {
        Deity deity = deityService.findByPersonId(person.getId());
        // create default deity
        if (deity == null) {
            deity = new Deity();
            deity.setName(person.getName());
            deity.setPerson(person);
            deityService.create(deity);
        }

        session.setAttribute("DEITY_ID", deity.getId());
    }

    public DeityService getDeityService() {
        return deityService;
    }

    public void setDeityService(DeityService deityService) {
        this.deityService = deityService;
    }

    public PersonService getPersonService() {
        return personService;
    }

    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

}
