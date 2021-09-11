package me.darkeyedragon.randomtp.addon;

import br.net.fabiozumbi12.RedProtect.Bukkit.RedProtect;
import me.darkeyedragon.randomtp.api.addon.RandomAddon;
import me.darkeyedragon.randomtp.api.world.location.RandomLocation;
import me.darkeyedragon.randomtp.common.addon.BaseRequiredPlugin;
import me.darkeyedragon.randomtp.util.WorldUtil;
import org.bukkit.Location;

/**
 * RedProtect Validator
 *
 */
public class RedProtectAddon extends RandomAddon
{

    public RedProtectAddon() {
        super.addRequiredPlugin(new BaseRequiredPlugin("RedProtect", "7.7.0"));
    }

    @Override
    public String getIdentifier() {
        return "RedProtect";
    }

    @Override
    public boolean isValid(RandomLocation location) {
        Location loc = WorldUtil.toLocation(location);
        return RedProtect.get().getAPI().getRegion(loc) == null;
    }
}
