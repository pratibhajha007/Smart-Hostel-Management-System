import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Hostel hostel = new Hostel("Smart Hostel");

        hostel.loadStudents();
        hostel.loadRooms();
        hostel.loadComplaints();

        int choice;

        do {

            System.out.println();
            System.out.println("========================================");
            System.out.println("        SMART HOSTEL MANAGEMENT");
            System.out.println("========================================");
            System.out.println("1. Register Student");
            System.out.println("2. Add Room");
            System.out.println("3. Allocate Room");
            System.out.println("4. Vacate Room");
            System.out.println("5. View Students");
            System.out.println("6. View Rooms");
            System.out.println("7. Submit Complaint");
            System.out.println("8. View Complaints");
            System.out.println("9. Resolve Complaint");
            System.out.println("10. Calculate Hostel Fee");
            System.out.println("11. Save Data");
            System.out.println("0. Exit");
            System.out.println("========================================");

            choice = InputHelper.getInt(
                    scanner,
                    "Enter your choice: "
            );

            switch (choice) {

                case 1:

                    System.out.println();
                    System.out.println("===== REGISTER STUDENT =====");

                    int id = InputHelper.getInt(
                            scanner,
                            "Enter Student ID: "
                    );

                    scanner.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Phone Number: ");
                    String phone = scanner.nextLine();

                    System.out.print("Enter Course: ");
                    String course = scanner.nextLine();

                    Student student = new Student(
                            id,
                            name,
                            phone,
                            course
                    );

                    hostel.addStudent(student);

                    break;

                case 2:

                    System.out.println();
                    System.out.println("===== ADD ROOM =====");

                    int roomNumber = InputHelper.getInt(
                            scanner,
                            "Enter Room Number: "
                    );

                    System.out.println();
                    System.out.println("1. Single Room");
                    System.out.println("2. Shared Room");

                    int roomType = InputHelper.getInt(
                            scanner,
                            "Choose room type: "
                    );

                    if (roomType == 1) {

                        Room room = new SingleRoom(roomNumber);
                        hostel.addRoom(room);

                    } else if (roomType == 2) {

                        int capacity = InputHelper.getInt(
                                scanner,
                                "Enter room capacity: "
                        );

                        if (capacity <= 0) {

                            System.out.println(
                                    "Capacity must be greater than 0!"
                            );

                            break;
                        }

                        Room room = new SharedRoom(
                                roomNumber,
                                capacity
                        );

                        hostel.addRoom(room);

                    } else {

                        System.out.println("Invalid room type!");
                    }

                    break;

                case 3:

                    System.out.println();
                    System.out.println("===== ALLOCATE ROOM =====");

                    int studentId = InputHelper.getInt(
                            scanner,
                            "Enter Student ID: "
                    );

                    int roomToAllocate = InputHelper.getInt(
                            scanner,
                            "Enter Room Number: "
                    );

                    hostel.allocateRoom(
                            studentId,
                            roomToAllocate
                    );

                    break;

                case 4:

                    System.out.println();
                    System.out.println("===== VACATE ROOM =====");

                    int studentToVacate = InputHelper.getInt(
                            scanner,
                            "Enter Student ID: "
                    );

                    hostel.vacateRoom(studentToVacate);

                    break;

                case 5:

                    hostel.displayStudents();

                    break;

                case 6:

                    hostel.displayRooms();

                    break;

                case 7:

                    System.out.println();
                    System.out.println("===== SUBMIT COMPLAINT =====");

                    int complaintId = InputHelper.getInt(
                            scanner,
                            "Enter Complaint ID: "
                    );

                    int complaintStudent = InputHelper.getInt(
                            scanner,
                            "Enter Student ID: "
                    );

                    System.out.println();
                    System.out.println("1. Maintenance");
                    System.out.println("2. Electrical");

                    int complaintType = InputHelper.getInt(
                            scanner,
                            "Choose complaint type: "
                    );

                    scanner.nextLine();

                    System.out.print("Enter complaint description: ");
                    String description = scanner.nextLine();

                    Complaint complaint;

                    if (complaintType == 1) {

                        complaint = new MaintenanceComplaint(
                                complaintId,
                                complaintStudent,
                                description
                        );

                    } else if (complaintType == 2) {

                        complaint = new ElectricalComplaint(
                                complaintId,
                                complaintStudent,
                                description
                        );

                    } else {

                        System.out.println("Invalid complaint type!");
                        break;
                    }

                    hostel.addComplaint(complaint);

                    break;

                case 8:

                    hostel.displayComplaints();

                    break;

                case 9:

                    System.out.println();
                    System.out.println("===== RESOLVE COMPLAINT =====");

                    int complaintToResolve = InputHelper.getInt(
                            scanner,
                            "Enter Complaint ID: "
                    );

                    hostel.resolveComplaint(
                            complaintToResolve
                    );

                    break;

                case 10:

                    System.out.println();
                    System.out.println("===== HOSTEL FEE =====");

                    int feeStudent = InputHelper.getInt(
                            scanner,
                            "Enter Student ID: "
                    );

                    hostel.calculateStudentFee(feeStudent);

                    break;

                case 11:

                    System.out.println();
                    System.out.println("===== SAVING DATA =====");

                    hostel.saveStudents();
                    hostel.saveRooms();
                    hostel.saveComplaints();

                    System.out.println("All data saved successfully!");

                    break;

                case 0:

                    System.out.println();
                    System.out.println("========================================");
                    System.out.println(" Thank you for using Smart Hostel!");
                    System.out.println("========================================");

                    break;

                default:

                    System.out.println();
                    System.out.println(
                            "Invalid choice! Please enter 0-11."
                    );
            }

        } while (choice != 0);

        scanner.close();
    }
}