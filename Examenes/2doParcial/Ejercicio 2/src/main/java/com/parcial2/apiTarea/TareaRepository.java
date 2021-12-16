package com.parcial2.apiTarea;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public interface TareaRepository extends JpaRepository<Tarea, Long> {

    // public void updateArticle(Long id, Map<String, Object> request)
    // {
    // ArticleEntity articleEntity = articleRepository.findById(id).orElseThrow(()
    // -> {
    // throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id not found.");
    // });

    // request.forEach((k,v) -> {

    // Field field = ReflectionUtils.findField(ArticleEntity.class, k);
    // field.setAccessible(true);
    // ReflectionUtils.setField(field, articleEntity, v);

    // });
    // articleRepository.save(articleEntity);
    // }
}
