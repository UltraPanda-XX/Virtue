package cn.virtue;

import cn.virtue.events.EventManager;
import cn.virtue.events.EventTarget;
import cn.virtue.events.impl.EventKey;
import cn.virtue.modules.Module;
import cn.virtue.modules.ModuleManager;

public class Virtue {
    public static final Virtue instance = new Virtue();

    public final EventManager eventManager = new EventManager();
    public ModuleManager moduleManager;

    public void init() {
        // 1. 初始化模块管理器
        moduleManager = new ModuleManager();
        // 2. 将主类注册到事件系统，用于监听 EventKey 切换模块开关
        eventManager.register(this);
    }

    @EventTarget
    public void onKey(EventKey event) {
        // 遍历模块，匹配按键
        for (Module m : moduleManager.getModules()) {
            if (m.key == event.getKey()) {
                m.toggle();
            }
        }
    }
}