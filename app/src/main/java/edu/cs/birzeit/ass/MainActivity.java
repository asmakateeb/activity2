package edu.cs.birzeit.ass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.VoiceInteractor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String URL = "http://10.0.2.2:80/rest/info.php";
    List<Phone> phoneList;

    //the recyclerview
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        phoneList = new ArrayList<>();

        loadProducts();
    }
    private void loadProducts() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            //converting the string to json array object
                            JSONArray array = new JSONArray(response);

                            //traversing through all the object
                            for (int i = 0; i < array.length(); i++) {

                                //getting product object from json array
                                JSONObject phone = array.getJSONObject(i);

                                //adding the product to product list
                                phoneList.add(new Phone(
                                        phone.getString("phonename")
                                        phone.getString("screensize"),
                                        phone.getString("op"),
                                        phone.getDouble("memory"),
                                        phone.getDouble("battery"),
                                        phone.getString("Weight")
                                ));
                            }

                            //creating adapter object and setting it to recyclerview
                            phoneAdapter adapter = new phoneAdapter(MainActivity.this, phoneList);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }
}