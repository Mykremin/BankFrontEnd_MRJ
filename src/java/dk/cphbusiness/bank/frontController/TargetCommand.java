package dk.cphbusiness.bank.frontController;

import dk.cphbusiness.bank.frontController.Command;
import dk.cphbusiness.bank.security.SecurityRole;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public class TargetCommand implements Command {
  private final String target;
  private final List<SecurityRole> roles;

    public List<SecurityRole> getRoles() {
        return roles;
    }

    public TargetCommand(String target, List<SecurityRole> roles) {
        this.roles = roles;
        this.target = target;
    }
  
  @Override
  public String execute(HttpServletRequest request) {
    return target;
    }
  
  }
