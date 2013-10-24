package Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import Controllers.Controller;
import Interface.ObservableInterface;
import Models.Account;
import Models.Model;
import Models.Person;

import javax.swing.*;

public class AccountView extends JFrame implements  ActionListener , ObservableInterface , ItemListener
{	
	private Controller controller;	
	private JPanel panel = new JPanel();	
	private JTextField textBoxNewAccount ;
	private  JComboBox comboBoxOldPerson;	
	private JButton buttonAddAccount ;
	private JTextArea area ;	
	Model model;
	Person person ;
	int accountNumber;

	public AccountView(Controller controller , Model model)
	{
		this.controller = controller;	
		this.model = model;
		this.setLocation(820, 300);		
		this.setSize(300, 170);
		this.setTitle("AccountView");
		this.setVisible(true);
				
		textBoxNewAccount = new JTextField(5);
		textBoxNewAccount.addActionListener(this);
		comboBoxOldPerson = new JComboBox();
		comboBoxOldPerson.addItemListener(this);
		buttonAddAccount = new JButton("Add Account");
		area = new JTextArea(5,17);
		
		panel.add(new JLabel("number"));
		panel.add(textBoxNewAccount);
		panel.add(new JLabel("Person"));
		panel.add(comboBoxOldPerson);
		//panel.add(buttonAddAccount);
		panel.add(area);
		add(panel);
		model.registerObserver(this);
	}	
	
	public void modelChanged()
	{
		comboBoxOldPerson.removeAllItems();	
		for(Person person : controller.getPersonList())
		{
			comboBoxOldPerson.addItem(person);
		}				
	}
	
	public void update() {}

	@Override
	public void actionPerformed(ActionEvent event) 
	{			
		Object personObject = comboBoxOldPerson.getSelectedItem();
		if(personObject instanceof Person)
		{
			this.person = (Person) personObject;
			accountNumber = Integer.parseInt(textBoxNewAccount.getText());
			controller.createAccount(accountNumber, person);
			textBoxNewAccount.setText("");
			return;
		}
		System.out.println("Error");
	}

	@Override
	public void itemStateChanged(ItemEvent event)
	{
		if (event.getStateChange() == ItemEvent.SELECTED) 
		{
            Object personObject = event.getItem();            
            if(personObject instanceof Person) 
            {            	
            	person = (Person) personObject;
                fillArea(person);
                return;
            }            
        }
	}	
	
	private void fillArea(Person person)
	{		
		area.setText("Name " + person.getName() + "\n" + "Social Security Number: " + person.getScn());
		for(Account account : model.getAccountList())
		{			
//			area.setText("Name " + account.getPerson().getName() + "\n" + "Social Security Number: " 
//					+ account.getPerson().getScn() + "\n" + account.getAccountNumber());
//			System.out.println(account.getAccountNumber());
			area.setText("Name " + person.getName() + "\n" + "Social Security Number: " + person.getScn() +
					"\n" + person.getAccounts());
		}
	}
	
}
