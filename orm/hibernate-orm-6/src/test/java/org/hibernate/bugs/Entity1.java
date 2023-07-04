package org.hibernate.bugs;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Entity1 {

    @Id
    @GeneratedValue
    private Long id;
    private String uuid;

    public Entity1(String key) {
        this.uuid = key;
    }

    public Entity1() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String key) {
        this.uuid = key;
    }
}
