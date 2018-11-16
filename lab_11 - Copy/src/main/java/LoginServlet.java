import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Data data = Data.getInstance();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String rememberme = req.getParameter("remember");
        if (data.isValidLogin(username, password)) {
            SimpleUser user = new SimpleUser(username,password);
            req.getSession().setAttribute("user", user);
            if ("yes".equals(rememberme)) {
                Cookie c = new Cookie("user", username);
                c.setMaxAge(30 * 24 * 60 * 60);
                resp.addCookie(c);
            } else {
                Cookie c = new Cookie("user", null);
                c.setMaxAge(0);
                resp.addCookie(c);

            }
            resp.sendRedirect("welcome.jsp");
        }  else {
            req.getSession().setAttribute("err_msg", "Username and/or password invalid.");
            resp.sendRedirect("/");
        }


    }
}
