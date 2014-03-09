package Ekran;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Toolkit;

import javax.swing.JScrollPane;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JTextField;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;

public class AlinanUrun extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlinanUrun frame = new AlinanUrun();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AlinanUrun() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AlinanUrun.class.getResource("/Ekran/ista2.png")));
		setTitle("ALINAN \u00DCR\u00DCNLER\u0130 G\u00D6R");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 810, 620);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTextPane txtpnTarih = new JTextPane();
		txtpnTarih.setBounds(93, 99, 100, 20);
		txtpnTarih.setBackground(new Color(0, 191, 255));
		txtpnTarih.setEditable(false);
		txtpnTarih.setText("BA\u015ELANGI\u00C7 TAR\u0130H\u0130");
		
		JTextPane txtpnBitiTarihi = new JTextPane();
		txtpnBitiTarihi.setBounds(97, 164, 70, 20);
		txtpnBitiTarihi.setBackground(new Color(0, 191, 255));
		txtpnBitiTarihi.setEditable(false);
		txtpnBitiTarihi.setText("B\u0130T\u0130\u015E TAR\u0130H\u0130");
		
		final JComboBox comboBox_1 = new JComboBox();
		final JComboBox comboBox_2 = new JComboBox();
		final JComboBox comboBox_3 = new JComboBox();
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textField.setText((String) comboBox_3.getSelectedItem()+"."+(String) comboBox_2.getSelectedItem()+"."+(String) comboBox_1.getSelectedItem());
			textField_2.setText(comboBox_1.getSelectedItem()+"-"+comboBox_2.getSelectedItem()+"-"+comboBox_3.getSelectedItem());
String k = textField_2.getText();

			
			}
		});
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025"}));
		comboBox_1.setBounds(477, 92, 90, 35);
		
		final JComboBox comboBox_4 = new JComboBox();
		final JComboBox comboBox_5 = new JComboBox();
		final JComboBox comboBox = new JComboBox();
		
		comboBox_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setText((String) comboBox_4.getSelectedItem()+"."+(String) comboBox.getSelectedItem()+"."+(String) comboBox_5.getSelectedItem());
			}
		});

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setText((String) comboBox_4.getSelectedItem()+"."+(String) comboBox.getSelectedItem()+"."+(String) comboBox_5.getSelectedItem());
			}
		});
		comboBox_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setText((String) comboBox_4.getSelectedItem()+"."+(String) comboBox.getSelectedItem()+"."+(String) comboBox_5.getSelectedItem());
			}
		});
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox_4.setBounds(323, 158, 54, 26);
		
		JButton btnNewButton = new JButton("GET\u0130R");
		btnNewButton.setBounds(255, 285, 183, 54);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(97, 395, 411, 141);
		
		table = new JTable();
		table.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
					"Alinan Ürün Adý", "Ürün Fiyatý", "Aðýrlýk / Adet", "Tarih"
			}
		));
		scrollPane.setViewportView(table);
		contentPane.add(scrollPane);
		contentPane.add(txtpnTarih);
		contentPane.add(txtpnBitiTarihi);
		contentPane.add(btnNewButton);
		contentPane.add(comboBox_4);
		contentPane.add(comboBox_1);
	
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText((String) comboBox_3.getSelectedItem()+"."+(String) comboBox_2.getSelectedItem()+"."+(String) comboBox_1.getSelectedItem());
				
			}
		});
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		comboBox_2.setBounds(387, 92, 80, 35);
		contentPane.add(comboBox_2);
		
		
		comboBox_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText((String) comboBox_3.getSelectedItem()+"."+(String) comboBox_2.getSelectedItem()+"."+(String) comboBox_1.getSelectedItem());
			}
		});
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox_3.setBounds(323, 92, 54, 35);
		contentPane.add(comboBox_3);
		
		textField = new JTextField();
		textField.setFont(new Font("Comic Sans MS", Font.ITALIC, 12));
		textField.setForeground(Color.BLUE);
		textField.setBackground(Color.WHITE);
		textField.setEditable(false);

		textField.setBounds(216, 99, 93, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
	
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBox.setBounds(387, 158, 80, 26);
		contentPane.add(comboBox);
		
	
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025"}));
		comboBox_5.setBounds(477, 158, 90, 26);
		contentPane.add(comboBox_5);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(216, 164, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(576, 99, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
	
		System.out.println(textField.getText());
		
	}
	
	

	
	
}
