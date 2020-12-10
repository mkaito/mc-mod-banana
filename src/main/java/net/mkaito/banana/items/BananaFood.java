package net.mkaito.banana.items;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class BananaFood extends Item {
  public BananaFood() {
    super(new Item.Properties()
        .group(ItemGroup.FOOD)
        .food(new Food.Builder()
            .hunger(8)
            .fastToEat()
            .saturation(4)
            .fastToEat()
            .setAlwaysEdible()
            .effect(() -> new EffectInstance(Effects.GLOWING, 200, 1), 0.2f)
            .effect(() -> new EffectInstance(Effects.LEVITATION, 25, 1), 0.75f)
            .build())
    );
  }

  @Override
  public void addInformation(@Nonnull ItemStack stack, @Nullable World worldIn, @Nonnull List<ITextComponent> tooltip, @Nonnull ITooltipFlag flagIn) {
    super.addInformation(stack, worldIn, tooltip, flagIn);
    tooltip.add(new TranslationTextComponent("item.banana.banana.tooltip"));
  }
}