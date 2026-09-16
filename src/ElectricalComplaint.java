public class ElectricalComplaint extends Complaint {

    public ElectricalComplaint(int complaintId, int studentId, String description) {
        super(complaintId, studentId, description);
    }

    @Override
    public void displayComplaint() {
        System.out.println("Complaint Type: Electrical");
        super.displayComplaint();
    }
}