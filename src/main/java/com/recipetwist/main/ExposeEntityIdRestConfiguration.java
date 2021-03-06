package com.recipetwist.main;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
public class ExposeEntityIdRestConfiguration extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config){
        config.exposeIdsFor(Recipe.class)
              .exposeIdsFor(UserRecipe.class);
    }
}