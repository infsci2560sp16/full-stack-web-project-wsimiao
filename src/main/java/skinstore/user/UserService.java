package skinstore.user;
import java.util.*;

public class UserService {
	private List<User> userService = new ArrayList<User>();
	public UserService(){
		addUsers();
	}
	public void addUsers(){
		userService.add(new User("simiao@pitt.edu","123456"));
		userService.add(new User("gaole@pitt.edu","012345"));
	}
	public List<User> getUsers(){
		return userService;
	}
	

}
