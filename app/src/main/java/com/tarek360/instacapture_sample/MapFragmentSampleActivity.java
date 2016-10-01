package com.tarek360.instacapture_sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.tarek360.instacapture.InstaCapture;
import com.tarek360.instacapture.listener.SimpleScreenCapturingListener;
import java.io.File;

/**
 * Created by tarek on 5/28/16.
 */
public class MapFragmentSampleActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_map_fragment);
    ButterKnife.bind(this);
  }

  @OnClick(R.id.fab) public void onClickFAB(View view) {
    captureScreenshot(view);
  }

  private void captureScreenshot(View views) {

    // Capture screenshot
    InstaCapture.getInstance(this)
        .capture(views)
        .setScreenCapturingListener(new SimpleScreenCapturingListener() {

          @Override public void onCaptureComplete(File file) {
            startActivity(ShowScreenShotActivity.buildIntent(MapFragmentSampleActivity.this,
                file.getAbsolutePath()));
          }

          @Override public void onCaptureFailed(Throwable e) {
            super.onCaptureFailed(e);
            e.printStackTrace();
          }
        });
  }
}
