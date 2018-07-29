package fr.aboudou.myteamcapacity;

import fr.aboudou.myteamcapacity.controllers.TeamMemberController;
import fr.aboudou.myteamcapacity.enums.EnumRole;
import fr.aboudou.myteamcapacity.model.TeamMember;
import fr.aboudou.myteamcapacity.services.TeamMemberService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Base64Utils;


import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TeamMemberController.class)
public class TeamMenberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TeamMemberService service;


    @Test
    public void getTeamMember_Should_Return_TeamMemberInformations() throws Exception {
        //given
        TeamMember member = new TeamMember("SARE Aboudou Samadou", EnumRole.DEVELOPER);
        when(service.findTeamMemberByName(eq("aboudou"))).thenReturn(member);

        //When and then
        this.mockMvc.perform(get("/tm/aboudou").header(HttpHeaders.AUTHORIZATION,
                "Basic " + Base64Utils.encodeToString("user:password".getBytes())).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(member.getName())))
                .andExpect(content().json("{\"name\":\"SARE Aboudou Samadou\",\"role\":\"DEVELOPER\"}"));

    }
}
