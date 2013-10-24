package Controllers;


import java.util.ArrayList;
import java.util.List;

import Models.Model;
import Models.Person;
import Views.AccountView;
import Views.PersonView;
import Views.View;

public class Controller 
{	
	Model model ;
	public Controller(Model model)
	{
		this.model = model;
		View view = new View(this , model);	
	}
	
	public void startPersonView()
	{
		PersonView personView = new PersonView(this, model);
	}
	
	public void startAccountView()
	{
		AccountView accountView = new AccountView(this, model);
	}
	
	/*
	 * related to PersonView ONLY
	 */
	
	public void createPerson(int scn , String name )
	{	
		model.createPerson(scn, name);
	}	
	
	public ArrayList<Person> getPersonList() 
	{
		return model.getPersonList();
	}
	
	/*
	 * related to AccountView ONLY
	 */
	public void createAccount(int accountNumber , Person person )
	{	
		model.createAccnout(accountNumber, person);
	}	
	
}
