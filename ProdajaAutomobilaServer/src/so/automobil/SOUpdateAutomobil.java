/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.automobil;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Automobil;
import domain.DodatnaOprema;
import so.AbstractSO;

/**
 *
 * @author Sreten
 */
public class SOUpdateAutomobil extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Automobil)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Automobil!");
        }

        Automobil automobil = (Automobil) ado;

        if (automobil.getCena() < 0 || automobil.getCena() > 5000000) {
            throw new Exception("Cena mora biti izmedju 0 i 5000000€!");
        }

        if (automobil.getKilometraza() < 0 || automobil.getKilometraza() > 5000000) {
            throw new Exception("Kilometraza mora biti izmedju 0 i 5000000km!");
        }

        if (automobil.getListaDodatneOpreme().isEmpty()) {
            throw new Exception("Automobil mora imati barem jednu stavku dodatne opreme!");
        }

    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        
        DBBroker.getInstance().update(ado);

        Automobil automobil = (Automobil) ado;
        
        DBBroker.getInstance().delete(automobil.getListaDodatneOpreme().get(0));
        

        
        for (DodatnaOprema dodatnaOprema : automobil.getListaDodatneOpreme()) {
            DBBroker.getInstance().insert(dodatnaOprema);
        }
        
        
        
        
    }

}
