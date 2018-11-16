import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        System.out.println("Session: " + request.getSession()!= null);
        System.out.println("\tuser attribute: " + request.getSession().getAttribute("user"));
        if (request.getSession()!= null && request.getSession().getAttribute("user")!= null){
            filterChain.doFilter(servletRequest,servletResponse);
        } else {
            response.sendRedirect("index.jsp");
        }


    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
