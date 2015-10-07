package seniordesign.seniordesign;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
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
        calculate_score();
       // myLabel.setText(Integer.toString(score));

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

    public void calculate_score() {
        int R5 = MyView.Radius5 * MyView.Radius5;
        int R4 = MyView.Radius4 * MyView.Radius4;
        int R3 = MyView.Radius3 * MyView.Radius3;
        int R2 = MyView.Radius2 * MyView.Radius2;
        int R1 = MyView.Radius1 * MyView.Radius1;
        int x_1 ;
        int y_1 ;
        double cmtopix= MyView.cmtopix;

        int x_center = MyView.center_point_x;// center of our circle
        int y_center = MyView.center_point_y;// center of our circle
        for (int i = 0; i < Startsession.count; i += 2) {


                x_1 = (int) ((Startsession.target_shots[i] * cmtopix) + x_center);
                y_1 = (int) ((Startsession.target_shots[i + 1] * -cmtopix) + y_center);

                int predicted_radius = (x_center - x_1) * (x_center - x_1) + (y_center - y_1) * (y_center - y_1);

                if (predicted_radius > R1) {
                    score += 0;

                } else if (predicted_radius <= R1 && predicted_radius > R2) {
                    score += 2;

                } else if (predicted_radius <= R2 && predicted_radius > R3) {
                    score += 4;


                } else if (predicted_radius <= R3 && predicted_radius > R4) {
                    score += 6;

                } else if (predicted_radius <= R4 && predicted_radius > R5) {
                    score += 8;

                } else if (predicted_radius <= R5) {
                    score += 15;

                }
        }
    }
}
