package servlet;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpsServer;
import util.CopyParamsToBean;
import vo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author 王承尧
 * @Date 2021/4/21 4:52 下午
 */
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User u =(User) CopyParamsToBean.copy(req,"vo.User");
        System.out.println(u);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
