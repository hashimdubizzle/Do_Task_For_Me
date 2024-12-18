package com.example.dotaskforme;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SplashScreen extends AppCompatActivity {
    private ImageView ivLogo;
    TextView tvslogan;

    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;


        });
        ivLogo = findViewById(R.id.ivlogo);
        tvslogan = findViewById(R.id.tvslogan);
        Animation logoAnimation = AnimationUtils.loadAnimation(this, R.anim.logo_animation);
        Animation textAnimation = AnimationUtils.loadAnimation(this, R.anim.text_animation);


        ivLogo.startAnimation(logoAnimation);
        tvslogan.startAnimation(textAnimation);

        new Handler().postDelayed(() -> {
            // Start the next activity with ActivityResultLauncher
            Intent intent = new Intent(SplashScreen.this, Login.class);
            startActivity(intent);
            finish();  // Close the splash activity
        }, 5000);  // Duration of splash screen
    }
}