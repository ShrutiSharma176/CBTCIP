package Dao;

import java.sql.*;
import Dto.User;
import java.util.*;
import Connection.MyConn;

public class UserDao {
    public int addUser(User obj){
        int i=0;
        try{
          Connection con = MyConn.getConnection();
          String query = "insert into user(id,name,email,password,status) values(?,?,?,?,?)";
          PreparedStatement ps = con.prepareStatement(query);
          ps.setInt(1, obj.getId());
          ps.setString(2, obj.getName());
          ps.setString(3, obj.getEmail());
          ps.setString(4, obj.getPassword());
          ps.setString(5, "true");
          
          i = ps.executeUpdate();
          con.close();
        }catch(SQLException e){
            System.out.println("Exception : "+e);
        }
        return i;
    }
    
    public int searchUser(String email,String password){
        int i=0;
        try{
            Connection con = MyConn.getConnection();
            
            String query="select * from user where email=? and password=? and status='true'";
            PreparedStatement ps=con.prepareStatement(query);
            
            ps.setString(1,email);
            ps.setString(2,password);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                i++;
            }
            
        }catch(SQLException e){
            System.out.println("Exception: "+e);
        }
        return i;
    }
    
    public ArrayList<User> getUser(){
        ArrayList<User> list = new ArrayList<>();
        try{
          Connection con = MyConn.getConnection();
          String query = "select * from user where status='true'";
            PreparedStatement ps = con.prepareStatement(query);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                User u = new User();
                u.setId(rs.getInt(1));
                u.setName(rs.getString(2));
                u.setEmail(rs.getString(3));
                u.setPassword(rs.getString(4));
                u.setStatus(rs.getString(5));
                list.add(u);
            }
            
        }catch(SQLException e){
            System.out.println("Exception: "+e);
        }
        return list;
    }
    
    public User getUserDetail(String email){
        User u = new User();
        try{
          Connection con = MyConn.getConnection();
          String query = "select * from user where email = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                u.setId(rs.getInt(1));
                u.setName(rs.getString(2));
                u.setEmail(rs.getString(3));
                u.setPassword(rs.getString(4));
                u.setStatus(rs.getString(5));
            }
            
        }catch(SQLException e){
            System.out.println("Exception: "+e);
        }
        return u;
    }
    
    public int updatePassword(String email,String password){
        int i=0;
        try{
            Connection con = MyConn.getConnection();
            
            String query="update user set password=? where email=?";
            PreparedStatement ps=con.prepareStatement(query);
            
            ps.setString(1,password);
            ps.setString(2,email);
            
            i = ps.executeUpdate();
            con.close();
            
        }catch(SQLException e){
            System.out.println("Exception: "+e);
        }
        return i;
    }
}
