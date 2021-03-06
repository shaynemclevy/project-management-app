package listview_components;

import javax.swing.*;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.border.BevelBorder;

import domain.ProjectController;

@SuppressWarnings("serial")
public class Project_form extends JFrame {

	private JPanel contentPane;
	private JTextField NameField;
	private JTextField DescField;
	private JTextField BudgetField;

	/**
	 * Create the frame.
	 */
	public Project_form() {
		
		//Initialize Frame Settings
		setTitle("PROJECT CREATION");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 266, 255);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Initialize and create Labels
		JLabel NameLabel = new JLabel("Name");
		NameLabel.setForeground(Color.BLACK);
		NameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		NameLabel.setBounds(10, 11, 55, 36);
		contentPane.add(NameLabel);
		
		JLabel DescLabel = new JLabel("Description");
		DescLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		DescLabel.setBounds(10, 76, 83, 26);
		contentPane.add(DescLabel);
		
		JLabel Budget = new JLabel("Budget");
		Budget.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Budget.setBounds(10, 131, 59, 26);
		contentPane.add(Budget);
		
		//Initialize and create Text Fields
		NameField = new JTextField();
		NameField.setBounds(91, 21, 147, 20);
		contentPane.add(NameField);
		NameField.setColumns(10);
		
		DescField = new JTextField();
		DescField.setBounds(91, 81, 147, 20);
		contentPane.add(DescField);
		DescField.setColumns(10);
		
		BudgetField = new JTextField();
		BudgetField.setBounds(91, 136, 147, 20);
		contentPane.add(BudgetField);
		BudgetField.setColumns(10);
		
		//Initialize and create Buttons
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(34, 183, 89, 23);
		contentPane.add(btnCancel);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(130, 183, 89, 23);
		contentPane.add(btnSave);
		
		//Set and define listeners for both buttons
		
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				disposeWindow();
			}
		});
		
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				saveAction();
			}
		});
		
	}
		
	private void saveAction () {
		try
		{
			double budget = Double.parseDouble(BudgetField.getText());
			if (!NameField.getText().isEmpty() && !DescField.getText().isEmpty() && budget > 0)
			{
				ProjectController.addProject(NameField.getText(), DescField.getText(), Double.parseDouble(BudgetField.getText()));
                this.dispose();
			}
			else
			{
				JOptionPane.showMessageDialog(new JFrame(),
	                    "Please Fill in all values correctly",
	                    "Values are incorrect format or missing values",
	                    JOptionPane.WARNING_MESSAGE);
			}
		}
		catch (Exception exception)
		{
			JOptionPane.showMessageDialog(new JFrame(),
                    "Budget must be numeric",
                    "Budget must be numeric",
                    JOptionPane.WARNING_MESSAGE);
		}

    }
	
	private void disposeWindow(){
		this.dispose();
	}
	
	
}

