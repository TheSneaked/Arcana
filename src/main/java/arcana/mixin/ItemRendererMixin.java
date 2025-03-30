package arcana.mixin;

import arcana.Arcana;
import arcana.init.ModItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.item.ItemModels;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Environment(EnvType.CLIENT)
@Mixin(ItemRenderer.class)
public abstract class ItemRendererMixin {
    @Shadow public abstract ItemModels getModels();

    @ModifyVariable(method = "renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformationMode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IILnet/minecraft/client/render/model/BakedModel;)V", at = @At(value = "LOAD", ordinal = 0), ordinal = 0, argsOnly = true)
    public BakedModel render(BakedModel bakedModel, ItemStack stack, ModelTransformationMode renderMode) {
        boolean isGui = renderMode == ModelTransformationMode.GUI || renderMode == ModelTransformationMode.GROUND; // fixed is not here so that it works with combat amenities :>
        if (stack.isOf(ModItems.DIVINE_DAGGER) && isGui) {
            return this.getModels().getModelManager().getModel(Arcana.id("item/divine_dagger_inventory"));
        }
        return bakedModel;
    }
}