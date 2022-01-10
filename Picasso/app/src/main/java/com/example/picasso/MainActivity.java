package com.example.picasso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    ProgressBar progressBar;
    TextView textView;

    enum Example {
        // Success loading image. When loading show spongebob_loading.
        SIMPLE_WORKING,

        // Failed loading image. When loading show spongebob_loading. When failed show spongebob_failed.
        SIMPLE_FAILED,

        // Success loading image. When loaded resize image to 100x100
        RESIZE,

        // Success loading image. When loading show progressBar.
        ADVANCED_WORKING,

        // Failed loading image. When loading show progressBar. When failed - display text
        ADVANCED_FAILED,

        // Task for students
        TASK
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        progressBar = findViewById(R.id.progressBar);
        textView = findViewById(R.id.textView);

        Example example = Example.TASK;

        switch (example) {
            case SIMPLE_WORKING:
                Picasso.get()
                        .load("https://rynekisztuka.pl/wp-content/uploads/2021/03/picasso-e1614587799619.jpg")
                        .placeholder(R.drawable.spongebob_loading)
                        .error(R.drawable.spongebob_failed)
                        .into(imageView);
                break;
            case SIMPLE_FAILED:
                Picasso.get()
                        .load("https://not-existing-link.hr")
                        .placeholder(R.drawable.spongebob_loading)
                        .error(R.drawable.spongebob_failed)
                        .into(imageView);
                break;
            case RESIZE:
                Picasso.get()
                        .load("https://rynekisztuka.pl/wp-content/uploads/2021/03/picasso-e1614587799619.jpg")
                        .placeholder(R.drawable.spongebob_loading)
                        .error(R.drawable.spongebob_failed)
                        .resize(100, 100)
                        .into(imageView);
                break;
            case ADVANCED_WORKING:
                progressBar.setVisibility(View.VISIBLE);

                Picasso.get()
                        .load("https://www.galeriaperspektywa.pl/images/546-1.jpg")
                        .into(imageView, new Callback() {
                            @Override
                            public void onSuccess() {
                                progressBar.setVisibility(View.INVISIBLE);
                            }

                            @Override
                            public void onError(Exception e) {
                                progressBar.setVisibility(View.INVISIBLE);
                                textView.setText(R.string.failed_loading);
                            }
                        });
                break;
            case ADVANCED_FAILED:
                progressBar.setVisibility(View.VISIBLE);

                Picasso.get()
                        .load("https://not-existing-link.hr")
                        .into(imageView, new Callback() {
                            @Override
                            public void onSuccess() {
                                progressBar.setVisibility(View.INVISIBLE);
                            }

                            @Override
                            public void onError(Exception e) {
                                progressBar.setVisibility(View.INVISIBLE);
                                textView.setText(R.string.failed_loading);
                            }
                        });
                break;
            case TASK:
                task();
                break;
        }
    }

    public void task() {
        // Place for task implementation.
    }
}