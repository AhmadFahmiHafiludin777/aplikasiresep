package com.example.recipeapp.Listeners;

import com.example.recipeapp.Models.SimiliarRecipeResponse;

import java.util.List;

public interface SimiliarRecipesListener {
    void didFetch(List<SimiliarRecipeResponse> responses, String message);
    void didError(String message);
}
