public class SingleRoom extends Room implements FeeCalculable {

    public SingleRoom(int roomNumber) {
        super(roomNumber, 1);
    }

    @Override
    public void displayRoom() {
        System.out.println("Room Type: Single Room");
        super.displayRoom();
    }

    @Override
    public double calculateFee() {
        return 8000;
    }
}