package seniordesign.seniordesign;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class Clustersize extends ActionBarActivity {
    public double overall_p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clustersize);
        calculate_cluster();
        final TextView cluster_ = (TextView) findViewById(R.id.Cluster_Size);
        cluster_.setText(String.format("%.2f", overall_p));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_clustersize, menu);
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

    public void calculate_cluster()
    {
        double mean_y = 0;
        double mean_x = 0;
        double num_bull = Startsession.num_bullets;
        overall_p = 0;
        for (int i = 0; i < Startsession.count; i += 2) {
            mean_x += Startsession.target_shots[i];
            mean_y += Startsession.target_shots[i+1];
        }
        mean_x= mean_x/num_bull;
        Log.i("mean x :", Double.toString(mean_x));
        mean_y = mean_y/num_bull;
        Log.i("mean y :", Double.toString(mean_y));

        for (int i = 0; i < Startsession.count; i += 2) {
            overall_p += (Startsession.target_shots[i] - mean_x)*(Startsession.target_shots[i] - mean_x) + (Startsession.target_shots[i+1] - mean_y)*(Startsession.target_shots[i+1] - mean_y) ;
        }
        overall_p = (Math.sqrt(overall_p))/num_bull;
        Log.i("Value", Double.toString(overall_p));

        //smaller the p , the ore percise. Need to figure out the max percision and maybe do some things on that


    }
}
