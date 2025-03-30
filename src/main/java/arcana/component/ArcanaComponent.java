package arcana.component;

import arcana.init.ModEntityComponents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import org.ladysnake.cca.api.v3.component.sync.AutoSyncedComponent;
import org.ladysnake.cca.api.v3.component.tick.CommonTickingComponent;

public class ArcanaComponent implements AutoSyncedComponent, CommonTickingComponent {

    private final PlayerEntity playerEntity;
    private int mana = -1; // stub for now

    public ArcanaComponent(PlayerEntity playerEntity) {
        this.playerEntity = playerEntity;
    }

    @Override
    public void readFromNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup wrapperLookup) {
        mana = nbt.getInt("ArcanaMana");
    }

    @Override
    public void writeToNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup wrapperLookup) {
        nbt.putInt("ArcanaMana", mana);
    }

    @Override
    public void tick() {
        // idk I'll figure it out when we get more info
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int value) {
        mana = value;
        sync();
    }

    public void sync() {
        ModEntityComponents.ARCANA.sync(playerEntity);
    }
}
