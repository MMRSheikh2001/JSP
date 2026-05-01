/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Custom;
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
 * @author Administrator
 */
public class CustomDao {

    static PreparedStatement ps;
    static ResultSet rs;
    static String sql;
    static DBUtil db = new DBUtil();

    public static void save(Custom c) {
        sql = "insert into custom (name,custom1,custom2,custom3,custom4,custom5) values(?,?,?,?,?,?)";
        try {
            ps = db.getCon().prepareStatement(sql);
            ps.setString(1, c.getName());
            ps.setString(2, c.getCustom1());
            ps.setString(3, c.getCustom2());
            ps.setString(4, c.getCustom3());
            ps.setString(5, c.getCustom4());
            ps.setString(6, c.getCustom5());
            ps.executeUpdate();
            ps.close();
            db.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(CustomDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static List<Custom> viewAll() {
        List<Custom> cList = new ArrayList<>();
        sql = "select * from custom";
        try {
            ps = db.getCon().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Custom c = new Custom(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("custom1"), rs.getString("custom2"),
                        rs.getString("custom3"),
                        rs.getString("custom4"),
                        rs.getString("custom5"));
                cList.add(c);

            }
            rs.close();
            ps.close();
            db.getCon().close();

        } catch (SQLException ex) {
            Logger.getLogger(CustomDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cList;
    }

    public static void delete(int id) {
        sql = "delete from custom where id=?";
        try {
            ps = db.getCon().prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            db.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(CustomDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static Custom getById(int id) {
        Custom c = null;
        sql = "select * from custom where id=?";
        try {
            ps = db.getCon().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                c = new Custom(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("custom1"), rs.getString("custom2"),
                        rs.getString("custom3"),
                        rs.getString("custom4"),
                        rs.getString("custom5"));

            }
            rs.close();
            ps.close();
            db.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(CustomDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

    public static void update(Custom c) {
        sql = "update custom set name=?,custom1=?,custom2=?,custom3=?,custom4=?,custom5=? where id=?";
        try {
            ps = db.getCon().prepareStatement(sql);
            ps.setString(1, c.getName());
            ps.setString(2, c.getCustom1());
            ps.setString(3, c.getCustom2());
            ps.setString(4, c.getCustom3());
            ps.setString(5, c.getCustom4());
            ps.setString(6, c.getCustom5());
            ps.setInt(7, c.getId());
            ps.executeUpdate();
            ps.close();
            db.getCon().close();

        } catch (SQLException ex) {
            Logger.getLogger(CustomDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
