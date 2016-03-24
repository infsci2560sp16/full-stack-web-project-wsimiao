
import static spark.Spark.*;

import routes.*;

public class Main {

  public static void main(String[] args) {

    port(Integer.valueOf(System.getenv("PORT")));
    staticFileLocation("/public");

    //Object r = new JavaGettingStarted();
    //Object r = new Week6Routes();
    //Object r = new Week7Routes();
    Object r = new Week8Routes();
  }

}
