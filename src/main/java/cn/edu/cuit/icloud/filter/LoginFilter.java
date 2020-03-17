package cn.edu.cuit.icloud.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * µÇÂ¼À¹½ØÆ÷
 */
/*@WebFilter(value={"/*"},initParams={@WebInitParam(name="ignoreTypes",value="png,jpg,js,css,gif,bmp,flash")})*/
public class LoginFilter implements Filter {

	private String[] ignoreTypes;
	
    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		// place your code here
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		Object user = request.getSession().getAttribute("u");
		String requestUri = request.getRequestURI();
        String contextPath = request.getContextPath();
        String url = requestUri.substring(contextPath.length());
        
		boolean isIgnoreType = false;
        if(null != ignoreTypes){
            for (int i = 0; i < ignoreTypes.length; i++) {
                if (url.endsWith("." + ignoreTypes[i])) {
	                isIgnoreType = true;
	                break;
                }
            }
        }else{
            chain.doFilter(request, response);
        }
        
        if(url.indexOf("/login") > -1 || isIgnoreType==true){
            chain.doFilter(request, response);
        }else{
        	if(null == user){
    			request.setAttribute("msg", "Î´µÇÂ¼£¬ÇëÖØÐÂµÇÂ¼£¡");
    			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
    		}else{
                chain.doFilter(request, response);
            }
        }
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig config) throws ServletException {
		String ignoreTypes = config.getInitParameter("ignoreTypes");
		this.ignoreTypes = ignoreTypes.split(",");
	}

}
