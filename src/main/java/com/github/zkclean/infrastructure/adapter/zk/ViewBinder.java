package com.github.zkclean.infrastructure.adapter.zk;

/**
 * {@link ViewBinder} holds references to the objects from a view-model
 * bound to a ZUL view. {@linkplain ViewBinder} will be passed as an
 * argument to the method retrieving a use case from the application
 * context. It will be used when constructing an instance of a presenter.
 *
 * @see #updateView(String...)
 */
public interface ViewBinder {

    void setError(Throwable t);

    /**
     * Notifies ZK's {@code Binder} that some view properties need to be updated.
     * Will update "error" property automatically.
     *
     * @param properties properties of this view binder to be updated in the view
     */
    void updateView(String... properties);
}