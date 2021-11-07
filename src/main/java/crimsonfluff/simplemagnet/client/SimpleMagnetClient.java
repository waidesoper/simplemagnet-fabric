package crimsonfluff.simplemagnet.client;

import crimsonfluff.simplemagnet.SimpleMagnet;
import crimsonfluff.simplemagnet.networking.ModPackets;
import crimsonfluff.simplemagnet.networking.ModPacketsS2C;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.network.PacketByteBuf;
import org.lwjgl.glfw.GLFW;

@Environment(EnvType.CLIENT)
public class SimpleMagnetClient implements ClientModInitializer {
    private static KeyBinding keyMagnetToggle;
    private static KeyBinding keyMagnetMode;

    @Override
    public void onInitializeClient() {
        ModPacketsS2C.register();
        keyMagnetToggle = KeyBindingHelper.registerKeyBinding(new KeyBinding("key" + SimpleMagnet.MOD_ID + ".magnet", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_V, "Crimson Simple Magnet"));
        keyMagnetMode = KeyBindingHelper.registerKeyBinding(new KeyBinding("key." + SimpleMagnet.MOD_ID + ".magnetmode", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_B, "Crimson Simple Magnet"));

        ClientTickEvents.START_CLIENT_TICK.register(client ->{
            while(keyMagnetToggle.wasPressed()){
                PacketByteBuf buf = PacketByteBufs.empty();
                ClientPlayNetworking.send(ModPackets.MAGNET_TOGGLE,buf);
            }
            while(keyMagnetMode.wasPressed()){
                PacketByteBuf buf = PacketByteBufs.empty();
                ClientPlayNetworking.send(ModPackets.MAGNET_MODE,buf);
            }
        });
    }
}
