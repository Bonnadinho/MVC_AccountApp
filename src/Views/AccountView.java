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
import Models.Model;
import Models.ModelPersoon;
import Models.ModelRekening;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.TabExpander;

public class AccountView extends JFrame implements  ActionListener , ObservableInterface , ItemListener
{	
	private Controller ctlr;
	private Model model;
	private JPanel panel = new JPanel();
	private JTable table ;
	private JScrollPane scrollpane;
	private DefaultTableModel tablemodel ;	
	private JTextField textBoxNewAccount ;
	private  JComboBox comboBoxOldPerson;	
	private JButton buttonAddAccount ;
	private JTextArea area ;	
	ModelPersoon selectedPerson;

	public AccountView(Controller ctlr , Model mdl)
	{
		this.ctlr = ctlr;
		this.model = mdl ;		
		this.setLocation(820, 300);		
		this.setSize(300, 170);
		this.setTitle("AccountView");
		this.setVisible(true);
		
		
		// creating the View for the Account	
		tablemodel = new DefaultTableModel();	
		tablemodel.addColumn("Person");
		tablemodel.addColumn("AccountNumber");
		table = new JTable(tablemodel);			
		scrollpane = new JScrollPane(table);	
		scrollpane.setPreferredSize(new Dimension(230, 100));
		//panel.add(scrollpane);
		
		textBoxNewAccount = new JTextField(5);
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
		mdl.registerObserver(this);
	}	
	
	public void modelChanged()
	{
		comboBoxOldPerson.removeAllItems();		
		for(ModelPersoon person : model.getPersonList())
		{
			comboBoxOldPerson.addItem(person);	
		}
	}
	
	public void update() {}

	@Override
	public void actionPerformed(ActionEvent event) 
	{	
		int number = Integer.parseInt(textBoxNewAccount.getText());			
		ctlr.addAccount(number, selectedPerson);
	}

	@Override
	public void itemStateChanged(ItemEvent event)
	{
		// door Reshad geschreven
		if (event.getStateChange() == ItemEvent.SELECTED) 
		{
		   Object item = event.getItem();
		   // do something with object
		   if(item instanceof ModelPersoon) 
		      {            	
		         selectedPerson = (ModelPersoon) item;
		      //  fillArea(selectedPerson);
		      } 
		   else
		      {
		         selectedPerson = null;
		      }
		}		
	}	
	
	private void fillArea(ModelRekening rekening)
	{
		 //area.setText("Name " + person.getNaam() + "\n" + "BSN " + person.getBsn());
		//area.setText("Name" + rekening.getPersoon().getNaam());
	}
}
