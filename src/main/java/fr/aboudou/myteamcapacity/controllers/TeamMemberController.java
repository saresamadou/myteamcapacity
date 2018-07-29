package fr.aboudou.myteamcapacity.controllers;


import fr.aboudou.myteamcapacity.enums.EnumRole;
import fr.aboudou.myteamcapacity.model.TeamMember;
import fr.aboudou.myteamcapacity.services.TeamMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tm")
public class TeamMemberController {

    @Autowired
    private TeamMemberService service;

    @GetMapping(value = "/{name}")
    public TeamMember getTeamMemberByName(@PathVariable("name") String name) {
        return service.findTeamMemberByName(name);
    }

    @GetMapping(value = "/about")
    public String aboutApplicaton() {
        return "This is an application about Team member capacity";
    }
}
