package crimsonfluff.simplemagnet.init;

import crimsonfluff.simplemagnet.SimpleMagnet;
import crimsonfluff.simplemagnet.items.MagnetItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class initItems {
    public static final MagnetItem MAGNET_ITEM = new MagnetItem();

    public static void register(){
        Registry.register(Registry.ITEM, new Identifier(SimpleMagnet.MOD_ID,"magnet"),MAGNET_ITEM);
    }

}
