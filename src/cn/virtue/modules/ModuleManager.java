package cn.virtue.modules;

import cn.virtue.modules.impl.movement.Sprint;
import java.util.ArrayList;
import java.util.List;

public class ModuleManager {
    private final List<Module> modules = new ArrayList<>();

    public ModuleManager() {


        //add modules

        modules.add(new Sprint());
    }

    public List<Module> getModules() {
        return modules;
    }

    public Module getModule(Class<? extends Module> clazz) {
        return modules.stream().filter(m -> m.getClass() == clazz).findFirst().orElse(null);
    }
}