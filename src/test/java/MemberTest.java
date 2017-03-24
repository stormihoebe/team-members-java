import org.junit.*;
import static org.junit.Assert.*;

public class MemberTest {
  Member testMember = new Member("Stormi Hoebe", "Java, JavaScript, UX Design", "Developer");

  @Test
  public void Member_instantiatesAsMember_true(){
    assertEquals(true, testMember instanceof Member);
  }

  @Test
  public void Member_instantiatesWithName_nameString(){
    assertEquals("Stormi Hoebe", testMember.getMemberName());
  }

  @Test
  public void Member_instantiatesWithSkills_skillsString(){
    assertEquals("Java, JavaScript, UX Design", testMember.getSkills());
  }

  @Test
  public void Member_instantiatesWithRole_roleString(){
    assertEquals("Developer", testMember.getRole());
  }

  @Test
  public void all_returnsAllInstancesOfMember_true(){
    Member testMember2 = new Member("Test Name", "Test Skill Set", "Test Roll");
    assertEquals(true, Member.all().contains(testMember));
    assertEquals(true, Member.all().contains(testMember2));
  }

  @Test
  public void clear_emptiesAllInstancesofMemberfromArrayList_true() {
    Member testMember2 = new Member("Test Name", "Test Skill Set", "Test Roll");    Member.clear();
    assertEquals(0, Member.all().size());
  }

  @Test
  public void getId_memberInstantiatesWithID_1(){
    Member.clear();
    Member testMember2 = new Member("Test Name", "Test Skill Set", "Test Roll");
    assertEquals(1, testMember2.getId());
  }

  @Test
  public void find_returnsMemberWithSameID_testMember() {
    Member.clear();
    Member testMember = new Member("Test Name", "Test Skill Set", "Test Roll");
    assertEquals(Member.find(testMember.getId()), testMember);
  }
}
