package login.servlet;

import login.User;
import login.userDao.UserDao;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/check")
public class CheckServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        System.out.println("login/check.........");

        Map<String, String[]> parameterMap = request.getParameterMap();


        User loginUser = new User();

//        BeanUtils.setProperty(loginUser, "username","张三");
//        String username = BeanUtils.getProperty(loginUser, "username");

        try {
            BeanUtils.populate(loginUser, parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        User user = new UserDao().check(loginUser);

        //User user = new UserDao().check(new User(username,password));

        if (user != null) {
            request.setAttribute("user", user);
            request.getRequestDispatcher("/check/success").forward(request, response);
        } else {
            request.getRequestDispatcher("/check/failed").forward(request, response);
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
