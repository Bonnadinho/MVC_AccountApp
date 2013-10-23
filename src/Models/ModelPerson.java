package Models;

import java.util.ArrayList;

import Views.AccountView;
import Views.PersonView;
import Interface.ObservableInterface;
import Interface.ObserverInterface;



public class ModelPerson implements ObserverInterface
{
    int scn;
    String name;
    ArrayList<ModelAccount> accountList;   
    
    ArrayList<ObservableInterface> observers =  new ArrayList();
    
    public ModelPerson() {
    	// Class initiater
    }  

	public ModelPerson(int scn, String name) {
        this.scn = scn;
        this.name = name;          
    }

    public String toString() {
        return this.name;
    }

    public void addAccount(ModelAccount account) 
    {
        accountList.add(account);
    }

    public void removeAccount(ModelAccount account) 
    {
        accountList.remove(account);
    }

    public ArrayList<ModelAccount> getAccounts() 
    {
        return accountList;
    }

    public int getScn() {
        return this.scn;
    }

    public String getName() {
        return this.name;
    }
    
    
    /*
     * use fellowing codes uses the Observer Pattern
     * 
     */
    
    public void notifyObserver()
	{
		for(ObservableInterface view :observers )
		{			
			view.modelChanged();
			return;
		}	
		System.out.println("no view in observer");
	}

	public void registerObserver(PersonView observable)
	{		
		this.observers.add(observable);	
		System.out.println("added to observer");
	}
	
	public void registerObserver(AccountView observable) 
	{		
		//observers.add(observable);			
	}
	
	public void removeObserver(ObservableInterface observable) 
	{}	
		
}
