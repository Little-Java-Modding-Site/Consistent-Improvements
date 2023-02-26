package net.scmods;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.scmods.blocks.gold_hopper.GoldHopperBlock;
import net.scmods.blocks.gold_hopper.GoldHopperBlockEntity;

public class Main implements ModInitializer {
	public static final String MODID = "consistentimprovements";

	public static BlockEntityType<GoldHopperBlockEntity> GOLD_HOPPER_ENTITY;
	public static ScreenHandlerType<GoldHopperScreenHandler> GOLD_HOPPER_SCREEN_HANDLER;
	public static final Identifier GOLD_HOPPER_ID = new Identifier(MODID, "gold_hopper");
	public static final GoldHopperBlock GOLD_HOPPER = new GoldHopperBlock(FabricBlockSettings.of(Material.METAL).strength(3.0f, 6.0f));
	public static final BlockItem GOLD_HOPPER_ITEM = new BlockItem(GOLD_HOPPER, new FabricItemSettings());

	@Override
	public void onInitialize() {
		Registry.register(Registries.BLOCK, GOLD_HOPPER_ID, GOLD_HOPPER);
		GOLD_HOPPER_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(MODID, "gold_hopper_entity"),
				FabricBlockEntityTypeBuilder.create(GoldHopperBlockEntity::new, GOLD_HOPPER).build());
		GOLD_HOPPER_SCREEN_HANDLER = Registry.register(Registries.SCREEN_HANDLER, GOLD_HOPPER_ID, GoldHopperScreenHandler);
		Registry.register(Registries.ITEM, GOLD_HOPPER_ID, GOLD_HOPPER_ITEM);

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(content -> {
			content.addAfter(Items.HOPPER, GOLD_HOPPER_ITEM);
		});
	}
}
