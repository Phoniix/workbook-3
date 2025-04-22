package com.pluralsight;

public class Employee {

    // Introducing the Variables --------------------------------------------------------------------------------------
    private int employeeID = 0;
    private String employeeName = "";
    private float employeeHoursWorked = 0;
    private float employeePayRate = 0;

    // Five Parameter Constructor Only // -----------------------------------------------------------------------------
    public Employee (int employeeID, String employeeName, float employeeHoursWorked, float employeePayRate) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.employeeHoursWorked = employeeHoursWorked;
        this.employeePayRate = employeePayRate;
    }

    // Getters --------------------------------------------------------------------------------------------------------
    public int getEmployeeID() {
        return employeeID;
    }
    public String getEmployeeName() {
        return employeeName;
    }
    public float getEmployeeHoursWorked() {
        return employeeHoursWorked;
    }
    public float getEmployeePayRate() {
        return employeePayRate;
    }

    // Setters --------------------------------------------------------------------------------------------------------
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    public void setEmployeeHoursWorked(float employeeHoursWorked) {
        this.employeeHoursWorked = employeeHoursWorked;
    }
    public void setEmployeePayRate(float employeePayRate) {
        this.employeePayRate = employeePayRate;
    }
}
