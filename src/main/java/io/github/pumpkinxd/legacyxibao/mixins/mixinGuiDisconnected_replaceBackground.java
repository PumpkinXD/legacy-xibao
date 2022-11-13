package io.github.pumpkinxd.legacyxibao.mixins;
//prob not quite useful i guess
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiDisconnected;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(GuiDisconnected.class)
public class mixinGuiDisconnected_replaceBackground {
    @Inject(method = "drawScreen",
            at=@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/GuiDisconnected;drawDefaultBackground()",
                    ordinal = 0,
                    shift=At.Shift.AFTER,
                    remap = true
            )

    )
    public void replaceBackground(int mouseX, int mouseY, float partialTicks, CallbackInfo ci)
    {

    }




    //@Inject(method = "startGame", at = @At("HEAD"))
    //public void startGame(CallbackInfo ci) {
     //   System.out.println("Test start mixin");
    //}
}