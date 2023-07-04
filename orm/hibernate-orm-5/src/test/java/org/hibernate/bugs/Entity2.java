package org.hibernate.bugs;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import java.util.List;

@Entity
public class Entity2 {

    @Id
    @GeneratedValue
    private Long id;
    private String uuid;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Property> properties;

    public Entity2(String key, List<Property> properties) {
        this.uuid = key;
        this.properties = properties;
    }

    public Entity2() {
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

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }
}
