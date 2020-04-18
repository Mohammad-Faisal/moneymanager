package com.faisal.moneymanager.model.data;


import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@Entity(name = "users") // if we set name attribute here the entity name and the name in database will change
//@Table //this will only change the tables name in database
public class User extends BaseEntity {


    private String username;
    private String password;

    @ManyToMany
    private Set<Role> roles;


}
