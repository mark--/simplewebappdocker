package simplewebapp;

import java.util.Objects;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Login
{
    private static final Logger LOG = LoggerFactory.getLogger(Login.class);

    public boolean login(String login, String password, HttpSession session)
    {
        LOG.info("Login requested: login={}, password={}", login, password);

        if (login != null && Objects.equals(login, password))
        {
            session.setAttribute("authenticated", true);
            return true;
        }
        else
        {
            session.setAttribute("authenticated", false);
            return false;
        }
    }

}
