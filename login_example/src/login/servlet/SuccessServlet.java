package login.servlet;

import login.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/check/success")
public class SuccessServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User)request.getAttribute("user");
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("登陆成功！"+ user.getUsername() +"，欢迎你");

        Date date = new Date();
        String login_last_time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);

        //获取Session中的上次登陆时间
        response.getWriter().write("你上次的登陆时间是：" + request.getSession().getAttribute("login_last_time"));


        HttpSession session = request.getSession();             //获得session
        session.setAttribute("login_last_time",login_last_time);    //设置登陆时间的session
        Cookie cookie = new Cookie("JSSIONID",session.getId());   //存入cookie
        cookie.setMaxAge(60*60*24*7); //7天
        response.addCookie(cookie);     //加入响应头


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
