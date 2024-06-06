public class Operations {
    private final Dao dao;

    Operations() {
        dao = new Dao();
    }

    public String addUser(String name, String gender, int age) {
        return dao.addUser(new User(name, gender, age));
    }

    public String addVehicle(String userId, String name, String number) {
        User user = dao.getUser(userId);

        if (user == null) {
            System.out.println("User does not exist");
            return null;
        }

        return dao.addVehicle(new Vehicle(user, name, number));
    }

    public String offerRide(String userId, String vehicleId, String origin, String destination, int seats) {
        User user = dao.getUser(userId);

        if (user == null) {
            System.out.println("User does not exist");
            return null;
        }

        Vehicle vehicle = dao.getVehicle(vehicleId);

        if (vehicle == null) {
            System.out.println("Vehicle does not exist");
            return null;
        }

        if (dao.getVehicleRide(vehicle) != null) {
            System.out.println("Vehicle already has another ongoing ride");
            return null;
        }

        return dao.offerRide(new Ride(user, vehicle, seats, origin, destination));
    }

    public String selectRide(String userId, String origin, String destination, int seats, String selectionStrategy, String preferredVehicle) {
        User user = dao.getUser(userId);

        if (user == null) {
            System.out.println("User does not exist");
            return null;
        }

        return dao.selectRide(user, origin, destination, seats, selectionStrategy, preferredVehicle);
    }

    public void endRide(String rideId) {
        dao.endRide(rideId);
    }

    public void printRideStats() {
        dao.printRideStats();
    }
}
