package dk.cphbusiness.bank.frontController;

import dk.cphbusiness.bank.security.SecurityRole;
import java.util.List;


  // @author Lars Mortensen
  // This command is necessary because it give us a type to test against
  public class ShowLoginCommand  extends TargetCommand{

  public ShowLoginCommand(String target,List<SecurityRole> roles) {
    super(target,roles);
  }
}
