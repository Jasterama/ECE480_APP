package edu.msu.huangmax.ece480_app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
    }

    public void onStartIntro(View view) {
        goToUrl("https://youtu.be/EznyKH-qWZc");
    }

    public void onStartHow(View view) {
        goToUrl("https://youtu.be/EznyKH-qWZc");
    }

    public void onHelpBack(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
}
