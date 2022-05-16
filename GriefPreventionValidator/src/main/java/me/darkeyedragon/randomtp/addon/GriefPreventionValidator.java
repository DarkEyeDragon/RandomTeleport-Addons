package me.darkeyedragon.randomtp.addon;

import me.darkeyedragon.randomtp.api.addon.RandomAddon;
import me.darkeyedragon.randomtp.api.world.location.RandomLocation;
import me.darkeyedragon.randomtp.common.addon.BaseRequiredPlugin;
import me.darkeyedragon.randomtp.util.WorldUtil;
import me.ryanhamshire.GriefPrevention.Claim;
import me.ryanhamshire.GriefPrevention.GriefPrevention;
import org.bukkit.Location;

/**
 * GriefPrevention location validator
 *
 */
public class GriefPreventionValidator extends RandomAddon
{

    public GriefPreventionValidator() {
        super.addRequiredPlugin(new BaseRequiredPlugin("GriefPrevention", "16.13.0"));
    }

    @Override
    public String getIdentifier() {
        return "GriefPreventionValidator";
    }

    @Override
    public boolean isValid(RandomLocation location) {
        Location loc = WorldUtil.toLocation(location);
        Claim claim = GriefPrevention.instance.dataStore.getClaimAt(loc, true, null);
        return claim == null;
    }
}
