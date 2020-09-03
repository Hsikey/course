package classServlet;

import Dao.ClasDAO;
import bean.Apply;
import bean.Class;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/applyToClass")
public class applyToClass extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();//获取session
        ClasDAO clasDAO=new ClasDAO();
        String studentId=request.getParameter("studentId");
        int classId= Integer.parseInt(request.getParameter("classId"));
        //存到session
        boolean flag=clasDAO.register(studentId,classId);
        if(flag==true)
            request.setAttribute("applyisOK",1);
        else
            request.setAttribute("applyisOK",0);
        RequestDispatcher rd = request.getRequestDispatcher("/class_sign_upServlet.do");
        rd.forward(request, response);
    }
}
