package Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Controllers.Controller;
import Interface.ObservableInterface;
import Models.Model;
import Models.Person;

import javax.swing.*;


public class PersonView extends JFrame implements ActionListener ,ItemListener, ObservableInterface
{
	private Controller controller;	
	Model model ; 
	JPanel panel = new JPanel() ;
	JTextField textBoxPerson , textBoxtAccountnumber;
	JButton buttonPerson ;		
	private  JComboBox comboBoxPerson;		
	private JTextArea area ;
	Person person ;
	
	
	public PersonView(Controller controller , Model model)
	{
		this.controller = controller;
		this.model = model ;		
		this.setLocation(250, 300);		
		this.setSize(300, 210);
		this.setTitle("PersonView");
		this.setVisible(true);
		this.model.registerObserver(this);
		
		// creating the View for the Person		
		textBoxtAccountnumber = new JTextField(10);	
		textBoxtAccountnumber.addActionListener(this);
		textBoxPerson = new JTextField(10);		
		buttonPerson = new JButton("Add Person");	
		buttonPerson.addActionListener(this);
		comboBoxPerson = new JComboBox();	
		comboBoxPerson.addItemListener(this);
		area = new JTextArea(5,17);		
		
		panel.add(new JLabel("Add Person :"));
		panel.add(textBoxPerson);
		panel.add(new JLabel("Account number :"));
		panel.add(textBoxtAccountnumber);	
		panel.add(buttonPerson);	
		panel.add(new JLabel("Person"));
		panel.add(comboBoxPerson);		
		panel.add(area);
		add(panel);
	}
	
	public void actionPerformed(ActionEvent btn) 
	{	
		int scn = Integer.parseInt((textBoxtAccountnumber.getText()));	
		String name = textBoxPerson.getText();
		
		controller.createPerson(scn, name);			
		textBoxPerson.setText("");
		textBoxtAccountnumber.setText("");			
	}

	@Override
	public void update() 
	{}

	@Override
	public void modelChanged()
	{			
		comboBoxPerson.removeAllItems();	
		for(Person person : controller.getPersonList())
		{
			comboBoxPerson.addItem(person);
		}		
	}

	@Override
	public void itemStateChanged(ItemEvent event) 
	{			
		if (event.getStateChange() == ItemEvent.SELECTED) 
		{
            Object item = event.getItem();
            // do something with object
            if(item instanceof Person) 
            {            	
            	person = (Person) item;
                fillArea(person);
            } 
            else
            {
            	person = null;
            }
        }
	}	
	
	private void fillArea(Person person)
	{
		area.setText("Name " + person.getName() + "\n" + "Social Security Number: " + person.getScn());
	}
}
