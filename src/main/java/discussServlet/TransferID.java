package discussServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//中转id 学生回复老师 学生回复评论
@WebServlet(name = "TransferID",urlPatterns = {"/TransferID"})
public class TransferID extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //防止乱码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String no=request.getParameter("no");
        String judgment=request.getParameter("judge");

        HttpSession session=request.getSession();
        session.setAttribute("transit_no",no);
        session.setAttribute("judgment",judgment); //判断是回复 回复 还是回复 评论
        response.sendRedirect("StuResond.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }
}
