package fl.site.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import fl.core.domain.Deity;
import fl.core.domain.Fighter;
import fl.core.service.DeityService;
import fl.core.service.FighterService;
import fl.site.struts.form.FighterForm;

public class FighterAction extends DispatchAction {

    private FighterService fighterService;

    private DeityService deityService;

    public void setFighterService(FighterService fighterService) {
        this.fighterService = fighterService;
    }

    public void setDeityService(DeityService deityService) {
        this.deityService = deityService;
    }

    public FighterService getFighterService() {
        return fighterService;
    }

    public DeityService getDeityService() {
        return deityService;
    }

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        return super.execute(mapping, form, request, response);
    }

    public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        FighterForm fighterForm = (FighterForm) form;
        Fighter fighterBean = fighterForm.getFighter();

        Fighter fighter = new Fighter();
        fighter.setName(fighterBean.getName());
        fighter.setNickName(fighterBean.getNickName());
        fighter.setDeity(deityService.get(fighterBean.getDeity().getId()));
        fighterService.add(fighter);
        request.setAttribute("newFighter", fighter);

        return mapping.findForward("add");
    }

    public ActionForward initAdd(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        return mapping.findForward("initAdd");
    }

    public ActionForward listByDeity(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        int deityId = (int) request.getSession(true).getAttribute("DEITY_ID");
        Deity deity = deityService.getWithFighters(deityId);
        request.setAttribute("DEITY", deity);

        return mapping.findForward("listByDeity");
    }

}