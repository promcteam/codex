package studio.magemonkey.codex.modules;

import org.jetbrains.annotations.NotNull;
import studio.magemonkey.codex.CodexPlugin;
import studio.magemonkey.codex.core.config.CoreConfig;

public abstract class IExternalModule<P extends CodexPlugin<P>> extends IModule<P> {

    public IExternalModule(@NotNull P plugin) {
        super(plugin);
    }

    @NotNull
    public abstract LoadPriority getPriority();

    @Override
    @NotNull
    public String getPath() {
        return CoreConfig.MODULES_PATH_EXTERNAL + this.getId() + "/";
    }

    public static enum LoadPriority {
        HIGH,
        LOW,
        ;
    }
}
