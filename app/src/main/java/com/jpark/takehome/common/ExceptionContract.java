package com.jpark.takehome.common;

/**
 * Created by JH on 2017-04-13.
 */

public interface ExceptionContract {
    void onHttpException(int httpExceptionCode);
    void showErroMessage(String msg);

    void onInternalServerError();
    void onServiceUnavailable();
    void onNotFound();

    void onGeneralError();
}