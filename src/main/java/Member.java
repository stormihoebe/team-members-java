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
    mId = instances.size();
  }
}
