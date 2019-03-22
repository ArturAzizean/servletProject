package withDB.servletsDB;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import withDB.dao.UsersDao;
import withDB.dao.UsersDaoJdbcTemplateImpl;
import withDB.modelsDB.UserDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

@WebServlet("/users")
public class UsersServletWithDao extends HttpServlet {

    private UsersDao usersDao;

    @Override
    public void init() throws ServletException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource(); // С помощью этого обьека мы получаем конннект.
        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream(getServletContext().getRealPath("/WEB-INF/classes/db.properties")));  // "/WEB-INF/classes/db.properties"
            String dbUrl = properties.getProperty("db.url");
            String dbUsername = properties.getProperty("db.username");
            String dbPassword = properties.getProperty("db.password");
            String driverClassName = properties.getProperty("db.driverClassName");

            dataSource.setUsername(dbUsername);
            dataSource.setPassword(dbPassword);
            dataSource.setUrl(dbUrl);
            dataSource.setDriverClassName(driverClassName);

            usersDao = new UsersDaoJdbcTemplateImpl(dataSource); // Благодаря этому коннекту мы реализуем методы
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        List<UserDB> userDBList = null;

        if (req.getParameter("firstName") != null) {
            String firstName = req.getParameter("firstName");
            userDBList = usersDao.findAllByFirstName(firstName);
        } else userDBList = usersDao.findAll();

        req.setAttribute("usersFromServer" ,userDBList);
        req.getServletContext().getRequestDispatcher("/jsp1/users.jsp").forward(req, resp);
    }
}
