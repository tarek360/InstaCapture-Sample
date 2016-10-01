package com.tarek360.instacapture_sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.android.gms.maps.MapView;
import com.tarek360.instacapture.InstaCapture;
import com.tarek360.instacapture.listener.SimpleScreenCapturingListener;
import java.io.File;

public class MapViewSampleActivity extends AppCompatActivity {

  @BindView(R.id.mapView) public MapView mapView;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_map_view);

    ButterKnife.bind(this);

    mapView.onCreate(savedInstanceState);
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
            startActivity(ShowScreenShotActivity.buildIntent(MapViewSampleActivity.this,
                file.getAbsolutePath()));
          }
        });
  }

  @Override protected void onResume() {
    super.onResume();
    mapView.onResume();
  }

  @Override protected void onPause() {
    mapView.onPause();
    super.onPause();
  }

  @Override protected void onDestroy() {
    mapView.onDestroy();
    super.onDestroy();
  }

  @Override protected void onSaveInstanceState(final Bundle outState) {
    if (mapView != null) {
      mapView.onSaveInstanceState(outState);
    }

    super.onSaveInstanceState(outState);
  }

  @Override public void onLowMemory() {
    if (mapView != null) {
      mapView.onLowMemory();
    }

    super.onLowMemory();
  }
}
