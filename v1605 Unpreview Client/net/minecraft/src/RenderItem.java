package net.minecraft.src;

import org.lwjgl.opengl.GLContext;

public class RenderItem {
	public boolean a() {
		return false & GLContext.getCapabilities().GL_ARB_occlusion_query;
	}
}
