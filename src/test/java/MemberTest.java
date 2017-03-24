import org.junit.*;
import static org.junit.Assert.*;

public class MemberTest {
  Member testMember = new Member("Stormi Hoebe", "Java, JavaScript, UX Design", "Developer");

  @Test
  public void Member_instantiatesAsMember_true(){
    assertEquals(true, testMember instanceof Member);
  }
}
