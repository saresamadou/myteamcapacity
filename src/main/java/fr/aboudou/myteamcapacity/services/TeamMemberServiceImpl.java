package fr.aboudou.myteamcapacity.services;

import fr.aboudou.myteamcapacity.model.TeamMember;
import fr.aboudou.myteamcapacity.repository.TeamMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class TeamMemberServiceImpl implements TeamMemberService{

    @Autowired
    private TeamMemberRepository repository;

    @Override
    public TeamMember findTeamMemberByName(String name) {
        if(StringUtils.isEmpty(name)) {
            return null;
        }

        return repository.findTeamMemberByName(name);
    }
}
