package ru.practicum.ewm.controllers.public_api;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.practicum.ewm.entity.dto.category.CategoryDto;
import ru.practicum.ewm.services.category.CategoryService;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/categories")
@Validated
public class PublicCategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryDto> findAll(@PositiveOrZero @RequestParam(defaultValue = "0") Integer from,
                                     @Positive @RequestParam(defaultValue = "10") Integer size) {
        return categoryService.findAll(from, size);
    }

    @GetMapping("/{catId}")
    public CategoryDto findById(@Positive @PathVariable Long catId) {
        return categoryService.findById(catId);
    }
}
