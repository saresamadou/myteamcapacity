package fr.aboudou.myteamcapacity.repository;

import fr.aboudou.myteamcapacity.model.TeamMember;
import org.springframework.data.repository.CrudRepository;

public interface TeamMemberRepository extends CrudRepository<TeamMember, Long>{

    TeamMember findTeamMemberByName(String name);
}
