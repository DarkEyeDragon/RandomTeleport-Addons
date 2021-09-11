package me.darkeyedragon.randomtp.addon;

import me.darkeyedragon.randomtp.api.addon.RandomAddon;
import me.darkeyedragon.randomtp.api.world.location.RandomLocation;
import me.darkeyedragon.randomtp.common.addon.BaseRequiredPlugin;
import net.prosavage.factionsx.core.Faction;
import net.prosavage.factionsx.persist.data.FLocation;

public class FactionsXValidator extends RandomAddon {

    public FactionsXValidator() {
        super.addRequiredPlugin(new BaseRequiredPlugin("FactionsX"));
    }

    @Override
    public String getIdentifier() {
        return "FactionsXValidator";
    }

    @Override
    public boolean isValid(RandomLocation randomLocation) {
        Faction faction = new FLocation(randomLocation.getBlockX(), randomLocation.getBlockZ(), randomLocation.getWorld().getName()).getFaction();
        return faction.isWilderness() || faction.isWarzone();
    }
}
