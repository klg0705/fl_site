package fl.site.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import fl.core.domain.Deity;
import fl.core.service.DeityService;

public class DeityAction extends DispatchAction {

    private DeityService deityService;

    public DeityService getDeityService() {
        return deityService;
    }

    public void setDeityService(DeityService deityService) {
        this.deityService = deityService;
    }

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        return super.execute(mapping, form, request, response);
    }

    public ActionForward view(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        Deity deity = null;
        List<Deity> deities = deityService.getAll();
        if (deities == null || deities.size() == 0) {
            deity = new Deity();
            deity.setName("GOD");
            deityService.create(deity);
        } else {
            deity = deities.get(0);
        }

        request.getSession(true).setAttribute("DEITY_ID", deity.getId());
        request.setAttribute("DEITY", deity);

        return mapping.findForward("view");
    }

}