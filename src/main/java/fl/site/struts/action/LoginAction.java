package fl.site.struts.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import fl.site.struts.form.PersonForm;
import fl.site.util.PersonSessionUtil;
import fl.user.domain.Person;
import fl.user.service.PersonService;

public class LoginAction extends DispatchAction {

    private PersonService personService;

    public ActionForward initLogin(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) {

        return mapping.findForward("initLogin");
    }

    public ActionForward login(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        PersonForm personForm = (PersonForm) form;
        Person person = personService.getPerson(personForm.getPerson().getAccount(), personForm.getPassword());

        person.setIpLastActived(request.getRemoteAddr());
        person.setDateLastActived(new Date());
        personService.update(person);

        if (person != null) {
            PersonSessionUtil.setPersonInfo(request, person);
        }

        return mapping.findForward("login");
    }

    public ActionForward logout(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        PersonSessionUtil.removePersonInfo(request);
        return mapping.findForward("logout");
    }

    public PersonService getPersonService() {
        return personService;
    }

    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

}