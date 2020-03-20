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

import cn.edu.cuit.icloud.constant.Result;
import cn.edu.cuit.icloud.dto.MessageDTO;
import cn.edu.cuit.icloud.pojo.User;
import cn.edu.cuit.icloud.service.AccountService;
import cn.edu.cuit.icloud.service.impl.AccountServiceImpl;
import cn.edu.cuit.icloud.vo.AccountVO;

/**
 * TODO
 * @date: 2020年3月17日
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
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");
		String userId = req.getParameter("userId");
		String status = req.getParameter("status");
		
		boolean success = account.updateAccountIsEnableById(Integer.valueOf(userId), Integer.valueOf(status));
		MessageDTO dto = new MessageDTO();
		if(success){
			dto.setCode(Result.SUCCESS.getCode());
			dto.setMsg("操作成功");
			dto.setCount(1);
		}else{
			dto.setCode(Result.FAILURE.getCode());
			dto.setMsg("操作失败");
			dto.setCount(0);
		}
		Gson gson = new Gson();
		String json = gson.toJson(dto);
		resp.getWriter().write(json);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");
		MessageDTO dto = new MessageDTO();
		String action = req.getParameter("action");
		if("list".equals(action)){//动态渲染表格
			List<AccountVO> allAccount = account.getAllAccount();
			if(!allAccount.isEmpty() || 0 != allAccount.size()){
				Gson gson = new Gson();
				String json = gson.toJson(allAccount);
				dto.setCode(Result.SUCCESS.getCode());
				dto.setCount(allAccount.size());
				dto.setMsg(Result.SUCCESS.getMsg());
				dto.setData(json);
				logger.info("账户管理：获取所有账户成功");
			}else{
				dto.setCode(Result.FAILURE.getCode());
				dto.setCount(0);
				dto.setMsg(Result.FAILURE.getMsg());
				dto.setData(null);
				logger.info("账户管理：获取所有账户失败");
			}
		}else if("add".equals(action)){//添加用户
			String username = req.getParameter("username").trim();
			String password = req.getParameter("password").trim();
			int role = Integer.valueOf(req.getParameter("role"));
			int status = Integer.valueOf(req.getParameter("enable"));
			User user = new User.Builder().setUsername(username)
										.setPassword(password)
										.setRole(role)
										.setEnable(status)
										.builder();
			boolean regSuccess = account.registerUser(user);
			if(regSuccess){
				dto.setCode(Result.SUCCESS.getCode());
				dto.setMsg("添加成功");
				dto.setCount(1);
				logger.info("账户管理：添加账户成功");
			}else{
				dto.setCode(Result.FAILURE.getCode());
				dto.setMsg("添加失败");
				dto.setCount(0);
				logger.info("账户管理：添加账户失败");
			}
		}else if("del".equals(action)){//删除时
			String ids = req.getParameter("ids");
			String[] idArr = ids.split(",");
			boolean success = account.batchDelUser(ids);
			if(success){
				dto.setCode(Result.SUCCESS.getCode());
				dto.setMsg("删除成功");
				dto.setCount(idArr.length);
				logger.info("账户管理：删除成功");
			}else{
				dto.setCode(Result.FAILURE.getCode());
				dto.setMsg("删除失败");
				dto.setCount(0);
				logger.info("账户管理：删除失败");
			}
		}else if("edit".equals(action)){//编辑时
			int userId = Integer.valueOf(req.getParameter("userId"));
			String username = req.getParameter("username").trim();
			String password = req.getParameter("password").trim();
			int role = Integer.valueOf(req.getParameter("role"));
			int status = Integer.valueOf(req.getParameter("enable"));
			User user = new User.Builder().setUserId(userId)
										.setUsername(username)
										.setPassword(password)
										.setRole(role)
										.setEnable(status)
										.builder();
			boolean editSuccess = account.updateAccount(user);
			if(editSuccess){
				dto.setCode(Result.SUCCESS.getCode());
				dto.setMsg("修改成功");
				dto.setCount(1);
				logger.info("账户管理：修改账户成功");
			}else{
				dto.setCode(Result.FAILURE.getCode());
				dto.setMsg("修改失败");
				dto.setCount(0);
				logger.info("账户管理：修改账户失败");
			}
		}
		resp.getWriter().write(dto.toString());
	}
	
}
