package eu.epitech.area;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ModuleServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Core    core = (Core)request.getServletContext().getAttribute("core");
        Client  client  = (Client)request.getSession().getAttribute("client");
        String parameter = null;
        String value = null;
        for (IModule module : core.getModules()) {
            parameter = module.getParameter();
            value = request.getParameter(parameter);
            if (value != null) {
                System.out.println(module.getName());
                System.out.println(value);
                module.setToken(value);
                this.getServletContext().getRequestDispatcher("/WEB-INF/modules.jsp").forward(request, response);
                return;
            }
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/modules.jsp").forward(request, response);
    }
}
