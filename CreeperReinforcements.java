package org.devoxx4kids.forge.mods;

import net.minecraft.entity.monster.EntityCreeper;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CreeperReinforcements {
	
	// Subscribe to the LivingDeathEvent
	@SubscribeEvent
	public void spawnReinforcements(LivingDeathEvent event){
		
		// Return if LivingDeathEvent was not a creeper
		if (!(event.entity instanceof EntityCreeper)) {
			return;
		}
		
		// spawn 5 creepers
		for (int i = 0; i < 5; i++) {
			
			// create a creeper
			EntityCreeper creeper = new EntityCreeper(event.entity.worldObj);
			
			// set the new creeper location to that of the dead creeper
			creeper.setLocationAndAngles(event.entity.posX, event.entity.posY, event.entity.posZ, 0, 0);
			
			// make sure object is not remote
			if (!event.entity.worldObj.isRemote) {
				
				// spawn the new creeper
				event.entity.worldObj.spawnEntityInWorld(creeper);
				
			}
			
		}
		
	}

}
