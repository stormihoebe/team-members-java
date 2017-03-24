import java.util.ArrayList;
import java.util.List;

public class Member {
  private String mMemberName;
  private String mSkills;
  private String mRole;
  private static List<Member> instances = new ArrayList<Member>();
  private int mId;


  public Member(String name, String skills, String roll){
    mMemberName = name;
    mSkills = skills;
    mRole = roll;
    instances.add(this);
    mId = instances.size();
  }

  public String getMemberName(){
    return mMemberName;
  }
  public String getSkills(){
    return mSkills;
  }
  public String getRole(){
    return mRole;
  }

  public static List<Member> all(){
    return instances;
  }

  public static void clear(){
  instances.clear();
  }

  public int getId(){
    return mId;
  }

  public static Member find(int id){
    try{
      return instances.get(id - 1);
    } catch (IndexOutOfBoundsException exception) {
      return null;
    }
  }
}
