***CSCI_1112_OOP_Project***

#This is the repository for the CSCI 1112 project and all of its files including the project itself, the JUnit4 test of the project classes, and the JavaDoc of the project.

## Synopsis
This Project is called CalorieCounter.java. It allows a user to input up to 8 items per every meal with allowance of 5 meals per day. It allows the user to  input the calories, protein, fats, carbs, and sodium for each item that they wish to use and will print out all of the items and their amounts as well as the meal total and the daily total for each field. This will be printed out to the MealTracker.txt in the same file path as the CalorieCounter files.

## My Motivation Behind this Project
I wanted something that I would actually use in my daily life. This is something that I think a lot of people would find useful due to the fact that they will be able to track more than just calories without writeing each down outside of the application. This fills a much needed area due to the fact that all of the food tracking apps that I have tried don't allow for the tracking of more than calories.

## How to Run
The file needed to run the program is the CalorieCounter.java and a IDE capable of using JavaFx.

## Code Example
```
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
```
This loop allowed me to add RadioButtons to change the amount of items on the meal. Without this, the user would be unable to change the amount of items and would have to fill out all 8 item sequences.

## Test
If running the JUnit is Desiered, the files needed are the CalorieCounter.java and CalorieCounterTest.java and an IDE capable of running JavaFx as well as JUnit4 testing. These are the only necessary files, the other files are the JavaDoc for the CalorieCounter.java file.

## Contributors
Contributions made by Jason Adams to help navagate around certain problems concerning JavaFx.

Some important links concerning nutrition to help with the CalorieCounter.java file are listed below.

Calories per Day Calculator: https://www.healthline.com/nutrition/how-many-calories-per-day#calculator

Protien in the Diet: https://www.healthline.com/nutrition/how-much-protein-per-day

Fats in the Diet: https://www.healthline.com/nutrition/how-much-fat-to-eat#TOC_TITLE_HDR_6

Carbs in the Diet: https://www.healthline.com/nutrition/how-many-carbs-per-day-to-lose-weight#how-many-carbs-to-eat

Sodium in the Diet: https://www.fda.gov/food/nutrition-education-resources-materials/sodium-your-diet

Each of these links (including the link to the calorie calculator) have articles surrounding what they are, why they are important to the diet, and how to implement them into a diet correctly. If this is not enough information, each of these topics are reletively easy to find due to people wanting a healthy lifestyle. These aren't the only important aspects of a healthy diet (I have a link for reasons why exercise is important below), but it is a vital peice for a healthy lifestyle.

Both are important: https://www.healthline.com/nutrition/diet-vs-exercise#bottom-line

Reasons to Exercise too: https://www.mayoclinic.org/healthy-lifestyle/fitness/in-depth/exercise/art-20048389
