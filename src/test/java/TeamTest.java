import org.junit.*;
import static org.junit.Assert.*;

public class TeamTest {
  Team testTeam = new Team("Dream Team", "La La Land", "Make everything decent for once");

  @Test
  public void team_instantiatesCorrectly_true(){
    assertEquals(true, testTeam instanceof Team);
  }

  @Test
  public void getTeamName_TeamInstantiatesWithName_nameString(){
    assertEquals("Dream Team", testTeam.getTeamName());
  }

  @Test
  public void getLocation_TeamInstantiatesWithLocation_locationString(){
    assertEquals("La La Land", testTeam.getLocation());
  }

  @Test
  public void getProjectGoal_TeamInstantiatesWithGoal_goalString(){
    assertEquals("Make everything decent for once", testTeam.getProjectGoal());
  }

  @Test
  public void all_returnsAllInstancesOfTeam_true(){
    Team testTeam2 = new Team("Dream Team", "Low Land", "Also Make everything decent for once");
    assertTrue(Team.all().contains(testTeam));
    assertTrue(Team.all().contains(testTeam2));
  }

  @Test
  public void clear_emptiesAllTeamsFromList_0(){
    Team testTeam2 = new Team("Dream Team", "Low Land", "Also Make everything decent for once");
    Team.clear();
    assertEquals(0, Team.all().size());
  }

  @Test
  public void getId_teamInstantiatesWithAnID_1(){
    Team.clear();
    Team testTeam2 = new Team("Dream Team", "Low Land", "Also Make everything decent for once");
    assertEquals(1, testTeam2.getId());
  }

  @Test
  public void find_returnsTeamWithSameId_secondTeam(){
    Team.clear();
    Team testTeam = new Team("Dream Team1", "La La Land", "Make everything decent for once");
    Team testTeam2 = new Team("Dream Team2", "Low Land", "Also Make everything decent for once");
    assertEquals(Team.find(testTeam.getId()), testTeam);
  }


  @Test
  public void getMembers_initiallyReturnsEmptyList_EmptyArryList(){
    Team.clear();
    Team testTeam = new Team("Dream Team1", "La La Land", "Make everything decent for once");
    assertEquals(0, testTeam.getMembers().size());
  }

  @Test
  public void addMember_addsMemberToTeam_true(){
    Member testMember = new Member("Stormi Hoebe", "Java, JavaScript, UX Design", "Developer");
    testTeam.addMember(testMember);
    assertTrue(testTeam.getMembers().contains(testMember));
  }

}
