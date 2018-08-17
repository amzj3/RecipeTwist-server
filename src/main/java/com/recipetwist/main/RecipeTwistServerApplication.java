package com.recipetwist.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class RecipeTwistServerApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(RecipeTwistServerApplication.class, args);
	}
	
	@Bean
    ApplicationRunner init(RecipeRepository recipe_repo, UserRecipeRepository user_repo) {
		return args -> {
			generateMockDataFromFolder(recipe_repo,user_repo);
		};
	}
	
	private static void generateMockDataFromFolder(RecipeRepository recipe_repo, UserRecipeRepository user_repo) {
		File folder = new File("src/main/resources/mock-recipes");
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
		    if (file.isFile()) {
		    	try {
					Scanner temp = new Scanner(file);
					String title = temp.nextLine();
					temp.nextLine(); //Ingredients
					List<String> ing = new ArrayList<String>();
					String tempLine = temp.nextLine();
					while(temp.hasNextLine() && !tempLine.equals("Directions")) {
						ing.add(tempLine);
						tempLine = temp.nextLine();
					}
					
					List<String> steps = new ArrayList<String>();
					while(temp.hasNextLine() ) {
						steps.add(temp.nextLine());
					}
					
					Recipe recipe = new Recipe();
					recipe.setTitle(title);
					recipe.setIngredients(ing);
					recipe.setSteps(steps);
					recipe_repo.save(recipe);
					
					System.out.println(recipe);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} 
		        
		    }
		}
	
	}
	
	private void generateMockData(RecipeRepository recipe_repo, UserRecipeRepository user_repo) {
		Random rand = new Random();
		for(int i = 0; i < 10; i++) {
			String recipeName = "Recipe "+ i;
			int c = rand.nextInt(10) + 2;
			List<String> ing = new ArrayList<String>();
			
			for(int j = 0;j < c;j++) {
				ing.add(rand.nextInt(5) + " of ingredient " + j);
			}
			c = rand.nextInt(10) + 2;
			List<String> steps = new ArrayList<String>();
			
			for(int j = 0;j < c;j++) {
				steps.add("Doing Step " + j);
			}
			
			Recipe recipe = new Recipe();
			recipe.setTitle(recipeName);
			recipe.setIngredients(ing);
			recipe.setSteps(steps);
			recipe_repo.save(recipe);
		}
		
		UserRecipe r = new UserRecipe();
		r.setOriginal_recipe((long) 1);
		r.setTitle("Random");
		user_repo.save(r);
	}
}
