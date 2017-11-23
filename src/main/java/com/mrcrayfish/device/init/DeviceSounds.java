package com.mrcrayfish.device.init;

import com.mrcrayfish.device.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.LinkedList;
import java.util.List;

/**
 * Author: MrCrayfish
 */
public class DeviceSounds
{
    public static SoundEvent printing_ink;
    public static SoundEvent printing_paper;

    public static void register()
    {
        printing_ink = registerSound("cdm:printing_ink");
        printing_paper = registerSound("cdm:printing_paper");
    }

    private static SoundEvent registerSound(String soundNameIn)
    {
        ResourceLocation resource = new ResourceLocation(soundNameIn);
        SoundEvent sound = new SoundEvent(resource).setRegistryName(soundNameIn);
        RegistrationHandler.SOUNDS.add(sound);
        return sound;
    }

    @Mod.EventBusSubscriber(modid = Reference.MOD_ID)
    public static class RegistrationHandler
    {
        public static final List<SoundEvent> SOUNDS = new LinkedList<>();

        @SubscribeEvent
        public static void registerSounds(final RegistryEvent.Register<SoundEvent> event)
        {
            register();
            SOUNDS.stream().forEach(sound -> event.getRegistry().register(sound));
        }
    }
}