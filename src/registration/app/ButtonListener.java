/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package registration.app;

import android.view.View;
import android.widget.EditText;
import android.view.MotionEvent;
import android.app.AlertDialog;
import android.widget.ListView;
import android.widget.TextView;
import android.content.DialogInterface;
import java.util.ArrayList;
import android.os.Bundle;
import android.app.Activity;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import java.util.Iterator;
/**
 *
 * @author Kevin Lavender
 */
public class ButtonListener implements View.OnClickListener, Spinner.OnItemSelectedListener
{
    @Override
    public void onItemSelected(AdapterView<?> adapterView,View v,int p,long id)
    {
        Spinner spinner = (Spinner) v;
        String item = spinner.getSelectedItem().toString();
        
        if (item == "First Name")
        {
            
        }
        else if (item == "Last Name")
        {
            
        }
        else if (item == "Zip Code")
        {
            
        }
        else if (item == "Email")
        {
            
        }
        
    }
    
    @Override
    public void onNothingSelected(AdapterView<?> adapterView)
    {
        
    }
    
    @Override
    public void onClick(View v) 
    {
        View vp = (View) v.getParent();
        final Activity a = (Activity) vp.getContext();
        
        switch (v.getId())
        {
            case R.id.bquit:
                a.finish();
                break;
            case R.id.bsubmit:
                final Registrant registree = new Registrant();
                boolean valError = false;
                int[] datafields = {R.id.fname,R.id.mname,R.id.lname,R.id.dob,
                    R.id.phone,R.id.email,R.id.hschool,R.id.address,R.id.city,
                    R.id.state,R.id.zip};
                String[] validations = {"[a-zA-Z]+","[a-zA-Z]","[a-zA-Z]+","[01][0-9][/][0-3][0-9][/][21][0-9]{3}",
                    "([0-9]{3}-){2}[0-9]{4}","[_a-z0-9-]+(.[_a-z0-9-]+)*@[a-z0-9-]+(.[a-z0-9-]+)(.[a-z]{2,4})",
                    "[a-zA-Z]+","[a-zA-Z0-9]+","[a-zA-Z]+","[a-zA-Z]{2}","[0-9]{5}"};
                String[] helptext = {"A-Z (George)","A-Z (Jr, K. etc.)","A-Z (Johnson)","xx/xx/xxxx (12/21/1995)","xxx-xxx-xxxx (740-523-2312)",
                    "x@x.xx (joey@hotmail.com)","A-Z (Johnson High)","A-Z 0-9 . (123 Test Str.)","A-Z (New York)","A-Z xx (OH)","0-9 xxxxx (24502)"};
                
                for (int i = 0; i < 11; i++)
                {
                    EditText edit = (EditText)a.findViewById(datafields[i]);
                    if (edit.getText().toString().matches(validations[i]))
                        registree.setField(i,edit.getText().toString());
                    else
                    {
                        edit.setError(helptext[i]);
                        valError = true;
                    }
                }
                
                if (valError)
                {
                    AlertDialog.Builder alertb = new AlertDialog.Builder(a);
                    alertb.setTitle("Validation Error!");
                    alertb.setMessage("One more more fields failed validation. Please correct any errors and resubmit the form");
                    alertb.setCancelable(false);
                    alertb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id)
                        {
                            dialog.dismiss();
                        }
                    });
                    AlertDialog alert = alertb.create();
                    alert.show();
                    return;
                }
                else
                {
                    AlertDialog.Builder alertb = new AlertDialog.Builder(a);
                    alertb.setTitle("Are you sure?");
                    alertb.setMessage("Are you sure you wish to submit?");
                    alertb.setCancelable(false);
                    alertb.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id)
                        {
                            ((MainMenu)a).registrant_db.addRegistrant(registree);
                            a.setContentView(R.layout.main);
                            ((Button) a.findViewById(R.id.bregister)).setOnClickListener(new ButtonListener());
                            ((Button) a.findViewById(R.id.bsearch)).setOnClickListener(new ButtonListener());
                            ((Button) a.findViewById(R.id.brandom)).setOnClickListener(new ButtonListener());
                            ((Button) a.findViewById(R.id.bquit)).setOnClickListener(new ButtonListener());
                        }
                    });
                    alertb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id)
                        {
                            dialog.dismiss();
                        }
                    });
                    AlertDialog alert = alertb.create();
                    alert.show();
                }
                break;
            case R.id.bexit1:
            case R.id.bexit2:
            case R.id.bcancel:
                a.setContentView(R.layout.main);
                ((Button) a.findViewById(R.id.bregister)).setOnClickListener(this);
                ((Button) a.findViewById(R.id.bsearch)).setOnClickListener(this);
                ((Button) a.findViewById(R.id.brandom)).setOnClickListener(this);
                ((Button) a.findViewById(R.id.bquit)).setOnClickListener(this);
                break;
            case R.id.brandom:
                a.setContentView(R.layout.random);
                ((Button) a.findViewById(R.id.bexit2)).setOnClickListener(this);
                ((Button) a.findViewById(R.id.bselect)).setOnClickListener(this);
                break;
            case R.id.bselect:
                TextView text = (TextView) a.findViewById(R.id.rtext);
                Registrant registre = (Registrant) ((MainMenu)a).registrant_db.selectRandom();
                text.setText(registre.getField(0) + " " + registre.getField(1) + " " + registre.getField(2)
                        + "\n" + registre.getField(5));
                break;
            case R.id.bsearch:
                a.setContentView(R.layout.data);
                ArrayAdapter<CharSequence> fsa = ArrayAdapter.createFromResource(
                a, R.array.fopts, android.R.layout.simple_spinner_item);
                ArrayAdapter<CharSequence> ssa = ArrayAdapter.createFromResource(
                a, R.array.sopts, android.R.layout.simple_spinner_item);
                
                
                ((Button) a.findViewById(R.id.bexit1)).setOnClickListener(this);
                Spinner fs = (Spinner) a.findViewById(R.id.fcriteria);
                Spinner ss = (Spinner) a.findViewById(R.id.scriteria);
                
                
                fsa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                ssa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                //fs.setAdapter(fsa);
                //ss.setAdapter(ssa);
                fs.setOnItemSelectedListener(this);
                ss.setOnItemSelectedListener(this);
                
                ListView list = (ListView) a.findViewById(R.id.flist);
                ArrayList<Registrant> registrants = ((MainMenu)a).registrant_db.getRegistrants("", "","");
                ArrayAdapter<Registrant> aa = new ArrayAdapter<Registrant>(a,android.R.layout.simple_list_item_1,registrants);
                list.setAdapter(aa);
                
                break;
            case R.id.bregister:
                a.setContentView(R.layout.register);
                ((Button) a.findViewById(R.id.bcancel)).setOnClickListener(this);
                ((Button) a.findViewById(R.id.bsubmit)).setOnClickListener(this);
                break;
            default:
                a.finish();
        }
        
        //return true;
    }
}
