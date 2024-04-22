package com.ohgiraffers.crud.menu.model.dao;

import com.ohgiraffers.crud.menu.model.dto.CategoryAndMenuDTO;
import com.ohgiraffers.crud.menu.model.dto.CategoryDTO;
import com.ohgiraffers.crud.menu.model.dto.MenuAndCategoryDTO;
import com.ohgiraffers.crud.menu.model.dto.MenuDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MenuMapper {
    List<MenuDTO> findAllMenu();

    List<CategoryDTO> findAllCategory();

    void registNewMenu(MenuDTO menuDTO);

    List<MenuAndCategoryDTO> findAllMenuAndCategory();

    List<CategoryAndMenuDTO> findAllCategoryAndMenu();

    void deleteMenuByCode(int code);

    List<MenuDTO> menuByPrice(Map<String, Integer> price);
}
