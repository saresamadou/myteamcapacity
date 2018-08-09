package fr.aboudou.myteamcapacity.Indicator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class TeamMemberIndicator implements HealthIndicator {

    @Override
    public Health health() {
        return null;
    }
}
