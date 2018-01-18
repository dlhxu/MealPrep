package dlhxu.com.mealprep;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
//  TODO create a New Meal class for when they want to enter a new type of meal

public class MainActivity extends AppCompatActivity {

    Button mNewMealButton;
    Button mNewMealPlanButton;
    Button mMyMealsButton;
    Button mThisWeekButton;


    // TODO flesh out the main activity and main layout
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent newMealIntent = new Intent(MainActivity.this, NewMealActivity.class);


        mNewMealButton = (Button) findViewById(R.id.new_meal_button);
        mNewMealButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.startActivity(newMealIntent);
            }
        });

        mNewMealPlanButton = (Button) findViewById(R.id.new_meal_button);
        mNewMealPlanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // generate a new meal plan and pull up the "this weeks meal plan"
                // page that can be screenshotted (leverage the api)
            }
        });
        mMyMealsButton = (Button) findViewById(R.id.my_meals_button);
        mMyMealsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // bring up a page that displays all the saved meals that the user has created
                // requires a new activity
            }
        });
        mThisWeekButton = (Button) findViewById(R.id.this_week_prep_button);
        mThisWeekButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // view the meal plan for the week, i.e. the last meal plan generated by the
                // NewMealPlan button -> requires a new activity

            }
        });

    }

    static class NewMealActivity extends AppCompatActivity{
        @Override
        public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
            super.onCreate(savedInstanceState, persistentState);
        }


        // TODO create variables to access layout XML stuff
        // TODO create variables that will store information that the user inputs into textbox views
        // TODO create methods that will handle an overflow menu "done" click -> instantiate a new meal via constructor

        // Textboxes and relevant variables

        // meal name
        String mealName;

        EditText mMealNameEditText;

        = (EditText) findView

        // protein component
        String protein;

        // carb component (s)
        String carb;

        // vegetable component (in particular) -> should include a "health mode" that changes the preset editTexts to
        // remind you to eat properly
        String veg;
        // total calories (should be required)
        String totalCals;

        // macros (not required)
    }

    static class Meal{

    }
}
