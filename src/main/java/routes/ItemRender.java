package routes;

import com.google.gson.Gson;
import java.sql.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Date;
import java.util.*;
import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;
import static spark.Spark.get;
import skinstore.item.service.*;
import com.heroku.sdk.jdbc.DatabaseUrl;
import spark.Request;
import org.json.*;
import static spark.Spark.*;

public class ItemRender{

  Gson gson = new Gson();
  UserService userService = new UserService();
  List<User> userList = userService.getUsers();

  public ItemRender() {
      setupRoutes();
  }

  private void setupRoutes(){
    get("/skinstore/item123", (request,response) -> {
        Map<String, Object> model = new HashMap<>();
        model.put("item_brand","Giorgio Armani");
        model.put("item_name","Luminous Silk Foundation");
        model.put("item_id", "1359553");
        model.put("item_size", "1oz");
        model.put("item_price", "62");
        return new ModelAndView(model,"item.ftl");
    }, new FreeMarkerEngine());

    // get("/skinstore/foundations", (request,response) -> {
    //     ItemService itemService = new ItemService();
    //     Map attributes = new HashMap<>();
    //     attributes.put("allitems",itemService.getAllItems());
    //     return new ModelAndView(attributes,"foundations.ftl");
    // }, new FreeMarkerEngine());

    get("/skinstore/items",(request,response)->{
        	ItemService itemService =  new ItemService();
        	Map attributes = new HashMap<>();
        	attributes.put("allitems", itemService.getAllItems());
        	return new ModelAndView(attributes,"test.ftl");
        }, new FreeMarkerEngine());


    post("/skinstore/adduser",(request, response) -> {
      
      Connection connection = null;
      //System.out.println(request.body());
      try{
        //connection = DatabaseUrl.extract().getConnection();
        JSONObject obj = new JSONObject(request.body());
        String firstName = obj.getString("firstName");
        String lastName = obj.getString("lastName");
        String email = obj.getString("email");
        String password = obj.getString("password");
        System.out.print("connected to server"+ email);
        String suc = "Success";
        connection = DatabaseUrl.extract().getConnection();
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS users (firstname varchar(40), lastname varchar(40), email varchar(40), password varchar(40))");
            stmt.executeUpdate("INSERT INTO users VALUES ('"+firstName+"', '"+lastName+"','"+email+"','"+password+"')");
            //stmt.executeUpdate(""); 
        return request.body();
      
      }catch(Exception e ){
        response.status(500);
        return e.getMessage();
      }finally {
        response.status(500);
        if (connection != null) try{connection.close();} catch(SQLException e){}
      }
      
    });

    post("/skinstore/loginuser", (request, response) -> {
      String body = request.body();
      JSONObject obj = new JSONObject(body);
      String username = obj.getString("email");  //
      String password = obj.getString("password");
      String loginSuc = "You just log in Successfully";
      String loginerr = "the password does not match";
      String loginfind = "The user does not exist";
      for(User user:userList){
        if(user.getUserEmail().equals(username)){
          if(user.getUserPass().equals(password)){
            System.out.print("ok");
            return loginSuc;
          }else{
            return loginerr;
          }
        }
      }
      return loginfind;   
      
    }, gson::toJson);
    




  }

}
