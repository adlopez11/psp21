package edu.uniandes.ecos.ui;

import edu.uniandes.ecos.control.SimpsonInverseControl;
import edu.uniandes.ecos.exception.GammaException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.*;

public class MainWeb extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
      process(0.2d,6d,resp);
      process(0.45d, 15,resp);
      process(0.495d, 4,resp);
  }
  
  private void process(double p, double dof, HttpServletResponse resp) throws IOException{

      resp.getWriter().print("Calculo de X cuando la Integral de la Distribucion T es P\n\n");
        
        try {
            
            resp.getWriter().print("\nValores p=" + p + " dof="+dof+"\n\n");
            
            SimpsonInverseControl control = new SimpsonInverseControl(p, dof);
            control.operar();
            
            double x = control.getX();

            resp.getWriter().print("Valor X: " + x+"\n\n");


        } catch (GammaException ex) {
            resp.getWriter().print(ex.getMessage()+"\n");
        } 
        resp.getWriter().print("\nFin de la aplicacion\n");
  }

  public static void main(String[] args) throws Exception {
    Server server = new Server(Integer.valueOf(System.getenv("PORT")));
    ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
    context.setContextPath("/");
    server.setHandler(context);
    context.addServlet(new ServletHolder(new MainWeb()),"/*");
    server.start();
    server.join();
  }
}
