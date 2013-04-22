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
        registrant_db = new Registry(this);
        registrant_db.addRegistrant(new Registrant("John,B,Lacroix,12/3/1999,333-333-3333,joey@hotmail.com,hs,address,city,OH,12345"));
        registrant_db.addRegistrant(new Registrant("Jim,B,Rogers,12/3/1999,333-333-3333,joey@hotmail.com,hs,address,city,OH,12345"));
        setContentView(R.layout.main);
        ((Button) findViewById(R.id.bregister)).setOnClickListener(new ButtonListener());
        ((Button) findViewById(R.id.bsearch)).setOnClickListener(new ButtonListener());
        ((Button) findViewById(R.id.brandom)).setOnClickListener(new ButtonListener());
        ((Button) findViewById(R.id.bquit)).setOnClickListener(new ButtonListener());  
    }
    
    public Registry registrant_db;
}
