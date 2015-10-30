package com.example.estudiante.nomalo.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.estudiante.nomalo.R;
import com.example.estudiante.nomalo.adapter.ContactListAdapter;
import com.example.estudiante.nomalo.database.SQL;
import com.example.estudiante.nomalo.model.Contact;
import com.example.estudiante.nomalo.preference.CacheManager;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Estudiante on 28/10/2015.
 */
public class DummyFragment extends Fragment {


    @Bind(R.id.list) RecyclerView list;
   private ContactListAdapter adapter;
    private ArrayList<Contact> data;
    private SQL sql;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sql=new SQL(getContext());
        data=new ArrayList<>();

        Contact contact=sql.getContact(1);
        if(contact !=null){
            data.add(contact);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView= inflater.inflate(R.layout.fragment_dummy, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        adapter=new ContactListAdapter(data);
        list.setLayoutManager(linearLayoutManager);
        list.setAdapter(adapter);
    }
    public void refresh(long id){//hace una peticion a SQL
        Contact contact=sql.getContact(id);//todos
        if(contact !=null){
            data.add(contact);
        }
    adapter.setData(data);
    adapter.notifyDataSetChanged();}

}
