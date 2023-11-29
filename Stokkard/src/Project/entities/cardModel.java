package Project.entities;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import Project.business.concrete.StockCardManager;
import Project.dataccess.abstraction.IStockCardDao;
import Project.dataccess.concrete.context.IConnect;
import Project.dataccess.concrete.context.MysqlConnection;
import Project.dataccess.concrete.mysql.mysqlStockCard;
import Project.entities.concrete.StockCard;

import javax.swing.JScrollBar;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.sql.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.DefaultComboBoxModel;

public class cardModel extends JFrame {

	DefaultTableModel model;
	IConnect _conn;

	private JPanel contentPane;
	private JTextField textField_StockCode;
	private JTextField textField_StockName;
	private JTextField textField_Barcode;
	private JTable table_2;
	private JTextField textField_search;
	private JComboBox comboBox_StockType;
	private JComboBox comboBox_Unit;
	private JComboBox comboBox_KdvType;
	private JTextArea textArea_description;
	private JFormattedTextField formattedTextField_CreationTime;

	/**
	 * Launch the application.
	 */
	public ArrayList<StockCard> getCards() throws SQLException {
		Connection connection = null;
		MysqlConnection con = new MysqlConnection();
		Statement statement = null;
		ResultSet resultSet;
		ArrayList<StockCard> cards = null;
		try {
			connection = con.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from card");
			cards = new ArrayList<StockCard>();
			while (resultSet.next()) {
				cards.add(new StockCard(resultSet.getInt("id"), resultSet.getString("stockCode"),
						resultSet.getString("stockName"), resultSet.getInt("stockType"), resultSet.getString("unit"),
						resultSet.getString("barcode"), resultSet.getDouble("kdvType"),
						resultSet.getString("description"), resultSet.getDate("creationTime")));
			}

		} catch (SQLException ex) {
			con.showErrorMessage(ex);
		} finally {
			statement.close();
			connection.close();
		}

		return cards;

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					cardModel frame = new cardModel();
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

	public cardModel() {
		InitComponents();
		List();
	
	}
	public void List() {
		
		model = (DefaultTableModel) table_2.getModel();
		model.setRowCount(0);
		
		try {
			ArrayList<StockCard> cards = getCards();
			for (StockCard card : cards) {
				Object[] row = { card.getId(), card.getStockCode(), card.getStockName(), card.getStockType(),
						card.getUnit(), card.getBarcode(), card.getKdvType(), card.getDescription(),
						card.getCreationTime() };
				model.addRow(row);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	public void InitComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 574);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btn_delete = new JButton("Sil");
		btn_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StockCard card = new StockCard(textField_StockCode.getText(), textField_StockName.getText(),
						Integer.parseInt((String) comboBox_StockType.getSelectedItem()),
						(String) comboBox_Unit.getSelectedItem(), textField_Barcode.getText(),
						Double.parseDouble((String) comboBox_KdvType.getSelectedItem()),
						textArea_description.getText());
				StockCardManager manager = new StockCardManager(new mysqlStockCard());
				manager.Delete(card);
				List();
			}
		});
		btn_delete.setBounds(210, 341, 89, 23);
		contentPane.add(btn_delete);

		JButton btn_update = new JButton("Güncelle");
		btn_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StockCard card = new StockCard(textField_StockCode.getText(), textField_StockName.getText(),
						Integer.parseInt((String) comboBox_StockType.getSelectedItem()),
						(String) comboBox_Unit.getSelectedItem(), textField_Barcode.getText(),
						Double.parseDouble((String) comboBox_KdvType.getSelectedItem()),
						textArea_description.getText());
				if(textField_StockCode.getText()=="")
				{
					System.out.println("güncellenemedi");
				}
				JOptionPane.showMessageDialog(null,"GÜNCELLENDİ");
				StockCardManager manager = new StockCardManager(new mysqlStockCard());
				manager.Update(card);
				List();
			}
		});
		btn_update.setBounds(314, 341, 89, 23);
		contentPane.add(btn_update);

		JButton btn_save = new JButton("Kaydet");
		btn_save.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				StockCard card = new StockCard(textField_StockCode.getText(), textField_StockName.getText(),
						Integer.parseInt((String) comboBox_StockType.getSelectedItem()),
						(String) comboBox_Unit.getSelectedItem(), textField_Barcode.getText(),
						Double.parseDouble((String) comboBox_KdvType.getSelectedItem()),
						textArea_description.getText());
				StockCardManager manager = new StockCardManager(new mysqlStockCard());
				manager.Add(card);
				List();
			

			}

		});
		btn_save.setBounds(78, 341, 89, 23);
		contentPane.add(btn_save);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(220, 220, 220));
		panel.setBounds(10, 0, 874, 535);
		contentPane.add(panel);
		panel.setLayout(null);

		textField_StockCode = new JTextField();
		textField_StockCode.setBounds(222, 39, 86, 20);
		panel.add(textField_StockCode);
		textField_StockCode.setColumns(10);

		JLabel lbl_id_1 = new JLabel("Stok kodu   :");
		lbl_id_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		lbl_id_1.setBounds(71, 45, 98, 14);
		panel.add(lbl_id_1);

		textField_StockName = new JTextField();
		textField_StockName.setBounds(222, 77, 86, 20);
		panel.add(textField_StockName);
		textField_StockName.setColumns(10);

		comboBox_StockType = new JComboBox();
		comboBox_StockType.setModel(
				new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11" }));
		comboBox_StockType.setBounds(222, 108, 86, 22);
		panel.add(comboBox_StockType);

		JLabel lbl_id_1_1 = new JLabel("Stok Adi     :");
		lbl_id_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		lbl_id_1_1.setBounds(71, 78, 98, 14);
		panel.add(lbl_id_1_1);

		comboBox_Unit = new JComboBox();
		comboBox_Unit.setModel(new DefaultComboBoxModel(
				new String[] { "A00000", "A00001", "A00002", "A00003", "A00004", "A00005", "A00006", "" }));
		comboBox_Unit.setBounds(222, 141, 86, 22);
		panel.add(comboBox_Unit);

		JLabel lbl_id_1_1_1 = new JLabel("Birimi         :");
		lbl_id_1_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		lbl_id_1_1_1.setBounds(68, 145, 98, 14);
		panel.add(lbl_id_1_1_1);

		textField_Barcode = new JTextField();
		textField_Barcode.setBounds(222, 176, 86, 20);
		panel.add(textField_Barcode);
		textField_Barcode.setColumns(10);

		JLabel lbl_id_1_1_1_1 = new JLabel("Barkod       :");
		lbl_id_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		lbl_id_1_1_1_1.setBounds(68, 177, 98, 14);
		panel.add(lbl_id_1_1_1_1);

		comboBox_KdvType = new JComboBox();
		comboBox_KdvType.setModel(new DefaultComboBoxModel(new String[] { "0.1", "0.2", "0.3", "0.4", "0.5", "0.6",
				"0.7", "0.8", "0.9", "1.0", "1.1", "1.2", "1.3", "1.4", "1.5", "1.6", "1.7", "1.8", "1.9", "2.0", "2.1",
				"2.2", "2.3", "2.4", "2.5", "2.6", "2.7", "2.8", "2.9", "3.0", "3.1", "3.2", "3.3", "3.4", "3.5", "3.6",
				"3.7", "3.8", "3.9", "4.0", "4.1", "4.2", "4.3", "4.4", "4.5", "4.6", "4.7", "4.8", "4.9", "5.0" }));
		comboBox_KdvType.setBounds(222, 213, 86, 22);
		panel.add(comboBox_KdvType);

		JLabel lbl_id_1_1_1_1_1 = new JLabel("Kdv Tipi     :");
		lbl_id_1_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		lbl_id_1_1_1_1_1.setBounds(68, 215, 98, 14);
		panel.add(lbl_id_1_1_1_1_1);

		textArea_description = new JTextArea();
		textArea_description.setBounds(222, 244, 203, 39);
		panel.add(textArea_description);

		JLabel lbl_id_1_1_1_1_2 = new JLabel("Açiklama   :");
		lbl_id_1_1_1_1_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		lbl_id_1_1_1_1_2.setBounds(68, 249, 98, 14);
		panel.add(lbl_id_1_1_1_1_2);

		formattedTextField_CreationTime = new JFormattedTextField();
		formattedTextField_CreationTime.setBounds(222, 300, 203, 20);
		panel.add(formattedTextField_CreationTime);

		JLabel lbl_id_1_1_1_1_3 = new JLabel("Oluşturma Zamanı:");
		lbl_id_1_1_1_1_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		lbl_id_1_1_1_1_3.setBounds(68, 301, 144, 14);
		panel.add(lbl_id_1_1_1_1_3);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(452, 26, 385, 274);
		panel.add(scrollPane);

		table_2 = new JTable(new DefaultTableModel(new Object[][] {}, new String[] { "id", "stockCode", "stockName",
				"stockType", "unit", "barcode", "kdvType", "description", "creationTime" }) {
			Class[] columnTypes = new Class[] { Integer.class, String.class, String.class, Integer.class, String.class,
					String.class, Double.class, String.class, Object.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		ListSelectionModel smodel=table_2.getSelectionModel();
		smodel.addListSelectionListener(
				new ListSelectionListener()
				{
					public void valueChanged(ListSelectionEvent e) {
						int find=e.getFirstIndex();
						int lind=e.getLastIndex();
						boolean isAdjust=e.getValueIsAdjusting();
						int[]cols=table_2.getSelectedColumns();
						if(!isAdjust)
						{
							int j=0;
							for(int i=find;i<=lind;i++) {
								j++;
								for(int item:cols)
								{
									
									textField_StockCode.setText((String) table_2.getValueAt(i, item));
									textField_StockName.setText( (String) table_2.getValueAt(i, item+1));
					                comboBox_StockType.setSelectedIndex( (int) table_2.getValueAt(i, item+2)-1);
					                comboBox_Unit.setSelectedIndex(j);
					                textField_Barcode.setText((String) table_2.getValueAt(i, item+4));
					                textArea_description.setText((String) table_2.getValueAt(i, item+6));
					                
					                
								}
							}
						}
					
					}
				}
				);
		
		table_2.setBackground(new Color(255, 255, 255));

		scrollPane.setViewportView(table_2);

		JLabel lbl_StokBirimi = new JLabel("Stok Tipi    :");
		lbl_StokBirimi.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		lbl_StokBirimi.setBounds(68, 112, 98, 14);
		panel.add(lbl_StokBirimi);

		JLabel lbl_id_1_1_1_1_2_1 = new JLabel("StockCard  Ara :");
		lbl_id_1_1_1_1_2_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		lbl_id_1_1_1_1_2_1.setBounds(452, 311, 135, 14);
		panel.add(lbl_id_1_1_1_1_2_1);

		textField_search = new JTextField();
		textField_search.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String searchKey = textField_search.getText();
				TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<DefaultTableModel>(model);
				table_2.setRowSorter(tableRowSorter);
				tableRowSorter.setRowFilter(RowFilter.regexFilter(searchKey));
			}
		});
		textField_search.setBounds(597, 310, 86, 20);
		panel.add(textField_search);
		textField_search.setColumns(10);
		
		JButton btnCopy = new JButton("Kopyala");
		btnCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String code=textField_search.getText();
				System.out.println(code);
				StockCardManager manager = new StockCardManager(new mysqlStockCard());
				ResultSet result=manager.Copy(code);
				
				 try {
			            while (result.next()) {
			                
			                textField_StockCode.setText( result.getString("stockCode"));
			                textField_StockName.setText( result.getString("stockName"));
			                int stockType = result.getInt("stockType");
			                comboBox_StockType.setSelectedIndex(2);
			                comboBox_Unit.setSelectedItem(result.getInt("id"));
			                textField_Barcode.setText( result.getString("barcode"));
			                comboBox_KdvType.setSelectedItem(result.getInt("id"));
			                textArea_description.setText( result.getString("description"));
			                formattedTextField_CreationTime.setText(String.valueOf(result.getDate("creationTime")));
			                
			                
			            }
			            result.close();
			            
			            // ResultSet ve diğer kaynakları kapat
			            result.close();
			        } catch (SQLException ex) {
			            ex.printStackTrace();
			        }
			    
	           
			}
		});
		btnCopy.setBounds(702, 311, 89, 23);
		panel.add(btnCopy);
	}
}
