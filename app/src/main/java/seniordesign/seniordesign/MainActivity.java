package seniordesign.seniordesign;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
    public void start_score(View view){
        Intent intent =  new Intent(this, Startscore.class);
        startActivity(intent);
    }
    public void start_clustersize(View view){
        Intent intent = new Intent(this, Clustersize.class);
        startActivity(intent);
    }
    public void start_Accuracy(View view){
        Intent intent = new Intent(this, Accuracy.class);
        startActivity(intent);
    }
    public void start_Live_View(View view){
        Intent intent = new Intent(this, Live_View.class);
        startActivity(intent);
    }

}
