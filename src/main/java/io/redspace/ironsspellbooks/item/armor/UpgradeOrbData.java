package io.redspace.ironsspellbooks.item.armor;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Item;

import java.util.Optional;

public record UpgradeOrbData(
        Holder<Attribute> attribute,
        double amount,
        AttributeModifier.Operation operation,
        Optional<Holder<Item>> containerItem
) {
    public static final Codec<UpgradeOrbData> CODEC = RecordCodecBuilder.create(builder -> builder.group(
            BuiltInRegistries.ATTRIBUTE.holderByNameCodec().fieldOf("attribute").forGetter(UpgradeOrbData::attribute),
            Codec.DOUBLE.fieldOf("amount").forGetter(UpgradeOrbData::amount),
            AttributeModifier.Operation.CODEC.fieldOf("operation").forGetter(UpgradeOrbData::operation),
            BuiltInRegistries.ITEM.holderByNameCodec().optionalFieldOf("containerItem").forGetter(UpgradeOrbData::containerItem)
    ).apply(builder, UpgradeOrbData::new));

    @Override
    public int hashCode() {
        try {
            return attribute.getKey().hashCode() * 31 * 31 * 31 + ((int) amount) * 31 * 31 + operation.id() * 31 + containerItem.map(holder -> holder.getKey().hashCode()).orElse(0);
        } catch (NullPointerException e) {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof UpgradeOrbData other && attribute.equals(other.attribute) && amount == other.amount && operation == other.operation && containerItem.equals(other.containerItem);
    }
}
