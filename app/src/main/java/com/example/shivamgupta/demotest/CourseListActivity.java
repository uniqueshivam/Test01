package com.example.shivamgupta.demotest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class CourseListActivity extends AppCompatActivity {
    CardView cardView1;
    CardView cardView2;
    CardView cardView3;
    CardView cardView4;
    LinearLayout linearLayout;
    private static final String ur_link = "https://learncodeonline.in/api/android/datastructure.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);
        cardView1=(CardView)findViewById(R.id.ds_topic);
        cardView2=(CardView)findViewById(R.id.cpp_topic);
        cardView3=(CardView)findViewById(R.id.java_topic);
        cardView4=(CardView)findViewById(R.id.html_topic);
        linearLayout = (LinearLayout) findViewById(R.id.advertisment);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://courses.learncodeonline.in"));
                startActivity(intent);
            }
        });
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CourseListActivity.this,Homectivity.class);
                startActivity(intent);
                finish();
            }
        });

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CourseListActivity.this, "Sorry only Data Structure Content available right now", Toast.LENGTH_SHORT).show();
            }
        });

        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CourseListActivity.this, "Sorry only Data Structure Content available right now", Toast.LENGTH_SHORT).show();
            }
        });
        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CourseListActivity.this, "Sorry only Data Structure Content available right now", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
