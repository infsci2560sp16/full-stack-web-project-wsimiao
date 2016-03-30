import java.sql.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

import java.net.URI;
import java.net.URISyntaxException;

import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;
import static spark.Spark.get;

import static javax.measure.unit.SI.KILOGRAM;
import javax.measure.quantity.Mass;
import org.jscience.physics.model.RelativisticModel;
import org.jscience.physics.amount.Amount;
import com.google.gson.Gson;
import com.heroku.sdk.jdbc.DatabaseUrl;
import skinstore.item.service.*;

public class Main {

  public static void main(String[] args) {

    port(Integer.valueOf(System.getenv("PORT")));
    staticFileLocation("/public");

    //this is new added
    new UserController(new UserService());

    get("/hello", (req, res) -> {
          RelativisticModel.select();

          String energy = System.getenv().get("ENERGY");

          Amount<Mass> m = Amount.valueOf(energy).to(KILOGRAM);
          return "E=mc^2: " + energy + " = " + m.toString();
        });

    /*get("/", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("message", "Hello World!");

            return new ModelAndView(attributes, "index.ftl");
        }, new FreeMarkerEngine());*/

    get("/db", (req, res) -> {
      Connection connection = null;
      Map<String, Object> attributes = new HashMap<>();
      try {
        connection = DatabaseUrl.extract().getConnection();

        Statement stmt = connection.createStatement();
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");
        stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
        ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");

        ArrayList<String> output = new ArrayList<String>();
        while (rs.next()) {
          output.add( "Read from DB: " + rs.getTimestamp("tick"));
        }

        attributes.put("results", output);
        return new ModelAndView(attributes, "db.ftl");
      } catch (Exception e) {
        attributes.put("message", "There was an error: " + e);
        return new ModelAndView(attributes, "error.ftl");
      } finally {
        if (connection != null) try{connection.close();} catch(SQLException e){}
      }
    }, new FreeMarkerEngine());

    get("/products", (req, res) -> {
      Connection connection = null;
      Map<String, Object> attributes = new HashMap<>();
      try {
        connection = DatabaseUrl.extract().getConnection();

        Statement stmt = connection.createStatement();
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS products (price int, name varchar(50), category vachar(50), id int, size float, brandName varchar(50), stock int, img varchar(100), detail TEXT, love int,PRIMARY KEY (id)");
        stmt.executeUpdate("INSERT INTO products VALUES (62, 'Luminous Silk Foundation', 'foundation', 1, 1, 'Armani', 20, 'images/0001.jpg', 'This award-winning foundation is formulated with micro-fil technology, producing a low-density product that pairs high-impact pigments with weightless texture. ', 201)");
        ResultSet rs = stmt.executeQuery("SELECT tick FROM products");

        ArrayList<String> output = new ArrayList<String>();
        while (rs.next()) {
          output.add( "Read from DB the name is : " + rs.getTimestamp("name"));
        }

        attributes.put("results", output);
        return new ModelAndView(attributes, "db.ftl");
      } catch (Exception e) {
        attributes.put("message", "There was an error: " + e);
        return new ModelAndView(attributes, "error.ftl");
      } finally {
        if (connection != null) try{connection.close();} catch(SQLException e){}
      }
    }, new FreeMarkerEngine());


         Gson gson = new Gson();

        get("/item", (request,response) -> {
          HashMap model = new HashMap();
          model.put("item_brand","Giorgio Armani");
          model.put("item_name","Luminous Silk Foundation");
          model.put("item_id", "1359553");
          model.put("item_size", "1oz");
          model.put("item_price", "62");
          return new ModelAndView(model,"item.ftl");
        }, new FreeMarkerEngine());

        get("/items",(request,response)->{
          ItemService itemService =  new ItemService();
          Map attributes = new HashMap<>();
          attributes.put("allitems", itemService.getAllItems());
          return new ModelAndView(attributes,"test.ftl");
        }, new FreeMarkerEngine());

        get("/itemsJson",(request,response) ->{
          ItemService itemService = new ItemService();
          return itemService.getItems();
        }, gson::toJson);

  }

}
