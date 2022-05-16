package me.darkeyedragon.randomtp.addon.husktown;

import me.darkeyedragon.randomtp.api.addon.RandomAddon;
import me.darkeyedragon.randomtp.api.world.location.RandomLocation;
import me.darkeyedragon.randomtp.common.addon.BaseRequiredPlugin;
import me.darkeyedragon.randomtp.util.WorldUtil;
import me.william278.husktowns.HuskTownsAPI;

public final class HusktownValidator extends RandomAddon {

    private final HuskTownsAPI instance;

    public HusktownValidator() {
        this.instance = HuskTownsAPI.getInstance();
        super.addRequiredPlugin(new BaseRequiredPlugin("HuskTowns", "1.7"));
    }

    @Override
    public String getIdentifier() {
        return "HuskTownsValidator";
    }

    @Override
    public boolean isValid(RandomLocation randomLocation) {
        return instance.isWilderness(WorldUtil.toLocation(randomLocation));
    }
}
