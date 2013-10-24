package Models;

import Views.AccountView;
import Views.PersonView;
import Interface.ObservableInterface;
import Interface.ObserverInterface;


public class Account
{
    float saldo;
    int accountNumber;
    Person person;
    
    public Account(int accountNumber, Person person) 
    {
        this.accountNumber = accountNumber;
        this.person = person;
    }

    public Person getPerson() {
        return this.person;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public float getSaldo() {
        return this.saldo;
    }

    public void pasSaldoAan(double bedrag)
    {
        this.saldo += bedrag;
    }	
}
