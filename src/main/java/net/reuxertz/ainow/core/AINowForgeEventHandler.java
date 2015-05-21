package net.reuxertz.ainow.core;


import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.reuxertz.ainow.entity.EntityAICreature;

public class AINowForgeEventHandler {

    @SubscribeEvent
    public void onEntityJoinWorld(EntityJoinWorldEvent e) {

        boolean isAICreature = EntityAICreature.class.isInstance(e.entity);
        boolean isAnimal = EntityAnimal.class.isInstance(e.entity);
        boolean isVillager = EntityVillager.class.isInstance(e.entity);

        //if (isVillager || isAnimal)
        //    EntityAICreature.ConstructAI((EntityCreature)e.entity);

        return;
    }
}
