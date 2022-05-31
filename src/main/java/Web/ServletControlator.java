package Web;
import Data.UsersDAO;
import Domain.Users;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletControlator", value = "/ServletControlator")
public class ServletControlator extends HttpServlet {

    Users user=new Users();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Users> users=new UsersDAO().listUsers();
        System.out.println("Users"+users);
        request.setAttribute("Users",users);
        request.getRequestDispatcher("users.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF=8");
        try(PrintWriter out =response.getWriter()){
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet at "+request.getContextPath()+"</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
