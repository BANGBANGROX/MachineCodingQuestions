import java.util.UUID;

public class Vehicle {
    private String name;
    private String number;
    private User user;
    private final String id;

    Vehicle(User user, String name, String number) {
        this.user = user;
        this.name = name;
        this.number = number;
        id = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getId() {
        return id;
    }
}
