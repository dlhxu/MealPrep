package dlhxu.com.mealprep;

import android.app.Activity;
import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NewMealActivity extends AppCompatActivity {

    EditText mMealNameEditText;
    EditText mProteinOptionEditText;
    EditText mCarbOptionEditText;
    EditText mVegOptionEditText;
    EditText mTotalCalsEditText;
    Button mAddMealButton;

    ArrayList<Meal> mealList;
    File mealFile;
    int mealNum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_meal);

        // Fetch some required information
        mealFile = new File(getFilesDir(), "meals");


        Intent intent = getIntent();
        Bundle userMealInfo = intent.getExtras();

        mealList = (ArrayList<Meal>) userMealInfo.getSerializable("user meals");

        // this handles a mealNum of zero?
        mealNum = userMealInfo.getInt("meal num");

        final String mealName;
        final String protein;
        final String carb;
        final String veg;
        final String totalCals;


        Toast.makeText(getApplicationContext(), ":(", Toast.LENGTH_LONG).show();

        // Complete create variables to access layout XML stuff
        // Complete create variables that will store information that the user inputs into textbox views
        // Complete create methods that will handle "done" click -> instantiate a new meal via constructor
        // TODO add option to add additional "protein" "carb" "veg" options within the same meal

        // Textboxes and relevant variables

        // meal name

        mMealNameEditText = (EditText) findViewById(R.id.meal_name_editText);
        mealName = mMealNameEditText.getText().toString();

        // protein component
        mProteinOptionEditText = (EditText) findViewById(R.id.protein_option_editText);
        protein = mProteinOptionEditText.getText().toString();

        // carb component (s)
        mCarbOptionEditText = (EditText) findViewById(R.id.carb_option_editText);
        carb = mCarbOptionEditText.getText().toString();

        // vegetable component (in particular) -> should include a "health mode" that changes the preset editTexts to
        // remind you to eat properly
        mVegOptionEditText = (EditText) findViewById(R.id.veg_option_editText);
        veg = mVegOptionEditText.getText().toString();

        // total calories (should be required)
        mTotalCalsEditText = (EditText) findViewById(R.id.total_cals_editText);
        totalCals = mTotalCalsEditText.getText().toString();

        // macros (not required)

        // Add Meal button
        mAddMealButton = (Button) findViewById(R.id.add_meal_button);
        mAddMealButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                // Complete handle making a new meal, which will be tacked onto the end of a linkedlist
                mealList.add(new Meal(mealNum, mealName, protein, carb, veg, totalCals));
                Internals newSave = new Internals(mealList, mealFile);
                newSave.writeMealList();

                // Make the intent to pass back to the main activity, which will contain the linkedList
                //  and the new mealNum

                Intent i = new Intent(NewMealActivity.this, MainActivity.class);
                Bundle sendBack = new Bundle();
                sendBack.putSerializable("user meals", (Serializable) mealList);
                sendBack.putInt("meal num", mealNum);

                i.putExtras(sendBack);

                setResult(Activity.RESULT_OK, i);

                finish();

            }
        });



    }
}
