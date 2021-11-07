package crimsonfluff.simplemagnet;

import crimsonfluff.simplemagnet.config.SimpleMagnetConfig;
import crimsonfluff.simplemagnet.init.initConfigs;
import crimsonfluff.simplemagnet.init.initItems;
import crimsonfluff.simplemagnet.networking.ModPacketsC2S;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class SimpleMagnet implements ModInitializer, DedicatedServerModInitializer, ClientModInitializer {
    public static final String MOD_ID = "simplemagnet";
    public static final Logger LOGGER = LogManager.getLogger(SimpleMagnet.class);

    public static SimpleMagnetConfig CONFIG;
    @Override
    public void onInitialize() {
        AutoConfig.register(SimpleMagnetConfig.class, GsonConfigSerializer::new);
        CONFIG = AutoConfig.getConfigHolder(SimpleMagnetConfig.class).getConfig();
        initConfigs.init();
        initItems.register();
        ModPacketsC2S.register();
    }

    @Override
    public void onInitializeServer(){}

    @Override
    public void onInitializeClient(){}

    public static Identifier identifier(String path){
        return new Identifier(SimpleMagnet.MOD_ID, path);
    }
}
