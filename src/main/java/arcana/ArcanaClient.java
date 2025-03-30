package arcana;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;

public class ArcanaClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {





        ModelLoadingPlugin.register((context) -> {
            context.addModels(Arcana.id("item/divine_dagger_inventory"));
        });

    }
}
