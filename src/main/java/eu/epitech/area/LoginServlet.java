package eu.epitech.area;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.beans.XMLDecoder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost (HttpServletRequest req,
                           HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html");

        try {
            String idToken = req.getParameter("id_token");
            GoogleIdToken.Payload payLoad = IdTokenVerifierAndParser.getPayload(idToken);
            String name = (String) payLoad.get("name");
            String email = payLoad.getEmail();
            System.out.println("User name: " + name);
            System.out.println("User email: " + email);
            HttpSession session = req.getSession(true);
            session.setAttribute("userName", name);
            Core    core = (Core)req.getServletContext().getAttribute("core");
            Client  tmp = new Client(email);
            boolean exist = false;
            for (Client client : core.getClients()) {
                if (client.getUsername().equals(email)) {
                    tmp = client;
                    exist = true;
                }
            }
            req.getSession().setAttribute("client", tmp);
            if (!exist) {
                core.addClient(tmp);
            }
            req.getServletContext().setAttribute("core", core);
            req.getServletContext()
                    .getRequestDispatcher("/WEB-INF/home.jsp").forward(req, resp);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
