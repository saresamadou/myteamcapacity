package fr.aboudou.myteamcapacity;

import fr.aboudou.myteamcapacity.configuration.MtcProperties;
import fr.aboudou.myteamcapacity.enums.EnumRole;
import fr.aboudou.myteamcapacity.model.TeamMember;
import fr.aboudou.myteamcapacity.repository.TeamMemberRepository;
import fr.aboudou.myteamcapacity.services.TeamMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class, /*ErrorMvcAutoConfiguration.class*/})
@EnableConfigurationProperties(value = {MtcProperties.class})
public class MyteamcapacityApplication implements CommandLineRunner{

	@Autowired
	private TeamMemberRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(MyteamcapacityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repository.save(new TeamMember("aboudou", EnumRole.DEVELOPER));
	}
}
