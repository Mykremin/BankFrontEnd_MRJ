/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dk.cphbusiness.bank.frontController;

import dk.cphbusiness.bank.contract.BankManager;
import dk.cphbusiness.bank.contract.dto.AccountDetail;
import dk.cphbusiness.bank.contract.dto.AccountSummary;
import dk.cphbusiness.bank.contract.dto.CheckingAccountDetail;
import dk.cphbusiness.bank.contract.dto.CustomerIdentifier;
import dk.cphbusiness.bank.contract.eto.CustomerBannedException;
import dk.cphbusiness.bank.contract.eto.NoSuchCustomerException;
import dk.cphbusiness.bank.security.SecurityRole;
import dk.cphbusiness.bank.view.Factory;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Mykremin
 */
public class SaveAccountCommand extends TargetCommand {

    public SaveAccountCommand(String target, List<SecurityRole> roles) {
        super(target, roles);
    }

    @Override
    public String execute(HttpServletRequest request) {
        String cpr = request.getParameter("cpr");
        BigDecimal interest = new BigDecimal(request.getParameter("interest"));
        
        CustomerIdentifier customer = new CustomerIdentifier(cpr);
        AccountDetail detail = new CheckingAccountDetail(null, interest, null);

        BankManager manager = Factory.getInstance().getManager();
        
        try {
            manager.createAccount(customer, detail);
        } catch (NoSuchCustomerException ex) {
            Logger.getLogger(SaveAccountCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CustomerBannedException ex) {
            Logger.getLogger(SaveAccountCommand.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.setAttribute("customer", customer);
        request.setAttribute("interest", interest);
        
        return super.execute(request); 
    }
    
    
    
}
