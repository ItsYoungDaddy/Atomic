/*
 * This file is part of the atomic client distribution.
 * Copyright (c) 2021-2021 0x150.
 */

package me.zeroX150.atomic.helper.util;

import java.util.ArrayList;
import java.util.List;

public class Queue<T> {
    final List<T> queue = new ArrayList<>();

    public Queue(List<T> elements) {
        queue.addAll(elements);
    }

    public Queue() {
        this(new ArrayList<>());
    }

    public List<T> getQueue() {
        return queue;
    }

    public T poll() {
        if (queue.size() == 0) return null;
        T element = queue.get(0);
        queue.remove(0);
        return element;
    }

    public void add(T element) {
        queue.add(element);
    }
}
