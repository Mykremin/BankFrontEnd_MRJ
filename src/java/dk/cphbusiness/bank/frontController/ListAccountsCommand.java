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
import javax.servlet.http.HttpSession;

public class ListAccountsCommand extends TargetCommand {

    public ListAccountsCommand(String target, List<SecurityRole> roles) {
        super(target, roles);
    }

    @Override
    public String execute(HttpServletRequest request) {
        BankManager manager = Factory.getInstance().getManager();

        HttpSession session = request.getSession();
        CustomerIdentifier customer = (CustomerIdentifier) session.getAttribute("customer"); // har skrevet det her, fordi hvis jeg vælger at cancelle en transfer fra transferedit.jsp så skal jeg vende tilbage til kundens kontiliste med den samme cpr, og det får jeg ved hjælp af session
        String cpr = request.getParameter("cpr");
        if (cpr != null) {

            customer = CustomerIdentifier.fromString(cpr);
            session.setAttribute("customer", customer);
        }
        Collection<AccountSummary> accounts = manager.listCustomerAccounts(customer);

        request.setAttribute("accounts", accounts);

        return super.execute(request);
    }

}
