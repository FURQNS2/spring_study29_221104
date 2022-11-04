package com.sycompany.std24;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sycompany.std24.dao.IDao;
import com.sycompany.std24.dto.ContentDto;

@Controller
public class BoardController {

	@Autowired
	private SqlSession sqlSession;   //bean에서 만든 클래스를 멤버변수로 적는다.
	
	@RequestMapping("/writeForm")
	public String writeForm() {
		
		return "writeForm";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request) {
		
	
		IDao dao = sqlSession.getMapper(IDao.class); //불러오고 싶은 클래스명을 적음
		
		
		String mwriter = request.getParameter("mwriter");
		String mcontent = request.getParameter("mcontent");
		
		dao.writeDao(mwriter, mcontent);
		
		return "redirect:list";
		
	}
	
	
	@RequestMapping("/list")
	public String list(Model model) {
		
		IDao dao = sqlSession.getMapper(IDao.class); //불러오고 싶은 클래스명을 적음
		
		ArrayList<ContentDto> dtos = dao.listDao();
		
		model.addAttribute("list", dtos);
		

		return "list";
	}
	
	@RequestMapping("/")
	public String home() {
		
		
		return "redirect:list";
	}
	
	
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) {
		
	
		IDao dao = sqlSession.getMapper(IDao.class); //불러오고 싶은 클래스명을 적음
		
		String mid = request.getParameter("mid");
		
		
		dao.deleteDao(mid);
		
		return "redirect:list";
		
	}
	
	
	@RequestMapping("/mview")
	public String mveiw(HttpServletRequest request, Model model) {
		
		IDao dao = sqlSession.getMapper(IDao.class); //불러오고 싶은 클래스명을 적음
		
		String mid = request.getParameter("mid");
		
		ContentDto dto = dao.mviewDao(mid);
		
		
		model.addAttribute("mdto", dto);
		
		return "mview";
	}
	
	
	@RequestMapping("/modify")
	public String modify(HttpServletRequest request) {
	
		IDao dao = sqlSession.getMapper(IDao.class); //불러오고 싶은 클래스명을 적음
		
		String mid = request.getParameter("mid");
		String mwriter = request.getParameter("mwriter");
		String mcontent = request.getParameter("mcontent");
		
		dao.modifyDao(mid, mwriter, mcontent);
		
		return "redirect:list";
	}
	
	
}
