package Models;

import Views.AccountView;
import Views.PersonView;
import Interface.ObservableInterface;
import Interface.ObserverInterface;


public class ModelAccount
{
    float saldo;
    int accountNumber;
    ModelPerson person;
    
    public ModelAccount(int accountNumber, ModelPerson person) 
    {
        this.accountNumber = accountNumber;
        this.person = person;
    }

    public ModelPerson getPerson() {
        return this.person;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public float getSaldo() {
        return this.saldo;
    }

    public void pasSaldoAan(double bedrag) {

        this.saldo += bedrag;

    }	
}
