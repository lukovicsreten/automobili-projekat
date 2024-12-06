/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.marka;

import db.DBBroker;
import domain.AbstractDomainObject;

import domain.Marka;

import so.AbstractSO;

/**
 *
 * @author Sreten
 */
public class SOUpdateMarka extends AbstractSO{

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
       if (!(ado instanceof Marka)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Administrator!");
        }

        Marka a = (Marka) ado;

       

    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
         DBBroker.getInstance().update(ado);
    }
    
}
