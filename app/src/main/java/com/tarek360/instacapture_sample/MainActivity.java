package com.tarek360.instacapture_sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.tarek360.instacapture.InstaCapture;
import com.tarek360.instacapture.InstaCaptureConfiguration;

public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    InstaCaptureConfiguration config = new InstaCaptureConfiguration.Builder().logging(true).build();
    InstaCapture.setConfiguration(config);
  }

  @OnClick(R.id.sample_simple) public void simpleSample() {
    startActivity(new Intent(this, SimpleActivity.class));
  }
  @OnClick(R.id.sample_google_map_fragment) public void googleMapFragmentSample() {
    startActivity(new Intent(this, MapFragmentSampleActivity.class));
  }

  @OnClick(R.id.sample_google_map_view) public void googleMapViewSample() {
    startActivity(new Intent(this, MapViewSampleActivity.class));
  }

  @OnClick(R.id.sample_dialog) public void dialogSample() {
    startActivity(new Intent(this, DialogSampleActivity.class));
  }

  @OnClick(R.id.sample_ignore_views) public void ignoreViewsSample() {
    startActivity(new Intent(this, IgnoreViewsSampleActivity.class));
  }
}
