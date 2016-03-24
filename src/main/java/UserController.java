import static spark.Spark.*;
import spark.*;


public class UserController {
	public UserController(final UserService userService){
		get("/users", new Route(){
			@Override
			public Object handle(Request request, Response response){
				return  userService.getAllUsers();
			}
		});
	}

}
