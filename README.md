# RecipeTwistServer 

This project supports the RecipeTwistClient.

## Documentation

This project contains two tables: 

{localhost}/recipes

and 

{localhost}/user-recipe

The recipes database allows searching by ingredient. For example, to find recipes with cherry: 

{localhost}/recipes/search/findThisIngredient?ingredient=cherry

### Response Parameters

#### recipe

> id : auto generated id

> title : title of the recipe

> ingredients : an araay of ingredients

> steps : an array of steps

**Sample Response**
> {

> 	"id" : 4,

> 	"title" : "Mushroom Beef Tips with Rice",

> 	"ingredients" : [ "1 cup sliced fresh mushrooms", "2 tablespoons butter", "1 package (15 ounces) refrigerated beef tips with gravy", "1 package (8.8 ounces) ready-to-serve long grain rice", "1/2 cup sour cream" ],

> 	"steps" : [ "In a large skillet, saute mushrooms in butter for 2 minutes. Add beef to pan; cook for 4-6 minutes or until heated through, stirring occasionally.", "Meanwhile, cook rice according to package directions. Remove beef mixture from the heat; stir in sour cream. Serve with rice." ]

> }
	
#### user-recipe

> id : auto generated id

> original_recipe : id from recipes table, if empty then it is a new recipe

> title : title of the recipe

> ingredients_edits : a dictionary {index:text}, where index is the index of an ingredient in the original recipe and text is the change that the user chose. If the index does not exists in the original recipes, then it is an addition.

> steps_edits : a dictionary {a.b:text}, where a.b is the index of a step in the original recipe. if .b is not part of the index, then it is a modification of step a. Otherwise, step a.b is added at offset b after step a. and text is the text at that step.

**Sample Response**

> {

> 	"id" : 11,

> 	"original_recipe" : 4,

> 	"title" : "Healthier Mushroom Beef Tips with Rice",

> 	"ingredients_edits" : {
>       "1" : "2 tablespoons olive oil ",
>       "5" : "1/2 cup frozen spinach  "
>     },

> 	"steps_edits" :  {
>        "0" : "In the same skillet, saute mushrooms for 2 minutes. Add beef to pan; cook for 4-6 minutes or until heated through, stirring occasionally. ",
>        "-0.1" : "Cook spinach in a skillet with a spoon of olive oil until it is almost cooked "
>      }

> }

## Development server 

Simply import into eclipse and change src\main\resources\application.properties specifications to your own liking. The project creates the appropriate tables and loads in mock recipes.