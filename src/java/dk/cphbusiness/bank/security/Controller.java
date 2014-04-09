/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.bank.security;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dk.cphbusiness.bank.frontController.Command;
import dk.cphbusiness.bank.frontController.FrontController;
import dk.cphbusiness.bank.frontController.LogoutCommand;
import dk.cphbusiness.bank.frontController.ShowLoginCommand;

@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {

  private int PORT_NON_SSL;
  private int PORT_SSL;
   
    public Controller()
    {
    }

   protected void processRequest(HttpServletRequest request, HttpServletResponse response) // alle request går igennem controlleren. for hvergang der kommer et request bruges denne metode.
          throws ServletException, IOException {
    String cmdStr = request.getParameter("command");
    cmdStr = cmdStr!=null ? cmdStr: "main";
    Command command = FrontController.getInstance().getCommand(cmdStr, request);
    String path = command.execute(request);

    
    if (command instanceof ShowLoginCommand && !request.isSecure()) {
      String SSL = "https://" + request.getServerName() + ":" + PORT_SSL + request.getRequestURI() + "?command=showlogin";
      System.out.println("SSL redirect: " + SSL);
      response.sendRedirect(SSL);
    } else if (command instanceof LogoutCommand) {
      String nonSSL = "http://" + request.getServerName() + ":" + PORT_NON_SSL + request.getRequestURI();
      System.out.println("Non SSL redirect: " + nonSSL);
      response.sendRedirect(nonSSL);
    } 
    else {
      request.getRequestDispatcher(path).forward(request, response);
    }
    

  }

  @Override
  public void init() throws ServletException {
    PORT_NON_SSL = Integer.parseInt(getServletContext().getInitParameter("portNonSSL"));
    PORT_SSL = Integer.parseInt(getServletContext().getInitParameter("portSSL"));
  }

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>
}
