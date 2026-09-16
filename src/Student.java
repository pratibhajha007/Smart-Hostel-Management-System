public class Student extends Person {

    private String course;
    private int roomNumber;

    public Student(int id, String name, String phone, String course) {
        super(id, name, phone);
        this.course = course;
        roomNumber = -1;
    }

    public String getCourse() {
        return course;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public void displayDetails() {
        System.out.println("Student ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Phone: " + getPhone());
        System.out.println("Course: " + course);

        if (roomNumber == -1) {
            System.out.println("Room: Not Allocated");
        } else {
            System.out.println("Room Number: " + roomNumber);
        }
    }
}