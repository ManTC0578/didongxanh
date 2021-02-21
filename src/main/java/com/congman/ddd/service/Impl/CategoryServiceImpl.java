package com.congman.ddd.service.Impl;

import com.congman.ddd.entity.CategoryEntity;
import com.congman.ddd.repository.CategoryRepository;
import com.congman.ddd.service.CategoryService;
import com.congman.ddd.service.mapper.CategoryBeanUtil;
import com.congman.ddd.util.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryDTO> buildTreeCategory(Integer storeId) {
        List<CategoryDTO> roots = new ArrayList<>();
        Map<Integer, Map<Integer, CategoryDTO>> buildCateTreeView = buildCate2Map(storeId);
        //get list parent
        if (!buildCateTreeView.isEmpty() && buildCateTreeView.get(null) != null) {
            Map<Integer, CategoryDTO> mapParents = buildCateTreeView.get(null);
            for (Integer orderIndex : mapParents.keySet()) {
                roots.add(mapParents.get(orderIndex));
                buildChildCategory(mapParents.get(orderIndex), buildCateTreeView);
            }
        }

        return roots;
    }

    private void buildChildCategory(CategoryDTO root, Map<Integer, Map<Integer, CategoryDTO>> buildCateTreeView) {
        if (buildCateTreeView.get(root.getId()) == null) {
            return;
        }

        if (root.getChilds() == null) {
            root.setChilds(new ArrayList<>());
            Map<Integer, CategoryDTO> temp = buildCateTreeView.get(root.getId());
            if (temp != null && temp.size() > 0) {
                for(Integer key : temp.keySet()){
                    root.getChilds().add(temp.get(key));
                }
            }
        }
        for(CategoryDTO dto : root.getChilds()){
            buildChildCategory(dto,buildCateTreeView);
        }
    }


    private Map<Integer, Map<Integer, CategoryDTO>> buildCate2Map(Integer storeId) {
        Map<Integer, Map<Integer, CategoryDTO>> mapResult = new HashMap<>();
        Map<Integer, Integer> mapDisplayOrder = new HashMap<>();
        List<CategoryEntity> enities = this.categoryRepository.findAll();
        for (CategoryEntity enity : enities) {
            if (enity.getDisplayOrder() != null) {
                mapDisplayOrder.put(enity.getId(), enity.getDisplayOrder());
            }
            //childs
            if (enity.getParent() != null) {
                if (mapResult.get(enity.getParent().getId()) == null) {
                    mapResult.put(enity.getParent().getId(), new HashMap<>());
                }
                setDisplayOrder(enity.getParent().getId(), enity, mapResult, mapDisplayOrder);
            } else {
                if (mapResult.get(null) == null) {
                    mapResult.put(null, new HashMap<>());
                }
                setDisplayOrder(null, enity, mapResult, mapDisplayOrder);

            }
        }
        return mapResult;
    }

    private void setDisplayOrder(Integer parentId, CategoryEntity enity, Map<Integer, Map<Integer, CategoryDTO>> buildMap, Map<Integer, Integer> mapDisplayOrder) {
        if (enity.getDisplayOrder() == null) {
            int count = 1;
            if (mapDisplayOrder.get(parentId) != null) {
                count = mapDisplayOrder.get(parentId);
                count++;
            }

            while (true) {
                if (buildMap.get(parentId).get(count) == null) {
                    CategoryDTO dto = CategoryBeanUtil.entityDTO(enity);
                    dto.setDisplayOrder(count);
                    buildMap.get(parentId).put(count, dto);
                    mapDisplayOrder.put(parentId,count);
                    break;
                }
                count++;
            }
        } else {
            if (buildMap.get(parentId).get(enity.getDisplayOrder()) == null) {
                CategoryDTO dto = CategoryBeanUtil.entityDTO(enity);
                buildMap.get(parentId).put(enity.getDisplayOrder(), dto);
            }
        }

    }
}
