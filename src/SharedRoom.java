public class SharedRoom extends Room implements FeeCalculable {

    public SharedRoom(int roomNumber, int capacity) {
        super(roomNumber, capacity);
    }

    @Override
    public void displayRoom() {
        System.out.println("Room Type: Shared Room");
        super.displayRoom();
    }

    @Override
    public double calculateFee() {
        return 5000;
    }
}