package com.lets.cook.demo.rest;

import com.lets.cook.demo.entity.Bookmark;
import com.lets.cook.demo.service.BookmarkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/bookmark")
public class BookmarkRestController {
    private final BookmarkService bookmarkService;

    public BookmarkRestController(BookmarkService bookmarkService) {
        this.bookmarkService = bookmarkService;
    }

    @GetMapping()
    public ResponseEntity<Object> getAll(@RequestParam Integer page) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(bookmarkService.findAllBookmark(page));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("add")
    public ResponseEntity<Object> addBookmark(@RequestBody Bookmark bookmark) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(bookmarkService.create(bookmark));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("edit")
    public ResponseEntity<Object> editBookmark(@RequestBody Bookmark bookmark) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(bookmarkService.update(bookmark));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("delete")
    public ResponseEntity<Object> deleteBookmark(@RequestParam Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(bookmarkService.deleteRecipe(id));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
