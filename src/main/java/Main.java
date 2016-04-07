import static spark.Spark.*;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;
import spark.*;
import java.sql.*;
import java.util.*;
import com.google.gson.Gson;
import com.heroku.sdk.jdbc.DatabaseUrl;

import skinstore.item.service.*;

import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import routes.*;

public class Main {

  public static void main(String[] args) {

    port(Integer.valueOf(System.getenv("PORT")));
    staticFileLocation("/public");

    Object r = new ItemRoutes();
    Object r2 = new ItemRender();
    //////try sdd

    //this is new added
    //new UserController(new UserService());



    /*get("/", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("message", "Hello World!");

            return new ModelAndView(attributes, "index.ftl");
        }, new FreeMarkerEngine());*/

    // get("/db", (req, res) -> {
    //   Connection connection = null;
    //   Map<String, Object> attributes = new HashMap<>();
    //   try {
    //     connection = DatabaseUrl.extract().getConnection();
    //
    //     Statement stmt = connection.createStatement();
    //     stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");
    //     stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
    //     ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");
    //
    //     ArrayList<String> output = new ArrayList<String>();
    //     while (rs.next()) {
    //       output.add( "Read from DB: " + rs.getTimestamp("tick"));
    //     }
    //
    //     attributes.put("results", output);
    //     return new ModelAndView(attributes, "db.ftl");
    //   } catch (Exception e) {
    //     attributes.put("message", "There was an error: " + e);
    //     return new ModelAndView(attributes, "error.ftl");
    //   } finally {
    //     if (connection != null) try{connection.close();} catch(SQLException e){}
    //   }
    // }, new FreeMarkerEngine());

    // get("/insertItems", (req, res) -> {
    //   Connection connection = null;
    //   Map<String, Object> attributes = new HashMap<>();
    //   try {
    //     connection = DatabaseUrl.extract().getConnection();
    //
    //     Statement stmt = connection.createStatement();
    //
    //     // stmt.executeUpdate("CREATE TABLE IF NOT EXISTS items (itemID int, itemName varchar(100), itemBrand varchar(100), itemCategory varchar(100), itemDescription varchar(200), itemColor varchar(50), itemRating float, itemStock int, itemGender varchar(20), itemSize float)");
    //
    //
    //     stmt.executeUpdate("INSERT INTO products VALUES (3, 62,  'Diorskin Forever Flawless Wear Makeup', 'Dior', 'Foundation', 'A couture inspire liquid foundation', 'Ivory', 3000, 25, 'Female', 1.0,'images/0003.jpg')");
    //     stmt.executeUpdate("INSERT INTO products VALUES (4, 35, 'Lock it Foundation', 'Kat Von D', 'Foundation', 'A high pigment foundation for full coverage', 'Ivory', 1500, 10, 'Female', 1.0, 'images/0004.jpg')");
    //     stmt.executeUpdate("INSERT INTO products VALUES (5, 43,  'Ultra HD Invisible Cover Foundation', 'Make Up For Ever', 'Foundation', 'A bestselling HD foundation', 'Ivory', 3500, 25, 'Female', 1.0,'images/0005.jpg')");
    //     stmt.executeUpdate("INSERT INTO products VALUES (6, 38, 'Double Wear Stay in Foundation', 'Estee Lauder', 'Foundation', 'A 15 hour flawless foundation', 'Deep', 1500, 10, 'Female', 1.0, 'images/0006.jpg')");
    //
    //
    //     ResultSet rs = stmt.executeQuery("SELECT * FROM products");
    //
    //     ArrayList<String> output = new ArrayList<String>();
    //     while (rs.next()) {
    //       output.add( "Read from DB the name is : " + rs.getString("itemBrand"));
    //     }
    //     attributes.put("results", output);
    //     return new ModelAndView(attributes, "db.ftl");
    //   } catch (Exception e) {
    //     attributes.put("message", "There was an error: " + e);
    //     return new ModelAndView(attributes, "error.ftl");
    //   } finally {
    //     if (connection != null) try{connection.close();} catch(SQLException e){}
    //   }
    // }, new FreeMarkerEngine());

    //get Items from Heroku database and render use teachers' template

    get("/skinstore/getItems", (req, res) -> {
      Connection connection = null;
      Map<String, Object> attributes = new HashMap<>();
      try {
        connection = DatabaseUrl.extract().getConnection();

        Statement stmt = connection.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT * FROM products");

        ArrayList<String> output = new ArrayList<String>();
        while (rs.next()) {
          output.add( "Read from DB the name is : " + rs.getString("itemBrand"));
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

    get("/Jsons", new Route() {
        @Override
        public Object handle(Request request, Response response) {
        	ItemService itemservice = new ItemService();
          // process request
          return new Gson().toJson(itemservice.getAllItems());
        }
      });
///add new 
    }

}
