/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dk.cphbusiness.bank.frontController;

import dk.cphbusiness.bank.contract.BankManager;
import dk.cphbusiness.bank.contract.dto.CustomerDetail;
import dk.cphbusiness.bank.contract.dto.CustomerIdentifier;
import dk.cphbusiness.bank.contract.eto.NoSuchCustomerException;
import dk.cphbusiness.bank.security.SecurityRole;
import dk.cphbusiness.bank.view.Factory;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Mykremin
 */
public class ShowCustomerCommand extends TargetCommand {

    public ShowCustomerCommand(String target, List<SecurityRole> roles) {
        super(target, roles);
    }

    @Override
    public String execute(HttpServletRequest request) {
 BankManager manager = Factory.getInstance().getManager();

        HttpSession session = request.getSession();
        CustomerIdentifier customer = (CustomerIdentifier) session.getAttribute("customer"); 
        String cpr = request.getParameter("cpr");
        String title = request.getParameter("title");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String street = request.getParameter("street");
        String postalCode = request.getParameter("postalCode");
        String postalDistrict = request.getParameter("postalDistrict");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        
        if (cpr != null) {

            customer = CustomerIdentifier.fromString(cpr);
            session.setAttribute("customer", customer);
        }
            CustomerDetail showCustomer = null;
        try {
            showCustomer = manager.showCustomer(customer);
        } catch (NoSuchCustomerException ex) {
            Logger.getLogger(ShowCustomerCommand.class.getName()).log(Level.SEVERE, null, ex);
        }


        request.setAttribute("showCustomer", showCustomer);
        
        return super.execute(request); 
    }
    
    
    
}
