package com.axmed555.labyvisuals;

import net.labymod.api.events.KeyPressEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

public class KeyHandler {
    
    @SubscribeEvent
    public void onKeyPress(KeyPressEvent event) {
        // Переключение эффектов на R
        if (event.getKey() == Keyboard.KEY_R) {
            Config config = LabyVisualsAddon.getConfig();
            config.setEnabled(!config.isEnabled());
            System.out.println("Visual effects: " + (config.isEnabled() ? "ON" : "OFF"));
        }
        
        // Открытие настроек на P
        if (event.getKey() == Keyboard.KEY_P) {
            // Будет открывать GUI настроек LabyMod
            System.out.println("Open settings GUI");
        }
    }
}
