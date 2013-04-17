package registration.app;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class MainMenu extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //WebView web = new WebView(this);
        //web.getSettings().setJavaScriptEnabled(true);
        //web.loadUrl("file:///android_asset/index.html");
        //setContentView(web);
        setContentView(R.layout.main);
    }
}
