package me.darkeyedragon.randomtp.addon;

import me.angeschossen.lands.api.integration.LandsIntegration;
import me.darkeyedragon.randomtp.RandomTeleport;
import me.darkeyedragon.randomtp.SpigotImpl;
import me.darkeyedragon.randomtp.api.addon.RandomAddon;
import me.darkeyedragon.randomtp.api.world.location.RandomLocation;
import me.darkeyedragon.randomtp.common.addon.BaseRequiredPlugin;
import me.darkeyedragon.randomtp.util.WorldUtil;

/**
 * Validator for the Lands plugin
 */
public class LandsValidator extends RandomAddon {
    private LandsIntegration landsIntegration;
    private SpigotImpl plugin;


    public LandsValidator() {
        super.addRequiredPlugin(new BaseRequiredPlugin("Lands", "6.0.0"));
    }

    @Override
    public String getIdentifier() {
        return "LandsValidator";
    }

    @Override
    public boolean isValid(RandomLocation randomLocation) {
        //TODO this is a dirty hack since the addon manager is only set after instantiating the addon so it cannot be done in the constructor.
        if (plugin == null) {
            plugin = ((RandomTeleport) getAddonManager().getInstance()).getPlugin();
            landsIntegration = new LandsIntegration(plugin);
        }
        return !landsIntegration.isClaimed(WorldUtil.toLocation(randomLocation));
    }
}
