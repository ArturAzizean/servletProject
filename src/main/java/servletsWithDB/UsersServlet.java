package servletsWithDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@WebServlet("/users")
public class UsersServlet extends HttpServlet {

    private Connection connection;
    @Override
    public void init() throws ServletException {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(getServletContext().getRealPath("/WEB-INF/classes/db.properties")));  // "/WEB-INF/classes/db.properties"
            String dbUrl = properties.getProperty("db.url");
            String dbusername = properties.getProperty("db.username");
            String dbPassword = properties.getProperty("db.password");

            connection = DriverManager.getConnection(dbUrl, dbusername, dbPassword);
        } catch (IOException | SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/jsp1/addUser.jsp").forward(req, resp);
    }
}
