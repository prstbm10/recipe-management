package com.lets.cook.demo.service;

import com.lets.cook.demo.entity.Bookmark;
import org.springframework.data.domain.Page;

public interface BookmarkService {
    Bookmark create(Bookmark bookmark);
    String update(Bookmark bookmark);
    Page<Bookmark> findAllBookmark(Integer page);
    String deleteRecipe(Long id);
}
