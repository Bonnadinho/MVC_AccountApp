package Models;

/**
 * Created with IntelliJ IDEA.
 * creater: reshadfarid
 * perfected by  :  Bonnie
 * Date: 25-09-13
 * Time: 13:05
 * To change this template use File | Settings | File Templates.
 */

public class ModelRekening {
    float saldo;
    int nummer;
    ModelPersoon persoon;

    public void createRekening(int nummer, ModelPersoon persoon) 
    {
        this.nummer = nummer;
        this.persoon = persoon;
    }

    public ModelPersoon getPersoon() {
        return this.persoon;
    }

    public int getNummer() {
        return this.nummer;
    }

    public float getSaldo() {
        return this.saldo;
    }

    public void pasSaldoAan(double bedrag) {

        this.saldo += bedrag;

    }
}
