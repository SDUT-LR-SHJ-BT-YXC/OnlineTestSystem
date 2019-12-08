package cn.OnlineTestSystem.web.filter;

import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "CheckLoginFilter", urlPatterns = {"/Ajax_RecentScoreRecord", "/CheckAnswerServlet", "/ExaminationServlet", "/ShowQbankServlet", "/client/Examination.jsp"
, "/client/personpage.jsp", "/client/showqbank.jsp", "/client/WrongAnswerRecord.jsp"})
public class CheckLoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        if(session.getAttribute("user") == null){
            System.out.println("未登录用户企图访问需登录页面，已拦截");
            response.sendRedirect(request.getContextPath() + "/client/login.jsp");
            return;
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
