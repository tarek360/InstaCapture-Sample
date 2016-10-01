package com.tarek360.instacapture_sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.tarek360.instacapture.InstaCapture;
import com.tarek360.instacapture.listener.SimpleScreenCapturingListener;
import java.io.File;

public class SimpleActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_simple);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    ButterKnife.bind(this);
  }

  @OnClick(R.id.fab) public void onClickFAB() {
    captureScreenshot();
  }

  private void captureScreenshot() {
    // Capture screenshot
    InstaCapture.getInstance(this)
        .capture()
        .setScreenCapturingListener(new SimpleScreenCapturingListener() {

          @Override public void onCaptureComplete(File file) {
            startActivity(
                ShowScreenShotActivity.buildIntent(SimpleActivity.this, file.getAbsolutePath()));
          }
        });
  }
}
