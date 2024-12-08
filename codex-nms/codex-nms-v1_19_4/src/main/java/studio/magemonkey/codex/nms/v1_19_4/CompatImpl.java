package studio.magemonkey.codex.nms.v1_19_4;

import org.bukkit.attribute.AttributeModifier;
import studio.magemonkey.codex.compat.Compat;
import studio.magemonkey.codex.api.meta.NBTAttribute;

public class CompatImpl implements Compat {
    @Override
    public AttributeModifier createAttributeModifier(NBTAttribute attribute, double amount, AttributeModifier.Operation operation) {
        return new AttributeModifier(ATTRIBUTE_BONUS_UUID, attribute.getNmsName(), amount, operation);
    }

    @Override
    public String getAttributeKey(AttributeModifier attributeModifier) {
        return attributeModifier.getName();
    }
}