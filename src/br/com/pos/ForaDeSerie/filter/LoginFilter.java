package br.com.pos.ForaDeSerie.filter;
 
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.pos.ForaDeSerie.controller.UsuarioController;


public class LoginFilter implements Filter {
 

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        UsuarioController loginController = (UsuarioController)((HttpServletRequest)request).getSession().getAttribute("usuarioController");
         
    
        if (loginController == null || !loginController.isLogado() ) {
            String contextPath = ((HttpServletRequest)request).getContextPath();
            ((HttpServletResponse)response).sendRedirect(contextPath + "/paginas/index.xhtml");
        }
         
        chain.doFilter(request, response);
             
    }
 
    public void init(FilterConfig config) throws ServletException {
        // Nothing to do here!
    }
 
    public void destroy() {
        // Nothing to do here!
    }  
     
}
