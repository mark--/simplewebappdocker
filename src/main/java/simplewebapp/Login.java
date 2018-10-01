package simplewebapp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Login
{
    private static final Logger LOG = LoggerFactory.getLogger(Login.class);

    public boolean login(String login, String password, HttpSession session)
    {
        LOG.info("Login requested: login={}, password={}", login, password);
        
        if (login != null) {
        	Credentials credentials = retrieveCredentials(login);
        	
        	if (credentials != null && credentials.getLogin().equals(login) && credentials.getPassword().equals(password)) {
        		  session.setAttribute("authenticated", true);
                  return true;
        	} else {
                session.setAttribute("authenticated", false);
                return false;
            }
        } else {
            session.setAttribute("authenticated", false);
            return false;
        }
    }
    
    protected Credentials retrieveCredentials(String login) {
		Context ctx = null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		Credentials credentials = null;
		try{
			ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/postgres");
			
			con = ds.getConnection();
			stmt = con.createStatement();
			
			rs = stmt.executeQuery("select login,password from credentials where login='"+login+"'");
			LOG.info("Executing SQL Statement");
			
			
			
            while(rs.next())
            {
            	LOG.info("Building Credentials");
            	credentials = new Credentials();
                credentials.setLogin(rs.getString("login"));
                credentials.setPassword(rs.getString("password"));
                break;
            }
            
		}catch(NamingException e){
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				stmt.close();
				con.close();
				ctx.close();
			} catch (SQLException e) {
				System.out.println("Exception in closing DB resources");
			} catch (NamingException e) {
				System.out.println("Exception in closing Context");
			} catch (Exception e) {
				System.out.println("Some exception occured");
			}
			
		}
		
		return credentials;
	}
    
    static class Credentials {
    
    	String login;
    	String password;
    	
		public String getLogin() {
			return login;
		}
		public void setLogin(String login) {
			this.login = login;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
    }
}
