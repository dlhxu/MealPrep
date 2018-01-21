package dlhxu.com.mealprep;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;

/**
 * Created by Derek on 2018-01-20.
 */

public class Internals extends AppCompatActivity implements Serializable {

    // Internals can save and read linked lists of meal objects currently

    // Internals could use some abstraction for the input and output functions (an Abstract List function
    //  of sorts lmfaoo)

    // list of meals that were created by the user
    LinkedList mealListToStore;

    Internals(){}

    Internals(LinkedList listOfMeals){
        mealListToStore = listOfMeals;
    }

    public void writeMealList(){

        File mealFile;
        FileOutputStream fos;
        ObjectOutputStream oos;

        try{
            mealFile = new File(getFilesDir(), "meals");
            fos = new FileOutputStream(mealFile);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(mealListToStore);
            oos.close();

        }catch(IOException e){
            e.printStackTrace();
        }

    }

    public LinkedList<Meal> getMealList(){

        LinkedList<Meal> mealListToRetrieve = null;

        File mealFile;
        FileInputStream fis;
        ObjectInputStream ois;

        try {
            mealFile = new File(getFilesDir(), "meals");
            fis = new FileInputStream(mealFile);
            ois = new ObjectInputStream(fis);
            mealListToRetrieve = (LinkedList<Meal>) ois.readObject();
            ois.close();
            return mealListToRetrieve;

        } catch (FileNotFoundException e){
            e.printStackTrace();

        } catch (IOException e){
            e.printStackTrace();

        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        return mealListToRetrieve;

    }


}
