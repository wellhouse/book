
INSERT INTO USERS (uuid, name, surname, gender, email, password, created_at) VALUES
('4ab9a501-0697-4905-a790-8a604391cbf1','Wellington', 'Soares Nunes', 'M', 'well.soares.nunes@gmail.com', '123456', CURRENT_TIMESTAMP()),
('a0e2839f-96c1-4198-bb3d-9211e44bbd50','Natasa', 'Mihajlovic', 'F', 'natasa.m@gmail.com', '123456', CURRENT_TIMESTAMP()),
('4a2a1116-4264-4100-b5b0-deae6a71cd46','Izabel', 'Vasconcelos Nunes', 'F', 'izabel.n@gmail.com', '123456', CURRENT_TIMESTAMP());

--INSERT INTO INGREDIENT_DESCRIPTION(uuid, name, ingredient_type, measure, amount) VALUES
--('dc83565a-c864-4e8a-9cbb-2fad44941468','Scallion', 'Herb','cup',1),
--('9f4b51f7-52d3-4222-bea1-48d931b13ccb','Chinese-style Egg Noodles', 'Past','grams',1),
--('7fa8b46e-e731-4a6b-a605-d8c6d2c243a2','Sesame oil', 'Oils and fat','ml',100),
--('3bdc633e-99ea-48ab-b821-a72ffc44d5e4','Ginger', 'Root','rasps',2),
--('43a333ff-35dd-4bde-acda-58f43d790258','Garlic', 'Root','Unit',6),
--('996fe45c-0856-4d1e-beed-fc372db8c7c9','Pork Belly', 'Meat and fish','grams',100);

INSERT INTO RECIPE(uuid, uuid_user, title, prep_time, cook_time, serving, instructions, ingredients, notes, occasion, recipe_type) VALUES
('a416e14c-b077-4c0a-9934-3f34c3307f8a','4ab9a501-0697-4905-a790-8a604391cbf1', 'Apple Pie', 10, 30, 8, 'Make crust: Place flour and butter into freezer for 30 minutes before starting crust process.', '1/2 Cup. Garlic','I love apple pie and this is by far the best one.', 'BRUNCH', 'VEGETARIAN');

INSERT INTO RECIPE(uuid, uuid_user, title, prep_time, cook_time, serving, instructions, ingredients, notes, occasion, recipe_type) VALUES
('fca81ff0-e049-4155-8c29-5ad1e6da589b','4ab9a501-0697-4905-a790-8a604391cbf1', 'Apple Pie', 10, 30, 8, 'Make crust: Place flour and butter into freezer for 30 minutes before starting crust process.', '1/2 Cup. Garlic','I love apple pie and this is by far the best one.', 'BRUNCH', 'VEGETARIAN');


INSERT INTO RECIPE(uuid_user, title, prep_time, cook_time, serving, instructions, ingredients, notes, occasion, recipe_type) VALUES
('4ab9a501-0697-4905-a790-8a604391cbf1', 'Apple Pie', 10, 30, 8, 'Make crust: Place flour and butter into freezer for 30 minutes before starting crust process.', '1/2 Cup. Garlic','I love apple pie and this is by far the best one.', 'BRUNCH', 'VEGETARIAN');

INSERT INTO RECIPE(uuid_user, title, prep_time, cook_time, serving, instructions, ingredients, notes, occasion, recipe_type) VALUES
('4ab9a501-0697-4905-a790-8a604391cbf1', 'Apple Pie', 10, 30, 8, 'Make crust: Place flour and butter into freezer for 30 minutes before starting crust process.',
'1/2 Cup. Cinnamon
 1/2 Cup. Orange Zests',
'I love apple pie and this is by far the best one.',
'BRUNCH',
'VEGETARIAN');


INSERT INTO RECIPE(uuid_user, title, prep_time, cook_time, serving, instructions, ingredients, notes, occasion, recipe_type) VALUES
('4ab9a501-0697-4905-a790-8a604391cbf1', 'Pork in the Oven', 50, 100, 6,
'Preheat an air fryer to 390 degrees F (200 degrees C).
Place pork chops on a plate and season both sides with Cajun seasoning.
Pulse croutons in a small food processor until they have a fine consistency; transfer to a shallow dish. Lightly beat eggs in a separate shallow dish. Dip pork chops into eggs, letting excess drip off. Coat chops in crouton breading and set on a plate. Mist chops with cooking spray.',
'1/2 Cup. Garlic
1/2 Cup. Cinnamon
1 teaspoon Cajun seasoning
1 ½ cups cheese and garlic croutons',
'',
'BRUNCH',
'VEGAN');

INSERT INTO RECIPE(uuid_user, title, prep_time, cook_time, serving, instructions, ingredients, notes, occasion, recipe_type) VALUES
('4ab9a501-0697-4905-a790-8a604391cbf1', 'Pork in the Oven', 50, 100, 6,
'Preheat an air fryer to 390 degrees F (200 degrees C).
Place pork chops on a plate and season both sides with Cajun seasoning.
Pulse croutons in a small food processor until they have a fine consistency; transfer to a shallow dish. Lightly beat eggs in a separate shallow dish. Dip pork chops into eggs, letting excess drip off. Coat chops in crouton breading and set on a plate. Mist chops with cooking spray.',
'1/2 Cup. Garlic
1 teaspoon Cajun seasoning
1 ½ cups cheese and garlic croutons',
'',
'BRUNCH',
'VEGAN');

INSERT INTO RECIPE(uuid_user, title, prep_time, cook_time, serving, instructions, ingredients, notes, occasion, recipe_type) VALUES
('4ab9a501-0697-4905-a790-8a604391cbf1', 'AirFryer pork', 50, 250, 10,
'Preheat an air fryer to 390 degrees F (200 degrees C).
Combine Parmesan cheese, paprika, garlic powder, salt, parsley, and pepper in a flat shallow dish; mix well.
Coat each pork chop with olive oil. Dredge both sides of each chop in the Parmesan mixture and set on a plate.',
'½ cup grated Parmesan cheese
1 teaspoon paprika
1 teaspoon garlic powder
1 teaspoon kosher salt',
'',
'DINNER',
'LOW_CARB');

INSERT INTO RECIPE(uuid_user, title, prep_time, cook_time, serving, instructions, ingredients, notes, occasion, recipe_type) VALUES
('4ab9a501-0697-4905-a790-8a604391cbf1', 'Tiramisu Toffee Dessert', 20, 120, 15,
'Arrange cake slices on bottom of a rectangular 11x7 inch baking dish, cutting cake slices if necessary to fit the bottom of the dish. Drizzle coffee over cake.
Beat cream cheese, sugar, and chocolate syrup, in a large bowl with an electric mixer on medium speed until smooth. Add heavy cream; beat on medium speed until light and fluffy. Spread over cake. Sprinkle with chocolate-covered toffee candy.
Cover and refrigerate for at least 1 hour, but no longer than 24 hours, to set dessert and blend flavors.',
'1 (10.75 ounce) package frozen prepared pound cake, thawed and cut into 9 slices
¾ cup strong brewed coffee
1 (8 ounce) package cream cheese
1 cup white sugar',
'',
'PARTY',
'DESSERT');

