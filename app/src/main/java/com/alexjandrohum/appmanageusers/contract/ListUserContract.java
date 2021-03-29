package com.alexjandrohum.appmanageusers.contract;

import com.alexjandrohum.appmanageusers.dto.Datum;
import com.alexjandrohum.appmanageusers.dto.ListUsers;

import java.util.List;

public interface ListUserContract {

    interface listUserContractView {
        void showListUser(List<Datum> listUsers);

        void showMessage(String menssaje);
    }

    interface listUserContractPresenter {
        void onDestroy();
        void getListUser();
    }

    interface ListUserContractDao {
        interface OnFinishedListener {
            void onFinishedListenerShowList(List<Datum> listUsers);

            void onFinishedListenerShowMessage(String message);
        }

        void getListUser(OnFinishedListener onFinishedListener);
    }

}
