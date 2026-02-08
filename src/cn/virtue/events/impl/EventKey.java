package cn.virtue.events.impl;

public class EventKey implements Event { // 必须使用 extends
    private final int key;

    public EventKey(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }
}