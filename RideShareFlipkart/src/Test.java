public class Test {
    public static void main(String[] args) {
        Operations operations = new Operations();
        final String BANGALORE = "Bangalore";
        final String HYDERABAD = "Hyderabad";
        final String MYSORE = "Mysore";
        final String PUNE = "Pune";
        final String MUMBAI = "Mumbai";

        String rohanId = operations.addUser("Rohan", "M", 36);
        assert rohanId != null;

        String rohanVehicleId = operations.addVehicle(rohanId, "Swift", "KA-01-12345");
        assert rohanVehicleId != null;

        String shashankId = operations.addUser("Shashank", "M", 29);
        assert shashankId != null;

        String shashankVehicleId = operations.addVehicle(shashankId, "Baleno", "TS-05-62395");
        assert shashankVehicleId != null;

        String nandiniId = operations.addUser("Nandini", "F", 29);
        assert nandiniId != null;

        String shipraId = operations.addUser("Shipra", "F", 27);
        assert shipraId != null;

        String shipraVehicleId1 = operations.addVehicle(shipraId, "Polo", "KA-05-41491");
        assert shipraVehicleId1 != null;

        String shipraVehicleId2 = operations.addVehicle(shipraId, "Activa", "KA-12-12332");
        assert shipraVehicleId2 != null;

        String gauravId = operations.addUser("Gaurav", "M", 29);
        assert gauravId != null;

        String rahulId = operations.addUser("Rahul", "M", 35);
        assert rahulId != null;

        String rahulVehicleId = operations.addVehicle(rahulId, "XUV", "KA-05-1234");
        assert rahulVehicleId != null;

        String rohanRideId1 = operations.offerRide(rohanId, rohanVehicleId, HYDERABAD, BANGALORE, 1);
        assert rohanRideId1 != null;

        String shipraRideId1 = operations.offerRide(shipraId, shipraVehicleId2, BANGALORE, MYSORE, 1);
        assert shipraRideId1 != null;

        String shipraRideId2 = operations.offerRide(shipraId, shipraVehicleId1, BANGALORE, MYSORE, 2);
        assert shipraRideId2 != null;

        String shashankRideId = operations.offerRide(shashankId, shashankVehicleId, HYDERABAD, BANGALORE, 2);
        assert shashankRideId != null;

        String rahulRideId = operations.offerRide(rahulId, rahulVehicleId, HYDERABAD, BANGALORE, 5);
        assert rahulRideId != null;

        String rohanRideId2 = operations.offerRide(rohanId, rohanVehicleId, BANGALORE, PUNE, 2);
        assert rohanRideId2 == null;

        String nandiniSelectRideId = operations.selectRide(nandiniId, BANGALORE, MYSORE, 1, "MostVacant", null);
        assert nandiniSelectRideId.equals(shipraRideId2);

        String gauravSelectRideId = operations.selectRide(gauravId, BANGALORE, MYSORE, 1, "Vehicle", "Activa");
        assert gauravSelectRideId.equals(shipraRideId1);

        String shashankSelectRideId1 = operations.selectRide(shashankId, MUMBAI, BANGALORE, 1, "MostVacant", null);
        assert shashankSelectRideId1 == null;

        String rohanSelectRideId = operations.selectRide(rohanId, HYDERABAD, BANGALORE, 1, "Vehicle", "Baleno");
        assert rohanSelectRideId.equals(shashankRideId);

        String shashankSelectRideId2 = operations.selectRide(shashankId, HYDERABAD, BANGALORE, 1, "Vehicle", "Polo");
        assert shashankSelectRideId2 == null;

        operations.endRide(rohanRideId1);
        operations.endRide(shipraRideId1);
        operations.endRide(shipraRideId2);
        operations.endRide(shashankRideId);

        operations.printRideStats();
    }
}
