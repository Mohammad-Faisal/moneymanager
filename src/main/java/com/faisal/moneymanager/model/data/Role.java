package com.faisal.moneymanager.model.data;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity(name = "roles")
@Data
public class Role extends BaseEntity {

    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

}
