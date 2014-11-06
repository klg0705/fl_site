package fl.site.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.util.WebUtils;

import fl.user.domain.Person;

public class PersonSessionUtil {

    public static final String PERSON_INFO = "personInfo";

    public static PersonInfo getPersonInfo(HttpServletRequest request) {
        return (PersonInfo) WebUtils.getSessionAttribute(request, PERSON_INFO);
    }

    public static void setPersonInfo(HttpServletRequest request, Person person) {
        PersonInfo personInfo = new PersonInfo();
        personInfo.setId(person.getId());
        personInfo.setAccount(person.getAccount());

        WebUtils.setSessionAttribute(request, PERSON_INFO, personInfo);
    }

}
