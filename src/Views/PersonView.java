package Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Map;

import Controllers.Controller;
import Interface.ObservableInterface;
import Models.Model;
import Models.ModelPersoon;

import javax.swing.*;

public class PersonView extends JFrame implements ActionListener ,ItemListener, ObservableInterface
{
	private Controller controller;
	private Model model;
	JPanel panel = new JPanel() ;
	JTextField textBoxPerson , textBoxtAccountnumber;
	JButton buttonPerson ;		
	private  JComboBox comboBoxOldPerson;		
	private JTextArea area ;
	ModelPersoon selectedPerson;
	
	public PersonView(Controller controller , Model model)
	{
		this.controller = controller;
		this.model = model ;		
		this.setLocation(250, 300);		
		this.setSize(300, 210);
		this.setTitle("PersonView");
		this.setVisible(true);
		model.registerObserver(this);
		
		// creating the View for the Person		
		textBoxtAccountnumber = new JTextField(10);	
		textBoxtAccountnumber.addActionListener(this);
		textBoxPerson = new JTextField(10);		
		buttonPerson = new JButton("Add Person");	
		buttonPerson.addActionListener(this);
		comboBoxOldPerson = new JComboBox();	
		comboBoxOldPerson.addItemListener(this);
		area = new JTextArea(5,17);		
		
		panel.add(new JLabel("Add Person :"));
		panel.add(textBoxPerson);
		panel.add(new JLabel("Account number :"));
		panel.add(textBoxtAccountnumber);	
		panel.add(buttonPerson);	
		panel.add(new JLabel("Person"));
		panel.add(comboBoxOldPerson);		
		panel.add(area);
		add(panel);
	}
	
	public void actionPerformed(ActionEvent btn) 
	{	
		String value = textBoxPerson.getText();
		int key = Integer.parseInt((textBoxtAccountnumber.getText()));	
		controller.createPerson(value, key);			
		textBoxPerson.setText("");
		textBoxtAccountnumber.setText("");			
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
	}

	@Override
	public void modelChanged()
	{		
		int value = 0 ;
		String key =  null ;
		comboBoxOldPerson.removeAllItems();		
		for(ModelPersoon person : model.getPersonList())
		{
			comboBoxOldPerson.addItem(person);	
		}
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
                fillArea(selectedPerson);
            } 
            else
            {
                selectedPerson = null;
            }
        }
	}	
	
	private void fillArea(ModelPersoon person)
	{
		 area.setText("Name " + person.getNaam() + "\n" + "BSN " + person.getBsn());
	}
}
