package arcana.item;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Style;
import net.minecraft.text.Text;

import java.util.List;

public class DivineDaggerItem extends SwordItem {

    public DivineDaggerItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }



    @Environment(EnvType.CLIENT)
    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.literal("be gay do crime").setStyle(Style.EMPTY.withColor(0x752CA1)));
        }
        super.appendTooltip(stack, context, tooltip, type);
    }
}
