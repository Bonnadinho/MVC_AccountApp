package Controllers;


import java.util.ArrayList;

import Models.ModelPerson;
import Models.ModelAccount;
import Views.AccountView;
import Views.PersonView;
import Views.View;

public class Controller 
{	
	ModelPerson modelPerson = new ModelPerson();	
	
	// create an arraylist with the object "Person"
	public ArrayList<ModelPerson> personList = new ArrayList();
	
	public Controller(ModelPerson modelPerson)
	{
		this.modelPerson = modelPerson;
		View view = new View(this , modelPerson);	
	}
	
	public void startPersonView()
	{
		PersonView personView = new PersonView(this, modelPerson);
	}
	
	public void startAccountView()
	{
		AccountView accountView = new AccountView(this, modelPerson);
	}
	
	public void createPerson(int scn , String name )
	{		
		modelPerson = new ModelPerson(scn, name);		
		personList.add(modelPerson);
		modelPerson.notifyObserver();
		System.out.println("creatPerson in Cont.");		
	}	
	
	public void addAccount(int number , ModelPerson person)
	{		
		
	}	
}
