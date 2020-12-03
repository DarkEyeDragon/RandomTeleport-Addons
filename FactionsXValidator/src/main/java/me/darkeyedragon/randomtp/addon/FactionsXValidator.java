package me.darkeyedragon.randomtp.addon;

import me.darkeyedragon.randomtp.api.world.location.RandomLocation;
import me.darkeyedragon.randomtp.common.addon.BaseRequiredPlugin;
import me.darkeyedragon.randomtp.common.addon.RandomAddon;
import net.prosavage.factionsx.core.Faction;
import net.prosavage.factionsx.manager.GridManager;
import net.prosavage.factionsx.persist.data.FLocation;

public class FactionsXValidator extends RandomAddon {
    @Override
    public String getIdentifier() {
        super.addRequiredPlugin(new BaseRequiredPlugin("FactionsX"));
        return "FactionsXValidator";
    }

    @Override
    public boolean isValid(RandomLocation randomLocation) {
        Faction faction = GridManager.INSTANCE.getFactionAt(new FLocation(randomLocation.getX(), randomLocation.getZ(), randomLocation.getWorld().getName()));
        return faction.isWilderness() || faction.isWarzone();
    }
}
