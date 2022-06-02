package net.minecraft.src;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.lwjgl.opengl.GL11;

public class RenderSpider {
	private Map o = new HashMap();
	public static RenderSpider a = new RenderSpider();
	private BlockDoor p;
	public static double b;
	public static double c;
	public static double d;
	public BlockRedstoneWire e;
	public EntitySmokeFX f;
	public EntitySpider g;
	public BlockMobSpawner h;
	public float i;
	public float j;
	public World k;
	public double l;
	public double m;
	public double n;

	private RenderSpider() {
		this.o.put(TextureFX.class, new nw());
		this.o.put(mj.class, new OSMapIsom(new IWorldAccess(), new IWorldAccess(0.5F), 0.7F));
		this.o.put(SoundPoolEntry.class, new nf(new EntityPlayer(), new ItemSoup(), 0.7F));
		this.o.put(StepSoundSand.class, new ls(new EntitySheep(), 0.7F));
		this.o.put(mm.class, new MaterialLiquid(new IInventory(), 0.3F));
		this.o.put(EntityFlameFX.class, new PathPoint());
		this.o.put(RenderBlocks.class, new ItemBow(new RenderList(), 0.5F));
		this.o.put(lr.class, new ItemBow(new GuiErrorScreen(), 0.5F));
		this.o.put(lq.class, new BlockSand(new Block(16), new Block(0), 0.25F));
		this.o.put(BlockMobSpawner.class, new Render());
		this.o.put(EntityZombie.class, new nl(new GuiErrorScreen(), 0.5F, 6.0F));
		this.o.put(RecipesIngots.class, new ItemBow(new EntityDiggingFX(), 0.5F));
		this.o.put(EntityMinecart.class, new TexturedQuad());
		this.o.put(RecipesWeapons.class, new WorldGenerator());
		this.o.put(NBTTagEnd.class, new Gui());
		this.o.put(StepSoundGlass.class, new RenderPainting());
		this.o.put(EffectRenderer.class, new ModelMinecart());
		this.o.put(EntityRainFX.class, new BlockTorch());
		this.o.put(BlockStairs.class, new GuiScreen());
		this.o.put(no.class, new GuiMainMenu());
		this.o.put(ThreadDownloadResources.class, new SpawnerAnimals());
		Iterator var1 = this.o.values().iterator();

		while(var1.hasNext()) {
			TileEntityMobSpawnerRenderer var2 = (TileEntityMobSpawnerRenderer)var1.next();
			var2.a(this);
		}

	}

	public TileEntityMobSpawnerRenderer a(Class var1) {
		TileEntityMobSpawnerRenderer var2 = (TileEntityMobSpawnerRenderer)this.o.get(var1);
		if(var2 == null && var1 != EntityMinecart.class) {
			var2 = this.a(var1.getSuperclass());
			this.o.put(var1, var2);
		}

		return var2;
	}

	public TileEntityMobSpawnerRenderer a(EntityMinecart var1) {
		return this.a(var1.getClass());
	}

	public void a(EntitySpider var1, BlockRedstoneWire var2, BlockDoor var3, BlockMobSpawner var4, World var5, float var6) {
		this.g = var1;
		this.e = var2;
		this.k = var5;
		this.h = var4;
		this.p = var3;
		this.i = var4.ap + (var4.an - var4.ap) * var6;
		this.j = var4.aq + (var4.ao - var4.aq) * var6;
		this.l = var4.aF + (var4.ah - var4.aF) * (double)var6;
		this.m = var4.aG + (var4.ai - var4.aG) * (double)var6;
		this.n = var4.aH + (var4.aj - var4.aH) * (double)var6;
	}

	public void a(EntityMinecart var1, float var2) {
		double var3 = var1.aF + (var1.ah - var1.aF) * (double)var2;
		double var5 = var1.aG + (var1.ai - var1.aG) * (double)var2;
		double var7 = var1.aH + (var1.aj - var1.aH) * (double)var2;
		float var9 = var1.ap + (var1.an - var1.ap) * var2;
		float var10 = var1.a(var2);
		GL11.glColor3f(var10, var10, var10);
		this.a(var1, var3 - b, var5 - c, var7 - d, var9, var2);
	}

	public void a(EntityMinecart var1, double var2, double var4, double var6, float var8, float var9) {
		TileEntityMobSpawnerRenderer var10 = this.a(var1);
		if(var10 != null) {
			var10.a(var1, var2, var4, var6, var8, var9);
			var10.b(var1, var2, var4, var6, var8, var9);
		}

	}

	public void a(EntitySpider var1) {
		this.g = var1;
	}

	public double a(double var1, double var3, double var5) {
		double var7 = var1 - this.l;
		double var9 = var3 - this.m;
		double var11 = var5 - this.n;
		return var7 * var7 + var9 * var9 + var11 * var11;
	}

	public BlockDoor a() {
		return this.p;
	}
}
