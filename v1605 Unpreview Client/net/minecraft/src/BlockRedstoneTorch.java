package net.minecraft.src;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;
import org.lwjgl.opengl.GL11;

public class BlockRedstoneTorch {
	private static List a = new ArrayList();
	private static List torchUpdates = new ArrayList();

	public static synchronized int a(int var0) {
		int var1 = GL11.glGenLists(var0);
		a.add(Integer.valueOf(var1));
		a.add(Integer.valueOf(var0));
		return var1;
	}

	public static synchronized void a(IntBuffer var0) {
		GL11.glGenTextures(var0);

		for(int var1 = var0.position(); var1 < var0.limit(); ++var1) {
			torchUpdates.add(Integer.valueOf(var0.get(var1)));
		}

	}

	public static synchronized void a() {
		for(int var0 = 0; var0 < a.size(); var0 += 2) {
			GL11.glDeleteLists(((Integer)a.get(var0)).intValue(), ((Integer)a.get(var0 + 1)).intValue());
		}

		IntBuffer var2 = c(torchUpdates.size());
		var2.flip();
		GL11.glDeleteTextures(var2);

		for(int var1 = 0; var1 < torchUpdates.size(); ++var1) {
			var2.put(((Integer)torchUpdates.get(var1)).intValue());
		}

		var2.flip();
		GL11.glDeleteTextures(var2);
		a.clear();
		torchUpdates.clear();
	}

	public static synchronized ByteBuffer b(int var0) {
		ByteBuffer var1 = ByteBuffer.allocateDirect(var0).order(ByteOrder.nativeOrder());
		return var1;
	}

	public static IntBuffer c(int var0) {
		return b(var0 << 2).asIntBuffer();
	}

	public static FloatBuffer d(int var0) {
		return b(var0 << 2).asFloatBuffer();
	}
}
