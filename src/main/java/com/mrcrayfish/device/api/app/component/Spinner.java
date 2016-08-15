package com.mrcrayfish.device.api.app.component;

import org.lwjgl.opengl.GL11;

import com.mrcrayfish.device.api.app.Component;
import com.mrcrayfish.device.core.Laptop;

import net.minecraft.client.Minecraft;

public class Spinner extends Component 
{
	protected final int MAX_PROGRESS = 31;
	protected int currentProgress = 0;
	
	public Spinner(int x, int y, int left, int top)
	{
		super(x, y, left, top);
	}
	
	@Override
	public void handleTick() 
	{
		if(currentProgress >= MAX_PROGRESS)
		{
			currentProgress = 0;
		}
		currentProgress++;
	}

	@Override
	public void render(Laptop laptop, Minecraft mc, int mouseX, int mouseY, boolean windowActive, float partialTicks) 
	{
		if (this.visible)
        {
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			mc.getTextureManager().bindTexture(Component.COMPONENTS_GUI);
			drawTexturedModalRect(xPosition, yPosition, (currentProgress % 8) * 12, 12 + 12 * (int) Math.floor((double) currentProgress / 8), 12, 12);
        }
	}
}