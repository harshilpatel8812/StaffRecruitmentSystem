public class PartTimeStaffHire extends StaffHire {
    // Declaring variables specific to part-time staff
    private int workingHour;
    private double wagesPerHour;
    private String shifts;
    private boolean terminated;

    // Constructor for initializing part-time staff details
    public PartTimeStaffHire(int vacancyNumber, String designation, String jobType, String staffName,
                              String joiningDate, String qualification, String appointedBy, boolean joined,
                              int workingHour, double wagesPerHour, String shifts) {
        super(vacancyNumber, designation, jobType, staffName, joiningDate, qualification, appointedBy, joined);
        this.workingHour = workingHour;
        this.wagesPerHour = wagesPerHour;
        this.shifts = shifts;
        this.terminated = false; // Setting terminated to false initially
    }

    // Getters for accessing private variables
    public int getWorkingHour() { return workingHour; }
    public double getWagesPerHour() { return wagesPerHour; }
    public String getShifts() { return shifts; }
    public boolean getTerminated() { return terminated; }

    // Allowing shift change only if staff has joined
    public void setShifts(String shifts) {
        if (getJoined()) {
            this.shifts = shifts;
        } else {
            System.out.println("Cannot set shifts. Staff has not joined.");
        }
    }

    // Handling termination of staff
    public void terminate() {
        if (terminated) {
            System.out.println("Staff is already terminated.");
        } else {
            // Resetting staff details on termination
            setStaffName("");
            setJoiningDate("");
            setQualification("");
            setAppointedBy("");
            setJoined(false);
            terminated = true; // Marking as terminated
        }
    }

    // Displaying part-time staff details
    @Override
    public void display() {
        super.display(); // Calling parent class display method
        System.out.println("Working Hours: " + workingHour);
        System.out.println("Wages Per Hour: " + wagesPerHour);
        System.out.println("Shifts: " + shifts);
        System.out.println("Terminated: " + terminated);
        System.out.println("Income Per Day: " + (workingHour * wagesPerHour)); // Calculating daily income
    }
}
