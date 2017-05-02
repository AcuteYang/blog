package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.BlogDao;
import dao.BlogDaoImpl;
import entity.Blog;

@Controller
@RequestMapping("/blog")

public class BlogController {
	
	private BlogDao blogDao=new BlogDaoImpl();
	
	@RequestMapping("/")
	public String displayBlog(Model model){
		List<Blog> blogs=blogDao.getAllBlogs();
		model.addAttribute("blogs",blogs);
		
		return "blog";
	}
}
