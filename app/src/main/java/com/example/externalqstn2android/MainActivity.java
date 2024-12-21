package com.example.externalqstn2android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.content.SharedPreferences;
import android.os.Bundle;
 import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class MainActivity extends AppCompatActivity {

    private Switch switchDoNotDisturb, switchWritingContent , SwitchVibration,SwitchLEd,SwitchShowBanners,SwitchOnloackScreen;
    private Button btnSave;
    public TextView Vibration,LEd,ShowbANNER,ShowContent,ShowLockScreen,Sounds;
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        switchDoNotDisturb = findViewById(R.id.DND);
//        switchWritingContent = findViewById(R.id.DND2);
        Vibration=findViewById(R.id.Vibration);
        LEd=findViewById(R.id.Led);
        ShowbANNER=findViewById(R.id.Vib);
        ShowContent=findViewById(R.id.Onlock);
        ShowLockScreen=findViewById(R.id.Led);
        Sounds=findViewById(R.id.so);
        btnSave=findViewById(R.id.save);
        btnSave = findViewById(R.id.save);
        sharedPreferences = getSharedPreferences("NotificationPrefs", MODE_PRIVATE);
        loadPreferences();
        btnSave.setOnClickListener(v -> showBottomSheet());
    }

    private void loadPreferences() {
        boolean doNotDisturb = sharedPreferences.getBoolean("DoNotDisturb", false);
        boolean writingContent = sharedPreferences.getBoolean("WritingContent", false);

        switchDoNotDisturb.setChecked(doNotDisturb);
        switchWritingContent.setChecked(writingContent);
    }

    private void showBottomSheet() {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.activity_main);
        bottomSheetDialog.findViewById(R.id.save).setOnClickListener(v -> {
            savePreferences();
            bottomSheetDialog.dismiss();
        });

        bottomSheetDialog.show();
    }
    private void savePreferences() {
        // Save the toggle states in SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("DoNotDisturb", switchDoNotDisturb.isChecked());
        editor.putBoolean("WritingContent", switchWritingContent.isChecked());
        editor.apply();
        Toast.makeText(this, "Preferences Saved!", Toast.LENGTH_SHORT).show();
    }
}
