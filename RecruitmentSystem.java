import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class RecruitmentSystem extends JFrame implements ActionListener {
    // Creating a list to store staff details
    private ArrayList<StaffHire> staffList = new ArrayList<>();

    // Declaring text fields for user input
    private JTextField tfVacancyNumber, tfDesignation, tfJobType, tfStaffName, tfJoiningDate,
            tfQualification, tfAppointedBy, tfSalary, tfWeeklyHours, tfWorkingHour, tfWagesPerHour,
            tfShifts, tfDisplayIndex;

    // Declaring buttons for different actions
    private JButton btnAddFullTime, btnAddPartTime, btnSetSalary, btnSetShifts, btnTerminate, btnDisplay, btnClear;

    public RecruitmentSystem() {
        // Setting up the main window
        setTitle("Staff Recruitment System");
        setLayout(new GridLayout(18, 2, 5, 5));
        setSize(600, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Adding input fields with labels
        tfVacancyNumber = addLabeledTextField("Vacancy Number:");
        tfDesignation = addLabeledTextField("Designation:");
        tfJobType = addLabeledTextField("Job Type:");
        tfStaffName = addLabeledTextField("Staff Name:");
        tfJoiningDate = addLabeledTextField("Joining Date:");
        tfQualification = addLabeledTextField("Qualification:");
        tfAppointedBy = addLabeledTextField("Appointed By:");
        tfSalary = addLabeledTextField("Salary:");
        tfWeeklyHours = addLabeledTextField("Weekly Hours:");
        tfWorkingHour = addLabeledTextField("Working Hour:");
        tfWagesPerHour = addLabeledTextField("Wages Per Hour:");
        tfShifts = addLabeledTextField("Shifts:");
        tfDisplayIndex = addLabeledTextField("Display Index:");

        // Adding buttons for actions
        btnAddFullTime = addButton("Add Full Time Staff");
        btnAddPartTime = addButton("Add Part Time Staff");
        btnSetSalary = addButton("Set Salary");
        btnSetShifts = addButton("Set Shifts");
        btnTerminate = addButton("Terminate Part Time Staff");
        btnDisplay = addButton("Display");
        btnClear = addButton("Clear");

        // Making the window visible
        setVisible(true);
    }

    // Adding a label and text field to the UI
    private JTextField addLabeledTextField(String label) {
        JLabel jLabel = new JLabel(label);
        JTextField textField = new JTextField();
        add(jLabel);
        add(textField);
        return textField;
    }

    // Adding a button to the UI and setting up its action listener
    private JButton addButton(String label) {
        JButton button = new JButton(label);
        button.addActionListener(this);
        add(button);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // Handling "Add Full Time Staff" button click
            if (e.getSource() == btnAddFullTime) {
                int vacancyNo = Integer.parseInt(tfVacancyNumber.getText());
                String des = tfDesignation.getText();
                String jobType = tfJobType.getText();
                String staff = tfStaffName.getText();
                String joinDate = tfJoiningDate.getText();
                String qual = tfQualification.getText();
                String appoint = tfAppointedBy.getText();
                double salary = Double.parseDouble(tfSalary.getText());
                int weeklyHr = Integer.parseInt(tfWeeklyHours.getText());

                // Creating a new full-time staff object and adding it to the list
                FullTimeStaffHire f = new FullTimeStaffHire(vacancyNo, des, jobType, staff, joinDate, qual, appoint, true, salary, weeklyHr);
                staffList.add(f);
                JOptionPane.showMessageDialog(this, "Full Time Staff Added!");

            // Handling "Add Part Time Staff" button click
            } else if (e.getSource() == btnAddPartTime) {
                int vacancyNo = Integer.parseInt(tfVacancyNumber.getText());
                String des = tfDesignation.getText();
                String jobType = tfJobType.getText();
                String staff = tfStaffName.getText();
                String joinDate = tfJoiningDate.getText();
                String qual = tfQualification.getText();
                String appoint = tfAppointedBy.getText();
                int workingHr = Integer.parseInt(tfWorkingHour.getText());
                double wage = Double.parseDouble(tfWagesPerHour.getText());
                String shift = tfShifts.getText();

                // Creating a new part-time staff object and adding it to the list
                PartTimeStaffHire p = new PartTimeStaffHire(vacancyNo, des, jobType, staff, joinDate, qual, appoint, true, workingHr, wage, shift);
                staffList.add(p);
                JOptionPane.showMessageDialog(this, "Part Time Staff Added!");

            // Handling "Set Salary" button click
            } else if (e.getSource() == btnSetSalary) {
                int index = Integer.parseInt(tfDisplayIndex.getText());
                double newSalary = Double.parseDouble(tfSalary.getText());
                StaffHire s = staffList.get(index);
                if (s instanceof FullTimeStaffHire) {
                    // Updating salary for full-time staff
                    ((FullTimeStaffHire) s).setSalary(newSalary);
                    JOptionPane.showMessageDialog(this, "Salary Updated");
                }

            // Handling "Set Shifts" button click
            } else if (e.getSource() == btnSetShifts) {
                int index = Integer.parseInt(tfDisplayIndex.getText());
                String newShift = tfShifts.getText();
                StaffHire s = staffList.get(index);
                if (s instanceof PartTimeStaffHire) {
                    // Updating shifts for part-time staff
                    ((PartTimeStaffHire) s).setShifts(newShift);
                    JOptionPane.showMessageDialog(this, "Shifts Updated");
                }

            // Handling "Terminate Part Time Staff" button click
            } else if (e.getSource() == btnTerminate) {
                int index = Integer.parseInt(tfDisplayIndex.getText());
                StaffHire s = staffList.get(index);
                if (s instanceof PartTimeStaffHire) {
                    // Terminating part-time staff
                    ((PartTimeStaffHire) s).terminate();
                    JOptionPane.showMessageDialog(this, "Part Time Staff Terminated");
                }

            // Handling "Display" button click
            } else if (e.getSource() == btnDisplay) {
                int index = Integer.parseInt(tfDisplayIndex.getText());
                if (index >= 0 && index < staffList.size()) {
                    // Displaying staff details
                    staffList.get(index).display();
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid index");
                }

            // Handling "Clear" button click
            } else if (e.getSource() == btnClear) {
                // Clearing all text fields
                for (Component comp : getContentPane().getComponents()) {
                    if (comp instanceof JTextField) {
                        ((JTextField) comp).setText("");
                    }
                }
            }

        } catch (Exception ex) {
            // Showing error messages
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        // Launching the application
        new RecruitmentSystem();
    }
}