package cn.virtue.modules;

import net.minecraft.client.Minecraft;
import cn.virtue.Virtue;

public abstract class Module {
    public String name;
    public int key;
    public boolean toggled;
    public Category category;

    protected static Minecraft mc = Minecraft.getMinecraft();

    public Module(String name, int key, Category category) {
        this.name = name;
        this.key = key;
        this.category = category;
    }

    public void toggle() {
        toggled = !toggled;
        if (toggled) {
            onEnable();
        } else {
            onDisable();
        }
    }

    public void onEnable() {
        // 核心：模块开启时，将自己注册到 Cubk 的事件总线
        Virtue.instance.eventManager.register(this);
    }

    public void onDisable() {
        // 核心：模块关闭时，解绑监听，节省 CPU 消耗
        Virtue.instance.eventManager.unregister(this);
    }

    public enum Category {
        COMBAT, MOVEMENT, RENDER, PLAYER, WORLD
    }
}