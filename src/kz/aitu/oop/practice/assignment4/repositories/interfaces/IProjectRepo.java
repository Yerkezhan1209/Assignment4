package kz.aitu.oop.practice.assignment4.repositories.interfaces;

import kz.aitu.oop.practice.assignment4.entities.Project;
import java.util.List;

public interface IProjectRepo {
    boolean createProject(Project project);
    Project getProject(int code);
    List<Project> getAllProjects();
}