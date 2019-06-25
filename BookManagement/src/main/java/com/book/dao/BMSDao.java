package com.book.dao;

import java.sql.ResultSet;    
import java.sql.SQLException;    
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;    
import org.springframework.jdbc.core.JdbcTemplate;    
import org.springframework.jdbc.core.RowMapper;

import com.book.beans.Author;
import com.book.beans.Book;
import com.book.beans.Pair;
import com.book.beans.User;

import org.springframework.jdbc.core.ResultSetExtractor;

public class BMSDao {
	JdbcTemplate template;


public void setTemplate(JdbcTemplate template){
	this.template = template;
}

public int save(User user){    
    String sql="insert into BMSUSERS(email,name,isadmin,password) values('"
                 +user.getEmail()+"','"+ user.getName()+"',"+ user.getisadmin()+ ", '"+user.getPassword() + "')";   
    return template.update(sql);    
}  

//public int update(User user){    
//    String sql="update USERS set name='"+ user.getName()+"', ='"+p.getAddress()+"',drpartment='"+p.getDepartment()+"' where id="+p.getId()+"";    
//    return template.update(sql);    
//} 

public boolean getIsAdmin(String email){
	return getUser(email).getisadmin();
}

public User getUser(String email){    
    String sql="select * from BMSUSERS where email =?";    
    return template.queryForObject(sql, new Object[]{email},new UserMapper());    
  
} 

public class UserMapper implements RowMapper<User>{

	public User mapRow(ResultSet rs, int arg1) throws SQLException {
		User user = new User();
        user.setEmail(rs.getString(1));
        user.setName(rs.getString(2));
        user.setadmin(rs.getBoolean(3));
        user.setPassword(rs.getString(4));
        return user;
	}
	
}

public class AuthorMapper implements RowMapper<Author>{

	public Author mapRow(ResultSet arg0, int arg1) throws SQLException {
		Author author= new Author();
		author.setAuthorId(arg0.getInt(1));
		author.setAuthorName(arg0.getString(2));
		return author;
	}
	
}

public class BookMapper implements RowMapper<Book>{

	public Book mapRow(ResultSet rs, int arg1) throws SQLException {
		Book book = new Book();
		book.setBookName(rs.getString(1));
		book.setBookId(rs.getInt(2));
		book.setPrice(rs.getInt(3));
		book.setYear(rs.getInt(4));
		book.setAuthorId(rs.getInt(5));
		
		return book;
	}
	
}

public class PairMapper implements RowMapper<Pair>{

	public Pair mapRow(ResultSet rs, int arg1) throws SQLException {
		Pair pair= new Pair();
		Book book= new Book();
		Author author= new Author();
		book.setBookName(rs.getString(1));
		book.setPrice(rs.getInt(2));
		book.setYear(rs.getInt(3));
		author.setAuthorName(rs.getString(4));
		pair.setBook(book);
		pair.setAuthor(author);
		return pair;
	}
	
}
public List<User> getAllUsers(){
	return template.query("select * from BMSUsers ",new UserMapper()); 
}

public int saveAuthor(Author author){
	String sql="insert into BMSAuthors(authorname) values('"+author.getAuthorName()+"')";
    return template.update(sql);  
}

public List<Author> getAllAuthors(){
	return template.query("select * from BMSAuthors", new AuthorMapper());
}

public int deleteAuthor(int id){
	String sql= "delete from BMSAuthors where authorId="+id;
	return template.update(sql);
}

public int deleteUser(String email){
	String sql= "delete from BMSUsers where email='"+email+"'";
	return template.update(sql);
}

public int saveBook(Book book){
	String sql="insert into BMSBooks(bookname,price, year,authorid) values('"+book.getBookName()+"'"+
                 ","+book.getPrice()+","+book.getYear()+","+book.getAuthorId()+")";
    return template.update(sql); 
}

public List<Book> getAllBooks(){
	return template.query("select * from BMSBooks", new BookMapper());
}

public List<Pair> getBookbyName(String name){
	String sql = "select bookName,price,year,authorName from BMSBooks INNER JOIN BMSAuthors ON BMSBooks.authorId= BMSAuthors.authorId"
			+ " WHERE bookName like '" +name+"%'";
	return template.query(sql, new PairMapper());
}
public List<Pair> getBookbyAuthor(String name){
	String sql = "select bookName,price,year,authorName from BMSBooks INNER JOIN BMSAuthors ON BMSBooks.authorId= BMSAuthors.authorId"
			+ " WHERE authorName like '" +name+"%'";
	return template.query(sql, new PairMapper());
}
}