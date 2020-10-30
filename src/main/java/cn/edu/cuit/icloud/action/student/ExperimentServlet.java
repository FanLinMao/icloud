package cn.edu.cuit.icloud.action.student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.log4j.Logger;

import com.google.gson.Gson;

import cn.edu.cuit.icloud.call.template.create.ResponseTags;
import cn.edu.cuit.icloud.constant.Cmd;
import cn.edu.cuit.icloud.constant.Result;
import cn.edu.cuit.icloud.dto.MessageDTO;
import cn.edu.cuit.icloud.exception.BaseException;
import cn.edu.cuit.icloud.service.CallService;
import cn.edu.cuit.icloud.service.impl.AdminServiceImpl;
import cn.edu.cuit.icloud.service.impl.CallServiceImpl;
import cn.edu.cuit.icloud.vo.TemplateVO;
import cn.edu.cuit.icloud.vo.UserVO;

/**
 * TODO
 * @author: Think
 * @since: 2020年5月9日
 */
@WebServlet("/exp")
public class ExperimentServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	static Logger logger = Logger.getLogger(ExperimentServlet.class);
	
	private CallService callService = null;
	
	private AdminServiceImpl adminService = null;
	
	public ExperimentServlet() {
		adminService = new AdminServiceImpl();
		callService = new CallServiceImpl();
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");
		String parameter = req.getParameter("action");
		MessageDTO dto = new MessageDTO();
		Gson gson = new Gson();
		if("listurl".equals(parameter)) {
			List<String> isoUrls = adminService.getIsoUrls();
			dto.setCode(Result.SUCCESS.getCode());
			dto.setMsg(Result.SUCCESS.getMsg());
			dto.setData(gson.toJson(isoUrls));
			dto.setCount(isoUrls.size());
			logger.info("获取url："+isoUrls.size()+"条");
		}
		
		resp.getWriter().write(dto.toString());
	}
	
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");
		String command = req.getParameter("action");//command
		String parameters = req.getParameter("parameters");
		MessageDTO dto = new MessageDTO();
		Gson gson = new Gson();
		if(Cmd.LIST_TEMPLATES.equals(command)) {
			dto.setCode(Result.SUCCESS.getCode());
			dto.setMsg(Result.SUCCESS.getMsg());
			dto.setCount(0);
			TemplateVO tpl = new TemplateVO();
			ArrayList<Object> list = new ArrayList<Object>();
			list.add(tpl);
			dto.setData(gson.toJson(list));
		}else if(Cmd.CREATE_TEMPLATE.equals(command)) {
			try {
				Object result = callService.callCommand(command, parameters);
				if(null != result) {
					TemplateVO tpl = new TemplateVO();
					ResponseTags params = (ResponseTags)result;
					tpl.setTemplateId(params.getId());
					tpl.setCreateDate(DateFormatUtils.format(new Date(), "yyyy-MM-ddTHH:mm:ss"));
					tpl.setTemplateName(params.getName());
					tpl.setOsType(params.getOstypename());
					UserVO vo = (UserVO)req.getSession().getAttribute("vo");
					tpl.setCreator(vo.getUser().getUsername());
					//入库处理
					String sql = "insert into templates values(?,?,?,?,?)";
					boolean success = callService.insertDB(sql, new Object[] {tpl.getTemplateId(),tpl.getTemplateName(),tpl.getOsType(),tpl.getCreator(),tpl.getCreateDate()});
					if(!success) {
						throw new BaseException("入库失败！");
					}
					//前端的消息
					dto.setCode(Result.SUCCESS.getCode());
					dto.setMsg(Result.SUCCESS.getMsg());
					dto.setCount(0);
				}else {
					dto.setCode(Result.SERVER_INTERNAL.getCode());
					dto.setMsg(Result.SERVER_INTERNAL.getMsg());
					dto.setCount(0);
				}
				
			} catch (Exception e) {
				logger.error("注册模板失败："+e.getMessage());
				dto.setCode(Result.SERVER_INTERNAL.getCode());
				dto.setMsg(Result.SERVER_INTERNAL.getMsg());
				dto.setCount(0);
			}
			
		}else if(Cmd.DELETE_TEMPLATE.equals(command)) {
			//注销模板
		}
		
		
		/*String command = req.getParameter("action");//command
		String parameters = req.getParameter("parameters");
		try {
			
			TemplateVO tpl = new TemplateVO();
			MessageDTO dto = new MessageDTO();
			Object obj = callService.callCommand(command, parameters);
			if(null != obj) {
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		resp.getWriter().write(dto.toString());
	}
	
}
