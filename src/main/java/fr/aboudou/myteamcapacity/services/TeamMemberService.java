package fr.aboudou.myteamcapacity.services;

import fr.aboudou.myteamcapacity.model.TeamMember;

public interface TeamMemberService {

    TeamMember findTeamMemberByName(String name);
}
