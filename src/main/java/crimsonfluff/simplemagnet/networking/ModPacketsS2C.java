package crimsonfluff.simplemagnet.networking;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;

public class ModPacketsS2C {
    @Environment(EnvType.CLIENT)
    public static void register() {
        ClientPlayConnectionEvents.INIT.register(((clientPlayNetworkHandler, minecraftClient) -> {
            ClientPlayNetworking.registerReceiver(ModPackets.MAGNET_MODE, ModPacketsS2C::magnetMode);
            ClientPlayNetworking.registerReceiver(ModPackets.MAGNET_TOGGLE, ModPacketsS2C::magnetToggle);
        }));
    }

    @Environment(EnvType.CLIENT)
    public static void magnetMode(MinecraftClient minecraftClient, ClientPlayNetworkHandler clientPlayNetworkHandler, PacketByteBuf packetByteBuf, PacketSender packetSender){
        minecraftClient.execute(() -> {

        });
    }

    @Environment(EnvType.CLIENT)
    public static void magnetToggle(MinecraftClient minecraftClient, ClientPlayNetworkHandler clientPlayNetworkHandler, PacketByteBuf packetByteBuf, PacketSender packetSender){
        minecraftClient.execute(() -> {

        });
    }
}
