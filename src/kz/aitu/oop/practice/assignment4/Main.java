package kz.aitu.oop.practice.assignment4;

import kz.aitu.oop.practice.assignment4.data.PostgresDB;
import kz.aitu.oop.practice.assignment4.data.interfaces.IDB;
import kz.aitu.oop.practice.assignment4.repositories.EmployeeRepo;
import kz.aitu.oop.practice.assignment4.repositories.ProjectRepo;
import kz.aitu.oop.practice.assignment4.repositories.CompletedProjectRepo;
import kz.aitu.oop.practice.assignment4.repositories.interfaces.IEmployeeRepo;
import kz.aitu.oop.practice.assignment4.repositories.interfaces.IProjectRepo;
import kz.aitu.oop.practice.assignment4.repositories.interfaces.ICompletedProjectRepo;

public class Main {
    public static void main(String[] args) {
//        String connectionUrl = "jdbc:postgresql://localhost:5432/assignment4";
//        Connection con = null;
//        ResultSet rs = null;
//        Statement stmt = null;
//        try {
//            Class.forName("org.postgresql.Driver");
//            con = DriverManager.getConnection(connectionUrl, "postgres", "dwrlwine20022E");
//            stmt = con.createStatement();
//            rs = stmt.executeQuery("select * mistake from users");
//            while (rs.next())
//                System.out.println(rs.getInt("id") + "  "
//                        + rs.getString("name") + "  " + rs.getString("surname"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                rs.close();
//                stmt.close();
//                con.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }

        IDB db = new PostgresDB();
        IEmployeeRepo repo1 = new EmployeeRepo(db);
        IProjectRepo repo2 = new ProjectRepo(db);
        ICompletedProjectRepo repo3 = new CompletedProjectRepo(db);
        MyApplication app = new MyApplication(repo1, repo2, repo3);
        app.start();
    }
}