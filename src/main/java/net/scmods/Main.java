package net.scmods;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.block.v1.FabricBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.scmods.blocks.gold_hopper.GoldHopperBlock;
import net.scmods.blocks.gold_hopper.GoldHopperBlockEntity;

public class Main implements ModInitializer {
	public static final String MODID = "consistentimprovements";

	public static BlockEntityType<GoldHopperBlockEntity> GOLD_HOPPER_ENTITY;
	public static final GoldHopperBlock GOLD_HOPPER = new GoldHopperBlock(FabricBlockSettings.of(Material.METAL).strength(3.0f, 6.0f));
	public static final BlockItem GOLD_HOPPER_ITEM = new BlockItem(GOLD_HOPPER, new FabricItemSettings());

	@Override
	public void onInitialize() {
		Registry.register(Registries.BLOCK, new Identifier(MODID, "gold_hopper"), GOLD_HOPPER);
		Registry.register(Registries.ITEM, new Identifier(MODID, "gold_hopper"), GOLD_HOPPER_ITEM);

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(content -> {
			content.addAfter(Items.HOPPER, GOLD_HOPPER_ITEM);
		});
	}
}
