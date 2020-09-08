package cn.hit.servlet1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/downloadServlet")
public class Demo10DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取文件名
        String filename = request.getParameter("filename");
        //获取真实路径
        String realPath = request.getServletContext().getRealPath("/picture/"+filename);
        //读取文件到内存
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(new File(realPath)));

        //设置response响应头,通过servletContext.getMimeType获取文件mime类型，设置附件打开方式
        response.setContentType(request.getServletContext().getMimeType(filename));
        response.setHeader("content-disposition","attachment;filename="+filename);

        //输出
        BufferedOutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
        byte[] buff = new byte[1024*1024];
        int len = 0;
        while((len=inputStream.read(buff))!=-1){
            outputStream.write(buff,0,len);
        }

        inputStream.close();
        outputStream.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
