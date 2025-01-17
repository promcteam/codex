package studio.magemonkey.codex.util.actions.actions.list;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import studio.magemonkey.codex.CodexPlugin;
import studio.magemonkey.codex.util.actions.actions.IActionExecutor;
import studio.magemonkey.codex.util.actions.actions.IActionType;
import studio.magemonkey.codex.util.actions.params.IParamResult;
import studio.magemonkey.codex.util.actions.params.IParamType;

import java.util.List;
import java.util.Set;

public class Action_Titles extends IActionExecutor {

    public Action_Titles(@NotNull CodexPlugin<?> plugin) {
        super(plugin, IActionType.TITLES);
    }

    @Override
    @NotNull
    public List<String> getDescription() {
        return plugin.lang().Codex_Editor_Actions_Action_Titles_Desc.asList();
    }

    @Override
    public void registerParams() {
        this.registerParam(IParamType.TARGET);
        this.registerParam(IParamType.TITLES_TITLE);
        this.registerParam(IParamType.TITLES_SUBTITLE);
        this.registerParam(IParamType.TITLES_FADE_IN);
        this.registerParam(IParamType.TITLES_FADE_OUT);
        this.registerParam(IParamType.TITLES_STAY);
    }

    @Override
    protected void execute(@NotNull Entity exe, @NotNull Set<Entity> targets, @NotNull IParamResult result) {
        String title    = result.getParamValue(IParamType.TITLES_TITLE).getString("");
        String subtitle = result.getParamValue(IParamType.TITLES_SUBTITLE).getString("");
        int    fadeIn   = result.getParamValue(IParamType.TITLES_FADE_IN).getInt(0);
        int    stay     = result.getParamValue(IParamType.TITLES_STAY).getInt(20);
        int    fadeOut  = result.getParamValue(IParamType.TITLES_FADE_OUT).getInt(0);

        for (Entity e : targets) {
            if (e.getType() != EntityType.PLAYER) continue;
            Player player = (Player) e;
            player.sendTitle(title, subtitle, fadeIn, stay, fadeOut);
        }
    }

    @Override
    public boolean mustHaveTarget() {
        return true;
    }

}
