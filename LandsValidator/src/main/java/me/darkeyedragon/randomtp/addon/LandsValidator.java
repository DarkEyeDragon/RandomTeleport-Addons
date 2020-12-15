package me.darkeyedragon.randomtp.addon;

import me.angeschossen.lands.api.integration.LandsIntegration;
import me.darkeyedragon.randomtp.RandomTeleport;
import me.darkeyedragon.randomtp.api.world.location.RandomLocation;
import me.darkeyedragon.randomtp.common.addon.RandomAddon;
import me.darkeyedragon.randomtp.common.plugin.RandomTeleportPlugin;
import me.darkeyedragon.randomtp.common.plugin.RandomTeleportPluginImpl;
import me.darkeyedragon.randomtp.util.WorldUtil;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

/**
 * Validator for the Lands plugin
 *
 */
public class LandsValidator extends RandomAddon
{
    private final LandsIntegration landsIntegration;


    public LandsValidator() {
        Plugin plugin = ((RandomTeleport)getAddonManager().getInstance()).getPlugin();
        landsIntegration = new LandsIntegration(plugin);
    }

    @Override
    public String getIdentifier() {
        return "LandsValidator";
    }

    @Override
    public boolean isValid(RandomLocation randomLocation) {
        return !landsIntegration.isClaimed(WorldUtil.toLocation(randomLocation));
    }
}
