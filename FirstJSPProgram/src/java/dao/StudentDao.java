/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Student;
import util.DbUtil;

/**
 *
 * @author Administrator
 */
public class StudentDao {

    static PreparedStatement ps;
    static ResultSet rs;
    static String sql;

    /**
     *
     *
     *
     */
    public static int save(Student s) {
        int value = 0;
        sql = "insert into student(name,email,address,cell) values(?,?,?,?)";
        try {
            ps = DbUtil.getCon().prepareStatement(sql);
            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getAddress());
            ps.setString(4, s.getCell());

            value = ps.executeUpdate();

            ps.close();
            DbUtil.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return value;
    }

    public static List<Student> viewAllStudent() {
        List<Student> sList = new ArrayList<>();
        sql = "select * from student";
        try {
            ps = DbUtil.getCon().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Student s = new Student(rs.getInt("id"), rs.getString("name"),
                        rs.getString("email"), rs.getString("address"), rs.getString("cell"));
                sList.add(s);

            }
            rs.close();
            ps.close();
            DbUtil.getCon().close();

        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sList;

    }

    public static void deleteStudent(Student s) {
        sql = "delete from student where id=?";
        try {
            ps = DbUtil.getCon().prepareStatement(sql);
            ps.setInt(1, s.getId());
            ps.executeUpdate();
            ps.close();
            DbUtil.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
