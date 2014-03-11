/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dk.cphbusiness.bank.frontController;

import dk.cphbusiness.bank.contract.dto.CustomerDetail;
import dk.cphbusiness.bank.security.SecurityRole;
import java.util.List;
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
  
        String cpr = request.getParameter("cpr");
        String title = request.getParameter("title");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String street = request.getParameter("street");
        String postalCode = request.getParameter("postalCode");
        String postalDistrict = request.getParameter("postalDistrict");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        
        
        
        request.setAttribute("cpr", cpr);
        request.setAttribute("title", title);
        request.setAttribute("firstName", firstName);
        request.setAttribute("lastName", lastName);
        request.setAttribute("street", street);
        request.setAttribute("postalCode", postalCode);
        request.setAttribute("postalDistrict", postalDistrict);
        request.setAttribute("phone", phone);
        request.setAttribute("email", email);
        
        return super.execute(request); 
    }
    
    
    
}
