package restaurant_server;

import java.util.Iterator;
import java.util.List;


public class RestManager
{
	private List<ClientsGroup>  clientsQueue;
	
	private List<Table> listOftables;
	
	public RestManager (List<Table> tables, List<ClientsGroup> clients)
	   
	{
      	// Lets create the queue for client accommodation and initialize the list of tables
		listOftables = tables;
		listOftables.sort(null);
		clientsQueue= clients;
		clientsQueue.sort(null);
   }
	
  	// new client(s) show up
   	public String onArrive (ClientsGroup group)
   
	{
   		
   		//Client groups must be served in the order of arrival with one exception: if there is enough room at a table for a smaller group 
		//arriving later, you can seat them before the larger group(s) in the queue. 
   		String strResponse = "";
      
		//If there is a suitable table accommodate the client
		Table t = this.lookup(group);
		if (t==null)
		{
			// There is no free table, so wait on queue
			clientsQueue.add(group);
			strResponse = "Sorry, there is no free table. Wait on queue.";
			}
		else
		{
			
			// There is a suitable table, so accommodate on table
			t.accomodateGroup(group);
			strResponse = "Welcome! There is a free table. Table id: " + String.valueOf(t.getId());
			// Sort list of tables so that always are in descending order regarding to free chairs
			listOftables.sort(null);
			}
		return strResponse;
   }

   	// client(s) leave, either served or simply abandoning the queue
   
	public  void onLeave (ClientsGroup group)
   
	{
		Table t = group.getTable();
      // If the clients where occupying a table, free their chairs 
	  // Groups can be either in the queue or dining in a table
		if (t!=null)
		{
			t.removeGroup(group);
			
			//And process remaining groups to see if now the table where the group was can accomodate any other group that is waiting on  queue
			
			ClientsGroup g = null;
			int i = 0;
			while(i < clientsQueue.size())
			{
			    g = clientsQueue.get(i);
			    if (g.getSize() <=t.getFreeChairs())
			    {
			    	//The table still has enough space for the group
			    	//We can accommodate as many groups as the table can hold
			    	t.accomodateGroup(g);
			    	// Remove the group from the original priority queue
			    	clientsQueue.remove(g); 
			    	
			    }
			    if (t.getFreeChairs()==0) 
			    {
			    	//There is no more free space in the table
			    	break;
			    }
			    i++;
			}
			// Sort list of tables so that always are in descending order regarding to free chairs
			listOftables.sort(null);
		}
		
		else
		{
			//Clients where just waiting on queue, so remove from it
			clientsQueue.remove(group);
			
		}
	  
	
   }

   	
private Table lookup (ClientsGroup group)
   
	{
		Table t = null;
		// Return a table to accommodate a group, or null if there is no free space
		// Look first for "smallest", "empty tables" with enough free chairs for the group
		t = findsmallestemptytable(group);
		if (t==null)
		{
			//No empty table available, so lets find a shared table
			t = findsmallestsharedtable(group);
		}
		return t;
	}

private Table findsmallestemptytable(ClientsGroup group)
{
	Table t=null;
	int i = 0;
	int neededsize = group.getSize();
	if (this.listOftables.isEmpty()) 
	{
		return null;
	}
	
	Table smallestemptytable = null;
	while (i < listOftables.size()) 
	{
		t = listOftables.get(i);
		if (t.getFreeChairs() < neededsize)
		{
			break; //As list of tables is sorted, break when there is no enough space in a table
		} 
		
		if (t.getSize()== t.getFreeChairs()) 
		{ 
			//Just looking for empty tables
			smallestemptytable=t;
		}
				
		i++;
	}
	return smallestemptytable;
}
private Table findsmallestsharedtable(ClientsGroup group)
{
	Table t=null;
	int i = 0;
	int neededsize = group.getSize();
	if (this.listOftables.isEmpty()) 
	{
		return null;
	}
	
	Table smallestsharedtable = null;
	while (i < listOftables.size()) 
	{
		t = listOftables.get(i);
		if (t.getFreeChairs() < neededsize)
		{
			break; //As list of tables is sorted, break when there is no enough space in a table
		} 
		
		if (t.getSize()> t.getFreeChairs()) 
		{ 
			//Just looking for shared tables
			smallestsharedtable=t;
		}
				
		i++;
	}
	return smallestsharedtable;
}
public ClientsGroup getClientFromQueueUsingId(int Id, List<ClientsGroup> clients) {
		    Iterator<ClientsGroup> iterator = clients.iterator();
		    while (iterator.hasNext()) {
		        ClientsGroup client = iterator.next();
		        if (client.getId() == Id) {
		            return client;
		        }
		    }
		    return null;
		}
public ClientsGroup getClientFromListOfTablesUsingId(int Id, List<Table> tables) {
    Iterator<Table> iterator = tables.iterator();
    ClientsGroup c = null;
    while (iterator.hasNext()) {
        Table t = iterator.next();
        // A table can contain more than one group of clients
        c = t.getClientUsingId(Id);
        if ( c != null) {
        	// We found the client
        	return c; 
        }
                
    }
    return c;	
 }
    
}
