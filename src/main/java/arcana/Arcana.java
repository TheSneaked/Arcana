package arcana;

import arcana.init.ModItems;
import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Arcana implements ModInitializer {
	public static final String MOD_ID = "arcana";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();

		LOGGER.info("what does magistry even mean dude can we just get some gay people in here already 🙏");

	}

	public static Identifier id(String string) {
		return Identifier.of(MOD_ID, string);
	}
}