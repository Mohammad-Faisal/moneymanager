package com.faisal.moneymanager.model.data;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Data
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;


}

