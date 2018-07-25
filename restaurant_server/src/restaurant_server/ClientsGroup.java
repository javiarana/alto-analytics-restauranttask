package restaurant_server;

import java.util.Date;

public class ClientsGroup implements Comparable <ClientsGroup>  {
	 
	private  int size=1; // number of clients
	 // up to 6 persons
	private  Table table=null;
	private int id;
	private Date arrivalDateTime;
	 
	public ClientsGroup (int id, int size, Date arrivalDateTime) {
		 this.id = id;
		 this.size = size;
		 this.arrivalDateTime = arrivalDateTime;
	 }
	 public int getId()
	 {
		 return id;
	 }
	  public int getSize()
	 {
		 return size;
	 }
	 public void setTable (Table t)
	 {
		 table=t;
	 }
	 public Table getTable ()
	 {
		 return table;
	 }
	 public Date getArrivalDateTime ()
	 {
		 return arrivalDateTime;
	 }
	  
	@Override
	public int compareTo(ClientsGroup compareGroup) {
		return this.arrivalDateTime.compareTo(compareGroup.getArrivalDateTime());
		
	}
}
