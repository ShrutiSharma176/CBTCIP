package Dao;

import java.sql.*;
import Dto.Admin;
import Connection.MyConn;

public class AdminDao {
    public int searchAdmin(String email,String password){
        int i=0;
        try{
           String query = "select * from admin where email =? and password = ?" ;
           Connection con = MyConn.getConnection();
           PreparedStatement ps = con.prepareStatement(query);
           
           ps.setString(1, email);
           ps.setString(2, password);
           
           ResultSet rs = ps.executeQuery();
           
           if(rs.next()){
               i++;
           }
           
        }catch(SQLException e){
            System.out.println("Exception : "+e);
        }
        
        return i;
    }
    
    
    public int deleteUSer(int id){
        int i= 0;
        try{
            Connection con = MyConn.getConnection();
            String query = "update user set status='false' where id=?";
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setInt(1, id);
            i=ps.executeUpdate();
            con.close();
        }catch(SQLException e){
            System.out.println("Exception: "+e);
        }
        return i;
    }
    
     public int changeAvailabilty(int id){
        int i = 0;
        try{
            Connection con =MyConn.getConnection();
            String query = "update book set available='false' where id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            i=ps.executeUpdate();
            con.close();
        }catch(SQLException e){
            System.out.println("Exception: "+e);
        }
        
        return i;
    }
}
