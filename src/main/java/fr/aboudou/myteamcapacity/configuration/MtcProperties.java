package fr.aboudou.myteamcapacity.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("mtc")
public class MtcProperties {

    /**
     * Information about the application
     */
    private String about = "This is an application about Team member capacity";

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
