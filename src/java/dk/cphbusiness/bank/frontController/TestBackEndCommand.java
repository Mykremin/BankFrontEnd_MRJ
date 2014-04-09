/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dk.cphbusiness.bank.frontController;

import dk.cphbusiness.bank.contract.BankManager;
import dk.cphbusiness.bank.security.SecurityRole;
import dk.cphbusiness.bank.view.Factory;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Mykremin
 */
public class TestBackEndCommand extends TargetCommand {

    public TestBackEndCommand(String target, List<SecurityRole> roles) {
        super(target, roles);
    }

    @Override
    public String execute(HttpServletRequest request) {
        BankManager manager = Factory.getInstance().getManager();
        //String greeting = manager.sayHello("Mykremin");
        //request.setAttribute("greeting", greeting);
        
       return super.execute(request); 
    }
    
}
