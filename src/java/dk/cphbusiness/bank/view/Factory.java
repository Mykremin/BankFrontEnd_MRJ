package dk.cphbusiness.bank.view;

import dk.cphbusiness.bank.contract.BankManager;
import dk.cphbusiness.dummy.bank.control.DummyBankManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Factory {
  private static Factory instance = null;
  private BankManager manager;
  
  private Factory() { // det er her switchen sker mellem dummy backend og den rigtige backend. Udkommentere den ene, når man tester.
//    manager = new DummyBankManager();
    manager = lookupBankManagerBeanRemote();
    }
 
  public static Factory getInstance() {
    if (instance == null) instance = new Factory();
    return instance;
    }

  public BankManager getManager() {
    return manager;
    }

    private BankManager lookupBankManagerBeanRemote() {
        try {
            Context c = new InitialContext();
            return (BankManager) c.lookup("java:global/BankBackend_MRJ/BankManagerBean!dk.cphbusiness.bank.contract.BankManager");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
  
  }
