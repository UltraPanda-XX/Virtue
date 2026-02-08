package cn.virtue.modules.impl.movement;

import cn.virtue.events.EventTarget;
import cn.virtue.events.impl.EventUpdate;
import cn.virtue.modules.Module;
import org.lwjgl.input.Keyboard;

public class Sprint extends Module {

    public Sprint() {
        super("Sprint", Keyboard.KEY_Z, Category.MOVEMENT);
    }

    @EventTarget
    public void onUpdate(EventUpdate event) {
        // 只有在按下 W 且没有吃东西、没有潜行时自动疾跑
        if (mc.player.moveForward > 0 && !mc.player.isSneaking() && !mc.player.isHandActive()) {
            mc.player.setSprinting(true);
        }
    }

    @Override
    public void onDisable() {
        super.onDisable(); // 必须调用父类解绑事件
        if (mc.player != null) mc.player.setSprinting(false);
    }
}