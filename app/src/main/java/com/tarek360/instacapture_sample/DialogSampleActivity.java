package com.tarek360.instacapture_sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.tarek360.instacapture.InstaCapture;
import com.tarek360.instacapture.listener.SimpleScreenCapturingListener;
import com.tarek360.instacapture_sample.dialog.AlertDialogFragment;
import java.io.File;

public class DialogSampleActivity extends AppCompatActivity
    implements AlertDialogFragment.OnAlertDialogListener {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_dialog_sample);

    findViewById(R.id.show_dialog).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        showAlertDialog();
      }
    });
  }

  private void showAlertDialog() {
    AlertDialogFragment.newInstance(R.string.dialog_title, R.string.dialog_message)
        .show(getSupportFragmentManager(), "dialogFragment");
  }

  @Override public void OnPositiveButtonClick() {

    // Capture screenshot
    InstaCapture.getInstance(this)
        .capture()
        .setScreenCapturingListener(new SimpleScreenCapturingListener() {

          @Override public void onCaptureComplete(File file) {

            startActivity(ShowScreenShotActivity.buildIntent(DialogSampleActivity.this,
                file.getAbsolutePath()));
          }
        });
  }
}
