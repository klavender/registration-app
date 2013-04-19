package registration.app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.MotionEvent;
import android.widget.Spinner;
import registration.app.ButtonListener;
import android.view.View;

public class MainMenu extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
setContentView(R.layout.main);

        ((Button) findViewById(R.id.mexit)).setOnClickListener(new ButtonListener());
        ((Button) findViewById(R.id.rexit)).setOnClickListener(new ButtonListener());
        ((Button) findViewById(R.id.dexit)).setOnClickListener(new ButtonListener());
        ((Button) findViewById(R.id.bsubmit)).setOnClickListener(new ButtonListener());
        ((Button) findViewById(R.id.bcancel)).setOnClickListener(new ButtonListener());
        Button btnregister = (Button) findViewById(R.id.register);
        btnregister.setOnClickListener(new ButtonListener());
                
        ((Button) findViewById(R.id.random)).setOnClickListener(new ButtonListener());
        ((Button) findViewById(R.id.search)).setOnClickListener(new ButtonListener());
        //((Spinner) findViewById(R.id.fcriteria)).setOnItemSelectedListener(this);
        //((Spinner) findViewById(R.id.scriteria)).setOnItemSelectedListener(this);
        
        
    }
    
    public void onRegister(View v)
    {
        TextView text = (TextView) findViewById(R.id.widget36);
        text.setText("Hello World!");
        //setContentView(R.layout.register);
    }
}
