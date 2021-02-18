package kz.aitu.oop.practice.assignment4.controllers;

import kz.aitu.oop.practice.assignment4.entities.Project;
import kz.aitu.oop.practice.assignment4.repositories.interfaces.IProjectRepo;

import java.util.List;

public class ProjectController {
    private final IProjectRepo repo;

    public ProjectController(IProjectRepo repo) {
        this.repo = repo;
    }

    public String createProject(String name, String application) {
        Project project = new Project(name, application);
        boolean created = repo.createProject(project);
        return (created ? "Project was created!" : "Project creation was failed!");
    }

    public String getProject(int code) {
        Project project = repo.getProject(code);
        return (project == null ? "Project was not found!" : project.toString());
    }

    public String getAllProjects() {
        List<Project> projects = repo.getAllProjects();
        return projects.toString();
    }
}
