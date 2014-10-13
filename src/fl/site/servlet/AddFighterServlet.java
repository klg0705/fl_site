package fl.site.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fl.core.domain.Fighter;
import fl.core.service.FighterService;
import fl.core.service.FighterServiceImpl;
import fl.site.bean.StudentVO;

public class AddFighterServlet extends HttpServlet {
    
    private static final long serialVersionUID = 5490569009174482040L;
    
    private FighterService fighterService = new FighterServiceImpl();
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        StudentVO studentVO = new StudentVO();
        studentVO.setName(request.getParameter("name"));
        studentVO.setNickName(request.getParameter("nickName"));
        
        String error = validate(studentVO);
        if(error != null) {
            request.setAttribute("error", error);
        } else {
            Fighter fighter = new Fighter();
            fighter.setName(studentVO.getName());
            fighter.setNickName(studentVO.getNickName());
            try {
                fighterService.addFighter(fighter);
            } catch (SQLException e) {
                throw new ServletException(e.getMessage(), e.getCause());
            }
            request.setAttribute("newFighter", fighter);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/");
        try {
            dispatcher.forward(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String validate(StudentVO studentVO) {
        if(studentVO.getName() == null || studentVO.getName().trim().equals("")) {
            return "姓名不能为空";
        }
        if(studentVO.getNickName() == null || studentVO.getNickName().trim().equals("")) {
            return "昵称不能为空";
        }
        return null;
    }

}
