package withDB.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import withDB.modelsDB.Car;
import withDB.modelsDB.UserDB;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.*;

public class UsersDaoJdbcTemplateImpl implements UsersDao {
    /** Получает коннект от datasource(line 24)
     * Выполняет запрос к ДБ принимая SQL request и RowMapper, может иметь параметр(line 38)
     * ORM - делаем обьекты из запросов.(line 35)
     * */
    private JdbcTemplate template;

    //language=SQL
    private final String SQL_SELECT_ALL = "SELECT * from fix_user";
    //language=SQL
    private final String SQL_SELECT_ALL_BY_FIRST_NAME = "SELECT * from fix_user where first_name = ?";
    //language=SQL
    private final String SQL_SELECT_USER_WITH_CARS
            = "select fix_user.*, fix_car.id as car_id, fix_car.model from fix_user left JOIN fix_car on fix_user.id = fix_car.owner_id where fix_user.id = ?";

    private Map<Integer, UserDB> userMap = new HashMap<>();

    public UsersDaoJdbcTemplateImpl(DataSource dataSource) {//Constructor
        this.template = new JdbcTemplate(dataSource);
    }

    // Получаем обьекты из запросов и возвращем обьект со всеми car
    private RowMapper<UserDB> usersRowMapper = (ResultSet resultSet, int i) -> {

        Integer id = resultSet.getInt("id");

        // получаем от запроса узера и добавляем его в userMap, если его нет.
        if (!userMap.containsKey(id)) {
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            UserDB user = new UserDB(id, firstName, lastName, new ArrayList<>());
            userMap.put(id, user);
        }

        // Создаем car добавляем параметры = в качестве owner_id, добб. user-a.
        Car car = new Car(resultSet.getInt("car_id"),
                resultSet.getString("model"),
                userMap.get(id));

        // у user-a вызываем лист и добавляем этот car user-у внутри userMap.
        userMap.get(id).getCars().add(car);

        return userMap.get(id);
    };

    @Override
    public List<UserDB> findAllByFirstName(String firstName) {
        return template.query(SQL_SELECT_ALL_BY_FIRST_NAME, usersRowMapper, firstName);
    }

    @Override
    public Optional<UserDB> find(Integer id) {

        template.query(SQL_SELECT_USER_WITH_CARS, usersRowMapper, id);

        if (userMap.containsKey(id)) {
            return Optional.of(userMap.get(id));
        }
        return Optional.empty();
    }

    @Override
    public void save(UserDB model) {

    }

    @Override
    public void update(UserDB model) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<UserDB> findAll() {
        return template.query(SQL_SELECT_ALL, usersRowMapper);
    }
}
