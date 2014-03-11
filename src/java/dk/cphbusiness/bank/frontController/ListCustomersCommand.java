/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dk.cphbusiness.bank.frontController;

import dk.cphbusiness.bank.contract.BankManager;
import dk.cphbusiness.bank.contract.dto.AccountSummary;
import dk.cphbusiness.bank.contract.dto.CustomerIdentifier;
import dk.cphbusiness.bank.contract.dto.CustomerSummary;
import dk.cphbusiness.bank.security.SecurityRole;
import dk.cphbusiness.bank.view.Factory;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author RidvanGurel
 */
public class ListCustomersCommand extends TargetCommand {

    public ListCustomersCommand(String target, List<SecurityRole> roles) {
        super(target, roles);
    }

    @Override
    public String execute(HttpServletRequest request) {
        
    BankManager manager = Factory.getInstance().getManager();
    Collection<CustomerSummary> customers = manager.listCustomers();

    request.setAttribute("customers", customers);
      
        return super.execute(request); 
    }
    
}
