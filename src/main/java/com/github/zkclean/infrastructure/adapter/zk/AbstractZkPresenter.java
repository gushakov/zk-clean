package com.github.zkclean.infrastructure.adapter.zk;

import com.github.zkclean.core.port.presenter.ErrorHandlingPresenterOutputPort;

/**
 * Common parent for all Presenters which use {@link ViewBinder} to present
 * data to the view.
 * @see #presentError(Throwable)
 */
public abstract class AbstractZkPresenter implements ErrorHandlingPresenterOutputPort {

    @Override
    public void presentError(Throwable t) {
        viewBinder().setError(t);
        viewBinder().updateView();
    }

    /**
     * Concrete presenters must override returning concrete instance of {@link ViewBinder}
     * which will be used by this presenter.
     *
     * @return {@linkplain ViewBinder} implementation
     */
    protected abstract ViewBinder viewBinder();
}
