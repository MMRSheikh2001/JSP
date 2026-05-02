/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Emp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DBUtil;

/**
 *
 * @author Admin
 */
public class EmpDao {

    static DBUtil util = new DBUtil();

    static PreparedStatement ps;
    static ResultSet rs;
    static String sql;

    public static int save(Emp e) {
        int status = 0;
        sql = "insert into emp(name,custom1,custom2,custom3,custom4,custom5) values(?,?,?,?,?,?)";

        try {
            ps = util.getCon().prepareStatement(sql);

            ps.setString(1, e.getName());
            ps.setString(2, e.getCustom1());
            ps.setString(3, e.getCustom2());
            ps.setString(4, e.getCustom3());
            ps.setString(5, e.getCustom4());
            ps.setString(6, e.getCustom5());

            
            System.out.println("111111111111111111111111111111");
            status = ps.executeUpdate();
            System.out.println("222222222222222222222222");
            ps.close();
            util.getCon().close();

        } catch (SQLException ex) {
            Logger.getLogger(EmpDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;

    }

    public static List<Emp> getAll() {
        List<Emp> list = new ArrayList<>();
        sql = "select * from emp";

        try {
            ps = util.getCon().prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                Emp e = new Emp(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("custom1"),
                        rs.getString("custom2"),
                        rs.getString("custom3"),
                        rs.getString("custom4"),
                        rs.getString("custom5")
                );
                list.add(e);
            }

            rs.close();
            ps.close();
            util.getCon().close();

        } catch (SQLException ex) {
            Logger.getLogger(EmpDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;

    }

    public static Emp getById(int id) {
        Emp e = null;
        sql = "select * from emp where id =?";

        try {
            ps = util.getCon().prepareStatement(sql);

            ps.setInt(1, id);

            rs = ps.executeQuery();

            while (rs.next()) {
                e = new Emp(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("custom1"),
                        rs.getString("custom2"),
                        rs.getString("custom3"),
                        rs.getString("custom4"),
                        rs.getString("custom5")
                );

            }

            rs.close();
            ps.close();
            util.getCon().close();

        } catch (SQLException ex) {
            Logger.getLogger(EmpDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;
    }

    public static int update(Emp e) {
        int status = 0;
        sql = "update emp set name = ?,custom1=?,custom2=?,custom3=?,custom4=?,custom5=? where id=? ";

        try {
            ps = util.getCon().prepareStatement(sql);

            ps.setString(1, e.getName());
            ps.setString(2, e.getCustom1());
            ps.setString(3, e.getCustom2());
            ps.setString(4, e.getCustom3());
            ps.setString(5, e.getCustom4());
            ps.setString(6, e.getCustom5());
            ps.setInt(7, e.getId());

            status = ps.executeUpdate();

            ps.close();
            util.getCon().close();

        } catch (SQLException ex) {
            Logger.getLogger(EmpDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;

    }

    public static int delete(int id) {
        int status = 0;
        sql = "delete from emp where id =?";

        try {
            ps = util.getCon().prepareStatement(sql);
            ps.setInt(1, id);
            status = ps.executeUpdate();

            ps.close();
            util.getCon().close();

        } catch (SQLException ex) {
            Logger.getLogger(EmpDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;

    }

}
