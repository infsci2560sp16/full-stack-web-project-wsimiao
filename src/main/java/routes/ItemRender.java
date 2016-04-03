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
      
        //connection = DatabaseUrl.extract().getConnection();
        JSONObject obj = new JSONObject(request.body());
        String firstName = obj.getString("firstName");
        String lastName = obj.getString("lastName");
        String email = obj.getString("email");
        String password = obj.getString("password");
        System.out.print("connected to server"+ email);
        String suc = "Success";
        
      
      return suc;
      
    }, gson::toJson);


  }

}
