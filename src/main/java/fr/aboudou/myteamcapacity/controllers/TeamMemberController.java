package fr.aboudou.myteamcapacity.controllers;


import fr.aboudou.myteamcapacity.configuration.MtcProperties;
import fr.aboudou.myteamcapacity.enums.EnumRole;
import fr.aboudou.myteamcapacity.model.TeamMember;
import fr.aboudou.myteamcapacity.services.TeamMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class TeamMemberController {

    @Autowired
    private TeamMemberService service;

    @GetMapping(value = "/tm/{name}")
    public TeamMember getTeamMemberByName(@PathVariable String name) {
        return service.findTeamMemberByName(name);
    }

    @GetMapping(value = "/tm/about")
    public String aboutApplicaton(MtcProperties properties) {
        return properties.getAbout();
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void teamMemberNotFoundHandler(TeamMemberNotFound tmnf) {

    }
}
