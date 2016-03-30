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

import com.heroku.sdk.jdbc.DatabaseUrl;
import spark.Request;

public class ItemRoutes {

    private static boolean shouldReturnHtml(Request request) {
        String accept = request.headers("Accept");
        return accept != null && accept.contains("text/html");
    }

    Gson gson = new Gson();

    public ItemRoutes() {
        setupRoutes();
    }

    private void setupRoutes() {
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

      get("/skinstore/getItemsJson", (req, res) -> {
        Connection connection = null;
        Map<String, Object> attributes = new HashMap<>();
        try {
          connection = DatabaseUrl.extract().getConnection();
          Statement stmt = connection.createStatement();
          ResultSet rs = stmt.executeQuery("SELECT * FROM products");
          ResultSetMetaData rsmd = rs.getMetaData();
          int columnCount = rsmd.getColumnCount();
          List<Object> output = new ArrayList<>();
          while (rs.next()) {
            Map<String, Object> aRow = new HashMap<>();
            for(int i =1; i<= columnCount; i++){
              aRow.put(rsmd.getColumnName(i), rs.getObject(i));
            }
            output.add(aRow);
          }
          return output;
        } catch (Exception e) {
          attributes.put("message", "There was an error: " + e);
          return new ModelAndView(attributes, "error.ftl");
        } finally {
          if (connection != null) try{connection.close();} catch(SQLException e){}
        }
      }, gson::toJson);


        get("/api/slide15", (req, res) -> {
            Map<String, Object> data = new HashMap<>();
            data.put("format", "json");
            data.put("status", "live");
            return data;
        }, gson::toJson);

        get("/api/slide23", (req, res) -> {
            res.status(302);
            Map<String, Object> data = new HashMap<>();
            data.put("format", "json");
            data.put("status", "live");
            return data;
        }, gson::toJson);

        get("/api/slide27", (req, res) -> {
            Map<String, Object> data = new HashMap<>();
            data.put("status", "live");
            data.put("now", new Date());

            if (shouldReturnHtml(req)) {
                res.status(200);
                return "<pre>" + data + "</pre>";

            } else {
                res.status(200);
                return gson.toJson(data);
            }
        });

        get("/api/slide29", (req, res) -> {
            Map<String, Object> data = new HashMap<>();
            data.put("status", "live");
            data.put("now", new Date());

            if (shouldReturnHtml(req)) {
                res.status(200);
                res.type("text/html");
                return "<pre>" + data + "</pre>";

            } else {
                res.status(200);
                res.type("application/json");
                return gson.toJson(data);
            }
        });

        get("/api/slide31", (req, res) -> {
            Map<String, Object> data = new HashMap<>();
            data.put("status", "live");
            data.put("now", new Date());

            String xml =    "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                            "<note>" +
                                "<to>You</to>" +
                                "<from>Me</from>" +
                                "<heading>Reminder</heading>" +
                                "<body>Don't forget me this weekend!</body>" +
                            "</note>";
            res.type("text/xml");
            return xml;
        });
  }
}
