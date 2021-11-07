package crimsonfluff.simplemagnet.networking;

import crimsonfluff.simplemagnet.SimpleMagnet;
import crimsonfluff.simplemagnet.items.MagnetItem;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.networking.v1.ServerLoginNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerLoginNetworkHandler;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.TranslatableText;

public class ModPacketsC2S {
    public static void register() {
        ServerPlayNetworking.registerGlobalReceiver(ModPackets.MAGNET_TOGGLE, ModPacketsC2S::magnetToggle);
        ServerPlayNetworking.registerGlobalReceiver(ModPackets.MAGNET_MODE, ModPacketsC2S::magnetMode);
    }

    public static void magnetToggle(MinecraftServer minecraftServer, ServerPlayerEntity playerEntity, ServerPlayNetworkHandler handler, PacketByteBuf buffer, PacketSender sender) {
        minecraftServer.execute(() -> {
            if (playerEntity != null){
                ItemStack itemStack = ItemStack.EMPTY;

                for(ItemStack stack : playerEntity.getItemsHand())
                {
                    if(stack.getItem() instanceof MagnetItem)
                        itemStack = stack;
                }

                if (! itemStack.isEmpty())
                    ((MagnetItem) itemStack.getItem()).changeMagnetToggle(itemStack.getOrCreateTag().getInt("CustomModelData"), playerEntity, itemStack);
            }
        });
    }

    public static void magnetMode(MinecraftServer minecraftServer, ServerPlayerEntity playerEntity, ServerPlayNetworkHandler handler, PacketByteBuf buffer, PacketSender sender) {
        minecraftServer.execute(() -> {
            if (playerEntity != null){
                ItemStack itemStack = ItemStack.EMPTY;

                for(ItemStack stack : playerEntity.getItemsHand())
                {
                    if(stack.getItem() instanceof MagnetItem)
                        itemStack = stack;
                }

                if (! itemStack.isEmpty())
                    ((MagnetItem) itemStack.getItem()).changeMagnetMode(itemStack.getOrCreateTag().getInt("CustomModelData"), playerEntity, itemStack);
            }
        });
    }
}
