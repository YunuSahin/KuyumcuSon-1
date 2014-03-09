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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;

public class SatilanUrun extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textBaslangicTarihi;
	private JTextField textBaslangicBitisTarihi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SatilanUrun frame = new SatilanUrun();
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
	public SatilanUrun() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Batuhan\\Downloads\\kuyumcu iconlar\\kuyumcu iconlar\\Gold.png"));
		setTitle("SATILAN \u00DCR\u00DCNLER\u0130 G\u00D6R");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 810, 620);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTextPane txtpnTarih = new JTextPane();
		txtpnTarih.setBounds(10, 107, 100, 20);
		txtpnTarih.setBackground(new Color(0, 191, 255));
		txtpnTarih.setEditable(false);
		txtpnTarih.setText("BA\u015ELANGI\u00C7 TAR\u0130H\u0130");
		
		JTextPane txtpnBitiTarihi = new JTextPane();
		txtpnBitiTarihi.setBounds(23, 185, 70, 20);
		txtpnBitiTarihi.setBackground(new Color(0, 191, 255));
		txtpnBitiTarihi.setEditable(false);
		txtpnBitiTarihi.setText("B\u0130T\u0130\u015E TAR\u0130H\u0130");
		final JComboBox comboBox_4 = new JComboBox();
		final JComboBox comboBox_5 = new JComboBox();
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textBaslangicBitisTarihi.setText((String) comboBox_4.getSelectedItem()+"."+(String) comboBox.getSelectedItem()+"."+(String) comboBox_5.getSelectedItem());

			}
		});
		comboBox.setBounds(330, 185, 47, 32);
		
		final JComboBox comboBox_1 = new JComboBox();
		final JComboBox comboBox_2 = new JComboBox();
		final JComboBox comboBox_3 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025"}));

		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textBaslangicTarihi.setText((String) comboBox_3.getSelectedItem()+"."+(String) comboBox_2.getSelectedItem()+"."+(String) comboBox_1.getSelectedItem());

			}
		});
		
		comboBox_1.setBounds(387, 99, 91, 37);
		
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(75, 396, 489, 148);
		
		table = new JTable();
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
				{null, null, null, null},
			},
			new String[] {
					"Satýlan Ürün Adý", "Ürün Fiyatý", "Aðýrlýk / Adet", "Tarih"
			}
		));
		scrollPane.setViewportView(table);
		contentPane.setLayout(null);
		contentPane.add(txtpnTarih);
		contentPane.add(txtpnBitiTarihi);
		
		contentPane.add(comboBox_1);
		contentPane.add(comboBox);
		contentPane.add(scrollPane);
	
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textBaslangicTarihi.setText((String) comboBox_3.getSelectedItem()+"."+(String) comboBox_2.getSelectedItem()+"."+(String) comboBox_1.getSelectedItem());

			}
		});
		comboBox_2.setBounds(323, 99, 54, 37);
		contentPane.add(comboBox_2);
		
	
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textBaslangicTarihi.setText((String) comboBox_3.getSelectedItem()+"."+(String) comboBox_2.getSelectedItem()+"."+(String) comboBox_1.getSelectedItem());

				
				
			}
		});
		comboBox_3.setBounds(255, 99, 63, 37);
		contentPane.add(comboBox_3);
		
		
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textBaslangicBitisTarihi.setText((String) comboBox_4.getSelectedItem()+"."+(String) comboBox.getSelectedItem()+"."+(String) comboBox_5.getSelectedItem());

			}
		});
		comboBox_4.setBounds(255, 185, 70, 32);
		contentPane.add(comboBox_4);
		
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025"}));
		comboBox_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textBaslangicBitisTarihi.setText((String) comboBox_4.getSelectedItem()+"."+(String) comboBox.getSelectedItem()+"."+(String) comboBox_5.getSelectedItem());

			}
		});
		comboBox_5.setBounds(387, 185, 91, 32);
		contentPane.add(comboBox_5);
		
		textBaslangicTarihi = new JTextField();
		textBaslangicTarihi.setBounds(136, 107, 86, 20);
		contentPane.add(textBaslangicTarihi);
		textBaslangicTarihi.setColumns(10);
		JButton btnNewButton = new JButton("GET\u0130R");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				
			}
		});
		btnNewButton.setBounds(255, 285, 183, 54);
		contentPane.add(btnNewButton);
		textBaslangicBitisTarihi = new JTextField();
		textBaslangicBitisTarihi.setBounds(136, 185, 86, 20);
		contentPane.add(textBaslangicBitisTarihi);
		textBaslangicBitisTarihi.setColumns(10);
	}
}
