package fl.site.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import fl.core.domain.Deity;
import fl.core.domain.Fighter;

public class FighterForm extends ActionForm {

    private static final long serialVersionUID = 1876362164866509924L;

    private Fighter fighter;

    public FighterForm() {
        fighter = new Fighter();
        fighter.setDeity(new Deity());
    }

    public Fighter getFighter() {
        return fighter;
    }

    public void setFighter(Fighter fighter) {
        this.fighter = fighter;
    }

    public void reset(ActionMapping mapping, HttpServletRequest request) {
        super.reset(mapping, request);
    }

    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        String action = request.getParameter(mapping.getParameter());
        if (!"add".equals(action)) {
            return null;
        }

        ActionErrors errors = new ActionErrors();
        if (fighter.getName() == null || fighter.getName().trim().equals("")) {
            errors.add("fighter.name", new ActionMessage("general.message.notEmpty", "Name"));
        }
        if (fighter.getNickName() == null || fighter.getNickName().trim().equals("")) {
            errors.add("fighter.nickName", new ActionMessage("general.message.notEmpty", "Nickname"));
        }
        return errors;
    }

}