package fl.site.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import fl.user.domain.Person;

public class PersonForm extends ActionForm {

    private static final long serialVersionUID = -4376485343922597359L;

    private Person person = new Person();

    private String password;

    public void reset(ActionMapping mapping, HttpServletRequest request) {
        super.reset(mapping, request);
    }

    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();

        String action = request.getParameter(mapping.getParameter());
        if ("login".equals(action)) {
            if (person.getAccount() == null || person.getAccount().trim().equals("")) {
                errors.add("person.account", new ActionMessage("general.message.notEmpty", "Account"));
            }
            if (password == null || password.trim().equals("")) {
                errors.add("password", new ActionMessage("general.message.notEmpty", "Password"));
            }
        } else if ("add".equals(action)) {
            if (person.getAccount() == null || person.getAccount().trim().equals("")) {
                errors.add("person.account", new ActionMessage("general.message.notEmpty", "Account"));
            }
            if (person.getPassword() == null || person.getPassword().trim().equals("")) {
                errors.add("person.password", new ActionMessage("general.message.notEmpty", "Password"));
            }
            if (password == null || password.trim().equals("")) {
                errors.add("password", new ActionMessage("general.message.notEmpty", "Confirmed Password"));
            } else if (!password.equals(person.getPassword())) {
                errors.add("password", new ActionMessage("password.not.same"));
            }
            if (person.getName() == null || person.getName().trim().equals("")) {
                errors.add("person.name", new ActionMessage("general.message.notEmpty", "Name"));
            }
            if (person.getEmail() == null || person.getEmail().trim().equals("")) {
                errors.add("person.email", new ActionMessage("general.message.notEmpty", "Email"));
            }
        }

        return errors;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}