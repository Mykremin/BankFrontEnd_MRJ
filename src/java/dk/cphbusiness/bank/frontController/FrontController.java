package dk.cphbusiness.bank.frontController;

import dk.cphbusiness.bank.security.SecurityRole;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FrontController", urlPatterns = {"/Controller"})
public class FrontController extends HttpServlet {
    private static FrontController instance = new FrontController();
  private final Map<String, Command> commands = new HashMap<>();

  public FrontController() {
    commands.put("main", new TargetCommand("loginStart.jsp", Arrays.asList(SecurityRole.All)));
    commands.put("showlogin", new ShowLoginCommand("login.jsp", Arrays.asList(SecurityRole.All)));  
    Map<SecurityRole, String> roles = new HashMap();
        roles.put(SecurityRole.Employee, "main.jsp");
        roles.put(SecurityRole.SuperEmployee, "main.jsp");
        roles.put(SecurityRole.Customer, "main.jsp");
    commands.put("login", new LoginCommand(roles, "login.jsp"));
    commands.put("logout", new LogoutCommand("loginStart.jsp", Arrays.asList(SecurityRole.All)));
          
    commands.put("list-customer-accounts", new ListAccountsCommand("account-list.jsp", Arrays.asList(SecurityRole.Employee, SecurityRole.SuperEmployee)));
    commands.put("list-customers", new ListCustomersCommand("customer-list.jsp", Arrays.asList(SecurityRole.Employee, SecurityRole.SuperEmployee)));
    commands.put("show-account-detail", new ShowAccountDetailCommand("account-detail.jsp", Arrays.asList(SecurityRole.Employee, SecurityRole.SuperEmployee)));
    commands.put("prepare-transfer", new TransferEditCommand("transfer-edit.jsp", Arrays.asList(SecurityRole.Employee, SecurityRole.SuperEmployee)));
    commands.put("save-transfer", new TransferSaveCommand("account-list.jsp", Arrays.asList(SecurityRole.Employee, SecurityRole.SuperEmployee)));
    commands.put("account-edit", new CreateAccountCommand("account-edit.jsp", Arrays.asList(SecurityRole.Employee, SecurityRole.SuperEmployee)));
    commands.put("save-account", new SaveAccountCommand("account-edit.jsp", Arrays.asList(SecurityRole.Employee, SecurityRole.SuperEmployee)));
    
    commands.put("customer-edit", new CreateCustomerCommand("customer-edit.jsp", Arrays.asList(SecurityRole.SuperEmployee)));
    commands.put("save-customer", new SaveCustomerCommand("customer-edit.jsp", Arrays.asList(SecurityRole.SuperEmployee)));
    commands.put("customer-update", new ShowCustomerCommand("customer-edit.jsp", Arrays.asList(SecurityRole.SuperEmployee)));
    commands.put("save-updated-customer", new SaveUpdatedCustomerCommand("customer-list.jsp", Arrays.asList(SecurityRole.SuperEmployee)));
    
 
    commands.put("back", new TargetCommand("main.jsp", Arrays.asList(SecurityRole.All)));
    commands.put("main", new TargetCommand("main.jsp", Arrays.asList(SecurityRole.All)));
    }
  
  @Override
  protected void service(
      HttpServletRequest request,
      HttpServletResponse response
      ) throws ServletException, IOException {
    String key = request.getParameter("command");
    if (key == null) key = "main";
    Command command = commands.get(key);
    String target = command.execute(request);
    RequestDispatcher dispatcher = request.getRequestDispatcher(target);
    dispatcher.forward(request, response);
    }

    public Command getCommand(String cmdStr, HttpServletRequest request) {
        if (cmdStr == null) {
            cmdStr = "main";
        }
        Command cmd = commands.get(cmdStr);
        SecurityCheck(cmd, request);
        return cmd;
    }

    private void SecurityCheck(Command command, HttpServletRequest request) throws SecurityException {
        if (command instanceof TargetCommand) {
            List<SecurityRole> requiredRoles = ((TargetCommand) command).getRoles();
            boolean requiredRoleFound = false;
            for (SecurityRole requiredRole : requiredRoles) {
                if (requiredRole == SecurityRole.All || request.isUserInRole(requiredRole.toString())) {
                    requiredRoleFound = true;
                    break;
                }
            }
            if (!requiredRoleFound) {
                throw new SecurityException("You don't have the necessary rights to perform this command");
            }
        }
    }
    
    public static FrontController getInstance() {
        return instance;
    }

}
