import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");

        // String password = request.getParameter("password");
        // Check password etc

        if (username != null) {
            request.getSession().setAttribute("user", username);
            response.sendRedirect(request.getContextPath() + "/");
        } else {
            request.getRequestDispatcher(request.getContextPath() + "/login.jsp").forward(request, response);
        }
    }
}
