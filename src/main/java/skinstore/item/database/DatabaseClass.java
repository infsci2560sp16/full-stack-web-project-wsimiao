package skinstore.item.database;
import java.util.*;



import skinstore.item.model.Item;;

public class DatabaseClass {
	private static Map <Long, Item > items = new HashMap<>();
	
	public static Map<Long, Item> getMessages(){
		return items;
	}

}
