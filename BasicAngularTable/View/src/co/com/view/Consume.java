package co.com.view;

import co.com.model.entities.PpeAppParametros;
import co.com.model.sessions.SessionEJBLocal;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.log4j.Logger;

public class Consume extends HttpServlet{
      //private static final String CONTENT_TYPE = "text/html; charset=windows-1252";
      private static final String CONTENT_TYPE_JSON = "application/json; charset=windows-1252";
      private static Logger logger = Logger.getLogger(Consume.class);
      
      @EJB
      private SessionEJBLocal SessionEJBLocal;

      public void init(ServletConfig config) throws ServletException{
            super.init(config);
      }

      public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
            response.setContentType(CONTENT_TYPE_JSON);
            PrintWriter out = response.getWriter();
            try{
                  List<PpeAppParametros> ppeAppParametrosList = new ArrayList<PpeAppParametros>();
                  ppeAppParametrosList = SessionEJBLocal.getPpeAppParametrosServicios();
                  PpeAppParametros ppeAppParametros = ppeAppParametrosList.get(0);
                  System.out.println("El nombre es:"+ppeAppParametros.getNombreparametro());
                  JSONArray jsonArray = new JSONArray();
                  jsonArray = JSONArray.fromObject(ppeAppParametrosList);
                  out.println(jsonArray.toString());
            }catch(Exception e){
                  String error = stacktraceError(e);
                  logger.error(error);
                  out.println(error);
            }
            out.close();
      }
      
      /**
       * PARA LA CAPTURA COMPLETA DE LA TRAZA DEL ERROR
       * @param e
       * @return
       */
      public String stacktraceError(Exception e){
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            return sw.toString();
      }
}
