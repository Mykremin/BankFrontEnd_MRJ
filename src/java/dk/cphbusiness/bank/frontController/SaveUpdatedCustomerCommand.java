/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dk.cphbusiness.bank.frontController;

import dk.cphbusiness.bank.contract.BankManager;
import dk.cphbusiness.bank.contract.dto.CustomerDetail;
import dk.cphbusiness.bank.contract.dto.CustomerIdentifier;
import dk.cphbusiness.bank.contract.dto.CustomerSummary;
import dk.cphbusiness.bank.contract.eto.NoSuchCustomerException;
import dk.cphbusiness.bank.security.SecurityRole;
import dk.cphbusiness.bank.view.Factory;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Mykremin
 */
public class SaveUpdatedCustomerCommand extends TargetCommand {

    public SaveUpdatedCustomerCommand(String target, List<SecurityRole> roles) {
        super(target, roles);
    }

    @Override
    public String execute(HttpServletRequest request) {
        
        BankManager manager = Factory.getInstance().getManager();

  

        try {
            String cpr = request.getParameter("cpr");
            CustomerIdentifier customerid = CustomerIdentifier.fromString(cpr);
            CustomerDetail customer = manager.showCustomer(customerid);
            customer.setTitle(request.getParameter("title"));
            customer.setFirstName(request.getParameter("firstName"));
            customer.setLastName(request.getParameter("lastName"));
            customer.setStreet(request.getParameter("street"));
            customer.setPostalCode(request.getParameter("postalCode"));
            customer.setPostalDistrict(request.getParameter("postalDistrict"));
            customer.setPhone(request.getParameter("phone"));
            customer.setEmail(request.getParameter("email"));
            
            Collection<CustomerSummary> customers = manager.listCustomers();
            request.setAttribute("customers", customers);
            
        } catch (NoSuchCustomerException ex) {
            String title = request.getParameter("title");
            String cprid = request.getParameter("cpr");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String street = request.getParameter("street");
            String postalCode = request.getParameter("postalCode");
            String postalDistrict = request.getParameter("postalDistrict");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            
            CustomerDetail customer = new CustomerDetail(cprid, title, firstName, lastName, street, postalCode, postalDistrict, phone, email);
            manager.saveCustomer(customer);
            
            Collection<CustomerSummary> customers = manager.listCustomers();
            request.setAttribute("customers", customers);
        }
        
        return super.execute(request); 
    }
    
    
    
}
