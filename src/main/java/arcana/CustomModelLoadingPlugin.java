package arcana;

import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import net.minecraft.client.util.ModelIdentifier;

import java.util.ArrayList;
import java.util.List;

public class CustomModelLoadingPlugin implements ModelLoadingPlugin {
    public static final List<ModelIdentifier> MODELS = new ArrayList<>();


    @Override
    public void onInitializeModelLoader(Context pluginContext) {
        pluginContext.addModels(MODELS.stream().map(l -> l.id().withPrefixedPath("item/")).toList());

    }
}