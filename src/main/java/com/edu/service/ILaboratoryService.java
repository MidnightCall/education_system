package com.edu.service;

import com.edu.commons.Result;
import com.edu.entity.Laboratory;

/**
 * @ClassName ILaboratoryController
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/13 15:35
 * @Version
 */

public interface ILaboratoryService {
    Result getById(Long id);

    Result getAll();

    Result update(Laboratory laboratory);

    Result insert(Laboratory laboratory);

    Result deleteById(Long id);
}
