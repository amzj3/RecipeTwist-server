package com.recipetwist.main;

import java.util.List;

import javax.persistence.*;

@Entity
public class Recipe {
	@Id @GeneratedValue
	private Long id;
	private String title;
	@ElementCollection
	private List<String> ingredients;
	@ElementCollection
	@Lob
	private List<String> steps;
	
	public Recipe() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public List<String> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}
	
	public List<String> getSteps() {
		return steps;
	}

	public void setSteps(List<String> steps) {
		this.steps = steps;
	}

	@Override
	public String toString() {
		return "Recipe [id=" + id + ", title=" + title + "]";
	}
	

}
