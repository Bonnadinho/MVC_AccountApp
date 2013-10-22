package Interface;

import Views.AccountView;
import Views.PersonView;

public interface  ObserverInterface 
{	
	public void registerObserver(PersonView observable);
	public void registerObserver(AccountView observable);
	public void notifyObserver();
	public void removeObserver(ObservableInterface observable);	
}
