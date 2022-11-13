package io.github.pumpkinxd.legacyxibao;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.MusicTicker;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.audio.SoundRegistry;
import net.minecraft.client.gui.GuiDisconnected;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.client.event.sound.SoundEvent;
import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


@Mod(modid = legacy_xibao.MOD_ID)
public class legacy_xibao {

    public static final String MOD_ID = "legacyxibao";
    private Minecraft mc=Minecraft.getMinecraft();
    private SoundHandler soundHandler=mc.getSoundHandler();
    private boolean Gratz = true;//bonzo said that lol
    private boolean is_bgm_on=true;

    private static final ResourceLocation BACKGROUND_LOCATION =
            new ResourceLocation(MOD_ID, "textures/xibao.png");


    @Mod.EventHandler
    public void init(FMLPreInitializationEvent event) {
        System.out.println("test");
    }


    @Mod.EventHandler
    public void onDisconnectedInit(GuiScreenEvent.InitGuiEvent event) {

        if (Gratz && event.gui instanceof GuiDisconnected) {

            if (is_bgm_on){
            playBGM();
            }

            //add a button to stop showing "xibao"(or  config thing lol)
        }

    }

    @Mod.EventHandler
    public void onDisconnectedDrawBG(GuiScreenEvent.BackgroundDrawnEvent event) {//no need for mixin when forge supports this lol
        if (Gratz && event.gui instanceof GuiDisconnected) {
            //change the back ground to "xibao" thing


            final int tint=0;

            GlStateManager.disableLighting();
            GlStateManager.disableFog();
            Tessellator tessellator = Tessellator.getInstance();
            WorldRenderer worldrenderer = tessellator.getWorldRenderer();
            this.mc.getTextureManager().bindTexture(BACKGROUND_LOCATION);
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            float f = 32.0F;
            worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);


            worldrenderer.pos(0.0D, (double)event.gui.height, 0.0D).tex(0.0D, (double)((float)event.gui.height / 32.0F + (float)tint)).color(64, 64, 64, 255).endVertex();
            worldrenderer.pos((double)event.gui.width, (double)event.gui.height, 0.0D).tex((double)((float)event.gui.width / 32.0F), (double)((float)event.gui.height / 32.0F + (float)tint)).color(64, 64, 64, 255).endVertex();
            worldrenderer.pos((double)event.gui.width, 0.0D, 0.0D).tex((double)((float)event.gui.width / 32.0F), (double)tint).color(64, 64, 64, 255).endVertex();
            worldrenderer.pos(0.0D, 0.0D, 0.0D).tex(0.0D, (double)tint).color(64, 64, 64, 255).endVertex();
            tessellator.draw();

        }
        //@Mod.EventHandler
        //public void onDisconnectedPlayBGM(GuiScreenEvent)










        /* int tint=0






*/

    }

    //@Mod.EventHandler
    //public void onDisconnectedPlayBGM(PlaySoundEvent event)
    //{
      //  if(is_bgm_on&&Gratz && mc.currentScreen instanceof GuiDisconnected)
       // {
        //    playBGM();//play music again lol
       // }
//
  //  }

    private void playBGM()
    {
        Minecraft.getMinecraft().getSoundHandler().playSound(PositionedSoundRecord.create(
                new ResourceLocation(MOD_ID+":gratz")
        ));
    }


}


