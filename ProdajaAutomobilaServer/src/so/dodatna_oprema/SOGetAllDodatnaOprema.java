/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.dodatna_oprema;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.DodatnaOprema;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Sreten
 */
public class SOGetAllDodatnaOprema extends AbstractSO {

    private ArrayList<DodatnaOprema> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof DodatnaOprema)) {
            throw new Exception("Prosledjeni objekat nije instanca klase DodatnaOprema!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> listaDodatneOpreme = DBBroker.getInstance().select(ado);
        lista = (ArrayList<DodatnaOprema>) (ArrayList<?>) listaDodatneOpreme;
    }

    public ArrayList<DodatnaOprema> getLista() {
        return lista;
    }

}
