package studio.magemonkey.codex.api.meta;

import org.bukkit.attribute.Attribute;
import org.bukkit.inventory.EquipmentSlot;
import org.jetbrains.annotations.NotNull;
import studio.magemonkey.codex.CodexEngine;
import studio.magemonkey.codex.api.NMSProvider;

import java.util.UUID;

public enum NBTAttribute {

    ARMOR(
            "generic.armor",
            NMSProvider.getNms().getAttribute("ARMOR"),
            "1f1173-9999-3333-5555-99cb0245f9c1"), // '1' at start

    ARMOR_TOUGHNESS(
            "generic.armorToughness",
            NMSProvider.getNms().getAttribute("ARMOR_TOUGHNESS"),
            "1f1173-9999-3333-5555-99cb0245f9c2"),

    ATTACK_DAMAGE(
            "generic.attackDamage",
            NMSProvider.getNms().getAttribute("ATTACK_DAMAGE"),
            "1f1173-9999-3333-5555-99cb0245f9c3"),

    ATTACK_SPEED(
            "generic.attackSpeed",
            NMSProvider.getNms().getAttribute("ATTACK_SPEED"),
            "1f1173-9999-3333-5555-99cb0245f9c4"),

    MOVEMENT_SPEED(
            "generic.movementSpeed",
            NMSProvider.getNms().getAttribute("MOVEMENT_SPEED"),
            "1f1173-9999-3333-5555-99cb0245f9c5"),

    MAX_HEALTH(
            "generic.maxHealth",
            NMSProvider.getNms().getAttribute("MAX_HEALTH"),
            "1f1173-9999-3333-5555-99cb0245f9c6"),

    KNOCKBACK_RESISTANCE(
            "generic.knockbackResistance",
            NMSProvider.getNms().getAttribute("KNOCKBACK_RESISTANCE"),
            "1f1173-9999-3333-5555-99cb0245f9c7"),
    ;

    private final String    nmsName;
    private final Attribute att;
    private final String    uuid;

    NBTAttribute(@NotNull String nmsName, @NotNull Attribute att, @NotNull String uuid) {
        this.nmsName = nmsName;
        this.att = att;
        this.uuid = uuid;
    }

    @NotNull
    public String getNmsName() {
        return this.nmsName;
    }

    @NotNull
    public Attribute getAttribute() {
        return this.att;
    }

    @NotNull
    public UUID getUUID(@NotNull EquipmentSlot slot) {
        return UUID.fromString(slot.ordinal() + this.uuid);
    }
}