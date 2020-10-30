package cn.edu.cuit.icloud.action;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import cn.edu.cuit.icloud.constant.Result;
import cn.edu.cuit.icloud.context.LoginContext;
import cn.edu.cuit.icloud.dto.MessageDTO;
import cn.edu.cuit.icloud.dto.UserDTO;
import cn.edu.cuit.icloud.pojo.Menu;
import cn.edu.cuit.icloud.pojo.User;
import cn.edu.cuit.icloud.service.MenuService;
import cn.edu.cuit.icloud.service.impl.MenuServiceImpl;
import cn.edu.cuit.icloud.utils.MD5Util;
import cn.edu.cuit.icloud.vo.UserVO;

/**
 * 登录
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private Logger logger = Logger.getLogger(LoginServlet.class);
	
    private MenuService menuService = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
    	menuService = new MenuServiceImpl();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("登录页面");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8"); 
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		//获取用户名和密码，去两边的空格，获取用户角色
		String username = request.getParameter("username").trim();
		String password = request.getParameter("password").trim();
		String role = request.getParameter("role");
		User user = null;
		MessageDTO dto = null;
		if((null != username && !"".equals(username))
				&& (null != password && !"".equals(password))
				&& (null != role && !"".equals(role))){
						UserDTO userDTO = new UserDTO(username, MD5Util.encryMD5(password), Integer.valueOf(role));
						//执行登录上下文，根据角色获取用户信息
						LoginContext context = new LoginContext(userDTO);
						try {
							dto = context.login();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
		if(200 == dto.getCode()) {
			user = (User)dto.getData();
			UserVO userVO = new UserVO();
			userVO.setUser(user);
			List<Menu> menuList = menuService.findMenuByRole(user.getRole());
			boolean fold = menuService.IsMenuFold(user.getRole());
			logger.info("是否折叠菜单："+fold);
			userVO.setFold(fold);
			if(null != menuList){
				userVO.setMenuList(menuList);
			}
			request.getSession().setAttribute("vo", userVO);
			
			Cookie nameCookie = new Cookie("r",URLEncoder.encode(user.getRole()+"", "UTF-8"));
			// 为两个 Cookie 设置过期日期为 24 小时后
			nameCookie.setMaxAge(60*60*24); 
			nameCookie.setPath(request.getContextPath());
			// 添加 Cookie信息
	        response.addCookie(nameCookie);

			MessageDTO msgDTO = new MessageDTO();
			msgDTO.setCode(Result.SUCCESS.getCode());
			msgDTO.setMsg(Result.SUCCESS.getMsg());
			msgDTO.setData("");
			Gson gson = new Gson();
			String json = gson.toJson(msgDTO);
			response.getWriter().write(json);
			logger.info("登录成功");
			/*String contextPath = request.getContextPath();
			response.sendRedirect(contextPath+"/index");*/
		}else{
			Gson gson = new Gson();
			String json = gson.toJson(dto);
			response.getWriter().write(json);
			logger.error("登录失败："+dto.getMsg());
		}
		
		//request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
