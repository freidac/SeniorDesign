package seniordesign.seniordesign;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import android.widget.ListView;
import java.lang.String;



public class PreviousSession extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_session);
        open_list();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_previous_session, menu);
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

    void open_list(){
        ListView FilesListView = (ListView) findViewById(R.id.listView);
        ArrayAdapter arrayAdapter;
        String final_name;
        ArrayList<File> inFiles = new ArrayList<File>();
        ArrayList<String> File2 = new ArrayList<String>();

        File filesDir = getFilesDir();
        for (File file : filesDir.listFiles()) {
                if(file.getName().contains("aybp")){
                    inFiles.add(file);
                    String [] file2 = String.valueOf(file).split("/");
                    final_name = file2[5].split(".txt")[0];
                    File2.add(final_name);
                }
        }
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, File2);
        FilesListView.setAdapter(arrayAdapter);

    }
}
