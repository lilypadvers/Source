package net.minecraft.src;

import java.nio.FloatBuffer;
import org.lwjgl.opengl.GL11;

public class GLStatics {
	private static FloatBuffer a = BlockRedstoneTorch.d(16);

	public static void a() {
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_LIGHT0);
		GL11.glDisable(GL11.GL_LIGHT1);
		GL11.glDisable(GL11.GL_COLOR_MATERIAL);
	}

	public static void b() {
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glEnable(GL11.GL_LIGHT0);
		GL11.glEnable(GL11.GL_LIGHT1);
		GL11.glEnable(GL11.GL_COLOR_MATERIAL);
		GL11.glColorMaterial(GL11.GL_FRONT_AND_BACK, GL11.GL_AMBIENT_AND_DIFFUSE);
		BlockTNT var3 = BlockTNT.b((double)0.2F, 1.0D, -0.699999988079071D).b();
		GL11.glLight(GL11.GL_LIGHT0, GL11.GL_POSITION, a(var3.a, var3.b, var3.c, 0.0D));
		GL11.glLight(GL11.GL_LIGHT0, GL11.GL_DIFFUSE, a(0.6F, 0.6F, 0.6F, 1.0F));
		GL11.glLight(GL11.GL_LIGHT0, GL11.GL_AMBIENT, a(0.0F, 0.0F, 0.0F, 1.0F));
		GL11.glLight(GL11.GL_LIGHT0, GL11.GL_SPECULAR, a(0.0F, 0.0F, 0.0F, 1.0F));
		BlockTNT var4 = BlockTNT.b(-0.20000000298023224D, 1.0D, (double)0.7F).b();
		GL11.glLight(GL11.GL_LIGHT1, GL11.GL_POSITION, a(var4.a, var4.b, var4.c, 0.0D));
		GL11.glLight(GL11.GL_LIGHT1, GL11.GL_DIFFUSE, a(0.6F, 0.6F, 0.6F, 1.0F));
		GL11.glLight(GL11.GL_LIGHT1, GL11.GL_AMBIENT, a(0.0F, 0.0F, 0.0F, 1.0F));
		GL11.glLight(GL11.GL_LIGHT1, GL11.GL_SPECULAR, a(0.0F, 0.0F, 0.0F, 1.0F));
		GL11.glShadeModel(GL11.GL_FLAT);
		GL11.glLightModel(GL11.GL_LIGHT_MODEL_AMBIENT, a(0.4F, 0.4F, 0.4F, 1.0F));
	}

	private static FloatBuffer a(double var0, double var2, double var4, double var6) {
		return a((float)var0, (float)var2, (float)var4, (float)var6);
	}

	private static FloatBuffer a(float var0, float var1, float var2, float var3) {
		a.clear();
		a.put(var0).put(var1).put(var2).put(var3);
		a.flip();
		return a;
	}
}
