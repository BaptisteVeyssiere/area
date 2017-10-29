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
            //creating bean
            UsersBean users = new UsersBean();
            UserBean ub = new UserBean();
            ub.setUserToken(idToken);
            ub.createPair("twitter", "AZEJO1azlejalzekjaZOojZOJ8_èyZJK");
            ub.createPair("slack", "AZEtesttesstteeesstjalzekeaaoziekaoèyZJK");
            users.addUser(ub);
            UserBean ub2 = new UserBean();
            ub2.setUserToken("123456789012345678901234567890123456789012345678901234567890123456789");
            ub2.createPair("twitter", "AZEJO1azlejalzekjaZOojZOJ8_èyZJK");
            ub2.createPair("slack", "AZEtesttesstteeesstjalzekeaaoziekaoèyZJK");
            ub2.createPair("Facebook", "lelelelelelelel");
            users.addUser(ub2);
            //xml encoder
            XmlEncodeToFile xml2 = new XmlEncodeToFile();
            xml2.EncodeUsersBean(users); // cree mon xml
            //fin xml encoder

            UsersBean usersget = new UsersBean();
            XMLDecodeFromFile xml3 = new XMLDecodeFromFile();
            usersget = xml3.DecodeUsersBean(usersget); // déserialise
            //fin du décoder
            //début de l'affichage

            Iterator<UserBean> it = usersget.getUsers().iterator();
            while (it.hasNext()) {
                UserBean tmp = it.next();
                System.out.println(tmp.getUserToken());
                for(Map.Entry<String, String> entry : tmp.getPair().entrySet()){
                    System.out.printf("Key : %s and Value: %s %n", entry.getKey(), entry.getValue());
                }
            }
            //fin de l'affichage

            HttpSession session = req.getSession(true);
            session.setAttribute("userName", name);
            Core    core = (Core)req.getServletContext().getAttribute("core");
            Client  tmp = new Client(email);
            for (Client client : core.getClients()) {
                if (client.getUsername().equals(email)) {
                    tmp = client;
                }
            }
            req.getSession().setAttribute("client", tmp);
            if (!tmp.getUsername().equals(email)) {
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
