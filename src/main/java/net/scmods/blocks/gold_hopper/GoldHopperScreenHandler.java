package net.scmods.blocks.gold_hopper;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.math.BlockPos;

public class GoldHopperScreenHandler extends ScreenHandler {
    private BlockPos pos;
    private final Inventory inventory;

    public GoldHopperScreenHandler(int syncId, PlayerInventory playerInventory, PacketByteBuf buf) {
        this(syncId, playerInventory, new SimpleInventory(1));
        pos = buf.readBlockPos();
    }

    public GoldHopperScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        pos = BlockPos.ORIGIN;
    }

    public BlockPos getPos() {
        return pos;
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slot) {
        return null;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    @Override
    public ItemStack transferSlot(PlayerEntity player, int invSlot);
}
