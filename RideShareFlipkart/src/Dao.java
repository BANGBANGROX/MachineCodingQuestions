import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

public class Dao {
    private final Map<String, User> userTable;
    private final Map<String, Vehicle> vehicleTable;
    private final Map<String, Ride> rideTable;
    private final Map<Vehicle, Ride> vehicleRideMap;

    Dao() {
        userTable = new HashMap<>();
        vehicleTable = new HashMap<>();
        rideTable = new HashMap<>();
        vehicleRideMap = new HashMap<>();
    }

    public String addUser(User user) {
        userTable.put(user.getId(), user);

        return user.getId();
    }

    public User getUser(String userId) {
        return userTable.get(userId);
    }

    public String addVehicle(Vehicle vehicle) {
        vehicleTable.put(vehicle.getId(), vehicle);

        return vehicle.getId();
    }

    public Vehicle getVehicle(String vehicleId) {
        return vehicleTable.get(vehicleId);
    }

    public String offerRide(Ride ride) {
        rideTable.put(ride.getId(), ride);

        return ride.getId();
    }

    public String selectRide(User user, String origin, String destination, int seats, String selectionStrategy, String preferredVehicle) {
        PriorityQueue<Ride> applicableRides = new PriorityQueue<>((a, b) -> b.getAvailableSeats() - a.getAvailableSeats());

        for (Map.Entry<String, Ride> rideEntry : rideTable.entrySet()) {
            Ride ride = rideEntry.getValue();
            if (ride.getAvailableSeats() >= seats && origin.equals(ride.getSource()) && destination.equals(ride.getDestination()) && "AVAILABLE".equals(ride.getStatus()) && !Objects.equals(ride.getUser().getId(), user.getId())) {
                if (selectionStrategy.equals("MostVacant") || ride.getVehicle().getName().equals(preferredVehicle)) {
                    applicableRides.add(ride);
                }
            }
        }

        if (applicableRides.isEmpty()) {
            System.out.println("No rides found");
            return null;
        }

        Ride ride = applicableRides.peek();
        ride.setAvailableSeats(ride.getAvailableSeats() - seats);
        ride.setStatus("IN_PROGRESS");
        ride.getPassengers().add(user);
        vehicleRideMap.put(ride.getVehicle(), ride);

        return ride.getId();
    }

    public void endRide(String rideId) {
        if (rideTable.containsKey(rideId)) {
            Ride ride = rideTable.get(rideId);
            vehicleRideMap.remove(ride.getVehicle());
            ride.setStatus("AVAILABLE");
            ride.getUser().getOfferedRides().add(ride);
            for (User passenger : ride.getPassengers()) {
                passenger.getTakenRides().add(ride);
            }
        } else {
            System.out.println("Ride does not exist");
        }
    }

    public void printRideStats() {
        for (Map.Entry<String, User> entry : userTable.entrySet()) {
            User user = entry.getValue();
            System.out.println("ID : " + user.getId() + " Name : " + user.getName() + " " + user.getTakenRides().size() + " Taken" + " " + user.getOfferedRides().size() + " Offered");
        }
    }

    public Ride getVehicleRide(Vehicle vehicle) {
        return vehicleRideMap.get(vehicle);
    }
}
