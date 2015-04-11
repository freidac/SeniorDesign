package seniordesign.seniordesign;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;


public class MainActivity extends ActionBarActivity {
   // public static double[] target_shots = new double[80];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //insert_coordinates();
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void start_session(View view){
        Intent intent = new Intent(this , Startsession.class);
        startActivity(intent);
    }

    public void start_connect_bt(View view){
        Intent n_intent = new Intent(this , Connectbt.class);
        startActivity(n_intent);
    }

   /*
    public void insert_coordinates(){

        //for (int i = 0 ; i<target_shots.length ; i+2)
        //{
        //I will call the draw function after filling these up, there are at most 17 bulets in a clip, so a space for x, y cordinates = 34 possible spaces to fill from a full gun load.
        // }
        //hard coded for now
        target_shots[0] = 0;
        // Log.i("Where it should map", String.valueOf(target_shots[0]));
        target_shots[1] = 0;
        target_shots[2] = 0;
        target_shots[3] = 1;
        target_shots[4] = 9999;
        target_shots[5] = -1;
        target_shots[6] = 9999;
        /*target_shots[5] = (float) -2.54;
        target_shots[6] = (float) -2.54;
        target_shots[7] = 0;
        target_shots[8] = 0;
        target_shots[9] = 0;
        target_shots[10] = (float) -5.08;
        target_shots[11] = 0;
        target_shots[12] = (float) -7.62;
        target_shots[13] = 0;
        target_shots[14] = 9999;

    } */

}
