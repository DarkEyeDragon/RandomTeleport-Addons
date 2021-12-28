package me.darkeyedragon.randomtp.addon;

import me.darkeyedragon.randomtp.api.addon.RandomAddon;
import me.darkeyedragon.randomtp.api.world.location.RandomLocation;
import me.darkeyedragon.randomtp.util.WorldUtil;
import org.kingdoms.constants.land.Land;

public class KingdomsXValidator extends RandomAddon {


    @Override
    public String getIdentifier() {
        return "KingdomsXValidator";
    }

    @Override
    public boolean isValid(RandomLocation randomLocation) {
        Land land = Land.getLand(WorldUtil.toLocation(randomLocation));
        return land == null || !land.isClaimed();
    }
}
