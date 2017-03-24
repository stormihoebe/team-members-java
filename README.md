# _Startup Weekend_

#### A simple website for tracking teams and team members for a weekend hackathon, 3/24/17

### By Stormi Hoebelheinrich

## Description

#### This website allows users to see all teams that are registered for a startup weekend event. The user is also able to add a new team, add team members to an existing team, and view details about teams and members on their respective pages.

### Member Specifications

| Behavior |   Input   |   Output   |
|----------|:---------:|:----------:|
| Member instantiates correctly as Member Class | testMember = new Member("Stormi Hoebe", "Java, JavaScript, UX Design", "Developer")| testMember is an instance of Member |
| .getMemberName returns name of member | testMember.getMemberName()| "Stormi Hoebe" |
| .getSkills returns member skills)| testMember.getSkills() | "Java, JavaScript, UX Design"|
| .getRole returns member roll| testMember.getRole()| "Developer"|
| .all returns all instances of Member | Member.all().contains(testMember)  |  true|
| member instantiates with id | testMember.getId() | id = 1|
| .find returns member with a particular id| Member.find(1)| testMember |

### Team Specifications

| Behavior |   Input   |   Output   |
|----------|:---------:|:----------:|
| Team instantiates correctly as Team Class | testTeam = new Team("Dream Team", "La La Land", "Make everything decent for once")| testTeam is an instance of Team |
| .getTeamName returns name of team | testTeam.getTeamName()| "Dream Team" |
| .getLocation returns team location| testTeam.getLocation() | "La La Land"|
| .getProjectGoal returns team goal| testTeam.getProjectGoal()| "Make everything decent for once"|
| .all returns all instances of Team | Team.all().contains(testTeam)  |  true|
| team instantiates with id | testTeam.getId() | id = 1|
| .find returns team with a particular id| Team.find(1)| testTeam |
| .addMember adds member to a particular team| testMember = new Member("Stormi Hoebe", "Java, JavaScript, UX Design", "Developer");
testTeam.addMember(testMember);| testTeam.getMembers().contains(testMember) = true|

### This is the initial release (1.0):
https://github.com/stormihoebe/team-members-java/


## Setup/Installation Requirements
Open the terminal and preform the following:
* download download or update java if necessary (https://java.com/en/)
* open command line console
* clone repository from github to desktop
* navigate to main directory
* $ gradle run
* Open web browser and navigate to http://localhost:4567/ (while gradle is running Spark Application)
* Explore pages to view teams and members, add new teams, and add team members.
* ctrl+c in command line to stop gradle from running


## Known Bugs
no known bugs.

## Support and contact details

Contact Stormi at Epicodus
stormihoebe@gmail.com

#Built with the following tools:

* Atom (https://atom.io/)
* GitHub (https://github.com/)
* Git (https://git-scm.com/)
* Java (https://java.com/en/)
* gradle
* Spark
* Velocity

#License

*This software is licensed under the MIT license.*

Copyright (c) 2017 Stormi Hoebelheinrich
