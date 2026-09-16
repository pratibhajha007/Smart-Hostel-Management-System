import java.util.ArrayList;
import java.util.List;

public class Hostel {

    private String hostelName;
    private ArrayList<Student> students;
    private ArrayList<Room> rooms;
    private ArrayList<Complaint> complaints;

    public Hostel(String hostelName) {

        this.hostelName = hostelName;
        students = new ArrayList<>();
        rooms = new ArrayList<>();
        complaints = new ArrayList<>();
    }

    public void displayHostelName() {
        System.out.println("Hostel Name: " + hostelName);
    }

    // Student methods

    public void addStudent(Student student) {

        if (findStudent(student.getId()) != null) {
            System.out.println("Student ID already exists!");
            return;
        }

        students.add(student);
        System.out.println("Student registered successfully!");
    }

    public void displayStudents() {

        if (students.isEmpty()) {
            System.out.println("No students registered.");
            return;
        }

        System.out.println("\n===== STUDENT LIST =====");

        for (Student student : students) {

            student.displayDetails();
            System.out.println("-------------------------");
        }
    }

    public Student findStudent(int id) {

        for (Student student : students) {

            if (student.getId() == id) {
                return student;
            }
        }

        return null;
    }

    // Room methods

    public void addRoom(Room room) {

        if (findRoom(room.getRoomNumber()) != null) {
            System.out.println("Room number already exists!");
            return;
        }

        rooms.add(room);
        System.out.println("Room added successfully!");
    }

    public void displayRooms() {

        if (rooms.isEmpty()) {
            System.out.println("No rooms available.");
            return;
        }

        System.out.println("\n===== ROOM LIST =====");

        for (Room room : rooms) {

            room.displayRoom();
            System.out.println("-------------------------");
        }
    }

    public Room findRoom(int roomNumber) {

        for (Room room : rooms) {

            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }

        return null;
    }

    public void allocateRoom(int studentId, int roomNumber) {

        Student student = findStudent(studentId);
        Room room = findRoom(roomNumber);

        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        if (room == null) {
            System.out.println("Room not found!");
            return;
        }

        if (student.getRoomNumber() != -1) {
            System.out.println("Student already has a room!");
            return;
        }

        if (!room.isAvailable()) {
            System.out.println("Room is already full!");
            return;
        }

        room.addStudent();
        student.setRoomNumber(roomNumber);

        System.out.println("Room allocated successfully!");
    }

    public void vacateRoom(int studentId) {

        Student student = findStudent(studentId);

        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        if (student.getRoomNumber() == -1) {
            System.out.println("Student has no room allocated.");
            return;
        }

        Room room = findRoom(student.getRoomNumber());

        if (room != null) {
            room.removeStudent();
        }

        student.setRoomNumber(-1);

        System.out.println("Room vacated successfully!");
    }

    // Complaint methods

    public void addComplaint(Complaint complaint) {

        if (findStudent(complaint.getStudentId()) == null) {
            System.out.println(
                    "Student not found! Complaint cannot be submitted."
            );
            return;
        }

        complaints.add(complaint);

        System.out.println("Complaint submitted successfully!");
    }

    public void displayComplaints() {

        if (complaints.isEmpty()) {
            System.out.println("No complaints available.");
            return;
        }

        System.out.println("\n===== COMPLAINT LIST =====");

        for (Complaint complaint : complaints) {

            complaint.displayComplaint();
            System.out.println("-------------------------");
        }
    }

    public void resolveComplaint(int complaintId) {

        for (Complaint complaint : complaints) {

            if (complaint.getComplaintId() == complaintId) {

                complaint.resolveComplaint();

                System.out.println("Complaint resolved successfully!");
                return;
            }
        }

        System.out.println("Complaint not found!");
    }

    // Fee calculation

    public void calculateStudentFee(int studentId) {

        Student student = findStudent(studentId);

        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        if (student.getRoomNumber() == -1) {
            System.out.println("Student has no room allocated.");
            return;
        }

        Room room = findRoom(student.getRoomNumber());

        if (room instanceof FeeCalculable) {

            FeeCalculable feeRoom = (FeeCalculable) room;
            double fee = feeRoom.calculateFee();

            System.out.println("Student: " + student.getName());
            System.out.println("Room Number: " + student.getRoomNumber());
            System.out.println("Monthly Hostel Fee: Rs. " + fee);
        }
    }

    // Save data

    public void saveStudents() {

        StringBuilder data = new StringBuilder();

        for (Student student : students) {

            data.append("Student ID: ")
                    .append(student.getId())
                    .append("\n");

            data.append("Name: ")
                    .append(student.getName())
                    .append("\n");

            data.append("Phone: ")
                    .append(student.getPhone())
                    .append("\n");

            data.append("Course: ")
                    .append(student.getCourse())
                    .append("\n");

            data.append("Room: ")
                    .append(student.getRoomNumber())
                    .append("\n");

            data.append("-------------------------\n");
        }

        FileManager.saveData("students.txt", data.toString());

        System.out.println("Student data saved successfully!");
    }

    public void saveRooms() {

        StringBuilder data = new StringBuilder();

        for (Room room : rooms) {

            data.append("Room Number: ")
                    .append(room.getRoomNumber())
                    .append("\n");

            data.append("Capacity: ")
                    .append(room.getCapacity())
                    .append("\n");

            data.append("Occupied: ")
                    .append(room.getOccupied())
                    .append("\n");

            data.append("Available Beds: ")
                    .append(room.getCapacity() - room.getOccupied())
                    .append("\n");

            data.append("-------------------------\n");
        }

        FileManager.saveData("rooms.txt", data.toString());

        System.out.println("Room data saved successfully!");
    }

    public void saveComplaints() {

        StringBuilder data = new StringBuilder();

        for (Complaint complaint : complaints) {

            data.append("Complaint ID: ")
                    .append(complaint.getComplaintId())
                    .append("\n");

            data.append("Student ID: ")
                    .append(complaint.getStudentId())
                    .append("\n");

            data.append("Description: ")
                    .append(complaint.getDescription())
                    .append("\n");

            data.append("Status: ")
                    .append(complaint.getStatus())
                    .append("\n");

            data.append("-------------------------\n");
        }

        FileManager.saveData(
                "complaints.txt",
                data.toString()
        );

        System.out.println("Complaint data saved successfully!");
    }

    // Load students

    public void loadStudents() {

        List<String> data = FileManager.readData("students.txt");

        if (data == null || data.isEmpty()) {
            return;
        }

        for (int i = 0; i < data.size(); i++) {

            if (data.get(i).startsWith("Student ID: ")) {

                try {

                    int id = Integer.parseInt(
                            data.get(i).substring(12).trim()
                    );

                    String name = data.get(i + 1)
                            .substring(6)
                            .trim();

                    String phone = data.get(i + 2)
                            .substring(7)
                            .trim();

                    String course = data.get(i + 3)
                            .substring(8)
                            .trim();

                    int roomNumber = Integer.parseInt(
                            data.get(i + 4)
                                    .substring(6)
                                    .trim()
                    );

                    Student student = new Student(
                            id,
                            name,
                            phone,
                            course
                    );

                    student.setRoomNumber(roomNumber);
                    students.add(student);

                } catch (Exception e) {

                    System.out.println(
                            "Unable to load a student record."
                    );
                }
            }
        }
    }

    // Load rooms

    public void loadRooms() {

        List<String> data = FileManager.readData("rooms.txt");

        if (data == null || data.isEmpty()) {
            return;
        }

        for (int i = 0; i < data.size(); i++) {

            if (data.get(i).startsWith("Room Number: ")) {

                try {

                    int roomNumber = Integer.parseInt(
                            data.get(i).substring(13).trim()
                    );

                    int capacity = Integer.parseInt(
                            data.get(i + 1)
                                    .substring(10)
                                    .trim()
                    );

                    int occupied = Integer.parseInt(
                            data.get(i + 2)
                                    .substring(10)
                                    .trim()
                    );

                    Room room;

                    if (capacity == 1) {
                        room = new SingleRoom(roomNumber);
                    } else {
                        room = new SharedRoom(
                                roomNumber,
                                capacity
                        );
                    }

                    for (int j = 0; j < occupied; j++) {
                        room.addStudent();
                    }

                    rooms.add(room);

                } catch (Exception e) {

                    System.out.println(
                            "Unable to load a room record."
                    );
                }
            }
        }
    }

    // Load complaints

    public void loadComplaints() {

        List<String> data = FileManager.readData("complaints.txt");

        if (data == null || data.isEmpty()) {
            return;
        }

        for (int i = 0; i < data.size(); i++) {

            if (data.get(i).startsWith("Complaint ID: ")) {

                try {

                    int complaintId = Integer.parseInt(
                            data.get(i).substring(14).trim()
                    );

                    int studentId = Integer.parseInt(
                            data.get(i + 1).substring(11).trim()
                    );

                    String description = data.get(i + 2)
                            .substring(13)
                            .trim();

                    String status = data.get(i + 3)
                            .substring(8)
                            .trim();

                    Complaint complaint =
                            new MaintenanceComplaint(
                                    complaintId,
                                    studentId,
                                    description
                            );

                    if (status.equals("Resolved")) {
                        complaint.resolveComplaint();
                    }

                    complaints.add(complaint);

                } catch (Exception e) {

                    System.out.println(
                            "Unable to load a complaint record."
                    );
                }
            }
        }
    }
}