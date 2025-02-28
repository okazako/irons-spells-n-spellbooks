package io.redspace.ironsspellbooks.registries;

import com.mojang.serialization.Codec;
import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.item.armor.UpgradeOrbType;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.RegistryFixedCodec;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.neoforge.registries.DataPackRegistryEvent;

import java.util.Optional;

public class UpgradeOrbTypeRegistry {
    public static final ResourceKey<Registry<UpgradeOrbType>> UPGRADE_ORB_REGISTRY_KEY = ResourceKey.createRegistryKey(IronsSpellbooks.id("upgrade_orb_type"));
    public static final Codec<Holder<UpgradeOrbType>> UPGRADE_ORB_REGISTRY_CODEC = RegistryFixedCodec.create(UPGRADE_ORB_REGISTRY_KEY);
    public static final StreamCodec<RegistryFriendlyByteBuf, Holder<UpgradeOrbType>> UPGRADE_ORB_REGISTRY_STREAM_CODEC = ByteBufCodecs.holderRegistry(UPGRADE_ORB_REGISTRY_KEY);

    public static Registry<UpgradeOrbType> upgradeTypeRegistry(RegistryAccess registryAccess) {
        return registryAccess.registryOrThrow(UPGRADE_ORB_REGISTRY_KEY);
    }

    public static void registerDatapackRegistries(DataPackRegistryEvent.NewRegistry event) {
        event.dataPackRegistry(UPGRADE_ORB_REGISTRY_KEY, UpgradeOrbType.CODEC, UpgradeOrbType.CODEC);
    }

    public static Holder<UpgradeOrbType> FIRE_SPELL_POWER;
    public static Holder<UpgradeOrbType> ICE_SPELL_POWER;
    public static Holder<UpgradeOrbType> LIGHTNING_SPELL_POWER;
    public static Holder<UpgradeOrbType> HOLY_SPELL_POWER;
    public static Holder<UpgradeOrbType> ENDER_SPELL_POWER;
    public static Holder<UpgradeOrbType> BLOOD_SPELL_POWER;
    public static Holder<UpgradeOrbType> EVOCATION_SPELL_POWER;
    public static Holder<UpgradeOrbType> NATURE_SPELL_POWER;
    public static Holder<UpgradeOrbType> COOLDOWN;
    public static Holder<UpgradeOrbType> SPELL_RESISTANCE;
    public static Holder<UpgradeOrbType> MANA;
    public static Holder<UpgradeOrbType> ATTACK_DAMAGE;
    public static Holder<UpgradeOrbType> ATTACK_SPEED;
    public static Holder<UpgradeOrbType> HEALTH;
    ;

    public static void bootstrap(BootstrapContext<UpgradeOrbType> bootstrap) {
        FIRE_SPELL_POWER = bootstrap.register(ResourceKey.create(UPGRADE_ORB_REGISTRY_KEY, IronsSpellbooks.id("fire_power")),
                new UpgradeOrbType(AttributeRegistry.FIRE_SPELL_POWER, 0.05, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, Optional.of(ItemRegistry.FIRE_UPGRADE_ORB)));
        ICE_SPELL_POWER = bootstrap.register(ResourceKey.create(UPGRADE_ORB_REGISTRY_KEY, IronsSpellbooks.id("ice_power")),
                new UpgradeOrbType(AttributeRegistry.ICE_SPELL_POWER, .05, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, Optional.of(ItemRegistry.ICE_UPGRADE_ORB)));
        LIGHTNING_SPELL_POWER = bootstrap.register(ResourceKey.create(UPGRADE_ORB_REGISTRY_KEY, IronsSpellbooks.id("lightning_power")),
                new UpgradeOrbType(AttributeRegistry.LIGHTNING_SPELL_POWER, .05, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, Optional.of(ItemRegistry.LIGHTNING_UPGRADE_ORB)));
        HOLY_SPELL_POWER = bootstrap.register(ResourceKey.create(UPGRADE_ORB_REGISTRY_KEY, IronsSpellbooks.id("holy_power")),
                new UpgradeOrbType(AttributeRegistry.HOLY_SPELL_POWER, .05, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, Optional.of(ItemRegistry.HOLY_UPGRADE_ORB)));
        ENDER_SPELL_POWER = bootstrap.register(ResourceKey.create(UPGRADE_ORB_REGISTRY_KEY, IronsSpellbooks.id("ender_power")),
                new UpgradeOrbType(AttributeRegistry.ENDER_SPELL_POWER, .05, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, Optional.of(ItemRegistry.ENDER_UPGRADE_ORB)));
        BLOOD_SPELL_POWER = bootstrap.register(ResourceKey.create(UPGRADE_ORB_REGISTRY_KEY, IronsSpellbooks.id("blood_power")),
                new UpgradeOrbType(AttributeRegistry.BLOOD_SPELL_POWER, .05, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, Optional.of(ItemRegistry.BLOOD_UPGRADE_ORB)));
        EVOCATION_SPELL_POWER = bootstrap.register(ResourceKey.create(UPGRADE_ORB_REGISTRY_KEY, IronsSpellbooks.id("evocation_power")),
                new UpgradeOrbType(AttributeRegistry.EVOCATION_SPELL_POWER, .05, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, Optional.of(ItemRegistry.EVOCATION_UPGRADE_ORB)));
        NATURE_SPELL_POWER = bootstrap.register(ResourceKey.create(UPGRADE_ORB_REGISTRY_KEY, IronsSpellbooks.id("nature_power")),
                new UpgradeOrbType(AttributeRegistry.NATURE_SPELL_POWER, .05, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, Optional.of(ItemRegistry.NATURE_UPGRADE_ORB)));
        COOLDOWN = bootstrap.register(ResourceKey.create(UPGRADE_ORB_REGISTRY_KEY, IronsSpellbooks.id("cooldown")),
                new UpgradeOrbType(AttributeRegistry.COOLDOWN_REDUCTION, .05, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, Optional.of(ItemRegistry.COOLDOWN_UPGRADE_ORB)));
        SPELL_RESISTANCE = bootstrap.register(ResourceKey.create(UPGRADE_ORB_REGISTRY_KEY, IronsSpellbooks.id("spell_resistance")),
                new UpgradeOrbType(AttributeRegistry.SPELL_RESIST, .05, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, Optional.of(ItemRegistry.PROTECTION_UPGRADE_ORB)));
        MANA = bootstrap.register(ResourceKey.create(UPGRADE_ORB_REGISTRY_KEY, IronsSpellbooks.id("mana")),
                new UpgradeOrbType(AttributeRegistry.MAX_MANA, 50, AttributeModifier.Operation.ADD_VALUE, Optional.of(ItemRegistry.MANA_UPGRADE_ORB)));
        ATTACK_DAMAGE = bootstrap.register(ResourceKey.create(UPGRADE_ORB_REGISTRY_KEY, IronsSpellbooks.id("melee_damage")),
                new UpgradeOrbType(Attributes.ATTACK_DAMAGE, .05, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, Optional.empty()));
        ATTACK_SPEED = bootstrap.register(ResourceKey.create(UPGRADE_ORB_REGISTRY_KEY, IronsSpellbooks.id("melee_speed")),
                new UpgradeOrbType(Attributes.ATTACK_SPEED, .05, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, Optional.empty()));
        HEALTH = bootstrap.register(ResourceKey.create(UPGRADE_ORB_REGISTRY_KEY, IronsSpellbooks.id("health")),
                new UpgradeOrbType(Attributes.MAX_HEALTH, 2, AttributeModifier.Operation.ADD_VALUE, Optional.empty()));
    }
}
