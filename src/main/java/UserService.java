import java.util.*;

public class UserService {
	private List<User> users = new ArrayList<>();
	public UserService(){
		users.add(new User("1","g","g@gmail.com"));
		users.add(new User("2","m","m@gmail.com"));
		
	}
	
	
	public List<User> getAllUsers(){
		return users;
		
	}




}
