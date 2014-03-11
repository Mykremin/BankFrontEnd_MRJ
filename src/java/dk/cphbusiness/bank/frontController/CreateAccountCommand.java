/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dk.cphbusiness.bank.frontController;

import dk.cphbusiness.bank.contract.BankManager;
import dk.cphbusiness.bank.contract.dto.AccountDetail;
import dk.cphbusiness.bank.contract.dto.CustomerIdentifier;
import dk.cphbusiness.bank.contract.eto.CustomerBannedException;
import dk.cphbusiness.bank.contract.eto.NoSuchCustomerException;
import dk.cphbusiness.bank.security.SecurityRole;
import dk.cphbusiness.bank.view.Factory;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Mykremin
 */
public class CreateAccountCommand extends TargetCommand {

    public CreateAccountCommand(String target, List<SecurityRole> roles) {
        super(target, roles);
    }

    @Override
    public String execute(HttpServletRequest request) {
        
        BankManager manager = Factory.getInstance().getManager();
        
       String cpr = request.getParameter("cpr");       
       CustomerIdentifier customer = CustomerIdentifier.fromString(cpr);
        try {
            AccountDetail newAccount = manager.createAccount(customer, null);
        } catch (NoSuchCustomerException ex) {
            Logger.getLogger(CreateAccountCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CustomerBannedException ex) {
            Logger.getLogger(CreateAccountCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return super.execute(request);   
    
}
}
