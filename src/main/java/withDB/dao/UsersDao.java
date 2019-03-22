package withDB.dao;

import withDB.modelsDB.UserDB;

import java.util.List;

public interface UsersDao extends CrudDao<UserDB> {

    List<UserDB> findAllByFirstName(String firstName);

}



