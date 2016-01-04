package org.devoxx4kids.forge.mods;

import net.minecraft.entity.passive.EntityPig;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import scala.util.Random;

public class PigsDroppingDiamonds {
	
	@SubscribeEvent
	public void dropDiamonds(LivingDeathEvent event){
		
		// make sure entity that died is a pig
		if (!(event.entity instanceof EntityPig)) {
			return;
		}
		
		Random random = new Random();
		
		if (!event.entity.worldObj.isRemote) {
			
			// drop an item... like a diamond
			event.entity.dropItem(Items.diamond, random.nextInt(3));
			
			// dropping blocks is slightly different code
			event.entity.dropItem(Item.getItemFromBlock(Blocks.emerald_block), random.nextInt(3));
			
		}
		
	}

}
