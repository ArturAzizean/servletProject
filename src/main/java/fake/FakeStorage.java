package fake;

import models.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FakeStorage {
    private static final FakeStorage storage;

    static {
        storage = new FakeStorage();
    }

    private List<User> users;

    private FakeStorage(){
        this.users = new ArrayList<>();
        User artur = new User("Artur", "123", LocalDate.parse("1996-05-08"));
        User kristin = new User("Kristin", "321", LocalDate.parse("1996-05-08"));

        users.add(artur);
        users.add(kristin);
    }

    public static FakeStorage storage() {
        return storage;
    }

    public List<User> users() {
        return users;
    }


}
