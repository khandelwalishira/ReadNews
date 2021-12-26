package com.ishika.readnews;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScienceFragment extends Fragment {
    String api="7304139b90354661b9a97ecd3fc849f5";
    ArrayList<Modelclass> modelclassArrayList;
    Adapter adapter;
    String country="in";
    private RecyclerView sciencerecyclerview;
    private String category="science";

    @Override
    public View onCreateView(@NonNull  LayoutInflater inflater, @Nullable ViewGroup container, @Nullable  Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.sciencefragement, null);
        sciencerecyclerview=v.findViewById(R.id.sciencerecyclerview);
        modelclassArrayList=new ArrayList<>();
        sciencerecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new Adapter(getContext(),modelclassArrayList);
        sciencerecyclerview.setAdapter(adapter);
        findNews();
        return v;
    }

    private void findNews() {
        ApiUtility.getApiInterface().getCategoryNews(country,category,100,api).enqueue(new Callback<MainNews>() {
            @Override
            public void onResponse(Call<MainNews> call, Response<MainNews> response) {
                if(response.isSuccessful()){
                    modelclassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<MainNews> call, Throwable t) {

            }
        });


    }
}
