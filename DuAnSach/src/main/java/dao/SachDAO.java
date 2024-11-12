/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DbContext;
import model.Sach;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class SachDAO {

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    public ArrayList<Sach> getTop10() {
        ArrayList<Sach> ds = new ArrayList();
        String sql = "select top 10 * from sach order by ngaycapnhat desc";
        conn = new DbContext().getConnection();
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next())
            {
               ds.add(new Sach(rs.getInt(1),rs.getString(2),rs.getInt(3),
                       rs.getInt(4),rs.getInt(5),rs.getString(6),rs.getDate(7)));
            }
        } catch (Exception ex) {
            System.out.println("Loi SQL:" + ex.toString());
        }
        return ds;
    }
    
     public ArrayList<Sach> Laychude(int macd) {
        ArrayList<Sach> ds = new ArrayList();
        String sql = "select * from sach where macd=?";
        conn = new DbContext().getConnection();
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, macd);
            rs = ps.executeQuery();
            while(rs.next())
            {
               ds.add(new Sach(rs.getInt(1),rs.getString(2),rs.getInt(3),
                       rs.getInt(4),rs.getInt(5),rs.getString(6),rs.getDate(7)));
            }
        } catch (Exception ex) {
            System.out.println("Loi SQL:" + ex.toString());
        }
        return ds;
    }
    
    
    
    public static void main(String[] args) {
        for(Sach x:  new SachDAO().Laychude(2))
        {
            System.out.println(x); 
        }
    }
}
