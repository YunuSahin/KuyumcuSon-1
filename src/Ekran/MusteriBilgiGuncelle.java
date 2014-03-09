package Ekran;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class MusteriBilgiGuncelle extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MusteriBilgiGuncelle frame = new MusteriBilgiGuncelle();
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
	public MusteriBilgiGuncelle() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MusteriBilgiGuncelle.class.getResource("/Ekran/adduser.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("M\u00FC\u015Fteri Bilgisi G\u00FCncelleme Ekran\u0131");
		setBounds(100, 100, 557, 494);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setForeground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton guncellebutonu = new JButton("B\u0130LG\u0130LER\u0130 G\u00DCNCELLE");
		guncellebutonu.setBounds(287, 358, 133, 65);
		guncellebutonu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				System.out.println(table.getValueAt(table.getSelectedRow(),table.getSelectedColumn()));
			}
		});
		guncellebutonu.setFont(new Font("Tahoma", Font.PLAIN, 11));
		guncellebutonu.setBackground(new Color(0, 191, 255));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 27, 471, 319);
		
		JButton Sil = new JButton("B\u0130LG\u0130 GET\u0130R");
		Sil.setBackground(new Color(0, 191, 255));
		Sil.setBounds(110, 358, 133, 65);
		Sil.setForeground(new Color(0, 0, 0));
		Sil.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"M\u00FC\u015Fteri ID", "Ad", "Soyad", "Telefon", "Bor\u00E7 Miktar\u0131", "\u00D6denecek Miktar"
			}
		));
		scrollPane.setViewportView(table);
		contentPane.setLayout(null);
		contentPane.add(guncellebutonu);
		contentPane.add(scrollPane);
		contentPane.add(Sil);
	}
}
