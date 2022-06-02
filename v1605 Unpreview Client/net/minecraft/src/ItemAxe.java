package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class ItemAxe {
	private static Map a = new HashMap();
	private static Map b = new HashMap();
	public boolean j = false;

	static void a(int var0, Class var1) {
		if(a.containsKey(Integer.valueOf(var0))) {
			throw new IllegalArgumentException("Duplicate packet id:" + var0);
		} else if(b.containsKey(var1)) {
			throw new IllegalArgumentException("Duplicate packet class:" + var1);
		} else {
			a.put(Integer.valueOf(var0), var1);
			b.put(var1, Integer.valueOf(var0));
		}
	}

	public static ItemAxe a(int var0) {
		try {
			Class var1 = (Class)a.get(Integer.valueOf(var0));
			return var1 == null?null:(ItemAxe)var1.newInstance();
		} catch (Exception var2) {
			var2.printStackTrace();
			System.out.println("Skipping packet with id " + var0);
			return null;
		}
	}

	public final int b() {
		return ((Integer)b.get(this.getClass())).intValue();
	}

	public static ItemAxe b(DataInputStream var0) {
		int var1 = var0.read();
		if(var1 == -1) {
			return null;
		} else {
			ItemAxe var2 = a(var1);
			if(var2 == null) {
				throw new IOException("Bad packet id " + var1);
			} else {
				var2.a(var0);
				return var2;
			}
		}
	}

	public static void a(ItemAxe var0, DataOutputStream var1) {
		var1.write(var0.b());
		var0.a(var1);
	}

	public abstract void a(DataInputStream var1);

	public abstract void a(DataOutputStream var1);

	public abstract void a(kq var1);

	public abstract int a();

	static {
		a(0, SlotArmor.class);
		a(1, ItemSign.class);
		a(2, BlockSign.class);
		a(3, InventoryPlayer.class);
		a(10, BlockContainer.class);
		a(11, MinecraftAppletImpl.class);
		a(12, lx.class);
		a(13, Timer.class);
		a(14, MetadataChunkBlock.class);
		a(15, ItemRenderer.class);
		a(16, BlockLadder.class);
		a(17, ks.class);
		a(18, Slot.class);
		a(20, NoiseGeneratorOctaves.class);
		a(21, GuiIngame.class);
		a(22, EntityAnimal.class);
		a(23, TileEntityRenderer.class);
		a(29, RecipeSorter.class);
		a(30, lf.class);
		a(31, BlockStep.class);
		a(32, ItemFlintAndSteel.class);
		a(33, NibbleArray.class);
		a(34, IBlockAccess.class);
		a(50, RenderGiantZombie.class);
		a(51, PanelCrashReport.class);
		a(52, mn.class);
		a(53, kx.class);
		a(255, nt.class);
	}
}
