package kz.aitu.oop.practice.assignment4.repositories;

import kz.aitu.oop.practice.assignment4.data.interfaces.IDB;
import kz.aitu.oop.practice.assignment4.entities.Project;
import kz.aitu.oop.practice.assignment4.repositories.interfaces.IProjectRepo;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ProjectRepo implements IProjectRepo{
    private final IDB db;

    public ProjectRepo(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createProject(Project project) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO projects(name,application) VALUES (?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, project.getName());
            st.setString(2, project.getApplication());
            boolean executed = st.execute();
            return executed;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Project getProject(int code) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT code,name,application FROM projects WHERE code=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, code);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Project project = new Project(rs.getInt("code"),
                        rs.getString("name"),
                        rs.getString("application"));
                return project;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Project> getAllProjects() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT code,name,application FROM projects";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<Project> projects = new ArrayList<>();
            while (rs.next()) {
                Project project = new Project(rs.getInt("code"),
                        rs.getString("name"),
                        rs.getString("application"));
                projects.add(project);
            }
            return projects;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
}
