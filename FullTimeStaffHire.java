// Defining a class FullTimeStaffHire that extends StaffHire
public class FullTimeStaffHire extends StaffHire {
    // Declaring variables for salary and weekly fractional hours
    private double salary;
    private int weeklyFractionalHours;

    // Creating a constructor for initializing all the attributes
    public FullTimeStaffHire(int vacancyNumber, String designation, String jobType, String staffName,
                              String joiningDate, String qualification, String appointedBy, boolean joined,
                              double salary, int weeklyFractionalHours) {
        // Calling the parent class constructor for shared attributes
        super(vacancyNumber, designation, jobType, staffName, joiningDate, qualification, appointedBy, joined);
        // Setting salary and weekly fractional hours
        this.salary = salary;
        this.weeklyFractionalHours = weeklyFractionalHours;
    }

    // Providing a getter for retrieving salary
    public double getSalary() { return salary; }
    // Providing a getter for retrieving weekly fractional hours
    public int getWeeklyFractionalHours() { return weeklyFractionalHours; }

    // Allowing salary to be updated only if the staff hasn't joined yet
    public void setSalary(double salary) {
        if (!getJoined()) {
            this.salary = salary;
        } else {
            // Printing a message if salary can't be updated
            System.out.println("Cannot set salary. Staff has already joined.");
        }
    }

    // Allowing weekly fractional hours to be updated
    public void setWeeklyFractionalHours(int weeklyFractionalHours) {
        this.weeklyFractionalHours = weeklyFractionalHours;
    }

    // Overriding the display method to show additional details
    @Override
    public void display() {
        // Calling the parent class display method
        super.display();
        // Printing salary and weekly fractional hours
        System.out.println("Salary: " + salary);
        System.out.println("Weekly Fractional Hours: " + weeklyFractionalHours);
    }
}
