package cn.edu.cuit.icloud.action;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.log4j.Logger;

import cn.edu.cuit.icloud.action.admin.IsoServlet;
import cn.edu.cuit.icloud.constant.OStypeEnum;
import cn.edu.cuit.icloud.constant.Result;
import cn.edu.cuit.icloud.dto.MessageDTO;
import cn.edu.cuit.icloud.exception.BaseException;
import cn.edu.cuit.icloud.service.UploadService;
import cn.edu.cuit.icloud.service.impl.UploadServiceImpl;
import cn.edu.cuit.icloud.vo.IsoVO;
import cn.edu.cuit.icloud.vo.SoftVO;
import cn.edu.cuit.icloud.vo.UserVO;

/**
 * TODO
 * @author: Think
 * @since: 2020年5月10日
 */
//@MultipartConfig(fileSizeThreshold=3*1024*1024,maxFileSize=5*1024*1024*1024,location="D:\\upload")
@MultipartConfig
@WebServlet("/upload")
public class UploadServlet extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;
	
	static Logger logger = Logger.getLogger(UploadServlet.class);
	
	private static Properties props = null;
	static{
		props = new Properties();
		try {
			props.load(IsoServlet.class.getResourceAsStream("/config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private UploadService uploadService = null;
	
	public UploadServlet() {
		uploadService = new UploadServiceImpl();
	}
	  
	  @Override
	  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	  throws ServletException, IOException { 
		  processRequest(request, response); 
	  } 
	  
	  @Override
	  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	  throws ServletException, IOException { 
		  processRequest(request, response); 
	  } 
	  
	  /**
	   * 处理请求 
	   * @param request
	   * @param response
	   * @throws ServletException
	   * @throws IOException
	   */
	  protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
			  	throws ServletException, IOException { 
		  request.setCharacterEncoding("utf-8");
		  response.setCharacterEncoding("utf-8");
		  response.setContentType("application/json;charset=utf-8");
		  MessageDTO dto = new MessageDTO();
		  Part part = request.getPart("file"); 
		  String fileName = getFileName(part); 
		  String uploadFilePath = props.getOrDefault("upload_path", "c:/upload/") + fileName;
		  String src = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/upload/"+fileName;
		  long size = part.getSize() / (1024*1024);//MB
		  File file = new File(uploadFilePath);
		  //上传
		  logger.info("正在上传...");
		  long start = System.currentTimeMillis();
		  if(!file.exists()) {
			  writeTo(uploadFilePath, part);
		  }
		  long end = System.currentTimeMillis();
		  logger.info("上传完成！用时："+(end-start)/1000+"s.");
		  
		  dto.setCode(Result.SUCCESS.getCode());
          dto.setCount(1);
          dto.setMsg("上传成功！");
          dto.setData("{\"src\":\""+ src +"\"}");
		  //入库
		  try {
			  insertDB(request,fileName,size,src);
		  }catch(Exception e) {
			  logger.error(e.getMessage());
			  dto.setCode(Result.SERVER_INTERNAL.getCode());
	          dto.setCount(1);
	          dto.setMsg("文件上传成功，"+e.getMessage());
		  }
		  response.getWriter().write(dto.toString());
	  } 
	  
	  //取得文件名
	  private String getFileName(Part part) { 
		  String header = part.getHeader("Content-Disposition"); 
		  String fileName = header.substring(header.indexOf("filename=\"")+10, header.lastIndexOf("\"")); 
		  
		  return fileName; 
	  } 
	  
	  //存储文件 
	  private void writeTo(String uploadFilePath, Part part) throws IOException, FileNotFoundException { 
		  InputStream in = part.getInputStream(); 
		  OutputStream out = new FileOutputStream(uploadFilePath); 
		  final int length = 10 * 1024 * 1024;
		  //每次读取10MB
		  byte[] buffer = new byte[length]; 
		  int readed = -1; 
		  while ((readed = in.read(buffer)) != -1) { 
			  out.write(buffer, 0, readed); 
		  } 
		  in.close(); 
		  out.close();
		  
	  }
	  
	  //入库处理
	  private void insertDB(HttpServletRequest request,String filename, long size, String src) {
		  UserVO vo = (UserVO)request.getSession().getAttribute("vo");
		  String date = DateFormatUtils.format(new Date(), "yyyy-MM-dd");
		  if(filename.endsWith(".iso")) {
			  IsoVO isoVO = new IsoVO();
	          isoVO.setCreateDate(date);
	          isoVO.setCreator(vo.getUser().getUsername());
	          isoVO.setIsoName(filename);
	          isoVO.setOsSize(size);
	          isoVO.setSrc(src);
	          String osType = filename.toLowerCase();
	          //判断os类型
	          isoVO.setOsType(OStypeEnum.getOsType(osType));
	          boolean success = uploadService.insertIsoInfo(isoVO);
	          if(!success) {
	          	throw new BaseException("文件入库失败！");
	          }
		  }else {
			  SoftVO soft = new SoftVO();
			  soft.setUploader(vo.getUser().getUsername());
			  soft.setSoftName(filename);
			  soft.setUploadDate(date);
			  soft.setResource(src);
			  soft.setSize(size);
			  boolean success = uploadService.insertSoftInfo(soft);
			  if(!success) {
				  throw new BaseException("文件入库失败！");
			  }
		  }
          
	  }

	
	
	
	/*private static final long serialVersionUID = 1L;
	
	static Logger logger = Logger.getLogger(UploadServlet.class);
	
	private UploadService uploadService = null;
    
    // 上传文件存储目录
    private static final String UPLOAD_DIRECTORY = "upload";
 
    // 上传配置
    private static final int MEMORY_THRESHOLD   = 1024 * 1024  * 1024 * 1;  // 3MB
    private static final long MAX_FILE_SIZE      = 1024 * 1024 * 1024 * 1024 * 4; // 4GB
    private static final long MAX_REQUEST_SIZE   = 1024 * 1024 * 1024 * 1024 * 5; // 5GB
    
    
    public UploadServlet() {
    	uploadService = new UploadServiceImpl();
    }
 
    *//**
     * 上传数据及保存文件
     *//*
    @Override
    protected void doPost(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
    	response.setCharacterEncoding("utf-8");
    	response.setContentType("application/json;charset=utf-8");
    	MessageDTO dto = new MessageDTO();
        // 检测是否为多媒体上传
        if (!ServletFileUpload.isMultipartContent(request)) {
            // 如果不是则停止
            dto.setCode(Result.FAILURE.getCode());
            dto.setCount(0);
            dto.setMsg("Error: 表单必须包含 enctype=multipart/form-data");
            dto.setData("{\"src\":\"\"}");
            response.getWriter().write(dto.toString());
            return;
        }
 
        // 配置上传参数
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 设置内存临界值 - 超过后将产生临时文件并存储于临时目录中
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // 设置临时存储目录
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
 
        ServletFileUpload upload = new ServletFileUpload(factory);
         
        // 设置最大文件上传值
        upload.setFileSizeMax(MAX_FILE_SIZE);
         
        // 设置最大请求值 (包含文件和表单数据)
        upload.setSizeMax(MAX_REQUEST_SIZE);

        // 中文处理
        upload.setHeaderEncoding("UTF-8"); 

        // 构造临时路径来存储上传的文件
        // 这个路径相对当前应用的目录
        String uploadPath = "D:" + File.separator + UPLOAD_DIRECTORY;
       
         
        // 如果目录不存在则创建
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
 
        try {
            // 解析请求的内容提取文件数据
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(request);
            logger.info("解析请求...");
            List<String> files = new ArrayList<String>();
            if (formItems != null && formItems.size() > 0) {
                // 迭代表单数据
                for (FileItem item : formItems) {
                    // 处理不在表单中的字段
                    if (!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();
                        logger.info("文件名->>>>"+fileName);
                        files.add(fileName);
                        String filePath = uploadPath + File.separator + fileName;
                        File storeFile = new File(filePath);
                        // 在控制台输出文件的上传路径
                        logger.info(filePath);
                        // 保存文件到硬盘
                        item.write(storeFile);
                        
                    }
                }
                //入库处理
                IsoVO isoVO = new IsoVO();
                isoVO.setCreateDate(DateFormatUtils.format(new Date(), "yyyy-MM-dd"));
                UserVO vo = (UserVO)request.getSession().getAttribute("vo");
                isoVO.setCreator(vo.getUser().getUsername());
                isoVO.setIsoName(files.get(0));
                String osType = files.get(0).toLowerCase();
                //判断os类型
                isoVO.setOsType(OStypeEnum.getOsType(osType));
                boolean success = uploadService.insertIsoInfo(isoVO);
                if(!success) {
                	throw new BaseException("文件入库失败！");
                }
                dto.setCode(Result.SUCCESS.getCode());
                dto.setCount(formItems.size());
                dto.setMsg("上传文件成功！");
                String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/"+UPLOAD_DIRECTORY+"/";
                dto.setData("{\"src\":\""+ basePath+ files.get(0) +"\"}");
            }
        } catch (Exception ex) {
        	ex.printStackTrace();
        	logger.error("错误信息："+ex.getMessage());
        	dto.setCode(Result.SERVER_INTERNAL.getCode());
            dto.setCount(0);
            dto.setMsg("错误信息: " + ex.getMessage());
            dto.setData("{\"src\":\"\"}");
        }
        response.getWriter().write(dto.toString());
    }*/
	
}
