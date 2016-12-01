# Barista-matic
**Requirements**
* Java 8
* Maven +3

**How to compile and run tests**

 Excute the following commands:

1. git clone https://github.com/RockChalkJay/Barista-matic.git
2. cd Barista-matic
3. mvn clean package - This command will both compile the code and run the test suite

**Running the application**

java -jar ./target/barista-matic-1.0-SNAPSHOT.jar

**Design**

* **Ingredient** 
This is a interface for any ingredient. IngredientImpl is a concrete class
that implements Ingredient and can be used to create any variety of ingredient.
I have implemented several default ingredients for convenience sake. 
 
* **Drink** 
This is a interface for any drink. DrinkImpl is a concrete class that 
implements Drink and can be used to create any variety of drink, similar
to IngredientImpl. I implemented several default drinks for convenience sake.

* **InventoryService**
InventoryService is an interface used to manage the available ingredients.
InventoryServiceImpl is an implementation of InventoryService that can be
created with the default ingredients or a custom set of ingredients.

* **MenuService**
MenuService is an interface used to manage drinks. MenuServiceImpl 
is an implementation of MenuService that can be created with the default 
drinks or a custom set of drinks. InventoryService is injected
into MenuService as a dependency giving a lose coupling between drinks and 
the management of their ingredients. This creates a service that can service 
any number of drinks with any number of ingredients.

**Note**  
I was unclear if the program should display the users command along with
the program's output. In this case, I did display the command. I felt that 
it was beneficial feedback. However, this could be easily changed to hide 
the inputted command.


