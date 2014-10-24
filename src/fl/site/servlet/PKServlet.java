package fl.site.servlet;

import java.io.IOException;
import java.util.ArrayList;
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
import fl.core.service.FighterService;
import fl.site.service.FightService;

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
            message = "No fighters selected.";
        } else {
            Fighter fighter1 = fighterService.get(Integer.parseInt(fighterId1));
            Fighter fighter2 = fighterService.get(Integer.parseInt(fighterId2));
            List<Fighter> fighters = new ArrayList<Fighter>();
            fighters.add(fighter1);
            fighters.add(fighter2);

            fighters = fightService.fight(fighters);

            fighter1 = fighters.get(0);
            fighter2 = fighters.get(1);
            if (fighter1.getHp() <= 0) {
                message = fighter2.getName() + "(" + fighter2.getHp() + ") is winner! " + fighter1.getName()
                        + " is killed...";
                fighterService.deleteById(fighter1.getId());
            } else {
                message = fighter1.getName() + "(" + fighter1.getHp() + ") is winner! " + fighter2.getName()
                        + " is killed...";
                fighterService.deleteById(fighter2.getId());
            }
        }

        request.setAttribute("message", message);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/");
        try {
            dispatcher.forward(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
