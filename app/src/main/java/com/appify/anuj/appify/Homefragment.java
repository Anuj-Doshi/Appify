package com.appify.anuj.appify;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Homefragment extends Fragment {
    private final String JSON_URL="https://api.myjson.com/bins/1cmkmk";

    private JsonArrayRequest request;
    private RequestQueue queue;
    private List<Anime> stanime;
    private RecyclerView recyclerView;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.activity_home,container,false);

    }
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        stanime=new ArrayList<>();
        recyclerView=(RecyclerView)getView().findViewById(R.id.recyclerview_id);
        jsonrequest();
    }
    private void jsonrequest()
    {
        request=new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject object=null;

                for(int i=0;i<response.length();i++)
                {
                    try {
                        object=response.getJSONObject(i);
                        Anime anime=new Anime();
                        anime.setApp_name(object.getString("app_name"));
                        anime.setIcon(object.getString("app_icon"));
                        anime.setDescription(object.getString("app_description"));
                        anime.setApk(object.getString("app_apk"));
                        anime.setSs1(object.getString("app_ss1"));
                        anime.setSs2(object.getString("app_ss2"));
                        anime.setSs3(object.getString("app_ss3"));
                        stanime.add(anime);
                    }
                    catch (JSONException e)
                    {
                        e.printStackTrace();
                    }
                }
                setuprecyclerview(stanime);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue= Volley.newRequestQueue(getContext());
        queue.add(request);
    }

    private void setuprecyclerview(List<Anime> stanime) {
        RecyclerViewAdapter myAdapter=new RecyclerViewAdapter(getContext(),stanime);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(myAdapter);
    }
}
