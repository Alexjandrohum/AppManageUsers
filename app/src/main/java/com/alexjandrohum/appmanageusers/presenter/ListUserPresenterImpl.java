package com.alexjandrohum.appmanageusers.presenter;

import com.alexjandrohum.appmanageusers.contract.ListUserContract;
import com.alexjandrohum.appmanageusers.dto.Datum;
import com.alexjandrohum.appmanageusers.dto.ListUsers;

import java.util.List;

public class ListUserPresenterImpl implements ListUserContract.listUserContractPresenter, ListUserContract.ListUserContractDao.OnFinishedListener {

    private ListUserContract.listUserContractView view;
    private ListUserContract.ListUserContractDao dao;

    public ListUserPresenterImpl(ListUserContract.listUserContractView view, ListUserContract.ListUserContractDao dao) {
        this.view = view;
        this.dao = dao;
    }


    @Override
    public void onFinishedListenerShowList(List<Datum> listUsers) {
        if(view != null ){
            view.showListUser(listUsers);
        }
    }

    @Override
    public void onFinishedListenerShowMessage(String message) {
        if(view != null){
            view.showMessage(message);
        }
    }

    @Override
    public void onDestroy() {
        if ( view != null ){
            this.view = null;
        }
    }

    @Override
    public void getListUser() {
        if (view != null){
            this.dao.getListUser(this);
        }
    }
}
