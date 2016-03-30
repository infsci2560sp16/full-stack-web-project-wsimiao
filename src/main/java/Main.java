import static spark.Spark.*;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

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

public class Main {

  public static void main(String[] args) {

    port(Integer.valueOf(System.getenv("PORT")));
    staticFileLocation("/public");

    //this is new added
    //new UserController(new UserService());



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

    get("/insertItems", (req, res) -> {
      Connection connection = null;
      Map<String, Object> attributes = new HashMap<>();
      try {
        connection = DatabaseUrl.extract().getConnection();

        Statement stmt = connection.createStatement();
        // stmt.executeUpdate("CREATE TABLE IF NOT EXISTS products (price int, name varchar(50), category varchar(50), id int, size float, brandName varchar(50), stock int, img varchar(100), detail varchar(200), love int");
        // stmt.executeUpdate("INSERT INTO products VALUES (62, 'Luminous Silk Foundation', 'foundation', 1, 1.0, 'Armani', 20, 'images/0001.jpg', 'This award-winning foundation ', 201)");
        // stmt.executeUpdate("INSERT INTO products VALUES (39, 'Rainforest of the Sea Water Foundation Broad Spectrum SPF 15', 'foundation', 2, 1.0, 'tarte', 15, 'images/0002.jpg', 'A lightweight, full-coverage hydrating foundation ', 100000)");
        // stmt.executeUpdate("CREATE TABLE IF NOT EXISTS items (itemID int, itemName varchar(100), itemBrand varchar(100), itemCategory varchar(100), itemDescription varchar(200), itemColor varchar(50), itemRating float, itemStock int, itemGender varchar(20), itemSize float)");
        // stmt.executeUpdate("INSERT INTO items VALUES (000001, 'Air Jordan 1', 'Air Jordan', 'Basketball shoes', 'The first generation of Jordan shoes', 'Black/Red', 5.0, 5, 'Male', 9.0)");
        // stmt.executeUpdate("INSERT INTO items VALUES (000002, 'Kobe XI', 'NIKE KOBE', 'Basketball shoes', 'The last generation of Nike Kobe shoes', 'Yellow/Purple', 4.9, 10, 'Male', 8.5)");

        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS products (itemID int, itemPrice int, itemName varchar(100), itemBrand varchar(100), itemCategory varchar(100), itemDescription varchar(200), itemColor varchar(50), itemLove int, itemStock int, itemGender varchar(20), itemSize float, itemImg varchar(100))");
        stmt.executeUpdate("INSERT INTO products VALUES (000001, 62,  'Luminous Silk Foundation', 'Armarni', 'Foundation', 'This is an award-winning foundation', 'Ivory', 2000, 5, 'Female', 1.0,'images/0001.jpg')");
        stmt.executeUpdate("INSERT INTO products VALUES (000002, 39, 'Rainforest of Seawater Foundation', 'Tarte', 'Foundation', 'A lightweight, full-coverage foundation', 'Ivory', 1000, 10, 'Female', 1.0, 'images/0002.jpg')");

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


  }

}
