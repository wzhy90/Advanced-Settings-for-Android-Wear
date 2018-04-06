package com.sssemil.advancedsettings;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

public class UnpairActivity extends Activity {
    public TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_unpair);
        mTextView = findViewById(R.id.warning);

        Button unpair = (Button) findViewById(R.id.unpair);
        unpair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    new ProcessBuilder(new String[] {"su", "-c", "pm", "clear", "com.google.android.gms"}).start().waitFor();
                    new ProcessBuilder(new String[] {"su", "-c", "reboot"}).start().waitFor();
                    UnpairActivity.this.finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Button cancel = (Button) findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UnpairActivity.this.finish();
            }
        });

/*        LinearLayout mLinear = new LinearLayout(getApplicationContext());
        View prefsRoot = LayoutInflater.from(this).inflate(R.layout.activity_unpair, mLinear, true);
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
        localBuilder.setCancelable(false).setPositiveButton(getString(R.string.unpair), new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //new ProcessBuilder(new String[] {"su", "-c", "pm", "clear", "com.google.android.gms"}).start().waitFor();
                //new ProcessBuilder(new String[] {"su", "-c", "reboot"}).start().waitFor();
                UnpairActivity.this.finish();
            }
        }).setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                UnpairActivity.this.finish();
            }
        });
        localBuilder.setView(prefsRoot);
        localBuilder.show();
        */
    }
}
