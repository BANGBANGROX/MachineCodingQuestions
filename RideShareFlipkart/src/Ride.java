import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Ride {
    private final User user;
    private final Vehicle vehicle;
    private int availableSeats;
    private final String source;
    private final String destination;
    private final String id;
    private String status;
    private final List<User> passengers;

    Ride(User user, Vehicle vehicle, int availableSeats, String source, String destination) {
        this.user = user;
        this.vehicle = vehicle;
        this.availableSeats = availableSeats;
        this.source = source;
        this.destination = destination;
        status = "AVAILABLE";
        passengers = new ArrayList<>();
        id = UUID.randomUUID().toString();
    }

    public User getUser() {
        return user;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public List<User> getPassengers() {
        return passengers;
    }
}
