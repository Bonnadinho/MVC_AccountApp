package Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Controllers.Controller;
import Models.Model;


/* 
 * Author: Bonnadinho
 * Class:  superclass view which extends from Jframe
 * purpose : this generate a connection betwix the model and the controller ;
 * 
 * */


public class View extends JFrame implements ActionListener
{
	Controller controller;
	Model model;
	JPanel panel ;
	private JButton buttonperson , buttonaccount;
	public View(Controller controller ,Model model)
	{		
		this.controller = controller;
		this.model = model ;
		super.setSize(250, 80);	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
		buttonperson = new JButton("Person");
		buttonperson.addActionListener(this);
		buttonaccount = new JButton("Account");
		buttonaccount.addActionListener(this);
		panel = new JPanel();
		panel.add(buttonperson);
		panel.add(buttonaccount);
		add(panel);
	}		 
	
	public void actionPerformed(ActionEvent btn) 
	{
		if(btn.getSource() == buttonperson)
		{
			controller.startPersonView();
		}
		if(btn.getSource() == buttonaccount)
		{
			controller.startAccountView();
		}
	}		
}
