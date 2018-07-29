package fr.aboudou.myteamcapacity.integration;

import fr.aboudou.myteamcapacity.MyteamcapacityApplication;
import fr.aboudou.myteamcapacity.enums.EnumRole;
import fr.aboudou.myteamcapacity.model.TeamMember;
import fr.aboudou.myteamcapacity.repository.TeamMemberRepository;
import fr.aboudou.myteamcapacity.services.TeamMemberService;
import fr.aboudou.myteamcapacity.services.TeamMemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT, classes = MyteamcapacityApplication.class)
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
public class IntegrationTest {

    TestRestTemplate restTemplate;

    URL url;

    @Autowired
    private TeamMemberRepository repository;

    @LocalServerPort
    int port;

    @Autowired
    private TeamMemberService service;

    @Before
    public void setUp() throws MalformedURLException {
        restTemplate = new TestRestTemplate("user", "password");
        url = new URL("http://localhost:" + port);
        service = new TeamMemberServiceImpl();
    }

    @Test
    public void ShouldReturnATeamMember() {
        //arrage
        final String uri = "/tm/aboudou";
        repository.save(new TeamMember("aboudou", EnumRole.DEVELOPER));

        //act
        ResponseEntity<TeamMember> response = restTemplate.getForEntity(url.toString() + uri, TeamMember.class);

        //Assert
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(response.getBody().getName()).isEqualTo("aboudou");
        Assertions.assertThat(response.getBody().getRole()).isEqualTo(EnumRole.DEVELOPER);
    }
}
