package Models;

import java.util.ArrayList;

import Views.AccountView;
import Views.PersonView;
import Interface.ObservableInterface;
import Interface.ObserverInterface;



public class Person 
{
    int scn;
    String name;
    ArrayList<Account> accountList = new ArrayList<>();  
  
	public Person(int scn, String name) {
        this.scn = scn;
        this.name = name;          
    }	

    public String toString() {
        return this.name;
    }

    public void addAccount(Account account) 
    {
        accountList.add(account);
    }    
  

    public void Account(Account account) 
    {
        accountList.remove(account);
    }

    public ArrayList<Account> getAccounts() 
    {
        return accountList;
    }

    public int getScn() {
        return this.scn;
    }

    public String getName() {
        return this.name;
    }		
}
