package seniordesign.seniordesign;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class Accuracy extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accuracy);
        calculate_accuracy();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_accuracy, menu);
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

    public void calculate_accuracy()
    {
        final TextView acc_label = (TextView) findViewById(R.id.accurate_percentage);
        final TextView acc_title = (TextView) findViewById(R.id.Accurate_title);
        double x;
        double y;
        double distance;


        // acc_label.setText("You've shot ");
        acc_title.setText("You've shot " + Startsession.num_bullets + " bullets: \n");
        for (int i = 0 ; i< Startsession.count; i+=2)
        {
            x = Startsession.target_shots[i];
            y = Startsession.target_shots[i+1];
            distance = Math.sqrt((x*x)+ (y*y));
            acc_label.append("Bullet " + (i/2+1) + ":");
            acc_label.append(String.format( "%.2f", distance) + " cm from center \n");
        }

    }
}
