package arcana.init;

import arcana.Arcana;
import arcana.component.ArcanaComponent;
import org.ladysnake.cca.api.v3.component.ComponentKey;
import org.ladysnake.cca.api.v3.component.ComponentRegistry;
import org.ladysnake.cca.api.v3.entity.EntityComponentFactoryRegistry;
import org.ladysnake.cca.api.v3.entity.EntityComponentInitializer;
import org.ladysnake.cca.api.v3.entity.RespawnCopyStrategy;

public class ModEntityComponents implements EntityComponentInitializer {

    public static final ComponentKey<ArcanaComponent> ARCANA = ComponentRegistry.getOrCreate(Arcana.id("arcana"), ArcanaComponent.class);

    @Override
    public void registerEntityComponentFactories(EntityComponentFactoryRegistry entityComponentFactoryRegistry) {
        entityComponentFactoryRegistry.registerForPlayers(ARCANA, ArcanaComponent::new, RespawnCopyStrategy.CHARACTER);


    }
}
