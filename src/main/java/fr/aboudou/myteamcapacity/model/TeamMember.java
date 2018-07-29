package fr.aboudou.myteamcapacity.model;

import fr.aboudou.myteamcapacity.enums.EnumRole;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TeamMember {

    @Id
    private String name;

    private EnumRole role;

    public TeamMember() {
    }

    public TeamMember(String name, EnumRole role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EnumRole getRole() {
        return role;
    }

    public void setRole(EnumRole role) {
        this.role = role;
    }
}
