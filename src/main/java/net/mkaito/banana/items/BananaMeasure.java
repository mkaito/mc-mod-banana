package net.mkaito.banana.items;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

public class BananaMeasure extends Item {
  private static final double BananaLength = 17.78f;
  private BlockPos anchorBlock;

  public BananaMeasure() {
    super(new Properties()
        .group(ItemGroup.MISC)
    );
  }

  @Override
  public void addInformation(@Nonnull ItemStack stack, @Nullable World worldIn, @Nonnull List<ITextComponent> tooltip, @Nonnull ITooltipFlag flagIn) {
    super.addInformation(stack, worldIn, tooltip, flagIn);
    tooltip.add(new TranslationTextComponent("item.banana.banana_measure.tooltip"));
  }

  @Nonnull
  @Override
  public ActionResultType onItemUse(@Nonnull ItemUseContext context) {
    World world = context.getWorld();
    BlockPos pos = context.getPos();
    PlayerEntity playerIn = context.getPlayer();

    double distance;
    double distanceInBananas;

    if (!world.isRemote()) {
      return ActionResultType.PASS;
    }

    if (playerIn == null) {
      return ActionResultType.PASS;
    }

    if (playerIn.isSneaking()) {
      this.anchorBlock = pos;
    } else {

      distance = this.anchorBlock.distanceSq(pos);
      distanceInBananas = distance * 100 / BananaLength;

      playerIn.sendMessage(new StringTextComponent(String.format("That's about %.2f bananas across.", distanceInBananas)), UUID.randomUUID());
    }

    return ActionResultType.PASS;
  }
}