package net.mkaito.banana.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.mkaito.banana.Banana;
import net.mkaito.banana.items.BananaFood;
import net.mkaito.banana.items.BananaMeasure;

public class RegistryHandler {
  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Banana.MOD_ID);
  public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Banana.MOD_ID);

  // Items
  public static final RegistryObject<BananaFood> BANANA = ITEMS.register("banana", BananaFood::new);
  public static final RegistryObject<BananaMeasure> BANANA_MEASURE = ITEMS.register("banana_measure", BananaMeasure::new);

  public static void init() {
    ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
  }
}
