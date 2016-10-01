package com.tarek360.instacapture_sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.tarek360.instacapture.InstaCapture;
import com.tarek360.instacapture.listener.SimpleScreenCapturingListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class IgnoreViewsSampleActivity extends AppCompatActivity {

  @BindView(R.id.textViewCheckBox) CheckBox textViewCheckBox;
  @BindView(R.id.buttonCheckBox) CheckBox buttonCheckBox;
  @BindView(R.id.imageViewCheckBox) CheckBox imageViewCheckBox;

  @BindView(R.id.textView) TextView textView;
  @BindView(R.id.button) Button button;
  @BindView(R.id.imageView) ImageView imageView;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ignore_views_sample);
    ButterKnife.bind(this);
  }

  @OnClick(R.id.fab) public void onClickFAB(View view) {

    List<View> views = new ArrayList<>();

    views.add(view);

    if (!textViewCheckBox.isChecked()) {
      views.add(textView);
    }
    if (!buttonCheckBox.isChecked()) {
      views.add(button);
    }
    if (!imageViewCheckBox.isChecked()) {
      views.add(imageView);
    }

    View[] ignoredViews = new View[views.size()];
    ignoredViews = views.toArray(ignoredViews);

    captureScreenshot(ignoredViews);
  }

  private void captureScreenshot(View[] views) {

    // Capture screenshot
    InstaCapture.getInstance(this)
        .capture(views)
        .setScreenCapturingListener(new SimpleScreenCapturingListener() {

          @Override public void onCaptureComplete(File file) {
            startActivity(ShowScreenShotActivity.buildIntent(IgnoreViewsSampleActivity.this,
                file.getAbsolutePath()));
          }
        });
  }

  @OnClick(R.id.textView) public void onClickTextView() {
    textViewCheckBox.setChecked(!textViewCheckBox.isChecked());
  }

  @OnClick(R.id.button) public void onClickButton() {
    buttonCheckBox.setChecked(!buttonCheckBox.isChecked());
  }

  @OnClick(R.id.imageView) public void onClickImageView() {
    imageViewCheckBox.setChecked(!imageViewCheckBox.isChecked());
  }
}
