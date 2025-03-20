package arcana.item;

import arcana.Arcana;
import arcana.item.custom.DivineDagger;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

//nitron if you read this you stink
public class ModItems {

    public static final Item DIVINE_DAGGER = registerItem("divine_dagger",
            new DivineDagger(ModToolMaterial.DIVINE_DAGGER, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterial.DIVINE_DAGGER,2,-2.5f ))));





    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Arcana.MOD_ID, name), item);
    }

    public static void registerModItems() {

    }
}
