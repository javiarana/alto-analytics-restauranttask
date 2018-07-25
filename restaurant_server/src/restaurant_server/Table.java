package restaurant_server;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Table implements Comparable <Table>, Comparator <Table>
{
	private int id;
	private int size=0; 
	private int freechairs=0;
	// Each table can accommodate 2, 3, 4, 5 or 6 persons
	private  List<ClientsGroup> groups;// Lets use a list to register which groups are in each table
	
	public Table() {
	}
	
	public Table(int s, int number)
	{
		//Create a table of size s 
		size = s;
		freechairs = s;
		id = number;
		groups = new ArrayList <ClientsGroup>();
	}
	public int getSize () 
	{
	return size;	
	}
	public int getId () 
	{
	return id;	
	}
	
	public int getFreeChairs () 
	{
	return freechairs;	
	}
	public void accomodateGroup(ClientsGroup g)
	{
		groups.add(g); // Add a group to the list of groups related to this table
		g.setTable(this); //Add the table reference to the group itself
		freechairs = freechairs - g.getSize(); // Decrease the number of free chairs on this table
		
	}
	public void removeGroup(ClientsGroup g)
	{
		groups.remove(g);
		freechairs = freechairs + g.getSize(); //If the group is removed from the table, we have to update the number of free chairs
		
		
	}
	public List<ClientsGroup> getGroups()
	{
		return groups;
	}
	
	
	public int compareTo(Table compareTable) 
	{
		//Compare in descending order by number of freechairs and in ascending by number of Ids
		int result = 0;
		result = compareTable.getFreeChairs() - this.freechairs;
	     if (result == 0) {
	        result = compareTable.id - this.id;
	     }
	     return result;
	}
	 public int compare(Table t1, Table t2) {
	      return t1.getId() - t2.getId();
	   }
	 
	public ClientsGroup getClientUsingId (int Id)
	{
		 Iterator<ClientsGroup> iterator = groups.iterator();
		    
		 while (iterator.hasNext()) {
			 ClientsGroup c = iterator.next();
		     if ( c.getId()==Id) {
		    	 // We found the client
		        return c; 
		     }
		 }     	
		return null;
	}

	public String getClientIds()
	{
		String s="";
		Iterator<ClientsGroup> iterator = groups.iterator();
	    
		 while (iterator.hasNext()) {
			 ClientsGroup c = iterator.next();
		     s = s + String.valueOf(c.getId()) + " , ";
		     }
		return s;
	}
}


