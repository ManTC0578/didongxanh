alter table common_attribute add constraint commonArrt_parent foreign key
    (parent_id) references common_attribute(id);

alter table category add constraint cate_parent_fk foreign key
    (parent_id) references category(id);

    alter table product_outlet add primary key (id);
alter table product add primary key (id);
alter table product_sku add primary key (id);
alter table product_outlet_sku add primary key (id);
alter table product_outlet_store add primary key (id);
alter table ware_house add primary key (id);

alter table didongxanh_v1.product add constraint productId_cateId_fk foreign key (category_id) references
    category(id);

alter table didongxanh_v1.product add constraint productId_brandId_fk foreign key (brand_id) references
    brand(id);