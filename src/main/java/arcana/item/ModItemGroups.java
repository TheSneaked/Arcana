package arcana.item;

import arcana.Arcana;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup AOTC_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Arcana.MOD_ID, "arcana"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.DIVINE_DAGGER))
                    .displayName(Text.translatable("itemgroup.arcana.arcana"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.DIVINE_DAGGER);







                    }).build());


    public static void registerItemGroups() {
        Arcana.LOGGER.info("Registering Item Groups for " + Arcana.MOD_ID);
    }
}