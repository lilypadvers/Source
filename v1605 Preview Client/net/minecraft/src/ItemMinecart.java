package net.minecraft.src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ItemMinecart {
	private static final ItemMinecart a = new ItemMinecart();
	private List b = new ArrayList();

	public static final ItemMinecart a() {
		return a;
	}

	private ItemMinecart() {
		(new SignModel()).a(this);
		(new mq()).a(this);
		(new ku()).a(this);
		(new BlockLog()).a(this);
		(new ChatLine()).a(this);
		(new RenderGlobal()).a(this);
		this.a(new TileEntityFurnace(EntityTNTPrimed.aI, 3), new Object[]{"###", Character.valueOf('#'), EntityTNTPrimed.aH});
		this.a(new TileEntityFurnace(EntityTNTPrimed.aJ, 1), new Object[]{"#", "#", "#", Character.valueOf('#'), EntityTNTPrimed.aI});
		this.a(new TileEntityFurnace(ln.aY, 1), new Object[]{"###", "#X#", "###", Character.valueOf('#'), ln.x, Character.valueOf('X'), EntityTNTPrimed.l});
		this.a(new TileEntityFurnace(ln.an, 1), new Object[]{"###", "XXX", "###", Character.valueOf('#'), ln.x, Character.valueOf('X'), EntityTNTPrimed.aJ});
		this.a(new TileEntityFurnace(ln.aU, 1), new Object[]{"##", "##", Character.valueOf('#'), EntityTNTPrimed.aB});
		this.a(new TileEntityFurnace(ln.aW, 1), new Object[]{"##", "##", Character.valueOf('#'), EntityTNTPrimed.aG});
		this.a(new TileEntityFurnace(ln.al, 1), new Object[]{"##", "##", Character.valueOf('#'), EntityTNTPrimed.aF});
		this.a(new TileEntityFurnace(ln.ab, 1), new Object[]{"###", "###", "###", Character.valueOf('#'), EntityTNTPrimed.I});
		this.a(new TileEntityFurnace(ln.am, 1), new Object[]{"X#X", "#X#", "X#X", Character.valueOf('X'), EntityTNTPrimed.K, Character.valueOf('#'), ln.E});
		this.a(new TileEntityFurnace(ln.ak, 3), new Object[]{"###", Character.valueOf('#'), ln.w});
		this.a(new TileEntityFurnace(ln.aF, 1), new Object[]{"# #", "###", "# #", Character.valueOf('#'), EntityTNTPrimed.B});
		this.a(new TileEntityFurnace(EntityTNTPrimed.at, 1), new Object[]{"##", "##", "##", Character.valueOf('#'), ln.x});
		this.a(new TileEntityFurnace(EntityTNTPrimed.az, 1), new Object[]{"##", "##", "##", Character.valueOf('#'), EntityTNTPrimed.m});
		this.a(new TileEntityFurnace(EntityTNTPrimed.as, 1), new Object[]{"###", "###", " X ", Character.valueOf('#'), ln.x, Character.valueOf('X'), EntityTNTPrimed.B});
		this.a(new TileEntityFurnace(ln.x, 4), new Object[]{"#", Character.valueOf('#'), ln.J});
		this.a(new TileEntityFurnace(EntityTNTPrimed.B, 4), new Object[]{"#", "#", Character.valueOf('#'), ln.x});
		this.a(new TileEntityFurnace(ln.aq, 4), new Object[]{"X", "#", Character.valueOf('X'), EntityTNTPrimed.k, Character.valueOf('#'), EntityTNTPrimed.B});
		this.a(new TileEntityFurnace(EntityTNTPrimed.C, 4), new Object[]{"# #", " # ", Character.valueOf('#'), ln.x});
		this.a(new TileEntityFurnace(ln.aG, 16), new Object[]{"X X", "X#X", "X X", Character.valueOf('X'), EntityTNTPrimed.m, Character.valueOf('#'), EntityTNTPrimed.B});
		this.a(new TileEntityFurnace(EntityTNTPrimed.ax, 1), new Object[]{"# #", "###", Character.valueOf('#'), EntityTNTPrimed.m});
		this.a(new TileEntityFurnace(EntityTNTPrimed.aL, 1), new Object[]{"A", "B", Character.valueOf('A'), ln.au, Character.valueOf('B'), EntityTNTPrimed.ax});
		this.a(new TileEntityFurnace(EntityTNTPrimed.aM, 1), new Object[]{"A", "B", Character.valueOf('A'), ln.aB, Character.valueOf('B'), EntityTNTPrimed.ax});
		this.a(new TileEntityFurnace(EntityTNTPrimed.aC, 1), new Object[]{"# #", "###", Character.valueOf('#'), ln.x});
		this.a(new TileEntityFurnace(EntityTNTPrimed.au, 1), new Object[]{"# #", " # ", Character.valueOf('#'), EntityTNTPrimed.m});
		this.a(new TileEntityFurnace(EntityTNTPrimed.g, 1), new Object[]{"A ", " B", Character.valueOf('A'), EntityTNTPrimed.m, Character.valueOf('B'), EntityTNTPrimed.an});
		this.a(new TileEntityFurnace(EntityTNTPrimed.S, 1), new Object[]{"###", Character.valueOf('#'), EntityTNTPrimed.R});
		this.a(new TileEntityFurnace(ln.at, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), ln.x});
		this.a(new TileEntityFurnace(ln.aH, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), ln.w});
		this.a(new TileEntityFurnace(EntityTNTPrimed.aq, 1), new Object[]{"###", "#X#", "###", Character.valueOf('#'), EntityTNTPrimed.B, Character.valueOf('X'), ln.ab});
		this.a(new TileEntityFurnace(EntityTNTPrimed.ar, 1), new Object[]{"###", "#X#", "###", Character.valueOf('#'), ln.ah, Character.valueOf('X'), EntityTNTPrimed.h});
		this.a(new TileEntityFurnace(ln.aJ, 1), new Object[]{"X", "#", Character.valueOf('#'), ln.w, Character.valueOf('X'), EntityTNTPrimed.B});
		this.a(new TileEntityFurnace(ln.aQ, 1), new Object[]{"X", "#", Character.valueOf('#'), EntityTNTPrimed.B, Character.valueOf('X'), EntityTNTPrimed.aA});
		this.a(new TileEntityFurnace(ln.aR, 1), new Object[]{"#", "#", Character.valueOf('#'), ln.t});
		this.a(new TileEntityFurnace(ln.aK, 1), new Object[]{"###", Character.valueOf('#'), ln.t});
		this.a(new TileEntityFurnace(ln.aM, 1), new Object[]{"###", Character.valueOf('#'), ln.x});
		this.a(new TileEntityFurnace(ln.PillarBlock, 4), new Object[]{"#X#", "X X", "#X#", Character.valueOf('#'), ln.x, Character.valueOf('X'), EntityTNTPrimed.B});
		this.a(new TileEntityFurnace(ln.QuadWindowGlassBlock, 1), new Object[]{" # ", "#X#", " # ", Character.valueOf('#'), ln.w, Character.valueOf('X'), ln.M});
		Collections.sort(this.b, new EntityLavaFX(this));
		System.out.println(this.b.size() + " recipes");
	}

	void a(TileEntityFurnace var1, Object... var2) {
		String var3 = "";
		int var4 = 0;
		int var5 = 0;
		int var6 = 0;
		if(var2[var4] instanceof String[]) {
			String[] var7 = (String[])((String[])var2[var4++]);

			for(int var8 = 0; var8 < var7.length; ++var8) {
				String var9 = var7[var8];
				++var6;
				var5 = var9.length();
				var3 = var3 + var9;
			}
		} else {
			while(var2[var4] instanceof String) {
				String var11 = (String)var2[var4++];
				++var6;
				var5 = var11.length();
				var3 = var3 + var11;
			}
		}

		HashMap var12;
		int var15;
		for(var12 = new HashMap(); var4 < var2.length; var4 += 2) {
			Character var13 = (Character)var2[var4];
			var15 = 0;
			if(var2[var4 + 1] instanceof EntityTNTPrimed) {
				var15 = ((EntityTNTPrimed)var2[var4 + 1]).aQ;
			} else if(var2[var4 + 1] instanceof ln) {
				var15 = ((ln)var2[var4 + 1]).ba;
			}

			var12.put(var13, Integer.valueOf(var15));
		}

		int[] var14 = new int[var5 * var6];

		for(var15 = 0; var15 < var5 * var6; ++var15) {
			char var10 = var3.charAt(var15);
			if(var12.containsKey(Character.valueOf(var10))) {
				var14[var15] = ((Integer)var12.get(Character.valueOf(var10))).intValue();
			} else {
				var14[var15] = -1;
			}
		}

		this.b.add(new BlockPressurePlate(var5, var6, var14, var1));
	}

	public TileEntityFurnace a(int[] var1) {
		for(int var2 = 0; var2 < this.b.size(); ++var2) {
			BlockPressurePlate var3 = (BlockPressurePlate)this.b.get(var2);
			if(var3.a(var1)) {
				return var3.b(var1);
			}
		}

		return null;
	}
}
