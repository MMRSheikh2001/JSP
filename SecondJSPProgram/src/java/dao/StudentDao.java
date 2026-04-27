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
 * @author Admin
 */
public class StudentDao {

    static PreparedStatement ps;
    static ResultSet rs;
    static String sql;

    public static int save(Student s) {
        int value = 0;
        sql = "insert into student1 (name,email,dob,fee) values(?,?,?,?)";
        try {
            ps = DbUtil.getCon().prepareStatement(sql);
            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getDob());
            ps.setDouble(4, s.getFee());

            value = ps.executeUpdate();
            ps.close();
            DbUtil.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return value;
    }

    public static List<Student> findAll() {
        List<Student> sList = new ArrayList<>();
        sql = "select * from student1";
        try {
            ps = DbUtil.getCon().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Student s = new Student(rs.getInt("id"), rs.getString("name"),
                        rs.getString("email"), rs.getString("dob"), rs.getDouble("fee"));
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

    public static void delete(int id) {
        sql = "delete from student1 where id=?";
        try {
            ps = DbUtil.getCon().prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            DbUtil.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void update(Student s) {
        sql = "update student1 set name=?,email=?,dob=?,fee=? where id=?";
        try {
            ps = DbUtil.getCon().prepareStatement(sql);
            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getDob());
            ps.setDouble(4, s.getFee());
            ps.setInt(5, s.getId());

            ps.executeUpdate();
            ps.close();
            DbUtil.getCon().close();

        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Student findById(int id) {
        Student s = null;
        sql = "select * from student1 where id=?";
        try {
            ps = DbUtil.getCon().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                s = new Student(rs.getInt("id"), rs.getString("name"),
                        rs.getString("email"), rs.getString("dob"), rs.getDouble("fee"));

            }
            rs.close();
            ps.close();
            DbUtil.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return s;
    }

}
