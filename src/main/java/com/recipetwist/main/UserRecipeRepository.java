package com.recipetwist.main;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(path="user-recipe")
@CrossOrigin(origins = "http://localhost:4200")
public interface UserRecipeRepository extends JpaRepository<UserRecipe, Long> {

}
