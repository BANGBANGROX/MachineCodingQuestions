import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    private String name;
    private String gender;
    private int age;
    private final String id;
    private final List<Ride> takenRides;
    private final List<Ride> offeredRides;

    User(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.offeredRides = new ArrayList<>();
        takenRides = new ArrayList<>();
        id = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public List<Ride> getTakenRides() {
        return takenRides;
    }

    public List<Ride> getOfferedRides() {
        return offeredRides;
    }
}
