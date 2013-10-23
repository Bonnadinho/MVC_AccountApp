package Views;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import Controllers.Controller;
import Interface.ObservableInterface;
import Models.ModelPerson;
import Models.ModelAccount;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.TabExpander;

public class AccountView extends JFrame implements  ActionListener , ObservableInterface , ItemListener
{	
	private Controller controller;
	private ModelPerson modelPerson ;
	private JPanel panel = new JPanel();	
	private JTextField textBoxNewAccount ;
	private  JComboBox comboBoxOldPerson;	
	private JButton buttonAddAccount ;
	private JTextArea area ;	
	ModelPerson selectedPerson;

	public AccountView(Controller controller , ModelPerson modelPerson )
	{
		this.controller = controller;
		this.modelPerson = modelPerson ;		
		this.setLocation(820, 300);		
		this.setSize(300, 170);
		this.setTitle("AccountView");
		this.setVisible(true);
				
		textBoxNewAccount = new JTextField(5);
		textBoxNewAccount.addActionListener(this);
		comboBoxOldPerson = new JComboBox();
		buttonAddAccount = new JButton("Add Account");
		area = new JTextArea(5,17);
		
		panel.add(new JLabel("number"));
		panel.add(textBoxNewAccount);
		panel.add(new JLabel("Person"));
		panel.add(comboBoxOldPerson);
		//panel.add(buttonAddAccount);
		panel.add(area);
		add(panel);
		modelPerson.registerObserver(this);
	}	
	
	public void modelChanged()
	{
		comboBoxOldPerson.removeAllItems();				
	}
	
	public void update() {}

	@Override
	public void actionPerformed(ActionEvent event) 
	{	
		int number = Integer.parseInt(textBoxNewAccount.getText());	
		ModelPerson person = (ModelPerson) comboBoxOldPerson.getSelectedItem();
		controller.addAccount(number, person);
	}

	@Override
	public void itemStateChanged(ItemEvent event)
	{
		// door Reshad geschreven
		if (event.getStateChange() == ItemEvent.SELECTED) 
		{
		   Object item = event.getItem();
		   // do something with object
		   if(item instanceof ModelPerson) 
		      {            	
		         selectedPerson = (ModelPerson) item;
		         System.out.println("itemchanged");
		      //  fillArea(selectedPerson);
		      } 
		   else
		      {
		         selectedPerson = null;
		      }
		}		
	}	
	
	private void fillArea(ModelAccount rekening)
	{
		 //area.setText("Name " + person.getNaam() + "\n" + "BSN " + person.getBsn());
		//area.setText("Name" + rekening.getPersoon().getNaam());
	}
}
