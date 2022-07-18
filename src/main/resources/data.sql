
INSERT INTO USERS (uuid, name, surname, gender, email, password, created_at) VALUES
('4ab9a501-0697-4905-a790-8a604391cbf1','Wellington', 'Soares Nunes', 'M', 'well.soares.nunes@gmail.com', '123456', CURRENT_TIMESTAMP()),
('a0e2839f-96c1-4198-bb3d-9211e44bbd50','Natasa', 'Mihajlovic', 'F', 'natasa.m@gmail.com', '123456', CURRENT_TIMESTAMP()),
('4a2a1116-4264-4100-b5b0-deae6a71cd46','Izabel', 'Vasconcelos Nunes', 'F', 'izabel.n@gmail.com', '123456', CURRENT_TIMESTAMP());

INSERT INTO RECIPE(uuid, uuid_user, title, prep_time, cook_time, serving, instructions, ingredients, notes, occasion, recipe_type) VALUES
('a416e14c-b077-4c0a-9934-3f34c3307f8a','4ab9a501-0697-4905-a790-8a604391cbf1', 'Flapper Pie', 30, 30, 6,
'Preheat an oven to 350 degrees F (175 degrees C).
Mix the graham cracker crumbs, 1/2 cup sugar, melted butter, and cinnamon in a bowl. Reserve 1/4 cup for topping the pie. Press the remaining crumb mixture in the bottom and up the sides of a 9-inch deep-dish pie plate. Bake the crust in the preheated oven for 8 minutes.
Heat the milk in a saucepan over medium-high heat. In a non-plastic bowl, whisk together the 1/2 cup sugar, cornstarch, egg yolks, and vanilla. When the milk is hot but not boiling, slowly pour the milk in a steady stream into the yolk mixture, whisking constantly. Return the custard to the saucepan and bring to a boil over medium heat, stirring constantly with a wooden spoon or a heat-proof spatula. Cook and stir for 2 to 3 minutes over low heat until the custard has thickened. Pour the custard into the graham cracker crust.
Preheat the oven''s broiler and set the oven rack about 6 inches from the heat source.
Beat the egg whites until medium peaks form; add 2 tablespoons of sugar and beat until the meringue is stiff. Scoop out the meringue on top of the custard filling. Sprinkle the meringue with the reserved graham cracker crumbs.
Place the pie under the broiler and bake until the meringue starts to brown, 3 to 5 minutes.',
'1 ½ cups graham cracker crumbs
½ cup white sugar
½ cup butter, melted
1 tablespoon ground cinnamon
3 cups milk
½ cup white sugar
¼ cup cornstarch
3 egg yolks
1 teaspoon vanilla extract',
'Per Serving: 490 calories; protein 8.8g; carbohydrates 65.6g; fat 22.1g; cholesterol 152.9mg; sodium 318.4mg. ',
'AFTERNOON_COFFEE',
'VEGETARIAN');

INSERT INTO RECIPE(uuid, uuid_user, title, prep_time, cook_time, serving, instructions, ingredients, notes, occasion, recipe_type) VALUES
('fca81ff0-e049-4155-8c29-5ad1e6da589b','4ab9a501-0697-4905-a790-8a604391cbf1', 'Apple Muffins', 30, 30, 12,
'Heat oven to 400 degrees F (205 degrees C). Grease bottoms only of 12 muffin cups or line with baking cups.
In a medium bowl, combine flour, sugar, baking powder, cinnamon, and salt; mix well. In a small bowl, combine apple juice, oil, and egg; blend well. Add dry ingredients all at once; stir just until dry ingredients are moistened (batter will be lumpy.) Stir in chopped apples.
Fill cups 2/3 full. Bake for 18 to 22 minutes or until toothpick inserted in center comes out clean. Cool 1 minute before removing from pan. Serve warm.',
'2 cups all-purpose flour
½ cup white sugar
3 teaspoons baking powder
½ teaspoon salt
¾ cup apple juice
⅓ cup vegetable oil
1 egg
1 teaspoon ground cinnamon
1 cup apples - peeled, cored and finely diced',
'Per Serving: 182 calories; protein 2.7g; carbohydrates 28g; fat 6.8g; cholesterol 15.5mg; sodium 225.6mg.',
'AFTERNOON_COFFEE',
'VEGETARIAN');


INSERT INTO RECIPE(uuid_user, title, prep_time, cook_time, serving, instructions, ingredients, notes, occasion, recipe_type) VALUES
('4ab9a501-0697-4905-a790-8a604391cbf1', 'Pickled Squash', 10, 30, 8,
'In a large non-aluminum pot, combine the squash, bell pepper, and onions. Cover with salt, and let stand for 2 hours to release the liquids. Stir occasionally.
Just before the 2 hours are up, combine the sugar, vinegar, mustard seed, turmeric and celery seed in a saucepan. Bring to a boil. Drain the salty liquid from the vegetables. Pour the spice brine over the vegetables, and let stand for 2 more hours.
Bring to a boil once again, and simmer for about 5 minutes. Ladle into 1 pint sterile jars, filling with the liquid to within 1/4 inch of the top. Wipe rims with a clean towel, and run a thin spatula around the inside of the jar to remove air bubbles. Seal with lids and rings. Process for 10 minutes in a simmering water bath to seal completely.',
'¼ cup salt
2 ½ pounds young yellow squash and zucchini, sliced into rounds
1 green bell pepper, seeded and sliced into strips
2 small onions, thinly sliced
2 ¼ cups white sugar
2 cups distilled white vinegar
2 teaspoons mustard seed
1 teaspoon ground turmeric
1 teaspoon celery seed',
'',
'BRUNCH',
'VEGETARIAN');

INSERT INTO RECIPE(uuid_user, title, prep_time, cook_time, serving, instructions, ingredients, notes, occasion, recipe_type) VALUES
('4ab9a501-0697-4905-a790-8a604391cbf1', 'BLT Pasta Salad with Mayo', 15, 20, 8,
'Bring a large pot of lightly salted water to a boil. Cook elbow macaroni in the boiling water, stirring occasionally, until tender yet firm to the bite, about 8 minutes. Drain and rinse with cold water. Set aside.
Fry bacon in a large skillet over medium heat until browned and crisp, about 7 minutes. Remove with a slotted spoon and drain on paper towels. Refrigerate when cool.
Sprinkle 2 tablespoons lemon juice over the diced avocado.
Combine mayonnaise, creamy dressing, chile sauce, 1/4 cup lemon juice, chicken bouillon, and sugar. Stir in the cooked macaroni, avocado, tomato, and green onions. Cover tightly and refrigerate until well chilled, at least 6 hours. Mix in lettuce and the reserved bacon just before serving.',
'1 (7 ounce) package elbow macaroni
1 pound bacon, diced
2 tablespoons lemon juice
1 large avocado, diced
½ cup mayonnaise
½ cup creamy salad dressing (such as Miracle Whip®)
⅓ cup tomato-based chile sauce
¼ cup lemon juice
2 teaspoons chicken bouillon granules
2 teaspoons white sugar
1 large tomato - cored, seeded, and diced
½ cup sliced green onion tops
6 cups shredded lettuce',
'Per Serving: 425 calories; protein 12.1g; carbohydrates 31.7g; fat 28.5g; cholesterol 30.8mg; sodium 888.7mg.',
'LUNCH',
'SALAD');


INSERT INTO RECIPE(uuid_user, title, prep_time, cook_time, serving, instructions, ingredients, notes, occasion, recipe_type) VALUES
('4ab9a501-0697-4905-a790-8a604391cbf1', 'BLT Pasta Salad with Mayo', 15, 20, 8,
'Bring a large pot of lightly salted water to a boil. Cook elbow macaroni in the boiling water, stirring occasionally, until tender yet firm to the bite, about 8 minutes. Drain and rinse with cold water. Set aside.
Fry bacon in a large skillet over medium heat until browned and crisp, about 7 minutes. Remove with a slotted spoon and drain on paper towels. Refrigerate when cool.
Sprinkle 2 tablespoons lemon juice over the diced avocado.
Combine mayonnaise, creamy dressing, chile sauce, 1/4 cup lemon juice, chicken bouillon, and sugar. Stir in the cooked macaroni, avocado, tomato, and green onions. Cover tightly and refrigerate until well chilled, at least 6 hours. Mix in lettuce and the reserved bacon just before serving.',
'1 (7 ounce) package elbow macaroni
1 pound bacon, diced
2 tablespoons lemon juice
1 large avocado, diced
½ cup mayonnaise
½ cup creamy salad dressing (such as Miracle Whip®)
⅓ cup tomato-based chile sauce
¼ cup lemon juice
2 teaspoons chicken bouillon granules
2 teaspoons white sugar
1 large tomato - cored, seeded, and diced
½ cup sliced green onion tops
6 cups shredded lettuce',
'',
'BRUNCH',
'VEGAN');

INSERT INTO RECIPE(uuid_user, title, prep_time, cook_time, serving, instructions, ingredients, notes, occasion, recipe_type) VALUES
('4ab9a501-0697-4905-a790-8a604391cbf1', 'Filipino-Style Barbecue Chicken', 15, 30, 6,
'Mash ripe banana, tomato paste, vinegar, brown sugar, oil, ginger, onion powder, garlic powder, cayenne, salt, allspice, and turmeric together in a saucepan. Add water and stir to combine.
Place over medium-high heat and bring to a simmer. Stir to combine. Reduce heat to medium and simmer until reduced and thickened, 7 to 10 minutes. Remove from heat; reserve 3 tablespoons for the basting sauce, leaving about 1/2 cup for the marinade.
Transfer ½ cup banana ketchup to a bowl and add lemon-lime soda, soy sauce, garlic, brown sugar, black pepper, and lemon juice for the marinade. Whisk until combined. Add halved chicken thighs and toss to coat.
Cover with plastic wrap and marinate in the refrigerator for 4 to 18 hours.
When you are ready to cook the chicken, combine reserved 3 tablespoons banana ketchup, soy sauce, brown sugar, oil, and fish sauce in a small bowl for basting sauce.
Preheat a charcoal grill until coals are very hot.
Remove chicken from the refrigerator and place on metal skewers, folding in half with the smooth side on the outside, the rougher side folded in.
Grill chicken over hot coals until no longer pink in the centers, 15 to 20 minutes, turning and basting every 2 to 3 minutes. Serve with accumulated juices or extra basting sauce.',
'1 medium very ripe banana, mashed
¼ cup tomato paste
¼ cup apple cider vinegar
2 tablespoons brown sugar
2 teaspoons vegetable oil
2 teaspoons freshly grated ginger
½ teaspoon onion powder
¼ teaspoon garlic powder
¼ teaspoon cayenne pepper
¼ teaspoon kosher salt, or to taste
⅛ teaspoon ground allspice
⅛ teaspoon ground turmeric
¼ cup water',
'Feel free to grill chicken without skewers.
If chicken is getting too dark on the grill, move to indirect heat, or remove from the grill and finish in a preheated 400 degrees F (200 degrees C) oven until desired doneness.',
'DINNER',
'MEAT');

INSERT INTO RECIPE(uuid_user, title, prep_time, cook_time, serving, instructions, ingredients, notes, occasion, recipe_type) VALUES
('4ab9a501-0697-4905-a790-8a604391cbf1', 'Summer Grilled Pork Chops', 10, 20, 4,
'Mix the lemon juice, honey, Worcestershire sauce, garlic, and basil together in a bowl. Pour about half the marinade into a resealable plastic zipper bag, and place the pork chops in the bag. Squeeze out the air, seal the bag, and refrigerate for at least 2 hours (overnight is best). Refrigerate remaining marinade for basting.
Preheat an outdoor grill for medium-high heat, and lightly oil the grate.
Remove the chops from the bag, and discard the used marinade. Sprinkle chops with salt and black pepper. Grill the chops until browned and the meat is no longer pink inside, 20 to 25 minutes. Baste frequently with the reserved marinade, being sure to let the mixture cook onto the chops. An instant-read meat thermometer inserted into the center of a chop should read at least 145 degrees F (63 degrees C).',
'1 ½ cups lemon juice
1 ½ cups honey
2 tablespoons Worcestershire sauce
1 clove garlic, minced
¼ teaspoon dried basil
4 center-cut pork chops, 1/2-inch thick
salt and ground black pepper to taste',
'The nutrition data for this recipe includes the full amount of the marinade ingredients. The actual amount of the marinade consumed will vary.',
'DINNER',
'LOW_CARB');

INSERT INTO RECIPE(uuid_user, title, prep_time, cook_time, serving, instructions, ingredients, notes, occasion, recipe_type) VALUES
('4ab9a501-0697-4905-a790-8a604391cbf1', 'Nutty Cinnamon Bars', 15, 20, 18,
'Preheat oven to 350 degrees F (175 degrees C). Grease an 11x7-inch baking dish.
Combine flour, sweetener, cinnamon, baking powder, baking soda, and salt in a large bowl; mix until well combined.
Whisk together egg, oil, applesauce, and honey in a second bowl until well combined. Stir into the dry ingredients. Fold in nuts. Transfer batter into the prepared baking dish and smooth out the surface.
Bake in the preheated oven until a toothpick inserted into the center comes out clean, 18 to 22 minutes. Remove from oven and allow to cool.
For the icing, combine powdered sugar substitute, butter, honey, almond milk, vanilla, and cinnamon in a bowl. Spread or drizzle icing onto the cooled bars.',
'1 cup flour
½ cup low-calorie natural sweetener (such as Swerve®)
1 ½ teaspoons ground cinnamon
1 ¼ teaspoons baking powder
¼ teaspoon baking soda
¼ teaspoon salt
1 large egg, at room temperature
⅓ cup canola oil
¼ cup unsweetened applesauce
¼ cup honey
1 cup chopped nuts',
' 120 calories; fat 10g; cholesterol 13.7mg; sodium 83.2mg; carbohydrates 21g; protein 1.4g.',
'PARTY',
'DESSERT');

