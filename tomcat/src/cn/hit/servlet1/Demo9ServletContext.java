package cn.hit.servlet1;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/demo9")
public class Demo9ServletContext extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取ServletContext
        ServletContext servletContext = request.getServletContext();
        ServletContext servletContext1 = this.getServletContext();

        System.out.println(servletContext==servletContext1);   //true

        //获取MIME
        String filename = "a.jpg";
        System.out.println(servletContext.getMimeType(filename));   // image/jpg

        //servletContext共享域，所有用户都可以获得该共享数据
        servletContext.setAttribute("name", "aaa");

        //获取真实路径
        System.out.println(servletContext.getRealPath("/"));    //根路径是web的路径
        System.out.println(servletContext.getRealPath("/b.txt"));  //b 在web下
        System.out.println(servletContext.getRealPath("/WEB-INF/c.txt"));  // web/WEB-INF 下
        System.out.println(servletContext.getRealPath("/WEB-INF/classes/a.txt")); // src目录下的文件最后会到WEB-INF/classes中
        /*
          C:\Users\lenovo\IdeaProjects\Java_learn\out\artifacts\tomcat_war_exploded\
          C:\Users\lenovo\IdeaProjects\Java_learn\out\artifacts\tomcat_war_exploded\b.txt
          C:\Users\lenovo\IdeaProjects\Java_learn\out\artifacts\tomcat_war_exploded\WEB-INF\c.txt
          C:\Users\lenovo\IdeaProjects\Java_learn\out\artifacts\tomcat_war_exploded\WEB-INF\classes\a.txt
        */
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
