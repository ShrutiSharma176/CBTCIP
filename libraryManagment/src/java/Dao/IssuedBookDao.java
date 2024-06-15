package Dao;

import java.sql.*;
import Connection.MyConn;
import java.util.ArrayList;
import Dto.IssuedBook;
public class IssuedBookDao {
    public int getIssuedBook(int bId,int uId){
        int i=0;
        try{
            Connection con = MyConn.getConnection();
            String query = "select * from issuedBook where bookId=? and userId=? and isIssuedNow='true'";
            PreparedStatement ps = con .prepareStatement(query);
            ps.setInt(1, bId);
            ps.setInt(2, uId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                i++;
            }
        }catch(SQLException e){
            System.out.println("Exception : "+ e);
        }
        return i;
    }
    
    public int isNotIssued(int bId,int uId){
        int i=0;
        try{
            Connection con = MyConn.getConnection();
            String query = "select * from issuedBook where bookId=? and userId=? and isIssuedNow='false'";
            PreparedStatement ps = con .prepareStatement(query);
            ps.setInt(1, bId);
            ps.setInt(2, uId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                i++;
            }
        }catch(SQLException e){
            System.out.println("Exception : "+ e);
        }
        return i;
    }
    
    public int updateIssuedBook(int bId,int uId){
        int i=0;
        try{
            Connection con = MyConn.getConnection();
            String query = "update issuedBook set isIssuedNow='true' where bookId=? and userId=?";
            PreparedStatement ps = con .prepareStatement(query);
            ps.setInt(1, bId);
            ps.setInt(2, uId);
            i = ps.executeUpdate();
            
        }catch(SQLException e){
            System.out.println("Exception : "+ e);
        }
        return i; 
    }
    
    public int isAllottedToOther(int bId){
        int i=0;
        try{
            Connection con = MyConn.getConnection();
            String query = "select * from issuedBook where bookId=? and isIssuedNow='true'";
            PreparedStatement ps = con .prepareStatement(query);
            ps.setInt(1, bId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                i++;
            }
        }catch(SQLException e){
            System.out.println("Exception : "+ e);
        }
        return i;
    }
    
    public int issueBook(int bId,int uId){
       int i=0;
        try{
            Connection con = MyConn.getConnection();
            String query = "insert into issuedBook(bookId,userId,isIssuedNow ) values(?,?,?)";
            PreparedStatement ps = con .prepareStatement(query);
            ps.setInt(1, bId);
            ps.setInt(2, uId);
            ps.setString(3, "true");
            i = ps.executeUpdate();
            
        }catch(SQLException e){
            System.out.println("Exception : "+ e);
        }
        return i; 
    }
    
    public ArrayList<IssuedBook> getAllIssuedBookByUSer(int userId){
        ArrayList<IssuedBook> list = new ArrayList<>();
        try{
            Connection con = MyConn.getConnection();
            String query ="select * from issuedBook where userId=? and isIssuedNow='true'";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, userId);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                IssuedBook i = new IssuedBook();
                i.setBookId(rs.getInt(1));
                i.setUserId(rs.getInt(2));
                i.setIsIssuedNow(rs.getBoolean(3));
                list.add(i);
            }
            
        }catch(SQLException e){
            System.out.println("Exception : "+ e);
        }
        return list;
    }
    
    public ArrayList<IssuedBook> getAllIssuedBook(){
        ArrayList<IssuedBook> list = new ArrayList<>();
        try{
            Connection con = MyConn.getConnection();
            String query ="select * from issuedBook where isIssuedNow='true'";
            PreparedStatement ps = con.prepareStatement(query);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                IssuedBook i = new IssuedBook();
                i.setBookId(rs.getInt(1));
                i.setUserId(rs.getInt(2));
                i.setIsIssuedNow(rs.getBoolean(3));
                list.add(i);
            }
            
        }catch(SQLException e){
            System.out.println("Exception : "+ e);
        }
        return list;
    }
    
    public int returnBook(int id){
        int i=0;
        try{
            Connection con = MyConn.getConnection();
            String query = "update issuedBook set isIssuedNow='false' where bookId=?";
            PreparedStatement ps = con .prepareStatement(query);
            ps.setInt(1, id);
            
            i = ps.executeUpdate();
            
        }catch(SQLException e){
            System.out.println("Exception : "+ e);
        }
        return i;
    }
}
