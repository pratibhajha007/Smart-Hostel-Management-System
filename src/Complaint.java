public class Complaint {

    private int complaintId;
    private int studentId;
    private String description;
    private String status;

    public Complaint(int complaintId, int studentId, String description) {
        this.complaintId = complaintId;
        this.studentId = studentId;
        this.description = description;
        status = "Pending";
    }

    public int getComplaintId() {
        return complaintId;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public void resolveComplaint() {
        status = "Resolved";
    }

    public void displayComplaint() {
        System.out.println("Complaint ID: " + complaintId);
        System.out.println("Student ID: " + studentId);
        System.out.println("Description: " + description);
        System.out.println("Status: " + status);
    }
}