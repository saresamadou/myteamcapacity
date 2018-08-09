package fr.aboudou.myteamcapacity.model;

import fr.aboudou.myteamcapacity.enums.EnumRole;

import javax.persistence.*;

@Entity
public class TeamMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
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

    public Long getId() {
        return id;
    }
}
