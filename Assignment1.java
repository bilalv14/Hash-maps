package assignment1;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import assignment1.Employee;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author Bilal Zahid
 * Assignment 1
 * 
 * This program uses a HashMap to manipulate data in a txt file
 * @since January 29, 2023
 * I have followed the UNCG Academic Integrity policy on this assignment.
 */
public class Assignment1 {

    /**
     *Global HashMap.
     */
    public static Map<String, Employee> empMap = new HashMap<>();

    /**
     * The main method parses through the txt file and adds it into the hash map
     * and then calls the displayMenu method. 
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {

        File empFile = new File("employee.txt");

        Scanner sc = new Scanner(empFile);
        while (sc.hasNextLine()) {
            String[] tempEmpArr = sc.nextLine().trim().split(",");
            Employee tempEmp = new Employee(tempEmpArr[0], tempEmpArr[1], tempEmpArr[2], Double.parseDouble(tempEmpArr[3]));
            empMap.put(tempEmp.getEmployeeID(), tempEmp);
        }
        displayMenu();
    }

    /**
     * This method displays the menu and calls the other methods
     * based on user input.
     */
    public static void displayMenu() {
        Scanner userInput = new Scanner(System.in);
        String input = "0";
        while (!"4".equals(input)) {
            System.out.println("******Menu****** \n"
                    + "1.Display \n"
                    + "2.Add Employee \n"
                    + "3.Search Employee \n"
                    + "4.Exit");
            System.out.println("Please enter a single character integer");
            input = userInput.next();
            switch (input) {
                case "1":
                    dislpayEmployees();
                    break;
                case "2":
                    addEmployee();
                    System.out.println("Employee added");
                    break;
                case "3":
                    searchEmployee();
                    break;

                default:
                    if (!"4".equals(input)) {
                        System.out.println("Incorrect input");

                        break;
                    }
            }

        }
        System.out.println("Goodbye");
    }

    /**
     * This method prints the employees using a for loop.
     */
    public static void dislpayEmployees() {
        for (Map.Entry mp : empMap.entrySet()) {
            System.out.println(mp.getKey() + " " + mp.getValue());
        }
    }
    
    /**
     * This method creates 4 variables and asks the user for 
     * input and assigns it to the specified variable.
     * Those variables are then inserted into the hash map creating a new employee.
     */
    public static void addEmployee() {
        Scanner empScanner = new Scanner(System.in);

        String newEmpId;
        String empFirstName;
        String empLastName;
        String empSalary;

        System.out.println("Please enter a unique 3 digit employee ID ");
        newEmpId = empScanner.nextLine();

        System.out.println("Please enter their first name");
        empFirstName = empScanner.nextLine();

        System.out.println("Please enter their last name");
        empLastName = empScanner.nextLine();

        System.out.println("Please enter their salary");
        empSalary = empScanner.nextLine();

        Employee newEmp = new Employee(newEmpId, empFirstName, empLastName, Double.parseDouble(empSalary));
        empMap.put(newEmpId, newEmp);
    }
    
    /**
     * This method asks the user to enter an Id and checks to see if that 
     * employee exists and prints it.
     */
    public static void searchEmployee() {
        Scanner searchInput = new Scanner(System.in);
        String getId;

        System.out.println("Please enter an ID you wish to search for");
        getId = searchInput.nextLine();

        if (empMap.containsKey(getId)) {
            Employee foundEmployee = empMap.get(getId);
            System.out.printf("Employee found: %s\t%s\t%s \n",
                    foundEmployee.getFirstName().trim(), foundEmployee.getLastName().trim(), foundEmployee.getSalary());
        } else {
            System.out.println("Employee does not exist");
        }
    }
}
