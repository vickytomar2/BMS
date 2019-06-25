package com.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.book.beans.Author;
import com.book.beans.Book;
import com.book.beans.Pair;
import com.book.beans.User;
import com.book.dao.*;

@Controller
public class BMSController {
	
	@Autowired
	BMSDao dao;
	
	@RequestMapping("/register")
	public String register(){
		return "registerUser";
	}
	
	@RequestMapping("/registerUser")
	public String registerUser(@RequestParam("email") String email,
			@RequestParam("name") String name, @RequestParam("password") String password , Model m){
		User user = new User();
		user.setEmail(email);
		user.setName(name);
		user.setPassword(password);
		user.setadmin(false);
		try{
		dao.save(user);
		return "redirect:/";
		}catch(Exception ex){
			m.addAttribute("message", "User Already Exists!");
			return "error";
		}
	}
	
	@RequestMapping("/login")
	public String loginUser(@RequestParam("email") String email,@RequestParam("password")
	String password, Model m){
		User user;
		try{
			user= dao.getUser(email);
			
		}catch(Exception ex){
			String msg = "No User Found";
			m.addAttribute("message", msg);
			return "error";
		}
		
		if(password.equals(user.getPassword())){
			if(user.getisadmin()){
				return "adminPage";
			}else{
				return "userPage";
			}
		}else{
			String message = "Incorrect Password! ";
			m.addAttribute("message", message);
			return "error";
		}
		
	}
	
	@RequestMapping("/viewUsers")
	public String viewUsers(Model m){
		List<User> list= dao.getAllUsers();
		m.addAttribute("list",list);
		return "viewUsers";
	}
	
	@RequestMapping("/addAuthor")
	public String addAuthor(){
		return "addAuthor";
	}

	@RequestMapping("/addAuth")
	public String addAuth(@RequestParam("authorName") String authorName, Model m){
		Author author= new Author();
		author.setAuthorName(authorName);
		try{
	     dao.saveAuthor(author);
		}catch(Exception ex){
			m.addAttribute("message", "Author Already Exists!");
			return "error";
		}
	     m.addAttribute("message", "Author Added!");
	     return "error";
	}
	
	@RequestMapping("/viewAuthors")
	public String viewAuthors(Model m){
		List<Author> list= dao.getAllAuthors();
		m.addAttribute("list",list);
		return "viewAuthor";
	}
	
	@RequestMapping("/deleteAuthor/{id}")
	public String deleteAuthor(@PathVariable int id){
		dao.deleteAuthor(id);
		return "redirect:/viewAuthors";
	}
	
	@RequestMapping("/addBook")
	public String addBook(Model m){
		List<Author> list= dao.getAllAuthors();
		m.addAttribute("list", list);
		return "addBook";
	}
	
	@RequestMapping("/addABook")
	public String addABook(@RequestParam("authorId") int authorId,@RequestParam("bookName") String bookName,
			@RequestParam("price") int price,@RequestParam("year") int year, Model m){
		Book book= new Book();
		book.setBookName(bookName);
		book.setPrice(price);
		book.setYear(year);
		book.setAuthorId(authorId);
		
		try{
	        dao.saveBook(book);
		}catch(Exception ex){
			m.addAttribute("message", "Book Already Exists!");
			return "error";
		}
	     m.addAttribute("message", "Book Added!");
	     return "error";
	}
	
	@RequestMapping("/viewBooks")
	public String viewBooks(Model m){
		List<Book> list= dao.getAllBooks();
		m.addAttribute("list",list);
		return "viewBooks";
	}
	
	@RequestMapping("/searchBook")
	public String searchBook(){
		return "searchBook";
	}
	
	@RequestMapping("/searchBookByName")
	public String searchBookByName(@RequestParam("bookName") String bookName, Model m){
		List<Pair> list = dao.getBookbyName(bookName);
		m.addAttribute("list",list);
		return "searchView";
	}
	
	@RequestMapping("/searchBookByAuthor")
	public String searchBookByAuthor(@RequestParam("bookName") String authorName, Model m){
		List<Pair> list = dao.getBookbyAuthor(authorName);
		m.addAttribute("list",list);
		return "searchView";
	}
	
	@RequestMapping("/deleteUser/{email}")
	public String deleteAuthor(@PathVariable String email){
		dao.deleteUser(email);
		return "redirect:/viewUsers";
	}
}
