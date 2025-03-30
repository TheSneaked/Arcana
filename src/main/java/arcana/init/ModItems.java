package arcana.init;

import arcana.Arcana;
import arcana.item.ModToolMaterial;
import arcana.item.DivineDaggerItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;

// nitron if you read this you're awesome <3
public class ModItems {

    public static final Item DIVINE_DAGGER = registerItem("divine_dagger",
            new DivineDaggerItem(ModToolMaterial.DIVINE_DAGGER, new Item.Settings().maxCount(1).attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterial.DIVINE_DAGGER,2,-2.5f))));




    // Item Group
    public static final ItemGroup AOTC_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            Arcana.id("arcana"),
            FabricItemGroup.builder().icon(() -> new ItemStack(DIVINE_DAGGER))
                    .displayName(Text.translatable("itemgroup.arcana.arcana"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.DIVINE_DAGGER);


                    }).build());

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Arcana.id(name), item);
    }

    public static void registerModItems() {

    }
}
