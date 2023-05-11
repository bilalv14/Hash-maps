
package assignment1;

/**
 *
 * @author bilalzahid
 */
public class Employee {
    private String employeeID;
    private String firstName;
    private String lastName;
    private double salary;
    
    Employee(){
        
    }
    
    Employee(String employeeID, String firstName, String lastName, double salary){
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    @ Override
    public String toString(){
        return String.format("%-9s\t%-15s\t%11.2f",firstName.trim(), lastName.trim(), salary);
    }
    
    
}
