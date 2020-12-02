package softuni.fundamentals.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ME04TeamworkProjects {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int teamsCount = Integer.parseInt(scan.nextLine());
        List<Team> teams = new ArrayList<>();
        for (int i = 0; i<teamsCount; i++) {
           String[] teamData = scan.nextLine().split("-");
           if (isValid(teams, teamData)) {
               Team team = new Team(teamData[0], teamData[1]);
               team.addMember(new Member(teamData[0], teamData[1]));
               teams.add(team);
               System.out.printf("Team %s has been created by %s!%n", team.getTeamName(), team.getCreatorName());
           }
        }
        String input = scan.nextLine();
        while (!input.equals("end of assignment")) {
            String[] memberData = input.split("->");
            Member member = new Member(memberData[0], memberData[1]);
            Team team = member.findTeam(teams);
            if (!team.isEmpty()){
                if (member.isEligibleToJoin(teams)){
                    team.addMember(member);
                }
            }
            input = scan.nextLine();
        }
        teams.sort((t1,t2) -> Integer.compare(t2.getMembers().size(), t1.getMembers().size()));
        for (Team team : teams) {
            team.removeCreator();
            if (!team.getMembers().isEmpty()) {
                System.out.println(team.toString());
                team.getMembers().stream().sorted((m1, m2) -> m1.getUsername().compareTo(m2.getUsername())).forEach(System.out::println);
            }
        }
        System.out.println("Teams to disband:");
        for (Team team : teams) {
            if (team.getMembers().isEmpty()){
                System.out.println(team.getTeamName());
            }
        }
    }

    public static boolean isValid(List<Team> teams, String[] teamData) {
        String creator = teamData[0];
        String name = teamData[1];
        for (Team team : teams) {
            if (team.getTeamName().equals(name)){
                System.out.printf("Team %s was already created!%n", name);
                return false;
            }
            if (team.getCreatorName().equals(creator)){
                System.out.printf("%s cannot create another team!%n", creator);
                return false;
            }
        }
        return true;
    }
}

class Team {
    String creatorName;
    String teamName;
    List<Member> members = new ArrayList<>();

    public Team(String creatorName, String teamName) {
        this.creatorName = creatorName;
        this.teamName = teamName;
    }

    public Team() { }

    public String getCreatorName() {
        return creatorName;
    }

    public String getTeamName() {
        return teamName;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public boolean isEmpty() {
        return this.members.isEmpty();
    }

    public void removeCreator(){
        this.members.remove(0);
    }

    @Override
    public String toString() {
        return String.format("%s%n" +
                "- %s", getTeamName(), getCreatorName());
    }
}

class Member {
    String username;
    String team;

    public Member(String username, String team) {
        this.username = username;
        this.team = team;
    }

    public String getUsername() {
        return username;
    }

    public String getTeam() {
        return team;
    }

    public Team findTeam(List<Team> teams) {
        for (Team team1 : teams) {
            if (team1.getTeamName().equals(this.team)){
                return team1;
            }
        }
        System.out.printf("Team %s does not exist!%n", this.team);
        return new Team();
    }

    public boolean isEligibleToJoin(List<Team> teams) {
        for (Team team1 : teams) {
            for (Member member : team1.getMembers()) {
                if (member.getUsername().equals(this.username)){
                    System.out.printf("Member %s cannot join team %s!%n", getUsername(), getTeam());
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("-- %s", getUsername());
    }
}
