package com.example.android_template.base

import java.lang.ref.WeakReference


abstract class BasePresenter<V> {
    
    private var viewRef: WeakReference<V>? = null
    
    fun attachView(view: V) {
        viewRef = WeakReference(view)
    }
    
    fun detachView() {
        viewRef?.clear()
        viewRef = null
    }
    
    protected fun getView(): V? {
        return viewRef?.get()
    }
    
    protected fun isViewAttached(): Boolean {
        return getView() != null
    }
} 