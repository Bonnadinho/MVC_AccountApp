package Controllers;

import java.util.Collection;
import java.util.Map;

import Models.Model;
import Models.ModelPersoon;
import Models.ModelRekening;
import Views.AccountView;
import Views.PersonView;
import Views.View;

public class Controller 
{
	Model model;
	ModelPersoon personModel ;
	ModelRekening accountModel ;
	View view;
	PersonView personView ;
	AccountView accountView;
	public Controller(Model mdl)
	{
		this.model = mdl;
		view = new View(this , mdl);	
		personModel = new ModelPersoon();
	}
	
	public void startPersonView()
	{
		personView = new PersonView(this, model);
	}
	
	public void startAccountView()
	{
		accountView = new AccountView(this, model);
	}
	
	public void createPerson(String value , int key)
	{		
		personModel.createPersoon(key, value);
		model.setPersoon(personModel);		
	}	
	
	public void addAccount(int number , ModelPersoon person)
	{		
		accountModel.createRekening(number, person);
		personModel.voegtoeRek(accountModel);
	}	
}
