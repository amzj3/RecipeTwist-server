package com.recipetwist.main;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RecipeTwistServerApplicationTests {
	@Autowired
	private RecipeRepository repo;
	@Test
	public void contextLoads() {
		List<String> test = new ArrayList<String>();
		test.add("ingredient 0");
		System.out.println(repo.findThisIngredient("8"));
	}

}
