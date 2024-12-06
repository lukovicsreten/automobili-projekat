/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.marka;

import db.DBBroker;
import domain.AbstractDomainObject;

import domain.Marka;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Sreten
 */
public class SOAddMarka extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Marka)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Marka!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().insert(ado);
    }

}
