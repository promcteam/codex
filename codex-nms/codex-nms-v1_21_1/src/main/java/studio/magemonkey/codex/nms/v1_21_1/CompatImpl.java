package studio.magemonkey.codex.nms.v1_21_1;

import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.inventory.EquipmentSlotGroup;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import studio.magemonkey.codex.api.meta.NBTAttribute;
import studio.magemonkey.codex.compat.Compat;

public class CompatImpl implements Compat {
    @Override
    @SuppressWarnings("UnstableApiUsage")
    public AttributeModifier createAttributeModifier(NBTAttribute attribute,
                                                     double amount,
                                                     AttributeModifier.Operation operation) {
        return new AttributeModifier(attribute.getAttribute().getKey(), amount, operation, EquipmentSlotGroup.ANY);
    }

    @Override
    public String getAttributeKey(AttributeModifier attributeModifier) {
        return attributeModifier.getKey().toString();
    }

    @Override
    public Inventory getTopInventory(InventoryEvent event) {
        InventoryView view = event.getView();
        return view.getTopInventory();
    }

    @Override
    @NotNull
    public Inventory getTopInventory(Player player) {
        InventoryView view = player.getOpenInventory();
        return view.getTopInventory();
    }

    @Override
    public Inventory getBottomInventory(InventoryEvent event) {
        InventoryView view = event.getView();
        return view.getBottomInventory();
    }

    @Override
    public void setCursor(InventoryEvent event, ItemStack item) {
        InventoryView view = event.getView();
        view.setCursor(item);
    }

    @Override
    public void setItem(Player player, int slot, ItemStack item) {
        InventoryView view = player.getOpenInventory();
        view.setItem(slot, item);
    }

    @Override
    public Inventory getInventory(InventoryEvent event, int slot) {
        InventoryView view = event.getView();
        return view.getInventory(slot);
    }

    @Override
    public ItemStack getItem(InventoryEvent event, int slot) {
        InventoryView view = event.getView();
        return view.getItem(slot);
    }

    @Override
    public int convertSlot(InventoryEvent event, int slot) {
        InventoryView view = event.getView();
        return view.convertSlot(slot);
    }
}
