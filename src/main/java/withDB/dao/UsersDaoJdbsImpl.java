package withDB.dao;

import withDB.modelsDB.UserDB;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersDaoJdbsImpl implements UsersDao {

    //language=SQL
    private final String SQL_SELECT_ALL = "SELECT  * from fix_user";
    //language=SQL
    private final String SQL_SELECT_BY_ID = "SELECT  * from fix_user where id = ?";
    //language=SQL
    private final String SQL_INSERT = "INSERT INTO fix_user(first_name, last_name) VALUES(?, ?)";

    private Connection connection;

    public UsersDaoJdbsImpl(DataSource dataSource) throws SQLException {
        this.connection = dataSource.getConnection();
    }

    @Override
    public List<UserDB> findAllByFirstName(String firstName) {
        return null;
    }

    @Override
    public Optional<UserDB> find(Integer id) {

        try {
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_ID);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");

                return Optional.of(new UserDB(id, firstName, lastName)) ;
            }
            return Optional.empty();

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void save(UserDB model) {
//
//        String firstName = req.getParameter("first-name");
//        String lastName = req.getParameter("last-name");
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT);
//
//            preparedStatement.setString(1, firstName);
//            preparedStatement.setString(2, lastName);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void update(UserDB model) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<UserDB> findAll() {
        try {
            List<UserDB> usersList = new ArrayList<>();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);

            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");

                UserDB user = new UserDB(id, firstName, lastName);
                usersList.add(user);
            }

            return usersList;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

    }
}
