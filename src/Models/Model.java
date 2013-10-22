package Models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import Views.AccountView;
import Views.PersonView;
import Interface.ObservableInterface;
import Interface.ObserverInterface;

public class Model implements ObserverInterface
{	
	private ArrayList<ModelPersoon> personList =  new ArrayList();
	private ArrayList<ModelRekening> accountList =  new ArrayList();
	private ArrayList<ObservableInterface> observers =  new ArrayList();	
	private ModelPersoon person = new ModelPersoon() ;
	private ModelRekening rekening = new ModelRekening();	
	
	// This is a center model class which access all other Logical class need for the app

	
	public ArrayList<ModelPersoon> getPersonList() 
	{
		return personList;
	}	
	
	public void setPersoon(ModelPersoon persoon) 
	{
		this.person = persoon;
		personList.add(persoon);			
		notifyObserver();	
	}	

	public void notifyObserver()
	{		
		for(ObservableInterface view :observers )
		{
			view.modelChanged();			
		}
	}
	
	public void setRekening(ModelRekening rekening)
	{
		this.rekening = rekening;
		accountList.add(rekening);
		notifyObserver();		
	}
	
	/* 
	 * (non-Javadoc)
	 * @see Interface.ObserverInterface#registerObserver(Views.PersonView)
	 */
	
	public void registerObserver(PersonView observable)
	{
		observers.add(observable);	
	}
	
	public void removeObserver(ObservableInterface observable) {}
	
	public void registerObserver(AccountView observable)
	{
		observers.add(observable);	
	}
}
