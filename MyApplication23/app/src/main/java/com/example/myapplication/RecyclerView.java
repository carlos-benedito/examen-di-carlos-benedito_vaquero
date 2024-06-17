package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;


public class RecyclerView extends AppCompatActivity {
    List<ListElement> elements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        //inicio la funcion
        init();
    }

    public void init(){
        //crear araylist para luego meter cada elemento de RecyclerView
        elements = new ArrayList<>();
        elements.add(new ListElement("#775447", "Pedro", "peru", "activo"));
        elements.add(new ListElement("#776c47", "Julio", "argetina", "activo"));
        elements.add(new ListElement("#475277", "Cande", "italia", "inactivo"));
        elements.add(new ListElement("#776c47", "Anastasia", "rusia", "activo"));
        elements.add(new ListElement("#6c4777", "Pablo", "España", "inactivo"));
        elements.add(new ListElement("#B3261E", "Ana", "peru", "activo"));
        elements.add(new ListElement("#F9DEDC", "Marta", "colobia", "inactivo"));
        elements.add(new ListElement("#D0BCFF", "Eustaquio", "EE.UU", "activo"));
        elements.add(new ListElement("#F2B8B5", "Silvia", "Mongolia", "activo"));
        //le paso los elemnetos al RecyclerView tanto al ListAdapter como al listRecyclerView
        ListAdapter listAdapter = new ListAdapter(elements, this);
        androidx.recyclerview.widget.RecyclerView recyclerView = findViewById(R.id.listRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);

    }
}