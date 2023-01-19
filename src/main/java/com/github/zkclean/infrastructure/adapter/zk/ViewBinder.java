package com.github.zkclean.infrastructure.adapter.zk;

/**
 * {@link ViewBinder} holds references to the objects from a view-model
 * bound to a ZUL view. {@linkplain ViewBinder} will be used by Presenter
 * to update the view.
 *
 * @see #updateView(String...)
 */
public interface ViewBinder {

    /**
     * Set the error in the view using provided {@link Throwable}.
     *
     * @param t any error which Presenter needs to present
     */
    void setError(Throwable t);

    /**
     * Notifies ZK's {@code Binder} that some view properties need to be updated.
     * Will update "error" property automatically.
     *
     * @param properties properties of this view binder to be updated in the view
     */
    void updateView(String... properties);
}