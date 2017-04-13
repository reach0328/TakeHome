package com.jpark.takehome.common;

import android.util.Log;

/**
 * Created by JH on 2017-04-13.
 */

public class ExceptionHandler implements ExceptionContract{
    private static ExceptionHandler handler = null;
    private static final String TAG = "EXCEPTION";
    private ExceptionHandler(){
    }

    public static ExceptionHandler getInstance(){
        if(handler == null)
            handler = new ExceptionHandler();
        return handler;
    }

    @Override
    public void onHttpException(int code) {
        switch (code) {
            case 500 : onInternalServerError();
            case 503 : onServiceUnavailable();
            case 404 : onNotFound();
            default :
                onGeneralError();
        }
    }

    @Override
    public void onInternalServerError() {
        showErroMessage("onInternalServerError");
    }

    @Override
    public void onServiceUnavailable() {
        showErroMessage("onServiceUnavailable");
    }

    @Override
    public void onNotFound() {
        showErroMessage("onNotFound");
    }

    @Override
    public void onGeneralError() {
        showErroMessage("onGeneralError");
    }

    @Override
    public void showErroMessage(String msg) {
        Log.e(TAG,msg);
    }
}
