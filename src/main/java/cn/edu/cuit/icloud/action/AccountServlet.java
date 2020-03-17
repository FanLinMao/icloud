package cn.edu.cuit.icloud.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import cn.edu.cuit.icloud.service.AccountService;
import cn.edu.cuit.icloud.service.impl.AccountServiceImpl;
import cn.edu.cuit.icloud.vo.AccountVO;

/**
 * TODO
 * @date: 2020Äê3ÔÂ17ÈÕ
 * @author: flfan
 */
@WebServlet("/account")
public class AccountServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(AccountServlet.class);
	private AccountService account = null;
	
	public AccountServlet(){
		account = new AccountServiceImpl();
	}
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");
		List<AccountVO> allAccount = account.getAllAccount();
		Gson gson = new Gson();
		String json = gson.toJson(allAccount);
		resp.getWriter().write(json);
	}
	
}
