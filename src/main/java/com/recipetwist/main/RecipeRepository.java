package com.recipetwist.main;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
	
	@Query(value = "Select * from recipe usr inner join recipe_ingredients ri on usr.id = ri.recipe_id  where ingredients like %?1% ", nativeQuery = true)
	public List<Recipe> findThisIngredient(@Param("ingredient") String ingredient);
	
}
