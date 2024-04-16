package com.ohgiraffers.thymeleaftest.common;

import com.mysql.cj.Session;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ohgiraffers.thymeleaftest.template.Template.getSqlSession;

@Service
public class MenuService {

    private MenuMapper mapper;


    public List<MenuDTO> getAllMenu() {
        SqlSession session = getSqlSession();
        mapper = session.getMapper(MenuMapper.class);

        return mapper.getAllMenu();
    }
}
