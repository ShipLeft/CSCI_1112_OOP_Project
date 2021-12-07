import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.io.*;

/**
 *<h1>CalorieCounter</h1>
 *
 * <p>This class will open an application that will allow a user to track the amount of
 * nutrients (including calories, protein, fats, carbs, and sodium) in their meals throughout the day.
 * This will also print out all of the results and items into a file created by the program.</p>
 *
 * <p>Created: 12/1/2021 - 12/7/2021</p>
 *
 * @author Rhett Boatright
 */
public class CalorieCounter extends Application{

    //Create TextFields for each meal

    private BorderPane amountOfMeals = new BorderPane();

    //Create new food objects
    private Food singleMeal = new Food();
    private Food totalMeals = new Food();

    //Set variables for the totals.
    private int calorieTotal = 0, proteinTotal= 0, fatsTotal = 0, carbsTotal = 0, sodiumTotal = 0;
    private int mealCalories = 0, mealProtein = 0, mealFats = 0, mealCarbs = 0,
            mealSodium =0, mealNumber = 0, againButton = 1;

    //Create TextField arrays for each variable
    TextField[] namesField = new TextField[8];

    TextField[] calories = new TextField[8];

    TextField[] proteins = new TextField[8];

    TextField[] fats = new TextField[8];

    TextField[] carbs = new TextField[8];

    TextField[] sodium = new TextField[8];


    //Set up string arrays to accept TextField answers
    private String [] name = new String[8];
    private String [] calorieNumbers = new String[8];
    private String [] proteinNumbers = new String[8];
    private String [] fatsNumbers = new String[8];
    private String [] carbsNumbers = new String[8];
    private String [] sodiumNumbers = new String[8];

    //Set up int arrays for the string arrays to be parsed to.
    int [] calorieNumbersInt = new int[8];
    int [] proteinNumbersInt = new int[8];
    int [] fatsNumbersInt = new int[8];
    int [] carbsNumbersInt = new int[8];
    int [] sodiumNumbersInt = new int[8];

    //variable to track how many items have been chosen.
    int times = 0;

    //Create Alert for NumberFormatException
    Alert numberAlert = new Alert(AlertType.ERROR);

    //Create a BorderPane with each meal inside
    /**
     * This method will create the BorderPane in which the application shows. It will also create
     * all the buttons, RadioButtons, and other interactable areas in the application. Most of
     * what the application shows will be created here.
     *
     * @return borderPane (BorderPane; the BorderPane that contains all the application information)
     */
    private BorderPane bPane(){
        //Set alert title
        numberAlert.setTitle("Number not Found");
        numberAlert.setContentText("Please enter numbers in all but item TextFields");

        //Create all buttons to be used by the application.
        Button next2 = new Button("Next");
        Button next3 = new Button("Next");
        Button next4 = new Button("Next");
        Button next5 = new Button("Next");
        Button save = new Button("Save");
        Button again = new Button("New Day!");

        //Create Radio Buttons for the amount  of meals
        HBox amountMeals = new HBox(20);
        amountMeals.setPadding(new Insets(5, 5, 5, 5));
        amountMeals.setStyle("-fx-border-color: black");
        RadioButton oneMeal = new RadioButton("1 Meal");
        RadioButton twoMeal = new RadioButton("2 Meals");
        RadioButton threeMeal = new RadioButton("3 Meals");
        RadioButton fourMeal = new RadioButton("4 Meals");
        RadioButton fiveMeal = new RadioButton("5 Meals");
        amountMeals.getChildren().addAll(oneMeal, twoMeal, threeMeal, fourMeal, fiveMeal);
        amountMeals.setAlignment(Pos.CENTER);

        //Create BorderPane for all items
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(amountMeals);

        //Set the toggle group for the RadioButtons
        ToggleGroup selectedMeals = new ToggleGroup();
        oneMeal.setToggleGroup(selectedMeals);
        twoMeal.setToggleGroup(selectedMeals);
        threeMeal.setToggleGroup(selectedMeals);
        fourMeal.setToggleGroup(selectedMeals);
        fiveMeal.setToggleGroup(selectedMeals);

        //Set each RadioButton to create the specified amount of meals.
        //Clear each time before adding new getItems.
        //Create save file for meals when the 'next' and 'save' buttons are pressed
        oneMeal.setOnAction(e -> {
            if(oneMeal.isSelected()){
                amountMeals.getChildren().clear();
                HBox bottom = new HBox();
                bottom.getChildren().add(save); //Save will end the day of meals.
                bottom.setAlignment(Pos.CENTER);

                amountOfMeals.setBottom(bottom);

                borderPane.setCenter(getItems());
                borderPane.setBottom(amountOfMeals);

            }
        });

        twoMeal.setOnAction(e -> {
            if(twoMeal.isSelected()){
                amountMeals.getChildren().clear();
                HBox bottom = new HBox();
                bottom.getChildren().add(next2); //next2 will move the app to the last meal of the day.
                bottom.setAlignment(Pos.CENTER);

                amountOfMeals.setBottom(bottom);

                borderPane.setCenter(getItems());
                borderPane.setBottom(amountOfMeals);
            }
        });

        threeMeal.setOnAction(e -> {
            if(threeMeal.isSelected()){
                amountMeals.getChildren().clear();
                HBox bottom = new HBox();
                bottom.getChildren().add(next3); //next3 will move the app to twoMeal.
                bottom.setAlignment(Pos.CENTER);

                amountOfMeals.setBottom(bottom);

                borderPane.setCenter(getItems());
                borderPane.setBottom(amountOfMeals);
            }
        });

        fourMeal.setOnAction(e -> {
            if(fourMeal.isSelected()){
                amountMeals.getChildren().clear();
                HBox bottom = new HBox();
                bottom.getChildren().add(next4); //next4 will move the app to threeMeal.
                bottom.setAlignment(Pos.CENTER);

                amountOfMeals.setBottom(bottom);

                borderPane.setCenter(getItems());
                borderPane.setBottom(amountOfMeals);
            }
        });

        fiveMeal.setOnAction(e -> {
            if(fiveMeal.isSelected()){
                amountOfMeals.getChildren().clear();
                HBox bottom = new HBox();
                bottom.getChildren().add(next5); //next5 will move the app to fourMeal.
                bottom.setAlignment(Pos.CENTER);

                amountOfMeals.setBottom(bottom);

                borderPane.setCenter(getItems());
                borderPane.setBottom(amountOfMeals);
            }
        });

        //Create a path for the program to follow when each different button is pressed.
        next5.setOnAction(e ->{

            //Try catch to avoid NumberFormatException if a textField is left blank
            try{
                printOut();

                amountMeals.getChildren().clear();
                Text mealTotal = new Text(50,50,singleMeal.getString());
                mealTotal.setFont(Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR, 30));
                HBox bottom = new HBox();
                bottom.getChildren().add(next4); //Pass to next meal.
                bottom.setAlignment(Pos.CENTER);

                amountOfMeals.setBottom(bottom);

                borderPane.setTop(getItems());
                borderPane.setCenter(mealTotal);
                borderPane.setBottom(amountOfMeals);

                mealCalories = 0;
                mealProtein = 0;
                mealFats = 0;
                mealCarbs = 0;
                mealSodium = 0;

            }catch (NumberFormatException ex){
                System.out.println("Please enter numbers in all but item TextFields");
                numberAlert.showAndWait();
                amountMeals.getChildren().clear();
                Text mealTotal = new Text(50,50,singleMeal.getString());
                mealTotal.setFont(Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR, 30));
                HBox bottom = new HBox();
                bottom.getChildren().add(next5); //Send back to meal.
                bottom.setAlignment(Pos.CENTER);

                amountOfMeals.setBottom(bottom);


                borderPane.setBottom(amountOfMeals);

                mealCalories = 0;
                mealProtein = 0;
                mealFats = 0;
                mealCarbs = 0;
                mealSodium = 0;
            }
        });

        next4.setOnAction(e ->{

            //Try catch to avoid NumberFormatException if a textField is left blank
            try{
                printOut();

                amountMeals.getChildren().clear();
                Text mealTotal = new Text(50,50,singleMeal.getString());
                mealTotal.setFont(Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR, 30));
                HBox bottom = new HBox();
                bottom.getChildren().add(next3); //Send to next meal
                bottom.setAlignment(Pos.CENTER);

                amountOfMeals.setBottom(bottom);

                borderPane.setTop(getItems());
                borderPane.setCenter(mealTotal);
                borderPane.setBottom(amountOfMeals);

                mealCalories = 0;
                mealProtein = 0;
                mealFats = 0;
                mealCarbs = 0;
                mealSodium = 0;

            }catch (NumberFormatException ex){
                System.out.println("Please enter numbers in all but item TextFields");
                numberAlert.showAndWait();
                amountMeals.getChildren().clear();
                Text mealTotal = new Text(50,50,singleMeal.getString());
                mealTotal.setFont(Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR, 30));
                HBox bottom = new HBox();
                bottom.getChildren().add(next4); //Send back to meal
                bottom.setAlignment(Pos.CENTER);

                amountOfMeals.setBottom(bottom);

                borderPane.setBottom(amountOfMeals);

                mealCalories = 0;
                mealProtein = 0;
                mealFats = 0;
                mealCarbs = 0;
                mealSodium = 0;
            }
        });

        next3.setOnAction(e ->{

            //Try catch to avoid NumberFormatException if a textField is left blank
            try {
                printOut();

                amountMeals.getChildren().clear();
                Text mealTotal = new Text(50, 50, singleMeal.getString());
                mealTotal.setFont(Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR, 30));
                HBox bottom = new HBox();
                bottom.getChildren().add(next2); //Send to next meal
                bottom.setAlignment(Pos.CENTER);

                amountOfMeals.setBottom(bottom);

                borderPane.setTop(getItems());
                borderPane.setCenter(mealTotal);
                borderPane.setBottom(amountOfMeals);

                mealCalories = 0;
                mealProtein = 0;
                mealFats = 0;
                mealCarbs = 0;
                mealSodium = 0;
            }catch (NumberFormatException ex){
                System.out.println("Please enter numbers in all but item TextFields");
                numberAlert.showAndWait();
                amountMeals.getChildren().clear();
                Text mealTotal = new Text(50,50,singleMeal.getString());
                mealTotal.setFont(Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR, 30));
                HBox bottom = new HBox();
                bottom.getChildren().add(next3); //Send back to meal
                bottom.setAlignment(Pos.CENTER);

                amountOfMeals.setBottom(bottom);


                borderPane.setBottom(amountOfMeals);

                mealCalories = 0;
                mealProtein = 0;
                mealFats = 0;
                mealCarbs = 0;
                mealSodium = 0;
            }
        });

        next2.setOnAction(e -> {

            //Try catch to avoid NumberFormatException if a textField is left blank
            try {
                printOut();

                amountMeals.getChildren().clear();
                Text mealTotal = new Text(50, 50, singleMeal.getString());
                HBox bottom = new HBox();
                bottom.getChildren().add(save); //Save the totals
                bottom.setAlignment(Pos.CENTER);

                mealTotal.setFont(Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR, 30));

                amountOfMeals.setBottom(bottom);

                borderPane.setTop(getItems());
                borderPane.setCenter(mealTotal);
                borderPane.setBottom(amountOfMeals);

                mealCalories = 0;
                mealProtein = 0;
                mealFats = 0;
                mealCarbs = 0;
                mealSodium = 0;
            }catch (NumberFormatException ex){
                System.out.println("Please enter numbers in all but item TextFields");
                numberAlert.showAndWait();
                amountMeals.getChildren().clear();
                Text mealTotal = new Text(50,50,singleMeal.getString());
                mealTotal.setFont(Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR, 30));
                HBox bottom = new HBox();
                bottom.getChildren().add(next2); //Send back to meal
                bottom.setAlignment(Pos.CENTER);

                amountOfMeals.setBottom(bottom);


                borderPane.setBottom(amountOfMeals);

                mealCalories = 0;
                mealProtein = 0;
                mealFats = 0;
                mealCarbs = 0;
                mealSodium = 0;
            }
        });


        //Create the total printout for when the save button is pressed.
        save.setOnAction(e ->{

            //Try catch to avoid NumberFormatException if a textField is left blank
            try{
                totalMeals.setAgain(againButton);
                printOut();
                Text mealTotal = new Text(50,50,singleMeal.getString());
                Text total = new Text(50,50,totalMeals.myString());

                mealTotal.setFont(Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR, 30));
                total.setFont(Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR, 30));
                try(
                        PrintStream printStream =
                                new PrintStream(new FileOutputStream("MealTracker.txt", true))
                ){
                    printStream.println(totalMeals.myString());
                }catch (IOException ex){
                    System.out.println("File cannot be found/made");
                }

                borderPane.getChildren().clear();
                borderPane.setTop(mealTotal);
                borderPane.setLeft(total);
                HBox againButton = new HBox();
                againButton.getChildren().add(again);
                againButton.setAlignment(Pos.CENTER);
                borderPane.setBottom(againButton);

            }catch (NumberFormatException ex){
                System.out.println("Please enter numbers in all but item TextFields");
                numberAlert.showAndWait();
                Text mealTotal = new Text(50,50,singleMeal.getString());
                mealTotal.setFont(Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR, 30));
                HBox bottom = new HBox();
                bottom.getChildren().add(save); //Send back to meal.
                bottom.setAlignment(Pos.CENTER);

                amountOfMeals.setBottom(bottom);

                borderPane.setBottom(amountOfMeals);

                mealCalories = 0;
                mealProtein = 0;
                mealFats = 0;
                mealCarbs = 0;
                mealSodium = 0;
            }
        });

        //Allow the user to enter as many days as they would like to.
        again.setOnAction(e->{
            againButton ++;
            mealNumber = 0;
            borderPane.getChildren().clear();
            amountMeals.getChildren().addAll(oneMeal, twoMeal, threeMeal, fourMeal, fiveMeal);
            selectedMeals.getSelectedToggle().setSelected(false);
            borderPane.setCenter(amountMeals);
        });
        return borderPane;
    }

    /**
     * This method will create the scene, assign the bPane method to the scene,
     * put the scene into the primaryStage, and show the primaryStage.
     */
    @Override
    public void start(Stage primaryStage){
        Scene foodTracker = new Scene(bPane(), 900, 900);
        primaryStage.setTitle("Food Tracker");
        primaryStage.setScene(foodTracker);
        primaryStage.show();

    }

    /**
     * This method will launch the application. Needed for most IDE's
     *
     * @param args (String; placeholder for the main method)
     */
    public static void main(String[] args){
        launch(args);
    }

    /**
     * This method will create a second BorderPane that contains a VBox with the amount of items
     * that the user would like to put down and a gridPane with all the textFields.
     *
     * @return borderPane (BorderPane; holds all the VBox and GridPane information)
     */
    private BorderPane getItems(){
        BorderPane borderPane = new BorderPane();

        //Add RadioButton to adjust item amount
        RadioButton oneItem = new RadioButton("1");
        RadioButton twoItems = new RadioButton("2");
        RadioButton threeItems = new RadioButton("3");
        RadioButton fourItems = new RadioButton("4");
        RadioButton fiveItems = new RadioButton("5");
        RadioButton sixItems = new RadioButton("6");
        RadioButton sevenItems = new RadioButton("7");
        RadioButton eightItems = new RadioButton("8");


        //Create VBox for the Addition of more items in each meal.
        VBox mealItems = new VBox(20);
        mealItems.setPadding(new Insets(5, 5, 5, 5));
        mealItems.getChildren().add(new Label("Items: "));
        mealItems.setStyle("-fx-border-color: black");
        mealItems.getChildren().addAll(oneItem, twoItems, threeItems,
                fourItems, fiveItems, sixItems, sevenItems, eightItems);
        mealItems.setAlignment(Pos.CENTER);

        //Create a GridPane for the meals and add one Item line.
        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        //Toggle group for the radio buttons
        ToggleGroup selectedItems = new ToggleGroup();
        oneItem.setToggleGroup(selectedItems);
        twoItems.setToggleGroup(selectedItems);
        threeItems.setToggleGroup(selectedItems);
        fourItems.setToggleGroup(selectedItems);
        fiveItems.setToggleGroup(selectedItems);
        sixItems.setToggleGroup(selectedItems);
        sevenItems.setToggleGroup(selectedItems);
        eightItems.setToggleGroup(selectedItems);

        //Use radio buttons to add or subtract items
        oneItem.setOnAction(e ->{
            if(oneItem.isSelected()){
                gridPane.getChildren().clear();
                gridPane.getChildren().addAll(gridPaneLayout(1));
                times = 1;
            }
        });
        twoItems.setOnAction(e ->{
            if(twoItems.isSelected()){
                gridPane.getChildren().clear();
                gridPane.getChildren().add(gridPaneLayout(2));
                times = 2;
            }
        });
        threeItems.setOnAction(e ->{
            if(threeItems.isSelected()){
                gridPane.getChildren().clear();
                gridPane.getChildren().add(gridPaneLayout(3));
                times = 3;
            }
        });
        fourItems.setOnAction(e ->{
            if(fourItems.isSelected()){
                gridPane.getChildren().clear();
                gridPane.getChildren().add(gridPaneLayout(4));
                times = 4;
            }
        });
        fiveItems.setOnAction(e ->{
            if(fiveItems.isSelected()){
                gridPane.getChildren().clear();
                gridPane.getChildren().add(gridPaneLayout(5));
                times = 5;
            }
        });
        sixItems.setOnAction(e ->{
            if(sixItems.isSelected()){
                gridPane.getChildren().clear();
                gridPane.getChildren().add(gridPaneLayout(6));
                times = 6;
            }
        });
        sevenItems.setOnAction(e ->{
            if(sevenItems.isSelected()){
                gridPane.getChildren().add(gridPaneLayout(7));
                times = 7;
            }
        });
        eightItems.setOnAction(e ->{
            if(eightItems.isSelected()){
                gridPane.getChildren().clear();
                gridPane.getChildren().add(gridPaneLayout(8));
                times = 8;
            }
        });

        borderPane.setLeft(mealItems); //Place the mealItems VBox into the borderPane
        borderPane.setCenter(gridPane);
        return borderPane;
    }

    /**
     * This method will create a GridPane layout to be used in the getItems method. The layout
     * includes all the text fields required by the program and will run according to the amount of
     * items that the user would like to input.
     *
     * @param times (int; Tracks how many times the for loop will be run)
     *
     * @return gridPane (GridPane; holds all the TextFields in the program)
     */
    private GridPane gridPaneLayout(int times){
        //Create GridPane for the TextFields.
        GridPane gridPane = new GridPane();
        gridPane.setVgap(20); //Leave space in between layers.

        //For loops to make the new TextFields.
        for(int i = 0; i < namesField.length; i++){
            namesField[i] = new TextField();
            namesField[i].setMaxWidth(150);
            namesField[i].setPromptText("Item name");
        }
        for(int i = 0; i < calories.length; i++){
            calories[i] = new TextField();
            calories[i].setMaxWidth(75);
            calories[i].setPromptText("Calories");
        }
        for(int i = 0; i < proteins.length; i++){
            proteins[i] = new TextField();
            proteins[i].setMaxWidth(75);
            proteins[i].setPromptText("Proteins");
        }
        for(int i = 0; i < fats.length; i++){
            fats[i] = new TextField();
            fats[i].setMaxWidth(75);
            fats[i].setPromptText("Fats");
        }
        for(int i = 0; i < carbs.length; i++){
            carbs[i] = new TextField();
            carbs[i].setMaxWidth(75);
            carbs[i].setPromptText("Carbs");
        }
        for(int i = 0; i < sodium.length; i++){
            sodium[i] = new TextField();
            sodium[i].setMaxWidth(75);
            sodium[i].setPromptText("Sodium");
        }


        //For loop to create the grid pane layout
        for(int i = 0; i < times; i++) {

            gridPane.add(new Label("Item " + (i + 1) +":"),0, i);
            gridPane.add(namesField[i],1,i);

            gridPane.add(new Label(" Calories:"),2, i);
            gridPane.add(calories[i],3, i);
            calorieNumbers [i] = calories[i].getText();

            gridPane.add(new Label(" Protein:"),4, i);
            gridPane.add(proteins[i],5,i);
            proteinNumbers [i] = proteins[i].getText();

            gridPane.add(new Label(" Fats:"),6, i);
            gridPane.add(fats[i], 7, i);
            fatsNumbers [i] = fats[i].getText();

            gridPane.add(new Label(" Carbohydrates:"),8, i);
            gridPane.add(carbs[i],9, i);
            carbsNumbers [i] = carbs[i].getText();

            gridPane.add(new Label(" Sodium:"),10, i);
            gridPane.add(sodium[i], 11, i);
            sodiumNumbers [i] = sodium[i].getText();
        }
        return gridPane;
    }

    /**
     * This method will find all the variables and total anything up that needs to be before printing
     * all the information out to the Meals.txt file.
     */
    private void printOut(){

        //For loop to calculate total numbers.
        for(int i =0; i < times; i++){
            name [i] = namesField[i].getText();
            calorieNumbers [i] = calories[i].getText();
            proteinNumbers [i] = proteins[i].getText();
            fatsNumbers[i] = fats[i].getText();
            carbsNumbers[i] = carbs[i].getText();
            sodiumNumbers [i] = sodium[i].getText();

            calorieNumbersInt[i] = Integer.parseInt(calorieNumbers[i]);


            proteinNumbersInt[i] = Integer.parseInt(proteinNumbers[i]);


            fatsNumbersInt[i] = Integer.parseInt(fatsNumbers[i]);


            carbsNumbersInt[i] = Integer.parseInt(carbsNumbers[i]);


            sodiumNumbersInt[i] = Integer.parseInt(sodiumNumbers[i]);

            calorieTotal += calorieNumbersInt[i];
            mealCalories += calorieNumbersInt[i];
            proteinTotal += proteinNumbersInt[i];
            mealProtein += proteinNumbersInt[i];
            fatsTotal += fatsNumbersInt[i];
            mealFats += fatsNumbersInt[i];
            carbsTotal += carbsNumbersInt[i];
            mealCarbs += carbsNumbersInt[i];
            sodiumTotal += sodiumNumbersInt[i];
            mealSodium += sodiumNumbersInt[i];
        }

        //Make it so that the program will not run if a NumberFormatException happens.

        //Totals for everything as well as checking what Meal it is.
        mealNumber ++;
        singleMeal.setCalories(mealCalories);
        singleMeal.setProtein(mealProtein);
        singleMeal.setFat(mealFats);
        singleMeal.setCarbs(mealCarbs);
        singleMeal.setSodium(mealSodium);

        totalMeals.setCalories(+ calorieTotal);
        totalMeals.setProtein(+ proteinTotal);
        totalMeals.setFat(+ fatsTotal);
        totalMeals.setCarbs(+ carbsTotal);
        totalMeals.setSodium(+ sodiumTotal);

        //try catch for the printStream and print out the information to the text file.
        try(
                PrintStream printStream =
                        new PrintStream(new FileOutputStream("MealTracker.txt", true))
        ){
            printStream.print("\nMeal " + mealNumber +  ": ");
            printStream.println("Items in meal: ");
            for(int i = 0; i < times; i++){
                printStream.println("\n" + name[i] + "   Calories: " + calorieNumbers[i]
                        +"   Protein: " + proteinNumbers[i] + "   Fats: " + fatsNumbers[i]
                        +"   Carbs: " + carbsNumbers[i] + "   Sodium: " + sodiumNumbers[i]);
            }
            printStream.println(singleMeal.getString());
        }catch (IOException ex){
            System.out.println("File cannot be found/made");
        }
    }
}

/**
 * <h1>Food</h1>
 *
 * <p>This class will create a Food constructor to hold all of the name and nutrient values.
 * This will also have a string that will be able to print all of the information out.</p>
 *
 * <p>Created: 12/01/2021</p>
 *
 * @author Rhett Boatright
 */
class Food {
    //Variables for the constructor.
    private int calories, protein, fat, carbs, sodium, again;

    Food() { //Constructor
    }

    //Allow for the getting or setting of all the variables.
    void setCalories(int calories) {
        this.calories = calories;
    }

    void setProtein(int protein) {
        this.protein = protein;
    }

    void setFat(int fat) {
        this.fat = fat;
    }

    void setCarbs(int carbs) {
        this.carbs = carbs;
    }

    void setSodium(int sodium) {
        this.sodium = sodium;
    }

    void setAgain(int again){this.again= again;}

    //Strings for both, meals and end of day totals.
    String getString(){
        return "\nTotal amounts for the meal:"
                +"\nCalories: " + calories
                +"\nProtein: " + protein
                +"\nFats: " + fat
                +"\nCarbs: " + carbs
                +"\nSodium: " + sodium;
    }

    String myString(){
        return "\nTotal amounts for day " + again + ":"
                +"\nCalories: " + calories
                +"\nProtein: " + protein
                +"\nFats: " + fat
                +"\nCarbs: " + carbs
                +"\nSodium: " + sodium;
    }
}