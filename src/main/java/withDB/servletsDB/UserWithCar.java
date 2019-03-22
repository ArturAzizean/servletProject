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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

@WebServlet("/car")
public class UserWithCar extends HttpServlet {
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


        Optional<UserDB> userDBList = Optional.empty();
        List<UserDB> users = new ArrayList<>();


        if (req.getParameter("UserId") != null) {
            Integer id = Integer.parseInt(req.getParameter("UserId"));
            userDBList = usersDao.find(id);

            while (userDBList.isPresent()) {
                users.add(userDBList.get());
            }
        }

        req.setAttribute("usersWithCarFromServer" ,users);
        req.getServletContext().getRequestDispatcher("/jsp1/car.jsp").forward(req, resp);
    }
}
