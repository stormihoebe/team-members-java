import java.util.List;
import java.util.ArrayList;

public class Team {
  private String mTeamName;
  private String mLocation;
  private String mProjectGoal;
  private static List<Team> instances = new ArrayList<Team>();
  private int mId;
  private List<Member> mMembers;

  public Team(String name, String location, String goal){
    mTeamName = name;
    mLocation = location;
    mProjectGoal = goal;
    instances.add(this);
    mId = instances.size();
    mMembers = new ArrayList<Member>();
  }

  public String getTeamName(){
    return mTeamName;
  }

  public String getLocation(){
    return mLocation;
  }

  public String getProjectGoal(){
    return mProjectGoal;
  }

  public static List<Team> all(){
    return instances;
  }

  public static void clear(){
    instances.clear();
  }

  public int getId(){
    return mId;
  }

  public static Team find(int id) {
    try{
      return instances.get(id - 1);
    } catch (IndexOutOfBoundsException exception){
      return null;
    }
  }

  public List<Member> getMembers() {
    return mMembers;
  }

  public void addMember( Member member){
    mMembers.add(member);
  }

}
