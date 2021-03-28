package com.alexjandrohum.appmanageusers.contract;

import com.alexjandrohum.appmanageusers.dto.LoginUser;
import com.alexjandrohum.appmanageusers.dto.TokenUser;

public interface LoginUserContract {

    interface LoginPresenter {
        void onDestroy();

        void login(LoginUser loginUser);
    }

    interface LoginView {
        void showError(String error);

        void obtenerToken(TokenUser tokenUser);
    }

    interface LoginDao {
        interface OnFinishedListener {
            void onFinishedLogin(TokenUser tokenUser);

            void onFinishedError(String error);
        }

        void login(LoginUser loginUser, OnFinishedListener onFinishedListener);
    }
}
