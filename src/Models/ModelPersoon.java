package Models;

import java.util.ArrayList;

import Views.AccountView;
import Views.PersonView;
import Interface.ObservableInterface;
import Interface.ObserverInterface;

/**
 * Created with IntelliJ IDEA.
 * creater: reshadfarid
 * perfected by  :  Bonnie
 * Date: 25-09-13
 * Time: 12:58
 * To change this template use File | Settings | File Templates.
 */


public class ModelPersoon
{
    int bsn;
    String naam;
    ArrayList<ModelRekening> rekList;

    public void createPersoon(int bsn, String naam) {
        this.bsn = bsn;
        this.naam = naam;
    }

    public String toString() {
        return this.naam;
    }

    public void voegtoeRek(ModelRekening rek) {

        rekList.add(rek);

    }

    public void verwijderRek(ModelRekening rek) {

        rekList.remove(rek);

    }

    public ArrayList<ModelRekening> getRekeningen() {

        return rekList;

    }

    public int getBsn() {
        return this.bsn;
    }

    public String getNaam() {
        return this.naam;
    }
	
}
