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

public class PersonAction extends DispatchAction {

    private PersonService personService;

    public ActionForward initAdd(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) {

        return mapping.findForward("initAdd");
    }

    public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) {

        PersonForm personForm = (PersonForm) form;

        Person person = personForm.getPerson();
        person.setIpCreated(request.getRemoteAddr());
        person.setIpLastActived(request.getRemoteAddr());
        person.setDateCreated(new Date());
        person.setDateLastActived(new Date());

        personService.create(person);
        PersonSessionUtil.setPersonInfo(request, person);

        return mapping.findForward("add");
    }

    public PersonService getPersonService() {
        return personService;
    }

    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

}