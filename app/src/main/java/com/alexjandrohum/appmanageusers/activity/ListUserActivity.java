package com.alexjandrohum.appmanageusers.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.alexjandrohum.appmanageusers.R;
import com.alexjandrohum.appmanageusers.adapter.ListUserAdapter;
import com.alexjandrohum.appmanageusers.contract.ListUserContract;
import com.alexjandrohum.appmanageusers.dao.ListUserDao;
import com.alexjandrohum.appmanageusers.dto.Datum;
import com.alexjandrohum.appmanageusers.dto.ListUsers;
import com.alexjandrohum.appmanageusers.presenter.ListUserPresenterImpl;

import java.util.List;

public class ListUserActivity extends AppCompatActivity implements ListUserContract.listUserContractView {

    private RecyclerView rvListUser;
    private ListUserPresenterImpl presenter;
    private ListUserAdapter listUserAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);

        rvListUser = findViewById(R.id.rvListUser);

        presenter = new ListUserPresenterImpl(this, new ListUserDao());
        presenter.getListUser();


    }

    @Override
    public void showListUser(List<Datum> listUsers) {
        listUserAdapter = new ListUserAdapter(listUsers, this);
        //listUserAdapter.setItems(listUsers);
        rvListUser.setAdapter(listUserAdapter);
    }

    @Override
    public void showMessage(String menssaje) {
        Toast.makeText(this, menssaje, Toast.LENGTH_SHORT).show();
    }
}