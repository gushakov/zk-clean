package com.github.zkclean.infrastructure.adapter.zk;

public interface ViewBinder {

    boolean getIsError();

    void setError(String error);

    void updateView(String... properties);
}