package kz.aitu.oop.practice.assignment4.controllers;

import kz.aitu.oop.practice.assignment4.entities.CompletedProject;
import kz.aitu.oop.practice.assignment4.repositories.interfaces.ICompletedProjectRepo;

import java.util.List;

public class CompletedProjectController {
    private final ICompletedProjectRepo repo;

    public CompletedProjectController(ICompletedProjectRepo repo) {
        this.repo = repo;
    }

    public String createCompletedProject(String name, String application, String start_date, String end_date, int cost, String result) {
        boolean success = (result.toLowerCase().equals("success"));
        CompletedProject completedProject = new CompletedProject(name, application, start_date, end_date, cost, success);
        boolean created = repo.createCompletedProject(completedProject);
        return (created ? "Completed Project was added!" : "Completed Project addition was failed!");
    }

    public String getCompletedProject(int code) {
        CompletedProject completedProject = repo.getCompletedProject(code);
        return (completedProject == null ? "Completed Project was not found!" : completedProject.toString());
    }

    public String getAllCompletedProjects() {
        List<CompletedProject> completedProjects = repo.getAllCompletedProjects();
        return completedProjects.toString();
    }

    public String getSuccessfulCompletedProjects() {
        List<CompletedProject> successfulCompletedProjects = repo.getSuccessfulCompletedProjects();
        return successfulCompletedProjects.toString();
    }

    public int getTotal() {
        int response = repo.getTotal();
        return response;
    }

    public int getMax() {
        int max = repo.getMax();
        return max;
    }

    public int getMin() {
        int min = repo.getMin();
        return min;
    }
}