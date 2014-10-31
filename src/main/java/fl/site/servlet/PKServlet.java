package fl.site.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import fl.core.domain.Fighter;
import fl.core.service.FightService;
import fl.core.service.FighterService;
import fl.site.util.SiteMessages;

public class PKServlet extends HttpServlet {

    private static final long serialVersionUID = 5490569009174482040L;

    private FighterService fighterService;

    private FightService fightService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        WebApplicationContext ac = WebApplicationContextUtils
                .getRequiredWebApplicationContext(this.getServletContext());
        fighterService = (FighterService) ac.getBean("fighterServiceImpl");
        fightService = (FightService) ac.getBean("fightService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        doService(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        doService(req, resp);
    }

    private void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String message = "";

        String fighterId1 = request.getParameter("fighter1");
        String fighterId2 = request.getParameter("fighter2");
        if (fighterId1 == null || fighterId2 == null) {
            message = SiteMessages.getCLString("pk.needmorefighters");
        } else {
            String[] fighterIds = new String[2];
            fighterIds[0] = fighterId1;
            fighterIds[1] = fighterId2;
            List<Fighter> fighters = fightService.fight(fighterIds);

            Fighter fighter1 = fighters.get(0);
            Fighter fighter2 = fighters.get(1);
            if (fighter1.getHp() <= 0) {
                message = SiteMessages.getCLString("pk.result", fighter2.getName(), fighter2.getHp(),
                        fighter1.getName());
                fighterService.deleteById(fighter1.getId());
            } else {
                message = SiteMessages.getCLString("pk.result", fighter1.getName(), fighter1.getHp(),
                        fighter2.getName());
                fighterService.deleteById(fighter2.getId());
            }
        }

        request.setAttribute("message", message);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.do");
        try {
            dispatcher.forward(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
