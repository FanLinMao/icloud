package cn.edu.cuit.icloud.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import cn.edu.cuit.icloud.dto.MessageDTO;

/**
 * 用户退出
 * @date: 2020年3月20日
 * @author: flfan
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static Logger logger = Logger.getLogger(LogoutServlet.class);
	
	public LogoutServlet(){
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json");
		//注销用户，退出
		req.getSession().invalidate();
		MessageDTO dto = new MessageDTO();
		dto.setCode(200);
		dto.setCount(0);
		dto.setMsg("注销成功");
		logger.info("用户注销");
		Gson gson = new Gson();
		String json = gson.toJson(dto);
		resp.getWriter().write(json);
	}
	
	
	
}
