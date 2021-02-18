package kz.aitu.oop.practice.assignment4.repositories;

import kz.aitu.oop.practice.assignment4.data.interfaces.IDB;
import kz.aitu.oop.practice.assignment4.entities.CompletedProject;
import kz.aitu.oop.practice.assignment4.repositories.interfaces.ICompletedProjectRepo;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CompletedProjectRepo implements ICompletedProjectRepo{
    private final IDB db;

    public CompletedProjectRepo(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createCompletedProject(CompletedProject completedProject) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO completedProjects(name,application,start_date,end_date,cost,result) VALUES (?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, completedProject.getName());
            st.setString(2, completedProject.getApplication());
            st.setString(3, completedProject.getStart_date());
            st.setString(4, completedProject.getEnd_date());
            st.setInt(5, completedProject.getCost());
            st.setBoolean(6, completedProject.getResult());
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
    public CompletedProject getCompletedProject(int code) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT code,name,application,start_date,end_date,cost,result FROM completedProjects WHERE code=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, code);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                CompletedProject completedProject = new CompletedProject(rs.getInt("code"),
                        rs.getString("name"),
                        rs.getString("application"),
                        rs.getString("start_date"),
                        rs.getString("end_date"),
                        rs.getInt("cost"),
                        rs.getBoolean("result"));
                return completedProject;
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
    public List<CompletedProject> getAllCompletedProjects() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT code,name,application,start_date,end_date,cost,result FROM completedProjects";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<CompletedProject> completedProjects = new ArrayList<>();
            while (rs.next()) {
                CompletedProject completedProject = new CompletedProject(rs.getInt("code"),
                        rs.getString("name"),
                        rs.getString("application"),
                        rs.getString("start_date"),
                        rs.getString("end_date"),
                        rs.getInt("cost"),
                        rs.getBoolean("result"));
                completedProjects.add(completedProject);
            }
            return completedProjects;
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
    public List<CompletedProject> getSuccessfulCompletedProjects() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT code,name,application,start_date,end_date,cost,result FROM completedProjects";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<CompletedProject> successfulCompletedProjects = new ArrayList<>();
            while (rs.next()) {
                if (rs.getBoolean("result")) {
                    CompletedProject completedProject = new CompletedProject(rs.getInt("code"),
                        rs.getString("name"),
                        rs.getString("application"),
                        rs.getString("start_date"),
                        rs.getString("end_date"),
                        rs.getInt("cost"),
                        rs.getBoolean("result"));
                    successfulCompletedProjects.add(completedProject);
                }
            }
            return successfulCompletedProjects;
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
    public int getTotal() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT cost FROM completedProjects";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<CompletedProject> completedProjects = new ArrayList<>();
            int response = 0;
            while (rs.next()) {
                response = response + rs.getInt("cost");
            }
            return response;
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
        return 0;
    }

    @Override
    public int getMax() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT cost FROM completedProjects";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<CompletedProject> completedProjects = new ArrayList<>();
            int max = 0;
            while (rs.next()) {
                if ((rs.getInt("cost"))>max) {
                    max = rs.getInt("cost"); }
            }
            return max;
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
        return 0;
    }

    @Override
    public int getMin() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT cost FROM completedProjects";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<CompletedProject> completedProjects = new ArrayList<>();
            int min = 999999999;
            while (rs.next()) {
                if ((rs.getInt("cost"))<min) {
                    min = rs.getInt("cost"); }
            }
            return min;
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
        return 0;
    }
}
