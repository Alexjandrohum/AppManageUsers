package com.alexjandrohum.appmanageusers.presenter;

import android.util.Log;

import com.alexjandrohum.appmanageusers.contract.LoginUserContract;
import com.alexjandrohum.appmanageusers.dto.LoginUser;
import com.alexjandrohum.appmanageusers.dto.TokenUser;

public class LoginUserPresenterImpl implements LoginUserContract.LoginPresenter, LoginUserContract.LoginDao.OnFinishedListener {

    private LoginUserContract.LoginView view;
    private LoginUserContract.LoginDao dao;

    public LoginUserPresenterImpl(LoginUserContract.LoginView view, LoginUserContract.LoginDao dao) {
        this.view = view;
        this.dao = dao;
    }

    @Override
    public void onDestroy() {
        this.view = null;
    }

    @Override
    public void login(LoginUser loginUser) {
        if (view != null) {
            try {
                this.dao.login(loginUser, this);
            } catch (Exception e) {
                Log.e("LOG", e.getMessage());
                this.view.showError("El servicio no está funcionando");
            }
        }
    }

    @Override
    public void onFinishedLogin(TokenUser tokenUser) {
        if (view != null) {
            this.view.obtenerToken(tokenUser);
        }
    }

    @Override
    public void onFinishedError(String error) {
        if (view != null) {
            this.view.showError(error);
        }
    }
}
