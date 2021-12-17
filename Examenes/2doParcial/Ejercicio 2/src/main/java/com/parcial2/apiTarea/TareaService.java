package com.parcial2.apiTarea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;
import java.lang.reflect.Field;

import java.util.Map;

public class TareaService {
    @Autowired
    TareaRepository articleRepository;

    public void updateArticle(Long id, Map<String, Object> request) {
        Tarea articleEntity = articleRepository.findById(id);

        request.forEach((k, v) -> {

            Field field = ReflectionUtils.findField(Tarea.class, k);
            field.setAccessible(true);
            ReflectionUtils.setField(field, articleEntity, v);

        });
        articleRepository.save(articleEntity);
    }
}