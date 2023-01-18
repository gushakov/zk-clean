package com.github.zkclean.infrastructure.adapter.zk;

import com.github.zkclean.core.port.presenter.ErrorHandlingPresenterOutputPort;

public abstract class AbstractZkPresenter implements ErrorHandlingPresenterOutputPort {

    @Override
    public void presentError(Throwable t) {
        binder().setError(t.getMessage());
        binder().updateView("error");
    }

    protected abstract ViewBinder binder();
}
