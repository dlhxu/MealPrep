package dlhxu.com.mealprep;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.INotificationSideChannel;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
//  Complete create a New Meal class for when they want to enter a new type of meal
// Complete (STRUCTURAL) handle internal storage
// TODO (STRUCTURAL) handle myMeals Activity and dynamic Views etc.

public class MainActivity extends AppCompatActivity {

    // meal number (for repetitively instantiating meal objects)
    int mealNum;

    // linked list for storing meals
    ArrayList<Meal> mealList = new ArrayList();

    // internal storage
    File mealFile;


    // main menu button objects
    Button mNewMealButton;
    Button mNewMealPlanButton;
    Button mMyMealsButton;
    Button mThisWeekButton;


    // TODO flesh out the main activity and main layout
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // access any saved files
        Internals newReader = new Internals(mealList, mealFile);

        // run setup
        // read from internal storage to retrieve the user's preset meals, weekly meal, etc.
        // create the linkedlist that the new

        // appInit will initialize the list of Meals if it exists
        //appInit(newReader);

        // main menu


        mNewMealButton = (Button) findViewById(R.id.new_meal_button);
        mNewMealButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent newMealIntent = new Intent(MainActivity.this, NewMealActivity.class);
                Bundle userMealsInfo = new Bundle();
                userMealsInfo.putSerializable("user meals", (Serializable) mealList);
                userMealsInfo.putInt("meal num", mealNum);
                newMealIntent.putExtras(userMealsInfo);

                MainActivity.this.startActivityForResult(newMealIntent, 1);
            }
        });

        mNewMealPlanButton = (Button) findViewById(R.id.new_meal_button);
       /** mNewMealPlanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // generate a new meal plan and pull up the "this weeks meal plan"
                // page that can be screenshotted (leverage the api)
            }
        }); **/


        /**mMyMealsButton = (Button) findViewById(R.id.my_meals_button);
        mMyMealsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // bring up a page that displays all the saved meals that the user has created
                // requires a new activity
                Intent myMealsIntent = new Intent();
                MainActivity.this.startActivity(myMealsIntent);

                // iterate through a linked list, generating a new object and assigning it to a button everytime
                // possible through the View and ViewGroup objects, read up on it (documentation bookmarked!
            }
        });**/


        /**mThisWeekButton = (Button) findViewById(R.id.this_week_prep_button);
        mThisWeekButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // view the meal plan for the week, i.e. the last meal plan generated by the
                // NewMealPlan button -> requires a new activity

            }
        });**/
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {

                mealList = (ArrayList<Meal>) data.getSerializableExtra("user meals");
                mealNum = data.getIntExtra("meal num", 1);
            }
        }
    }

    void appInit(Internals newRead) {

        if(newRead.getMealList() == null){
            // can be used for future functionality, like starting a tutorial on how to use the app or smth
        }
        //mealNum = linkedlist.getLast.mealNum;

    }
    // NewMealActivity is mostly at working completeness -> requires ability to add multiple proteins
    //  or veg, etc. per meal

    // NewMealActivity is accessed via the MainActivity, it is the screen that the user will see
    //  when they want to add a new meal

    // NewMealActivity takes inputs from the user, via EditTextViews, and stores the data in the form of
    //  an Object, which is appended to the end of a linkedList. The Object will contain "mealNum" and
    //  a mealName in addition to the composition of the meal, used to aid in saving and accessing
    //  internal stor

    public class MyMealsActivity extends AppCompatActivity{

        ListIterator<Meal> mealIterator = mealList.listIterator(0);

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
            super.onCreate(savedInstanceState, persistentState);
            setContentView(R.layout.my_meals);
            showMeals();
        }

        void showMeals (){
            // showMeals generates all the meals that the user has stored in the form of clickable
            //  buttons that direct the user to a MealInfoActivity displaying the info of the clicked meal

            // initializing the xml write components
            ListView lv = (ListView) findViewById(R.id.my_meals);
            ViewGroup.LayoutParams lp =
                    new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            Button mealButton;
            while (mealIterator.hasNext()){

                // create a button at position which is equal to "next index"
                Meal currentMeal = mealIterator.next();
                mealButton = new Button (this);

                mealButton.setId(mealIterator.nextIndex());
                // button has name equal to the object.mealname of next()
                mealButton.setText(currentMeal.myName);


                // create an onClickListener which starts a new activity that contains
                // a bunch of textviews displaying info about the meal (mealActivity)
                mealButton.setOnClickListener(new View.OnClickListener()
                    {@Override
                    public void onClick(View view) {
                        // TODO implement showMealInfo, which will bring the user to a stat page of their meal

                        Toast.makeText(getApplicationContext(), "not ready yet :(", Toast.LENGTH_LONG).show();


                                                  }
                                              });
                lv.addView(mealButton);
            }

        }

        void showMealInfo() {
            // TODO dynamically create an activity
        }


    }

}

