package com.github.zkclean.infrastructure.adapter.zk;

import com.github.zkclean.core.port.presenter.ErrorHandlingPresenterOutputPort;

public abstract class AbstractZkPresenter implements ErrorHandlingPresenterOutputPort {

    @Override
    public void presentError(Throwable t) {
        binder().setError(t);
        binder().updateView();
    }

    /**
     * Concrete presenters must override returning concrete instance of {@link ViewBinder}
     * which will be used by this presenter.
     *
     * @return {@linkplain ViewBinder} implementation
     */
    protected abstract ViewBinder binder();
}
