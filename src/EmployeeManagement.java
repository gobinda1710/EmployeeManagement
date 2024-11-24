
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee {

    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

class SalaryManagementSystem {

    private List<Employee> employeeList;

    public SalaryManagementSystem() {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    public void deleteEmployee(int employeeId) {
        for (Employee employee : employeeList) {
            if (employee.getId() == employeeId) {
                employeeList.remove(employee);
                break;
            }
        }
    }

    public void updateEmployeeSalary(int employeeId, double newSalary) {
        for (Employee employee : employeeList) {
            if (employee.getId() == employeeId) {
                employee.setSalary(newSalary);
                break;
            }
        }
    }

    public void displayAllEmployees() {
        System.out.println("Employee Details:");
        for (Employee employee : employeeList) {
            System.out.println("ID: " + employee.getId());
            System.out.println("Name: " + employee.getName());
            System.out.println("Salary: " + employee.getSalary());
            System.out.println("-------------------------");
        }
    }
}

public class EmployeeManagement {

    public static void main(String[] args) {
        SalaryManagementSystem salarySystem = new SalaryManagementSystem();
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("1. Add an employee");
            System.out.println("2. Delete an employee");
            System.out.println("3. Update employee salary");
            System.out.println("4. Display all employees");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter employee ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter employee name: ");
                    scanner.nextLine(); // Consume newline character
                    String name = scanner.nextLine();
                    System.out.print("Enter employee salary: ");
                    double salary = scanner.nextDouble();
                    Employee employee = new Employee(id, name, salary);
                    salarySystem.addEmployee(employee);
                    System.out.println("Employee added successfully!");
                    break;
                case 2:
                    System.out.print("Enter employee ID to delete: ");
                    int deleteId = scanner.nextInt();
                    salarySystem.deleteEmployee(deleteId);
                    System.out.println("Employee deleted successfully!");
                    break;
                case 3:
                    System.out.print("Enter employee ID to update salary: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Enter new salary: ");
                    double newSalary = scanner.nextDouble();
                    salarySystem.updateEmployeeSalary(updateId, newSalary);
                    System.out.println("Employee salary updated successfully!");
                    break;
                case 4:
                    salarySystem.displayAllEmployees();
                    break;
                case 5:
                    isRunning = false;
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        }

        scanner.close();
    }
}
