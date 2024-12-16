package com.learnandroid.animationinsplash;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

    private LottieAnimationView animationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button test = findViewById(R.id.test);
        animationView = findViewById(R.id.animationView);


        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                animationView.setVisibility(View.VISIBLE);
                animationView.playAnimation();

                test.setVisibility(View.INVISIBLE);

                Thread thread = new Thread(){
                    public void run(){
                        try {
                            sleep(1000);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                        finally {
                            //animationView.setVisibility(View.INVISIBLE);
                          //  Toast.makeText(MainActivity.this, "fragment", Toast.LENGTH_SHORT).show();
                           // loadFragment(new DetailsFragment());

                        }
                    }
                }; thread.start();

            }
        });
    }

    public void loadFragment(Fragment fragment){

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

       // ft.add(R.id.fragments,fragment);
        ft.commit();
    }
}