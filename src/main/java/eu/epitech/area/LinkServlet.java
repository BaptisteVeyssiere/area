package eu.epitech.area;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LinkServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[]    action = req.getParameter("action").split("-");
        String[]    reaction = req.getParameter("reaction").split("-");
        Client      client = (Client)req.getSession().getAttribute("client");
        Core        core = (Core)req.getServletContext().getAttribute("core");
        boolean     exist = false;

        for (String[] tab : client.getLinks()) {
            if (tab[0].equals(action[0]) && tab[1].equals(action[1]) && tab[2].equals(reaction[0]) && tab[3].equals(reaction[1])) {
                exist = true;
            }
        }
        if (!exist) {
            client.addLink(action[0], action[1], reaction[0], reaction[1]);
            core.getClients().removeIf(tmp -> tmp.getUsername().equals(client.getUsername()));
            core.addClient(client);
            req.getServletContext().setAttribute("core", core);
            req.getSession().setAttribute("client", client);
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/factory.jsp").forward(req, resp);
    }
}
