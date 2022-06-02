package net.minecraft.src;

import java.util.HashMap;
import java.util.Map;

public class EntityPickupFX {
	private static Map a = new HashMap();
	private static Map b = new HashMap();

	private static void a(Class var0, String var1) {
		a.put(var1, var0);
		b.put(var0, var1);
	}

	public static EntityMinecart a(String var0, EntitySpider var1) {
		EntityMinecart var2 = null;

		try {
			Class var3 = (Class)a.get(var0);
			if(var3 != null) {
				var2 = (EntityMinecart)var3.getConstructor(new Class[]{EntitySpider.class}).newInstance(new Object[]{var1});
			}
		} catch (Exception var4) {
			var4.printStackTrace();
		}

		return var2;
	}

	public static EntityMinecart a(EntityItem var0, EntitySpider var1) {
		EntityMinecart var2 = null;

		try {
			Class var3 = (Class)a.get(var0.i("id"));
			if(var3 != null) {
				var2 = (EntityMinecart)var3.getConstructor(new Class[]{EntitySpider.class}).newInstance(new Object[]{var1});
			}
		} catch (Exception var4) {
			var4.printStackTrace();
		}

		if(var2 != null) {
			var2.e(var0);
		} else {
			System.out.println("Skipping Entity with id " + var0.i("id"));
		}

		return var2;
	}

	public static String a(EntityMinecart var0) {
		return (String)b.get(var0.getClass());
	}

	static {
		a(NBTTagEnd.class, "Arrow");
		a(StepSoundGlass.class, "Snowball");
		a(EffectRenderer.class, "Item");
		a(RecipesWeapons.class, "Painting");
		a(RecipesIngots.class, "Mob");
		a(IsoImageBuffer.class, "Monster");
		a(EntityFlameFX.class, "Creeper");
		a(RenderBlocks.class, "Skeleton");
		a(TextureFX.class, "Spider");
		a(EntityZombie.class, "Giant");
		a(lr.class, "Zombie");
		a(lq.class, "Slime");
		a(mj.class, "Pig");
		a(SoundPoolEntry.class, "Sheep");
		a(StepSoundSand.class, "Cow");
		a(mm.class, "Chicken");
		a(EntityRainFX.class, "PrimedTnt");
		a(BlockStairs.class, "FallingSand");
		a(no.class, "Minecart");
		a(ThreadDownloadResources.class, "Boat");
	}
}
