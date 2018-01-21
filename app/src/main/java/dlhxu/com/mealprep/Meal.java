package dlhxu.com.mealprep;

/**
 * Created by Derek on 2018-01-19.
 */

public class Meal {

    int myMealNum;
    String myName;
    String myProtein;
    String myCarb;
    String myVeg;
    int myTotalCals;


    Meal(int MealNum, String mealName, String protein, String carb, String veg, int totalCals){

        myMealNum = MealNum;
        myName = mealName;
        myProtein = protein;
        myCarb = carb;
        myVeg = veg;
        myTotalCals = totalCals;

    }
}
