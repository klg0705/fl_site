package fl.site.struts.form;

import org.apache.struts.action.ActionForm;

import fl.core.domain.Deity;

public class DeityForm extends ActionForm {

    private static final long serialVersionUID = -2525558679635362596L;

    private Deity deity;

    public DeityForm() {
        deity = new Deity();
    }

    public Deity getDeity() {
        return deity;
    }

    public void setDeity(Deity deity) {
        this.deity = deity;
    }

}