package Views;

import Controllers.Controller;
import Models.ModelPerson;

public class Main {

	public static void main(String[] args)
	{		
		ModelPerson modelPerson = new ModelPerson();
		new Controller(modelPerson);
	}
}
