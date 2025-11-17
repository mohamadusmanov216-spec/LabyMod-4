package com.axmed555.labyvisuals;

import com.google.gson.JsonObject;
import net.labymod.utils.JsonUtils;

public class Config {
    private boolean enabled = true;
    private int intensity = 75;
    private boolean particles = true;
    private boolean shaders = false;
    
    public void loadConfiguration() {
        try {
            JsonObject config = JsonUtils.parseFromFile("labyvisuals_config.json");
            if (config != null) {
                this.enabled = config.get("enabled").getAsBoolean();
                this.intensity = config.get("intensity").getAsInt();
                this.particles = config.get("particles").getAsBoolean();
                this.shaders = config.get("shaders").getAsBoolean();
            }
        } catch (Exception e) {
            // Используем значения по умолчанию
            saveConfiguration();
        }
    }
    
    public void saveConfiguration() {
        JsonObject config = new JsonObject();
        config.addProperty("enabled", enabled);
        config.addProperty("intensity", intensity);
        config.addProperty("particles", particles);
        config.addProperty("shaders", shaders);
        
        JsonUtils.writeToFile(config, "labyvisuals_config.json");
    }
    
    // Геттеры и сеттеры
    public boolean isEnabled() { return enabled; }
    public void setEnabled(boolean enabled) { 
        this.enabled = enabled; 
        saveConfiguration();
    }
    
    public int getIntensity() { return intensity; }
    public void setIntensity(int intensity) { 
        this.intensity = intensity; 
        saveConfiguration();
    }
    
    public boolean isParticles() { return particles; }
    public void setParticles(boolean particles) { 
        this.particles = particles; 
        saveConfiguration();
    }
    
    public boolean isShaders() { return shaders; }
    public void setShaders(boolean shaders) { 
        this.shaders = shaders; 
        saveConfiguration();
    }
}
