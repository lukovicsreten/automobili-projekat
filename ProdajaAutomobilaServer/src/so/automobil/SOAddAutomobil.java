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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import so.AbstractSO;

/**
 *
 * @author Sreten
 */
public class SOAddAutomobil extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Automobil)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Automobil!");
        }

        Automobil automobil = (Automobil) ado;

        if (automobil.getGodinaProizvodnje() < 1950 || automobil.getGodinaProizvodnje() > 2024) {
            throw new Exception("Godina proizvodnje mora biti izmedju 1950 i 2024!");
        }

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
        
       
        PreparedStatement ps = DBBroker.getInstance().insert(ado);
        
        
        ResultSet tableKeys = ps.getGeneratedKeys();
        tableKeys.next();
        Long autoID = tableKeys.getLong(1);
        
        
        Automobil automobil = (Automobil) ado;
        automobil.setAutomobilID(autoID);
        
        
        for (DodatnaOprema dodatnaOprema : automobil.getListaDodatneOpreme()) {
            dodatnaOprema.setAutomobil(automobil); 
            DBBroker.getInstance().insert(dodatnaOprema);
        }
        
    }

}
