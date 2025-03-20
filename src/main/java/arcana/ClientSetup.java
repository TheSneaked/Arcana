package arcana;

import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.ModelIdentifier;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class ClientSetup {



    public static final Map<ModelIdentifier, Map<ModelTransformationMode, ModelIdentifier>> LARGE_MODEL = new HashMap<>();

    public static final Map<ModelIdentifier, BakedModel> BAKED_MODELS = new HashMap<>();
    public static ModelIdentifier getCustomModel(ModelIdentifier item, ModelTransformationMode context) {
        return LARGE_MODEL.containsKey(item) && LARGE_MODEL.get(item).containsKey(context) ? new ModelIdentifier(LARGE_MODEL.get(item).get(context).id().withPrefixedPath("item/"), "fabric_resource") : item;
    }
    public static void modifyBakingResult(Map<ModelIdentifier, BakedModel> models) {
        for (ModelIdentifier id : models.keySet()) {
            BAKED_MODELS.put(id, models.get(id));
        }
    }


    private static void registerSimpleSpecialModel(String id) {
        LARGE_MODEL.put(ModelIdentifier.ofInventoryVariant(Arcana.id(id)), Map.of(
                ModelTransformationMode.HEAD, ModelIdentifier.ofInventoryVariant(Arcana.id(id + "_inventory")),
                ModelTransformationMode.GUI, ModelIdentifier.ofInventoryVariant(Arcana.id(id + "_inventory")),
                ModelTransformationMode.GROUND, ModelIdentifier.ofInventoryVariant(Arcana.id(id + "_inventory"))
        ));
    }



    public static void registerExtraBakedModels(Consumer<ModelIdentifier> registration) {
        registration.accept(ModelIdentifier.ofInventoryVariant(Arcana.id("divine_dagger_inventory")));



    }
    public static void clientSetup() {
        registerSimpleSpecialModel("divine_dagger");



    }

}