/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.tip_automobila;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.TipAutomobila;
import java.util.ArrayList;
//import so.AbstractSO;

/**
 *
 * @author Sreten
 */
public class SOGetAllTipAutomobila  {

    private ArrayList<TipAutomobila> lista;

    public void templateExecute(AbstractDomainObject ado) throws Exception {
        try {
            validate(ado);
            execute(ado);
            DBBroker.getInstance().getConnection().commit();
        } catch (Exception e) {
            DBBroker.getInstance().getConnection().rollback();
            throw e;
        }
    }
   // @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof TipAutomobila)) {
            throw new Exception("Prosledjeni objekat nije instanca klase TipAutomobila!");
        }
    }

   // @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> tipoviAutomobila = DBBroker.getInstance().select(ado);
        lista = (ArrayList<TipAutomobila>) (ArrayList<?>) tipoviAutomobila;
    }

    public ArrayList<TipAutomobila> getLista() {
        return lista;
    }

}
