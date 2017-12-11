package com.example.tharani.blinkingeffect;
/*import is libraries imported for writing the code
* AppCompatActivity is base class for activities
* Bundle handles the orientation of the activity
*/

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    /*onCreate is the first method in the life cycle of an activity
     savedInstance passes data to super class,data is pull to store state of application
   * setContentView is used to set layout for the activity
   *R is a resource and it is auto generate file
   * activity_main assign an integer value*/
    //Declaring variables for TextView,Button,animation
    TextView txtView;
    Button btn;
    Animation animation;

    /* A protected member is accessible within all classes in the same package and within subclasses in other packages
    * so here iam using protected method*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("onCreate()", "Execution Started");
        // you can search for log messages labelled myTag to easily find the message in the LogCat
        //checks whether the Execution is started debug the code
        /*by using debug we can know where the execution flow of our is and can locate the bugs easily*/
        setContentView(R.layout.activity_main);
        btn =  findViewById(R.id.button);// It takes button id from the activity_main.xml
        txtView =  findViewById(R.id.textView);// It takes textview id from the activity_main.xml


        // here it  load the animation
        /*The superclass of the animation API is the Animator class.
        The ObjectAnimation class can be used to modify attributes of an object.*/
        /**here created object of animation class
         * loading xml animation using AnimationUtils by calling the loadAnimation function
         * Context provides information about application environment
         * app context is attaining using getApplicationContext
         * getApplicationContext() is a activity context*/
        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink_in);
        //here by using this code it gets blink
      //using deep link the we can take the required content page directly
        //set animation listener
        btn.setOnClickListener(new View.OnClickListener() {
            // sets the onclick button event
            //ViewOnClickListener called to loads or touches the item

            @Override
            public void onClick(View view) {
                //shows the visibility of the textview
                txtView.setVisibility(View.VISIBLE);
                 // Set visibility: here it shows views using setVisibility
                //Start the animation
                txtView.startAnimation(animation);
                Toast.makeText(getApplicationContext(),"Started Blinking Animation",Toast.LENGTH_LONG).show();
                /*here it gives toast of Started Blinking Animation
                Toast is a notification message that pop up, display a certain amount of time
                it  fades in and out, it helps for debugging purpose
                LENGTH_LONG Show the view or text notification for a long period of time that is 3 to 5 sec*/
            }

        });

    }
}
