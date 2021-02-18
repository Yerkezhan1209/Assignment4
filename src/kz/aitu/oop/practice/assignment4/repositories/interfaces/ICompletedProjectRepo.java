package kz.aitu.oop.practice.assignment4.repositories.interfaces;

import kz.aitu.oop.practice.assignment4.entities.CompletedProject;
import java.util.List;

public interface ICompletedProjectRepo {
    boolean createCompletedProject(CompletedProject completedProject);
    CompletedProject getCompletedProject(int code);
    List<CompletedProject> getAllCompletedProjects();
    List<CompletedProject> getSuccessfulCompletedProjects();
    int getTotal();
    int getMax();
    int getMin();
}
