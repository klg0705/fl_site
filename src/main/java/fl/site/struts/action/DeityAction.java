package fl.site.struts.action;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.web.util.WebUtils;

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

        Serializable deityId = (Serializable) WebUtils.getSessionAttribute(request, "DEITY_ID");
        if (deityId != null) {
            Deity deity = deityService.get(deityId);
            request.setAttribute("DEITY", deity);
        }
        return mapping.findForward("view");
    }
}