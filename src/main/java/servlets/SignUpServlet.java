package servlets;

import models.User;
import repositories.UserRepository;
import repositories.UserRepositoryInMemory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {

    private UserRepository usersRepository;

    @Override
    public void init() throws ServletException {
        this.usersRepository = new UserRepositoryInMemory();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = usersRepository.findAll();
        req.setAttribute("usersFromServer", users);
        RequestDispatcher requestDispatcher = req.getServletContext().getRequestDispatcher("/jsp/signUp.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        LocalDate birthDate = LocalDate.parse(req.getParameter("birthDate"));


        usersRepository.save(new User(name, password, birthDate));
        RequestDispatcher requestDispatcher = req.getServletContext().getRequestDispatcher("/jsp/signUp.jsp");
        requestDispatcher.forward(req, resp);
    }
}
