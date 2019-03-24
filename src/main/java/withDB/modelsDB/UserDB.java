package withDB.modelsDB;

import java.util.List;

public class UserDB {
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;

    private List<Car> cars;

    public UserDB() {
    }

    public UserDB(String firstName, String lastName, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public UserDB(Integer id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public UserDB(Integer id, String firstName, String lastName, List<Car> cars) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cars = cars;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return this.id + " " + this.firstName + " " + this.lastName;
    }
}
