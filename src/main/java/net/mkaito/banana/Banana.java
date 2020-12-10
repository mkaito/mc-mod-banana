package net.mkaito.banana;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.mkaito.banana.util.RegistryHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("banana")
public class Banana {
  // Directly reference a log4j logger.
  private static final Logger LOGGER = LogManager.getLogger();

  public static final String MOD_ID = "banana";

  public Banana() {
    FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
    MinecraftForge.EVENT_BUS.register(this);

    RegistryHandler.init();
  }

  private void setup(final FMLCommonSetupEvent event) {
  }

  private void doClientStuff(final FMLClientSetupEvent event) {
  }
}
