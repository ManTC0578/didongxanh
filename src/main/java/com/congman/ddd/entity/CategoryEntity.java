package com.congman.ddd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "category")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryEntity extends AuditTable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Integer active;

    private String shortDescription;

    private Integer displayOrder;

    @ManyToOne
    @JoinColumn(name = "parentId", referencedColumnName = "id")
    private CategoryEntity parent;

}
