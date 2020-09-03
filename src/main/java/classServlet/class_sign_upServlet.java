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

@WebServlet("/class_sign_upServlet.do")
public class class_sign_upServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();//获取session
        ClasDAO clasDAO=new ClasDAO();
        //得到所有开设课程的信息
        ArrayList<Class> AllClsList=clasDAO.getAllCls();
        ArrayList<Apply> AllapplyList=clasDAO.getAllApply();
        //存到session
        session.setAttribute("AllClsList",AllClsList);
        session.setAttribute("AllapplyList",AllapplyList);
        RequestDispatcher rd = request.getRequestDispatcher("ClassSignUp.jsp");
        rd.forward(request, response);
    }
}
