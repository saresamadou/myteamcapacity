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
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TeamMemberRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TeamMemberRepository repository;

    @Test
    public void should_Return_TeamMember_From_Database() {
        //given
        TeamMember member = new TeamMember("SARE", EnumRole.DEVELOPER);
        entityManager.persist(member);
        entityManager.flush();

        //when
        TeamMember result = repository.findTeamMemberByName(member.getName());

        //then
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.getName()).isEqualTo("SARE");
        Assertions.assertThat(result.getRole()).isEqualTo(EnumRole.DEVELOPER);

    }
}
