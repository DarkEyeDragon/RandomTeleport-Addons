package me.darkeyedragon.randomtp.addon;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import me.darkeyedragon.randomtp.api.addon.RandomAddon;
import me.darkeyedragon.randomtp.api.world.location.RandomLocation;
import me.darkeyedragon.randomtp.common.addon.BaseRequiredPlugin;
import me.darkeyedragon.randomtp.util.WorldUtil;
import org.bukkit.Location;

/**
 * WorldGuard Validator
 *
 */
public class WorldGuardValidator extends RandomAddon
{

    public WorldGuardValidator() {
        super.addRequiredPlugin(new BaseRequiredPlugin("WorldGuard"));
    }

    @Override
    public String getIdentifier() {
        return "WorldGuardValidator";
    }

    @Override
    public boolean isValid(RandomLocation location) {
        if(location == null) return false;
        Location loc = WorldUtil.toLocation(location);
        RegionManager regions = WorldGuard.getInstance().getPlatform().getRegionContainer().get(BukkitAdapter.adapt(loc.getWorld()));
        if (regions == null) return true;
        else {
            for (ProtectedRegion region : regions.getRegions().values()) {
                if (region.contains(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ())) return false;
            }
        }
        return true;
    }
}
