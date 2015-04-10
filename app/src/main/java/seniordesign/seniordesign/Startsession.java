package seniordesign.seniordesign;


import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Set;
import java.util.UUID;


public class Startsession extends ActionBarActivity {
    private String[] values = new String[30];
    BluetoothSocket mmSocket;
    BluetoothDevice mmDevice = null;
    final byte delimiter = 33; //33 is a !
    int readBufferPosition = 0;
    int count = 0;

    public void sendBtMsg(String msg2send){
        UUID uuid = UUID.fromString("94f39d29-7d6d-437d-973b-fba39e49d4ee"); //Standard SerialPortService ID
        try {
            mmSocket = mmDevice.createRfcommSocketToServiceRecord(uuid);
            if (!mmSocket.isConnected()){
                mmSocket.connect();
            }
            String msg = msg2send;
//msg += "\n";
            OutputStream mmOutputStream = mmSocket.getOutputStream();
            mmOutputStream.write(msg.getBytes());
        } catch (IOException e) {
// TODO Auto-generated catch block
            //     e.printStackTrace();
        }
    }
  //  ImageView image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startsession);
        final Handler handler = new Handler();
        final TextView myLabel = (TextView) findViewById(R.id.textView2);
        final Button lightOffButton = (Button) findViewById(R.id.button5);
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        final class workerThread implements Runnable {
            private String btMsg;

            public workerThread(String msg) {
                btMsg = msg;
            }
            public void run()
            {
                sendBtMsg(btMsg);
                while(!Thread.currentThread().isInterrupted())
                {
                    int bytesAvailable;
                    boolean workDone = false;
                    try {
                        final InputStream mmInputStream;
                        mmInputStream = mmSocket.getInputStream();
                        bytesAvailable = mmInputStream.available();
                        if(bytesAvailable > 0)
                        {
                            byte[] packetBytes = new byte[bytesAvailable];
                            Log.e("Aquarium recv bt", "bytes available");
                            byte[] readBuffer = new byte[1024];
                            mmInputStream.read(packetBytes);
                            for(int i=0;i<bytesAvailable;i++)
                            {
                                byte b = packetBytes[i];
                                if(b == delimiter)//checks for eending byte which is ! (33 in decimal)
                                {
                                    byte[] encodedBytes = new byte[readBufferPosition];
                                    System.arraycopy(readBuffer, 0, encodedBytes, 0, encodedBytes.length);
                                    final String data = new String(encodedBytes, "US-ASCII");
                                    readBufferPosition = 0;
//The variable data now contains our full command
                                    handler.post(new Runnable()
                                    {
                                        public void run()
                                        {
                                            myLabel.setText(data);
                                            values[count] = data;
                                            Log.i("The data", values[count]);
                                            count+=1;
                                        }
                                    });
                                    workDone = true; //was commented out
                                    break;
                                }
                                else
                                {
                                    readBuffer[readBufferPosition++] = b;
                                }
                            }
                            if (workDone == true){
                                mmSocket.close();
                                break;
                            }
                        }
                    } catch (IOException e) {
// TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        };



        //start light off button handler
        // on every button press, creates a new thread to open socket
        lightOffButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on temp button click
                (new Thread(new workerThread("lightOn"))).start();
            }
        });// end light off button handler

        if(!mBluetoothAdapter.isEnabled())
        {
            Intent enableBluetooth = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBluetooth, 0);
        }
        Set<BluetoothDevice> pairedDevices = mBluetoothAdapter.getBondedDevices();
        if(pairedDevices.size() > 0)
        {
            for(BluetoothDevice device : pairedDevices)
            {
                if(device.getName().equals("Freida")) //Note, you will need to change this to match the name of your device
                {
                    Log.e("AYBP",device.getName());
                    mmDevice = device;
                    break;
                }
            }
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_startsession, menu);
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
