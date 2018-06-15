package com.example.shivamgupta.demotest;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Homectivity extends AppCompatActivity {
    LinearLayout linearLayout;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<modelclass_qstn_answer> listing;
    SwipeRefreshLayout mswipeRefreshLayout;

    private static final String ur_link = "https://learncodeonline.in/api/android/datastructure.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homectivity);
        mswipeRefreshLayout=(SwipeRefreshLayout)findViewById(R.id.swipe_refresh);
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
        recyclerView = (RecyclerView) findViewById(R.id.myrecycyler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
        listing = new ArrayList<>();
        loadRecyclerviewData();
        mswipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadRecyclerviewData();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mswipeRefreshLayout.setRefreshing(false);
                    }
                }, 3000);
            }
        });

    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Homectivity.this,CourseListActivity.class);
        startActivity(intent);
        finish();
    }

    private void loadRecyclerviewData() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Content Loading...");
        progressDialog.show();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, ur_link, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("in response", "hii");
                try {

                    progressDialog.dismiss();
                    JSONObject basejson = new JSONObject(response);
                    JSONArray articlesarray = basejson.getJSONArray("questions");
                    if (articlesarray.length() > 0) {
                        for (int i = 0; i < articlesarray.length(); i++) {
                            JSONObject firstobject = articlesarray.getJSONObject(i);
                            String question = firstobject.getString("question");
                            String answer = firstobject.getString("Answer");
                     modelclass_qstn_answer obj = new modelclass_qstn_answer(question, answer);
                       listing.add(obj);

                        }
                        adapter = new customadapter(listing, getApplication().getApplicationContext());
                        recyclerView.setAdapter(adapter);
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();

                Toast.makeText(getApplicationContext(), "Internet Connection Problem", Toast.LENGTH_SHORT).show();

            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);

    }
}

