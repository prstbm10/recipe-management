package com.lets.cook.demo.service.impl;

import com.lets.cook.demo.entity.Bookmark;
import com.lets.cook.demo.repository.BookmarkRepository;
import com.lets.cook.demo.service.BookmarkService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class BookmarkServiceImpl implements BookmarkService {
    BookmarkRepository bookmarkRepository;

    public BookmarkServiceImpl(BookmarkRepository bookmarkRepository) {
        this.bookmarkRepository = bookmarkRepository;
    }


    @Override
    public Bookmark create(Bookmark bookmark) {
        bookmarkRepository.save(bookmark);
        return bookmark;
    }

    @Override
    public String update(Bookmark bookmark) {
        if (bookmarkRepository.existsById(bookmark.getId())) {
            bookmarkRepository.save(bookmark);
            return "success updated bookmark id " + bookmark.getId();
        } else {
            return "bookmark id "+ bookmark.getId() +" not found";
        }
    }

    @Override
    public Page<Bookmark> findAllBookmark(Integer page) {
        int rowsPerPage = 10;
        Pageable pageable = PageRequest.of(page-1, rowsPerPage, Sort.by("id"));
        return bookmarkRepository.findAll(pageable);
    }

    @Override
    public String deleteRecipe(Long id) {
        if (bookmarkRepository.existsById(id)) {
            bookmarkRepository.deleteById(id);
            return "deleted bookmark id " + id;
        } else {
            return "bookmark id "+ id +" not found";
        }
    }
}
