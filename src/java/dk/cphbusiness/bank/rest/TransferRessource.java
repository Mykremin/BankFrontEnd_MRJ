/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dk.cphbusiness.bank.rest;

import dk.cphbusiness.bank.contract.BankManager;
import dk.cphbusiness.bank.contract.dto.TransferRequest;
import dk.cphbusiness.bank.contract.dto.TransferResponse;
import dk.cphbusiness.bank.contract.eto.InsufficientFundsException;
import dk.cphbusiness.bank.contract.eto.NoSuchAccountException;
import dk.cphbusiness.bank.contract.eto.TransferNotAcceptedException;
import dk.cphbusiness.bank.view.Factory;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;

/**
 * REST Web Service
 *
 * @author Mykremin
 */
@Path("transfer")
public class TransferRessource {
    
    BankManager manager;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of TransferRessource
     */
    public TransferRessource() {
        
        manager = Factory.getInstance().getManager();
        
    }

    /**
     * Retrieves representation of an instance of dk.cphbusiness.bank.rest.TransferRessource
     * @return an instance of dk.cphbusiness.bank.contract.dto.TransferRequest
     */
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public TransferResponse create(TransferRequest transfer) throws NoSuchAccountException, TransferNotAcceptedException, InsufficientFundsException {
        manager.transferAmount(transfer.getAmount(), transfer.getSource(), transfer.getTarget());
        return new TransferResponse(true, "Transfer completed!");
        //throw new UnsupportedOperationException("Please implement");
        
    }

}
