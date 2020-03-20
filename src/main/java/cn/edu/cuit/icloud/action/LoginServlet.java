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
import cn.edu.cuit.icloud.context.LoginContext;
import cn.edu.cuit.icloud.dto.MessageDTO;
import cn.edu.cuit.icloud.dto.UserDTO;
import cn.edu.cuit.icloud.pojo.Menu;
import cn.edu.cuit.icloud.pojo.User;
import cn.edu.cuit.icloud.service.MenuService;
import cn.edu.cuit.icloud.service.impl.MenuServiceImpl;
import cn.edu.cuit.icloud.vo.UserVO;

/**
 * µÇÂ¼
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
		logger.info("µÇÂ¼Ò³Ãæ");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8"); 
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*StringBuilder msg = new StringBuilder();*/
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
		String username = request.getParameter("username").trim();
		String password = request.getParameter("password").trim();
		String role = request.getParameter("role");
		User user = null;
		if((!"".equals(username) || null != username)
				&& (!"".equals(password) || null != password)
				&& (!"".equals(role) || null != role)){
						UserDTO userDTO = new UserDTO(username,password,Integer.valueOf(role));
						LoginContext context = new LoginContext(userDTO);
						try {
							user = context.login();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
		if(null != user.getUsername() || !"".equals(user.getUsername())){
			UserVO userVO = new UserVO();
			userVO.setUser(user);
			List<Menu> menuList = menuService.findMenuByRole(user.getRole());
			boolean fold = menuService.IsMenuFold(user.getRole());
			logger.info("ÊÇ·ñÕÛµþ²Ëµ¥£º"+fold);
			userVO.setFold(fold);
			if(null != menuList){
				userVO.setMenuList(menuList);
			}
			request.getSession().setAttribute("vo", userVO);
			MessageDTO msgDTO = new MessageDTO();
			msgDTO.setCode(Result.SUCCESS.getCode());
			msgDTO.setMsg(Result.SUCCESS.getMsg());
			msgDTO.setData("");
			Gson gson = new Gson();
			String json = gson.toJson(msgDTO);
			response.getWriter().write(json);
			logger.info("µÇÂ¼³É¹¦");
			/*String contextPath = request.getContextPath();
			response.sendRedirect(contextPath+"/index");*/
		}else{
			MessageDTO msgDTO = new MessageDTO();
			msgDTO.setCode(Result.FAILURE.getCode());
			msgDTO.setMsg(Result.FAILURE.getMsg());
			msgDTO.setData("");
			Gson gson = new Gson();
			String json = gson.toJson(msgDTO);
			response.getWriter().write(json);
			logger.error("µÇÂ¼Ê§°Ü");
		}
		
		//request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
