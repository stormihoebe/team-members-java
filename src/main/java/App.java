import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    //Default Teams

    Team teamRocket = new Team("Team Rocket", "The Moon", "Terraform Mars");
    Member jessie = new Member("Jessie", "Rocket Science, Engineering", "Group Lead");
    Member james = new Member ("James", "Space Enthusiast, Robotics Engineer", "Engineering Coordinator");
    teamRocket.addMember(jessie);
    teamRocket.addMember(james);

    Team avengers = new Team("The Avengers", "USA", "Protect earth from threats");
    Member cap = new Member("Captain America", "American History, Super Strength", "Group Lead");
    Member iron = new Member("Iron Man", "Weapons Engineering, Electricity Production", "Weapons Developer");
    Member widow = new Member("Black Widow", "Espionage, Ninja Skills", "Project Manager");
    avengers.addMember(cap);
    avengers.addMember(iron);
    avengers.addMember(widow);
    //index
    get("/", (request, response) -> {
    Map<String, Object> model = new HashMap<String, Object>();
    model.put("template", "templates/index.vtl");
    model.put("teams", Team.all());
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  }

}
