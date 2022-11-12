package io.github.pumpkinxd.legacyxibao;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ExampleMod.MOD_ID)
public class legacy_xibao {

    public static final String MOD_ID = "legacyxibao";

    @Mod.EventHandler
    public void init(FMLPreInitializationEvent event) {
        System.out.println("test");
    }
}
