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

public class ItemRender{

  private static boolean shouldReturnHtml(Request request) {
      String accept = request.headers("Accept");
      return accept != null && accept.contains("text/html");
  }

  Gson gson = new Gson();

  public ItemRender() {
      setupRoutes();
  }

  private void setupRoutes(){
    get("/item", (request,response) -> {
        HashMap model = new HashMap();
        model.put("item_brand","Giorgio Armani");
        model.put("item_name","Luminous Silk Foundation");
        model.put("item_id", "1359553");
        model.put("item_size", "1oz");
        model.put("item_price", "62");
        model.put("item_img", "images/0001.jpg");
        return new ModelAndView(model,"item.ftl");
    }, new FreeMarkerEngine());








  }

}
