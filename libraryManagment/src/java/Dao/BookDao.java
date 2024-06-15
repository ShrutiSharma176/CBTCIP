package Dao;

import java.sql.*;
import java.util.*;
import Connection.MyConn;
import Dto.Book;

public class BookDao {
    public int addBook(Book obj){
        int i =0;
        try{
            Connection con = MyConn.getConnection();
            String query = "insert into book(id,title,author,category,available) values(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setInt(1, obj.getId());
            ps.setString(2, obj.getTitle());
            ps.setString(3, obj.getAuthor());
            ps.setString(4, obj.getCategory());
            ps.setString(5, "true");
            
            i =ps.executeUpdate();
            con.close();
            
        }catch(SQLException e){
            System.out.println("Exception : "+e);
        }
        
        return i;
    }
    
    public ArrayList<Book> getBook(){
        ArrayList<Book> book = new ArrayList<>();
        try{
            Connection con = MyConn.getConnection();
            String query = "select * from book";
            PreparedStatement ps = con .prepareStatement(query);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Book obj = new Book();
                obj.setId(rs.getInt(1));
                obj.setTitle(rs.getString(2));
                obj.setAuthor(rs.getString(3));
                obj.setCategory(rs.getString(4));
                obj.setAvailable(rs.getString(5));
                
                book.add(obj);
            }
            
        }catch(SQLException e){
            System.out.println("Exception : "+e);
        }
        
        return book;
    }
    
    public Book getBookDetail(int id){
        Book obj = new Book();
        try{
            Connection con = MyConn.getConnection();
            String query = "select * from book where id=?";
            PreparedStatement ps = con .prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                obj.setId(rs.getInt(1));
                obj.setTitle(rs.getString(2));
                obj.setAuthor(rs.getString(3));
                obj.setCategory(rs.getString(4));
                obj.setAvailable(rs.getString(5));
            }
            
        }catch(SQLException e){
            System.out.println("Exception : "+e);
        }
        
        return obj;
    }
    
    public int updateBook(Book obj){
        int i=0;
        try{
            Connection con=MyConn.getConnection();
            String query="update book set title=?,author=?,category=? where id=?";
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setString(1,obj.getTitle());
            ps.setString(2,obj.getAuthor());
            ps.setString(3,obj.getCategory());
            
            ps.setInt(4,obj.getId());
            
            i = ps.executeUpdate();
        
            con.close();
        }catch(SQLException e){
            System.out.println("Exception: "+e);
        }
        
        return i;
    }
    
    public ArrayList<Book> getAvailBook(){
        ArrayList<Book> book = new ArrayList<>();
        try{
            Connection con = MyConn.getConnection();
            String query = "select * from book where available='true'";
            PreparedStatement ps = con .prepareStatement(query);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Book obj = new Book();
                obj.setId(rs.getInt(1));
                obj.setTitle(rs.getString(2));
                obj.setAuthor(rs.getString(3));
                obj.setCategory(rs.getString(4));
                obj.setAvailable(rs.getString(5));
                
                book.add(obj);
            }
            
        }catch(SQLException e){
            System.out.println("Exception : "+e);
        }
        
        return book;
    }
}
