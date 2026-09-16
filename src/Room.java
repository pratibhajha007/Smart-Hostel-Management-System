public class Room {

    private int roomNumber;
    private int capacity;
    private int occupied;

    public Room(int roomNumber, int capacity) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        occupied = 0;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getOccupied() {
        return occupied;
    }

    public boolean isAvailable() {
        return occupied < capacity;
    }

    public void addStudent() {
        if (isAvailable()) {
            occupied++;
        }
    }

    public void removeStudent() {
        if (occupied > 0) {
            occupied--;
        }
    }

    public void displayRoom() {
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Capacity: " + capacity);
        System.out.println("Occupied: " + occupied);
        System.out.println("Available Beds: " + (capacity - occupied));
    }
}