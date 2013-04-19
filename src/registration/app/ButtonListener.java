/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package registration.app;

import android.view.View;
import android.view.InputEvent;
import android.view.MotionEvent;
import android.os.Bundle;
import android.app.Activity;
import android.widget.Button;

/**
 *
 * @author Kevin Lavender
 */
public class ButtonListener implements Button.OnClickListener
{
    @Override
    public void onClick(View v) 
    {
        View vp = (View) v.getParent();
        Activity a = (Activity) vp.getContext();
        
        switch (v.getId())
        {
            case R.id.mexit:
                a.finish();
                break;
            case R.id.rexit:
            case R.id.dexit:
            case R.id.bcancel:
                a.setContentView(R.layout.main);
                break;
            case R.id.bsubmit:
                break;
            case R.id.random:
                a.setContentView(R.layout.random);
                break;
            case R.id.search:
                a.setContentView(R.layout.data);
                break;
            case R.id.register:
                a.setContentView(R.layout.register);
                break;
            default:
                a.finish();
        }
        
        //return true;
    }
}
