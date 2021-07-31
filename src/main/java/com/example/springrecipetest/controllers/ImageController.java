package com.example.springrecipetest.controllers;

import com.example.springrecipetest.services.ImageService;
import com.example.springrecipetest.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ImageController {

    private final ImageService imageService;
    private final RecipeService recipeService;

    public ImageController(ImageService imageService, RecipeService recipeService) {
        this.imageService = imageService;
        this.recipeService = recipeService;
    }

    @PostMapping("recipe/{id}/image")
    public String handleImagePost(@PathVariable String id, @RequestParam("imageFile") MultipartFile file) {
        imageService.saveImageFile(Long.valueOf(id),file);

        return "redirect:/recipe/" + id + "/show";
    }

}
