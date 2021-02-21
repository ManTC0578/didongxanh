package com.congman.ddd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "brand")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrandEntity extends AuditTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String image;

}
