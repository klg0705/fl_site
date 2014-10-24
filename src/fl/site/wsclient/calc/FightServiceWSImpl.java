package fl.site.wsclient.calc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import fl.site.wsclient.calc.fight.FightService;
import fl.site.wsclient.calc.fight.FightServiceImplService;
import fl.site.wsclient.calc.fight.Fighter;

public class FightServiceWSImpl implements fl.site.service.FightService {

    private FightServiceImplService service;

    public FightServiceImplService getService() {
        return service;
    }

    public void setService(FightServiceImplService service) {
        this.service = service;
    }

    @Override
    public List<fl.core.domain.Fighter> fight(List<fl.core.domain.Fighter> fighters) {
        List<Fighter> _fighters = new ArrayList<Fighter>(fighters.size());
        for (int i = 0; i < fighters.size(); i++) {
            Fighter _fighter = new Fighter();
            BeanUtils.copyProperties(fighters.get(i), _fighter);
            _fighters.add(_fighter);
        }

        FightService port = (FightService) service.getFightServiceImplPort();
        List<Fighter> _result = port.fight(_fighters);

        List<fl.core.domain.Fighter> result = new ArrayList<fl.core.domain.Fighter>(fighters);
        for (int i = 0; i < _result.size(); i++) {
            fl.core.domain.Fighter fighter = result.get(i);
            BeanUtils.copyProperties(_result.get(i), fighter);
            result.add(fighter);
        }
        return result;
    }

}
