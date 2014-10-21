package fl.site.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fl.core.domain.Fighter;
import fl.core.service.DeityService;
import fl.core.service.FighterService;
import fl.core.service.impl.DeityServiceImpl;
import fl.core.service.impl.FighterServiceImpl;
import fl.site.bean.FighterVO;

public class AddFighterServlet extends HttpServlet {
    
    private static final long serialVersionUID = 5490569009174482040L;
    
    private FighterService fighterService = new FighterServiceImpl();
    
    private DeityService deityService = new DeityServiceImpl();
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        FighterVO fighterVO = new FighterVO();
        fighterVO.setName(request.getParameter("name"));
        fighterVO.setNickName(request.getParameter("nickName"));
        fighterVO.setDeityId(request.getParameter("deityId"));
        
        String error = validate(fighterVO);
        if(error != null) {
            request.setAttribute("error", error);
        } else {
            Fighter fighter = new Fighter();
            fighter.setName(fighterVO.getName());
            fighter.setNickName(fighterVO.getNickName());
            fighter.setDeity(deityService.get(Integer.parseInt(fighterVO.getDeityId())));
            fighterService.add(fighter);
            request.setAttribute("newFighter", fighter);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/");
        try {
            dispatcher.forward(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String validate(FighterVO studentVO) {
        if(studentVO.getName() == null || studentVO.getName().trim().equals("")) {
            return "姓名不能为空";
        }
        if(studentVO.getNickName() == null || studentVO.getNickName().trim().equals("")) {
            return "昵称不能为空";
        }
        return null;
    }

}
