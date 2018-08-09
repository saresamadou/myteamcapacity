package fr.aboudou.myteamcapacity;

import fr.aboudou.myteamcapacity.enums.EnumRole;
import fr.aboudou.myteamcapacity.model.TeamMember;
import fr.aboudou.myteamcapacity.repository.TeamMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
public class TeamMemberRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TeamMemberRepository repository;

    @Test
    public void should_Return_TeamMember_From_Database() {
        //given
        TeamMember memberSaved = entityManager.persistFlushFind(new TeamMember("SARE", EnumRole.DEVELOPER));

        //when
        TeamMember result = repository.findTeamMemberByName("SARE");

        //then
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.getName()).isEqualTo(memberSaved.getName());
        Assertions.assertThat(result.getRole()).isEqualTo(memberSaved.getRole());

    }
}
