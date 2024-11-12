package dao;

import context.DbContext;
import model.ChuDe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class ChuDeDAO {
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    
    public ArrayList<ChuDe> getAll()
    {
       ArrayList<ChuDe>  ds = new ArrayList<>();
      
       String sql="select * from chude";
       conn= new DbContext().getConnection();
       try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next())
            {
                 ds.add(new ChuDe(rs.getInt(1),rs.getString(2)));
            }
        } catch (SQLException ex) {
            System.out.println("Loi SQL:" + ex.toString());
        }  
       return ds;       
    }
    
    public static void main(String[] args) {
        for(ChuDe x: new ChuDeDAO().getAll())
        {
            System.out.println(x);
        }
    }
}
