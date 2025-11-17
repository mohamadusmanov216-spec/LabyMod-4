package com.axmed555.labyvisuals;

import net.labymod.api.LabyModAddon;
import net.labymod.settings.elements.*;
import net.labymod.utils.Material;
import java.util.List;

public class LabyVisualsAddon extends LabyModAddon {
    
    private static LabyVisualsAddon instance;
    public static Config config;
    private VisualEffects visualEffects;
    private KeyHandler keyHandler;
    
    @Override
    public void onEnable() {
        instance = this;
        config = new Config();
        visualEffects = new VisualEffects();
        keyHandler = new KeyHandler();
        
        // Register handlers
        getApi().registerForgeListener(keyHandler);
        getApi().registerWorldRenderListener(visualEffects::onWorldRender);
        
        System.out.println("=== LabyVisuals Addon Enabled ===");
    }
    
    @Override
    public void loadConfig() {
        config.loadConfiguration();
    }
    
    @Override
    protected void fillSettings(List<SettingsElement> settings) {
        // Settings will be here
        SettingsElement header = new HeaderElement("LabyVisuals Settings");
        settings.add(header);
        
        // Enable/disable mod
        BooleanElement enabledToggle = new BooleanElement(
            "Enable Visual Effects", 
            new ControlElement.IconData(Material.LEVER),
            config::isEnabled, 
            config::setEnabled
        );
        settings.add(enabledToggle);
        
        // Effect intensity
        SliderElement intensitySlider = new SliderElement(
            "Effect Intensity", 
            new ControlElement.IconData(Material.REDSTONE),
            config::getIntensity, 
            config::setIntensity
        );
        intensitySlider.setRange(0, 100);
        intensitySlider.setSteps(5);
        settings.add(intensitySlider);
        
        // Particles toggle
        BooleanElement particlesToggle = new BooleanElement(
            "Enable Particles", 
            new ControlElement.IconData(Material.FIREWORK),
            config::isParticles, 
            config::setParticles
        );
        settings.add(particlesToggle);
        
        // Shaders toggle
        BooleanElement shadersToggle = new BooleanElement(
            "Enable Shaders", 
            new ControlElement.IconData(Material.GLASS),
            config::isShaders, 
            config::setShaders
        );
        settings.add(shadersToggle);
    }
    
    public static LabyVisualsAddon getInstance() {
        return instance;
    }
    
    public static Config getConfig() {
        return config;
    }
}
