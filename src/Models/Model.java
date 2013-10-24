package Models;

import java.util.ArrayList;

import Views.AccountView;
import Views.PersonView;
import Interface.ObservableInterface;
import Interface.ObserverInterface;

public class Model implements ObserverInterface
{
	Person person;
	Account account;
	private ArrayList<ObservableInterface> observers =  new ArrayList();
	private ArrayList<Person> personList =  new ArrayList();
	private ArrayList<Account> accountList =  new ArrayList();
	

	public void createPerson(int scn , String name )
	{	
		person = new Person(scn,name);
		addPerson(person);
		notifyObserver();
	}	
	
	public void createAccnout(int accountNumber , Person person)
	{		
		account = new Account(accountNumber , person);		
		//accountList.add(account);
		person.addAccount(account);
		personList.add(person);
		System.out.println("account created");
		//notifyObserver();
	}	
	
	public ArrayList<Account> getAccountList() {
		return accountList;
	}
	
	private void addPerson(Person person)
	{
		personList.add(person);
	}
	
	public ArrayList<Person> getPersonList() 
	{
		return personList;
	}
	
	/*
	 *  The Fellowing methodes uses the observer pattern
	 * 
	 */
	public void notifyObserver()
	{
		for(ObservableInterface view :observers )
		{
			view.modelChanged();			
		}
	}
	
	public void registerObserver(PersonView observable) 
	{		
		observers.add(observable);
	}
	
	public void registerObserver(AccountView observable) 
	{
		observers.add(observable);
	}	
	
	public void removeObserver(ObservableInterface observable)
	{}
}
