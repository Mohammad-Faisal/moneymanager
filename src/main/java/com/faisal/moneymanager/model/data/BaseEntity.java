package com.faisal.moneymanager.model.data;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Data
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;


}

