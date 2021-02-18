package kz.aitu.oop.practice.assignment4.controllers;

import kz.aitu.oop.practice.assignment4.entities.Employee;
import kz.aitu.oop.practice.assignment4.repositories.interfaces.IEmployeeRepo;

import java.util.List;

public class EmployeeController {
    private final IEmployeeRepo repo;

    public EmployeeController(IEmployeeRepo repo) {
        this.repo = repo;
    }

    public String createEmployee(String name, String surname, String gender, int age, String specialty) {
        boolean male = (gender.toLowerCase().equals("male"));
        Employee employee = new Employee(name, surname, male, age, specialty);
        boolean created = repo.createEmployee(employee);
        return (created ? "Employee was added!" : "Employee addition was failed!");
    }

    public String getEmployee(int id) {
        Employee employee = repo.getEmployee(id);
        return (employee == null ? "Employee was not found!" : employee.toString());
    }

    public String getAllEmployees() {
        List<Employee> employees = repo.getAllEmployees();
        return employees.toString();
    }
}