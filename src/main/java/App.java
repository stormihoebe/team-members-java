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

    get("/about", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/about.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


    get("/teams/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/team-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  post("/teams", (request, response) -> {
    Map<String, Object> model = new HashMap<String, Object>();
    String name = request.queryParams("teamName");
    String location = request.queryParams("location");
    String goal = request.queryParams("goal");
    Team newTeam = new Team(name, location, goal);
    model.put("template", "templates/team-success.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  get("/teams", (request, response) -> {
    Map<String, Object> model = new HashMap<String, Object>();
    model.put("template", "templates/teams.vtl");
    model.put("teams", Team.all());
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  get("/teams/:id", (request, response) ->{
    Map<String, Object> model = new HashMap<String, Object>();
    Team team = Team.find(Integer.parseInt(request.params(":id")));
    model.put("template", "templates/team.vtl");
    model.put("team", team);
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  get("/teams/:id/members/new", (request, response) ->{
    Map<String, Object> model = new HashMap<String, Object>();
    Team team = Team.find(Integer.parseInt(request.params(":id")));
    model.put("template", "templates/team-members-form.vtl");
    model.put("team", team);
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  post("/teams/:id/heroes", (request, response) -> {
    Map<String, Object> model = new HashMap<String, Object>();
    Team team = Team.find(Integer.parseInt(request.params(":id")));
    String name = request.queryParams("name");
    String skills = request.queryParams("skills");
    String role = request.queryParams("role");
    Member newMember = new Member( name, skills, role);
    team.addMember(newMember);
    model.put("team", team);
    model.put("template", "templates/team-members-success.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  get("/teams/:id1/members/:id2", (request, response) ->{
    Map<String, Object> model = new HashMap<String, Object>();
    Team team = Team.find(Integer.parseInt(request.params(":id1")));
    Member member = Member.find(Integer.parseInt(request.params(":id2")));
    model.put("team", team);
    model.put("member", member);
    model.put("template", "templates/member.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  }
}
