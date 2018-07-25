package restaurant_test;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Printable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import restaurant_server.*;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;


public class Home {

	private JFrame frame;
	private JTextField txtsize2;
	private JTextField txtsize3;
	private JTextField txtsize4;
	private JTextField txtsize5;
	private JTextField txtsize6;
	private JLabel lblStatus;
	private restaurant_server.RestManager restaurant;
	private List<Table> listOftables;
	private List<ClientsGroup> clientsQueue;
	private JLabel lblNewClientGroup;
	private JTextField txtClientGroupSize;
	private JButton btnNewArrival;
	private JTextArea txtAlocationStatus;
	private JScrollPane scrollPane_2;
	private int clientId;
	private JScrollPane scrollPane;
	private JTextArea txtClientsQueue;
	private JLabel lblLeavingClientGroup;
	private JTextField txtLeavingClientGroupId;
	private JButton btnClientLeaves;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblAlocationStatus;
	private JPanel panel_2;
	private JLabel lblClientsOnQueue;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1404, 1032);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("max(80dlu;default)"),
				ColumnSpec.decode("80dlu"),
				ColumnSpec.decode("50dlu:grow"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				RowSpec.decode("40dlu"),
				RowSpec.decode("40dlu"),
				RowSpec.decode("40dlu"),
				RowSpec.decode("40dlu"),
				RowSpec.decode("40dlu"),
				RowSpec.decode("50dlu"),
				RowSpec.decode("default:grow"),
				RowSpec.decode("default:grow"),
				RowSpec.decode("default:grow"),}));
		
		JLabel lblTablesOfSize = new JLabel("Tables of size: 2");
		lblTablesOfSize.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.getContentPane().add(lblTablesOfSize, "1, 1, right, fill");
		
		txtsize2 = new JTextField();
		txtsize2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtsize2.setText("2");
		frame.getContentPane().add(txtsize2, "2, 1, center, center");
		txtsize2.setColumns(10);
		
		
		JButton btnInitializeRestmanager = new JButton("Initialize RestManager");
		btnInitializeRestmanager.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnInitializeRestmanager.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent arg0) {
				
				lblStatus.setText("Initializing");
				/* Initialize client Ids*/
				clientId=0;
				listOftables = null;
				clientsQueue = null;
				listOftables = new ArrayList<Table>();
				clientsQueue = new ArrayList<ClientsGroup>();
				
				/* Initialize list of tables of size 2*/
				int i=0;
				int id=1;
				while (i < Integer.parseInt(txtsize2.getText())) 
				{
					listOftables.add(new restaurant_server.Table(2,id));
					i++;
					id++;
				}
				/* Initialize list of tables of size 3*/
				 i=0;
				while (i < Integer.parseInt(txtsize3.getText())) 
				{
					listOftables.add(new restaurant_server.Table(3,id));
					i++;
					id++;
				}
				/* Initialize list of tables of size 4*/
				i=0;
				while (i < Integer.parseInt(txtsize4.getText())) 
				{
					listOftables.add(new restaurant_server.Table(4,id));
					i++;
					id++;
				}
				/* Initialize list of tables of size 5*/
				i=0;
				while (i < Integer.parseInt(txtsize5.getText())) 
				{
					listOftables.add(new restaurant_server.Table(5,id));
					i++;
					id++;
				}
				/* Initialize list of tables of size 6*/
				i=0;
				while (i < Integer.parseInt(txtsize6.getText())) 
				{
					listOftables.add(new restaurant_server.Table(6,id));
					i++;
					id++;
				}
				restaurant = new  restaurant_server.RestManager(listOftables,clientsQueue);
				lblStatus.setText("Restaurant Manager class initialized!!");		
			}
		});
		frame.getContentPane().add(btnInitializeRestmanager, "6, 1");
		
		JLabel lblTablesOfSize_1 = new JLabel("Tables of size: 3");
		lblTablesOfSize_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.getContentPane().add(lblTablesOfSize_1, "1, 2, right, fill");
		
		txtsize3 = new JTextField();
		txtsize3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtsize3.setText("2");
		frame.getContentPane().add(txtsize3, "2, 2, center, center");
		txtsize3.setColumns(10);
		
		panel = new JPanel();
		panel.setBackground(SystemColor.info);
		frame.getContentPane().add(panel, "6, 2, 3, 1, fill, fill");
		panel.setLayout(new BorderLayout(0, 0));
		
		lblStatus = new JLabel("Waiting");
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblStatus);
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblTablesOfSize_2 = new JLabel("Tables of size 4:");
		lblTablesOfSize_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.getContentPane().add(lblTablesOfSize_2, "1, 3, right, center");
		
		txtsize4 = new JTextField();
		txtsize4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtsize4.setText("2");
		frame.getContentPane().add(txtsize4, "2, 3, center, center");
		txtsize4.setColumns(10);
		
		lblNewClientGroup = new JLabel("Arriving New Client Group Size:");
		lblNewClientGroup.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.getContentPane().add(lblNewClientGroup, "6, 3, left, default");
		
		txtClientGroupSize = new JTextField();
		txtClientGroupSize.setHorizontalAlignment(SwingConstants.RIGHT);
		txtClientGroupSize.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtClientGroupSize.setText("2");
		frame.getContentPane().add(txtClientGroupSize, "7, 3, left, center");
		txtClientGroupSize.setColumns(10);
		
		btnNewArrival = new JButton("Client Arrives");
		btnNewArrival.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewArrival.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				/*Create a new client group and find a table for it */
				clientId ++;
				restaurant_server.ClientsGroup client = new ClientsGroup(clientId, Integer.parseInt(txtClientGroupSize.getText()), new java.util.Date() );
				lblStatus.setText(restaurant.onArrive(client));
				RefreshAlocationStatus();
				RefreshClientsQueue();
			}
		});
		frame.getContentPane().add(btnNewArrival, "8, 3");
		
		JLabel lblTablesOfSize_3 = new JLabel("Tables of size 5:");
		lblTablesOfSize_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.getContentPane().add(lblTablesOfSize_3, "1, 4, right, default");
		
		txtsize5 = new JTextField();
		txtsize5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtsize5.setText("4");
		frame.getContentPane().add(txtsize5, "2, 4, center, center");
		txtsize5.setColumns(10);
		
		lblLeavingClientGroup = new JLabel("Leaving Client Group Id:");
		lblLeavingClientGroup.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.getContentPane().add(lblLeavingClientGroup, "6, 4, left, default");
		
		txtLeavingClientGroupId = new JTextField();
		txtLeavingClientGroupId.setHorizontalAlignment(SwingConstants.RIGHT);
		txtLeavingClientGroupId.setText("2");
		txtLeavingClientGroupId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtLeavingClientGroupId.setColumns(10);
		frame.getContentPane().add(txtLeavingClientGroupId, "7, 4, left, center");
		
		btnClientLeaves = new JButton("Client Leaves");
		btnClientLeaves.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Find if the leaving client was on queue or sitting in a table
				//Was client already sat on a table?
				ClientsGroup group;
				group = restaurant.getClientFromListOfTablesUsingId(Integer.parseInt(txtLeavingClientGroupId.getText()), listOftables );
				
				if (group==null)
				{
					//Client is not on a table
					lblStatus.setText("There is no such Id in any table.Id: " + txtLeavingClientGroupId.getText());
					//Was client waiting on queue?
					 group = restaurant.getClientFromQueueUsingId(Integer.parseInt(txtLeavingClientGroupId.getText()), clientsQueue );
					if (group==null)
					{
						//Client is not on queue
						lblStatus.setText("There is no such Id in the clients queue list.Id: " + txtLeavingClientGroupId.getText());
						}
					
					else
						{
							//Client is on queue
							lblStatus.setText("Leaving client Id: " + String.valueOf(group.getId()));
							restaurant.onLeave(group);
						}
					
					}
				
				else
					{
						//Client is on a table
						lblStatus.setText("Leaving client was on a table. Id: " + String.valueOf(group.getId()));
						restaurant.onLeave(group);
					}
							
			RefreshAlocationStatus();
			RefreshClientsQueue();
			}
		});
		
		btnClientLeaves.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.getContentPane().add(btnClientLeaves, "8, 4");
		
		
		JLabel lblTablesOfSize_4 = new JLabel("Tables of size 6:");
		lblTablesOfSize_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.getContentPane().add(lblTablesOfSize_4, "1, 5, right, default");
		
		txtsize6 = new JTextField();
		txtsize6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtsize6.setText("4");
		frame.getContentPane().add(txtsize6, "2, 5, center, center");
		txtsize6.setColumns(10);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(Color.WHITE);
		frame.getContentPane().add(panel_1, "2, 6, 3, 1, fill, bottom");
		
		lblAlocationStatus = new JLabel("Alocation Status");
		lblAlocationStatus.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_1.add(lblAlocationStatus);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBackground(Color.WHITE);
		frame.getContentPane().add(panel_2, "6, 6, 6, 1, fill, bottom");
		
		lblClientsOnQueue = new JLabel("Clients On Queue");
		lblClientsOnQueue.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_2.add(lblClientsOnQueue);
		
		scrollPane_2 = new JScrollPane();
		frame.getContentPane().add(scrollPane_2, "2, 7, 3, 3, fill, fill");
		
		txtAlocationStatus = new JTextArea();
		scrollPane_2.setViewportView(txtAlocationStatus);
		txtAlocationStatus.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, "6, 7, 6, 3, fill, fill");
		
		txtClientsQueue = new JTextArea();
		scrollPane.setViewportView(txtClientsQueue);
		txtClientsQueue.setFont(new Font("Tahoma", Font.PLAIN, 18));
	}
private void RefreshAlocationStatus() {
	txtAlocationStatus.setText("");
	if (listOftables==null)	{
		lblStatus.setText("First initialize the RestManager!");
		return;
	}
	
	//Lets sort the list by Id in order to be easier to check results
    Collections.sort(listOftables, new Table());
    for(Table t: listOftables) {   
    	txtAlocationStatus.append("Table id: " + String.valueOf(t.getId()) + " Size: " + String.valueOf(t.getSize()) + " FreeChairs: " + String.valueOf(t.getFreeChairs()) + " ClientIds: " + t.getClientIds() + "\n");
		}
	//Sort again to original order
    Collections.sort(listOftables);
	}
private void RefreshClientsQueue() {
	txtClientsQueue.setText("");
	if (clientsQueue==null)	{
		lblStatus.setText("First initialize RestManager!");
		return;
	}

	lblStatus.setText("ClientsQueue Size:" + clientsQueue.size());
	for(ClientsGroup client: clientsQueue) {  
		txtClientsQueue.append("Client group id:" + String.valueOf(client.getId()) + " Arrival time:" + String.valueOf(client.getArrivalDateTime()) + " Size:" + String.valueOf(client.getSize()) + "\n");
		}	
	}
}
