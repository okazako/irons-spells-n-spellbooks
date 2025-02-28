package io.redspace.ironsspellbooks.item;

import io.redspace.ironsspellbooks.item.armor.UpgradeOrbType;
import io.redspace.ironsspellbooks.item.armor.UpgradeType;
import io.redspace.ironsspellbooks.registries.ComponentRegistry;
import io.redspace.ironsspellbooks.util.MinecraftInstanceHelper;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.ItemAttributeModifiers;

import java.util.List;
import java.util.Optional;

public class UpgradeOrbItem extends Item {
    private final static Component TOOLTIP_HEADER = Component.translatable("tooltip.irons_spellbooks.upgrade_tooltip").withStyle(ChatFormatting.GRAY);

    @Deprecated(forRemoval = true)
    /**
     * Upgrade Orb Types are now datadriven; UpgradeType interface is no longer supported. See {@link io.redspace.ironsspellbooks.registries.UpgradeOrbTypeRegistry} for datagenning custom orbs
     */
    public UpgradeOrbItem(UpgradeType upgrade, Properties pProperties) {
        this(pProperties);
    }

    public UpgradeOrbItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public Component getName(ItemStack pStack) {
        return super.getName(pStack);
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext context, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        super.appendHoverText(pStack, context, pTooltipComponents, pIsAdvanced);
        if (pStack.has(ComponentRegistry.UPGRADE_ORB_TYPE)) {
            resolveRegistry(pStack, context).ifPresent(holder -> {
                        var upgrade = holder.value();
                        pTooltipComponents.add(Component.empty());
                        pTooltipComponents.add(TOOLTIP_HEADER);
                        var text =
                                Component.literal(" ").append(Component.translatable("attribute.modifier.plus." + upgrade.operation().id(),
                                        ItemAttributeModifiers.ATTRIBUTE_MODIFIER_FORMAT.format(upgrade.amount() * (upgrade.operation() == AttributeModifier.Operation.ADD_VALUE ? 1 : 100)),
                                        Component.translatable(upgrade.attribute().value().getDescriptionId())).withStyle(ChatFormatting.BLUE));
                        pTooltipComponents.add(text);
                    }
            );
        }
    }

    private Optional<Holder.Reference<UpgradeOrbType>> resolveRegistry(ItemStack stack, TooltipContext context) {
        // jei is cringe and passes in a null registry access to the tooltip, even though it is client only. this makes it show regardless.
        if (context.registries() != null) {
            return context.registries().holder(stack.get(ComponentRegistry.UPGRADE_ORB_TYPE));
        } else if (MinecraftInstanceHelper.getPlayer() != null) {
            return MinecraftInstanceHelper.getPlayer().registryAccess().holder(stack.get(ComponentRegistry.UPGRADE_ORB_TYPE));
        } else {
            return Optional.empty();
        }
    }
}
