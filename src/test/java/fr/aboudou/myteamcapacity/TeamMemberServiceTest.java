package fr.aboudou.myteamcapacity;

import fr.aboudou.myteamcapacity.enums.EnumRole;
import fr.aboudou.myteamcapacity.model.TeamMember;
import fr.aboudou.myteamcapacity.repository.TeamMemberRepository;
import fr.aboudou.myteamcapacity.services.TeamMemberService;
import fr.aboudou.myteamcapacity.services.TeamMemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class TeamMemberServiceTest {

    @MockBean
    private TeamMemberRepository repository;

    @Autowired
    private TeamMemberService service;


    @Before
    public void setUp() {

    }

    @TestConfiguration
    static class TeamMemberServiceImplTestContextConfiguration {
        @Bean
        public TeamMemberService teamMemberService() {
            return new TeamMemberServiceImpl();
        }
    }

    @Test
    public void should_Return_TeamMember() {
        //GIVEN

        Mockito.when(repository.findTeamMemberByName("aboudou")).thenReturn(new TeamMember("SARE Aboudou Samadou",
                EnumRole.DEVELOPER));

        //WHEN
        final TeamMember result = service.findTeamMemberByName("aboudou");

        //THEN
        Assertions.assertThat(result.getName()).isEqualTo("SARE Aboudou Samadou");
        Assertions.assertThat(result.getRole()).isEqualTo(EnumRole.DEVELOPER);

    }
}
