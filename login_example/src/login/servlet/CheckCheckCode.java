package login.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/CheckCheckCode")
public class CheckCheckCode extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //判断验证码是否一致
        Map<String, String[]> parameterMap = request.getParameterMap();
        char[] chs = (char[]) request.getSession().getAttribute("checkCode");

        //获取验证码之后立马删除session中的值(防止后退不刷新直接登陆)
        request.getSession().removeAttribute("checkCode");

        String[] verifyCodes = parameterMap.get("verifyCode");
        if (chs!=null&&new String(chs).equalsIgnoreCase(verifyCodes[0])) {
            request.getRequestDispatcher("/check").forward(request, response);
        } else {
            request.setAttribute("checkCodeCheck", "wrong");
            request.getRequestDispatcher("/").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
