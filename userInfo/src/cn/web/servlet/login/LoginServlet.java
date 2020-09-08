package cn.web.servlet.login;

import cn.domain.Admin;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String checkCode = request.getParameter("checkCode");
        String rightCode = (String) request.getSession().getAttribute("checkCode");
        request.getSession().removeAttribute("checkCode");
        if (rightCode.equalsIgnoreCase(checkCode)) {
            request.getRequestDispatcher("/verifyAdminServlet").forward(request, response);
        } else {
            request.setAttribute("login_msg","登陆失败！验证码错误");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
