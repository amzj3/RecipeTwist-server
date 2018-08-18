package com.recipetwist.main;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.recipetwist.main.Recipe;
import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class UserRecipe {
	
	@Id @GeneratedValue
	private Long id;
	
	private Long original_recipe;
	private String title;
	//key refers to the element being edited
	@ElementCollection
	private Map<Integer,String> ingredients_edits;
	
	//key is of the format a.b where a is the step and b is the
	//offset after the step
	@ElementCollection
	@Lob
	private Map<String,String> steps_edits;
	
	public UserRecipe() {
		super();
	}
	
	public UserRecipe(Long id, Long original_recipe, Map<Integer,String> ingredients_edits,
			Map<String,String> steps_edits) {
		super();
		this.id = id;
		this.original_recipe = original_recipe;
		this.ingredients_edits = ingredients_edits;	
		this.steps_edits = steps_edits;	
	}

	public Long getid() {
		return id;
	}

	public void setid(Long id) {
		this.id = id;
	}

	public Long getOriginal_recipe() {
		return original_recipe;
	}

	public void setOriginal_recipe(Long original_recipe) {
		this.original_recipe = original_recipe;
	}
	
	public Map<Integer,String> getIngredients_edits() {
		return ingredients_edits;
	}

	public void setIngredients_edits(Map<Integer,String> ingredients_edits) {
		this.ingredients_edits = ingredients_edits;
	}


	public Map<String,String> getSteps_edits() {
		return steps_edits;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}
