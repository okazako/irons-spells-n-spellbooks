package io.redspace.ironsspellbooks.registries;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.item.armor.UpgradeOrbType;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.registries.DataPackRegistryEvent;

import java.util.Optional;

public class UpgradeOrbTypeRegistry {
    public static final ResourceKey<Registry<UpgradeOrbType>> UPGRADE_ORB_REGISTRY_KEY = ResourceKey.createRegistryKey(IronsSpellbooks.id("upgrade_orb_type"));

    public static Registry<UpgradeOrbType> upgradeTypeRegistry(RegistryAccess registryAccess) {
        return registryAccess.registryOrThrow(UPGRADE_ORB_REGISTRY_KEY);
    }

    public static void registerDatapackRegistries(DataPackRegistryEvent.NewRegistry event) {
        event.dataPackRegistry(UPGRADE_ORB_REGISTRY_KEY, UpgradeOrbType.CODEC, UpgradeOrbType.CODEC);
    }

    public static void bootstrap(BootstrapContext<UpgradeOrbType> bootstrap) {
        bootstrap.register(ResourceKey.create(UPGRADE_ORB_REGISTRY_KEY, IronsSpellbooks.id("test")),
                new UpgradeOrbType(Attributes.MAX_HEALTH, 10, AttributeModifier.Operation.ADD_VALUE, Optional.of(BuiltInRegistries.ITEM.wrapAsHolder(Items.APPLE))));
    }
}
