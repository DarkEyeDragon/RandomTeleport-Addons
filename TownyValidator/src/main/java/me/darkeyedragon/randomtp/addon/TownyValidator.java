package me.darkeyedragon.randomtp.addon;

import com.palmergames.bukkit.towny.TownyAPI;
import me.darkeyedragon.randomtp.api.addon.RandomAddon;
import me.darkeyedragon.randomtp.api.world.location.RandomLocation;
import me.darkeyedragon.randomtp.common.addon.BaseRequiredPlugin;
import me.darkeyedragon.randomtp.util.WorldUtil;
import org.bukkit.Location;

/**
 * Towny location validator
 */
public class TownyValidator extends RandomAddon {

    private final TownyAPI instance;

    public TownyValidator() {
        this.instance = TownyAPI.getInstance();
        super.addRequiredPlugin(new BaseRequiredPlugin("Towny", "0.96.2.1"));

    }

    @Override
    public String getIdentifier() {
        return "TownyValidator";
    }

    @Override
    public boolean isValid(RandomLocation location) {
        Location loc = WorldUtil.toLocation(location);
        return instance.isWilderness(loc);
    }

}
