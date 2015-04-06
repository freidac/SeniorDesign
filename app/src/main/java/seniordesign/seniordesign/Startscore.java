package seniordesign.seniordesign;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class Startscore extends ActionBarActivity {
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startscore);
        TextView myLabel = (TextView) findViewById(R.id.score_result);
        calculate_score(500,622);
        calculate_score(300,300);
        calculate_score(600, 650);
        calculate_score(700, 650);
        calculate_score(800, 650);
        myLabel.setText(Integer.toString(score));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_startscore, menu);
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

    public void calculate_score(int x_1,int y_1){
        int R5 = 350 *350;
        int R4 = 275 * 275;
        int R3 = 200 *200;
        int R2= 125 *125;
        int R1 = 50 *50 ;


        int x_center = MyView.center_point_x; // 492;// center of our circle
        int y_center = MyView.center_point_y; // 481;// center of our circle
        int predicted_radius = (x_center - x_1)*(x_center - x_1) + (y_center - y_1)*(y_center - y_1);
        Log.i("Predicted Radius", Integer.toString(predicted_radius));

        if(predicted_radius > R5)
        {
            Log.i("Point Status", "Outside of target");
            score +=0;
            //    myLabel.setText("Inside of Circle");

        }
        else if(predicted_radius < R5 && predicted_radius > R4)
        {
            Log.i("Point Status", "In R5 ring");
            score+=7;

            //     myLabel.setText("Outside of Circle");
        }
        else if(predicted_radius < R4 && predicted_radius > R3)
        {
            Log.i("Point Status", "In R4 ring");
            score+=8;


        }

        else if(predicted_radius < R3 && predicted_radius > R2)
        {
            Log.i("Point Status", "In R3 ring");
            score+=9;

        }

        else if(predicted_radius < R2 && predicted_radius > R1)
        {
            Log.i("Point Status", "In R2 ring");
            score+=10;

        }

        else if(predicted_radius < R1)
        {
            Log.i("Point Status", "In R1 ring");
            score+=15;

        }

    }
}
