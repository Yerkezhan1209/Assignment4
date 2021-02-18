package kz.aitu.oop.practice.assignment4;

import kz.aitu.oop.practice.assignment4.controllers.EmployeeController;
import kz.aitu.oop.practice.assignment4.controllers.ProjectController;
import kz.aitu.oop.practice.assignment4.controllers.CompletedProjectController;
import kz.aitu.oop.practice.assignment4.repositories.interfaces.IEmployeeRepo;
import kz.aitu.oop.practice.assignment4.repositories.interfaces.IProjectRepo;
import kz.aitu.oop.practice.assignment4.repositories.interfaces.ICompletedProjectRepo;

import java.util.Scanner;

public class MyApplication {
    private final EmployeeController controller1;
    private final ProjectController controller2;
    private final CompletedProjectController controller3;
    private final Scanner scanner;

    public MyApplication(IEmployeeRepo employeeRepository, IProjectRepo projectRepository, ICompletedProjectRepo completedProjectRepository) {
        controller1 = new EmployeeController(employeeRepository);
        controller2 = new ProjectController(projectRepository);
        controller3 = new CompletedProjectController(completedProjectRepository);
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to My Application");
            System.out.println("Select option:");
            System.out.println("1. Get all employees");
            System.out.println("2. Get employee by id");
            System.out.println("3. Add a new employee");
            System.out.println("4. Get all projects");
            System.out.println("5. Get project by code");
            System.out.println("6. Create a new project");
            System.out.println("7. Get all completed projects");
            System.out.println("8. Get completed project by code");
            System.out.println("9. Add a completed project");
            System.out.println("10. Get only successful completed projects");
            System.out.println("11. Get the total cost of all completed projects");
            System.out.println("12. Get the maximum cost and the minimum cost of completed projects");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-12): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllEmployeesMenu();
                } else if (option == 2) {
                    getEmployeeByIdMenu();
                } else if (option == 3) {
                    createEmployeeMenu();
                } else if (option == 4) {
                    getAllProjectsMenu();
                } else if (option == 5) {
                    getProjectByCodeMenu();
                } else if (option == 6) {
                    createProjectMenu();
                } else if (option == 7) {
                    getAllCompletedProjectsMenu();
                } else if (option == 8) {
                    getCompletedProjectByCodeMenu();
                } else if (option == 9) {
                    createCompletedProjectMenu();
                } else if (option == 10) {
                    getSuccessfulCompletedProjectsMenu();
                } else if (option == 11) {
                    getTotalMenu();
                } else if (option == 12) {
                    getMaxMinMenu();
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.next(); // to ignore incorrect input
            }
            System.out.println("*************************");
        }
    }

    public void getAllEmployeesMenu() {
        String response = controller1.getAllEmployees();
        System.out.println(response);
    }

    public void getEmployeeByIdMenu() {
        System.out.println("Please enter id:");
        int id = scanner.nextInt();
        String response = controller1.getEmployee(id);
        System.out.println(response);
    }

    public void createEmployeeMenu() {
        System.out.println("Please enter name:");
        String name = scanner.next();
        System.out.println("Please enter surname:");
        String surname = scanner.next();
        System.out.println("Please enter gender (male/female):");
        String gender = scanner.next();
        System.out.println("Please enter age:");
        int age = scanner.nextInt();
        System.out.println("Please enter specialty:");
        String specialty = scanner.next();
        String response = controller1.createEmployee(name, surname, gender, age, specialty);
        System.out.println(response);
    }

    public void getAllProjectsMenu() {
        String response = controller2.getAllProjects();
        System.out.println(response);
    }

    public void getProjectByCodeMenu() {
        System.out.println("Please enter code:");
        int code = scanner.nextInt();
        String response = controller2.getProject(code);
        System.out.println(response);
    }

    public void createProjectMenu() {
        System.out.println("Please enter name:");
        String name = scanner.next();
        System.out.println("Please enter application:");
        String application = scanner.next();
        String response = controller2.createProject(name, application);
        System.out.println(response);
    }

    public void getAllCompletedProjectsMenu() {
        String response = controller3.getAllCompletedProjects();
        System.out.println(response);
    }

    public void getCompletedProjectByCodeMenu() {
        System.out.println("Please enter code:");
        int code = scanner.nextInt();
        String response = controller3.getCompletedProject(code);
        System.out.println(response);
    }

    public void createCompletedProjectMenu() {
        System.out.println("Please enter name:");
        String name = scanner.next();
        System.out.println("Please enter application:");
        String application = scanner.next();
        System.out.println("Please enter start date (dd/mm/yyyy format):");
        String start_date = scanner.next();
        System.out.println("Please enter end date (dd/mm/yyyy format):");
        String end_date = scanner.next();
        System.out.println("Please enter cost:");
        int cost = scanner.nextInt();
        System.out.println("Please enter result (success/fail):");
        String result = scanner.next();
        String response = controller3.createCompletedProject(name, application, start_date, end_date, cost, result);
        System.out.println(response);
    }

    public void getSuccessfulCompletedProjectsMenu() {
        String response = controller3.getSuccessfulCompletedProjects();
        System.out.println(response);
    }

    public void getTotalMenu() {
        int response = controller3.getTotal();
        System.out.println("The total cost of all completed projects is: " + response + ".");
    }

    public void getMaxMinMenu() {
        int max = controller3.getMax();
        System.out.println("The maximum cost of completed projects is: " + max + ".");
        int min = controller3.getMin();
        System.out.println("The minimum cost of completed projects is: " + min + ".");
    }
}