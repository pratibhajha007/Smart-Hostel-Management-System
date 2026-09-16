public class MaintenanceComplaint extends Complaint {

    public MaintenanceComplaint(int complaintId, int studentId, String description) {
        super(complaintId, studentId, description);
    }

    @Override
    public void displayComplaint() {
        System.out.println("Complaint Type: Maintenance");
        super.displayComplaint();
    }
}