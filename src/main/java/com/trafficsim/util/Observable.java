package com.trafficsim.util;

import java.util.ArrayList;
import java.util.List;

/** A minimal, framework-agnostic observable value. Used in place of JavaFX's
 *  {@code ObjectProperty} in non-UI code, so packages like {@code editor} stay reusable outside
 *  a JavaFX front end (e.g. from a future web backend). */
public class Observable<T>
{

    @FunctionalInterface
    public interface Listener<T>
    {
        void changed(T oldValue, T newValue);
    }

    private T value;
    private final List<Listener<T>> listeners = new ArrayList<>();

    public Observable(T initialValue)
    {
        this.value = initialValue;
    }

    public T get()
    {
        return value;
    }

    public void set(T newValue)
    {
        T old = value;
        value = newValue;
        for (Listener<T> listener : listeners)
        {
            listener.changed(old, newValue);
        }
    }

    public void addListener(Listener<T> listener)
    {
        listeners.add(listener);
    }
}
