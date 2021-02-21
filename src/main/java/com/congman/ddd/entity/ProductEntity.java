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
public class ProductEntity extends AuditTable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    private CategoryEntity category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id",referencedColumnName = "id")
    private BrandEntity brand;

    private String name;

    private String code;

    private String description;

    private String thumbnail;

}
