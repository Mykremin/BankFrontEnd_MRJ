/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dk.cphbusiness.bank.frontController;

import dk.cphbusiness.bank.contract.BankManager;
import dk.cphbusiness.bank.contract.dto.CustomerDetail;
import dk.cphbusiness.bank.security.SecurityRole;
import dk.cphbusiness.bank.view.Factory;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Mykremin
 */
public class SaveCustomerCommand extends TargetCommand  {

    public SaveCustomerCommand(String target, List<SecurityRole> roles) {
        super(target, roles);
    }

    @Override
    public String execute(HttpServletRequest request) {
        BankManager manager = Factory.getInstance().getManager();
        
        String cpr = request.getParameter("cpr");
        String title = request.getParameter("title");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String street = request.getParameter("street");
        String postalCode = request.getParameter("postalCode");
        String postalDistrict = request.getParameter("postalDistrict");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        
        CustomerDetail customer = new CustomerDetail(cpr, title, firstName, lastName, street, postalCode, postalDistrict, phone, email);        
        CustomerDetail newCustomer = manager.saveCustomer(customer);
        
        return super.execute(request); 
    }
    
    
    
}