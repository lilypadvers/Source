package net.minecraft.src;

import java.util.ArrayList;
import java.util.Random;

public class ln {
	public static final RenderTNTPrimed e = new RenderTNTPrimed("stone", 1.0F, 1.0F);
	public static final RenderTNTPrimed f = new RenderTNTPrimed("wood", 1.0F, 1.0F);
	public static final RenderTNTPrimed g = new RenderTNTPrimed("gravel", 1.0F, 1.0F);
	public static final RenderTNTPrimed h = new RenderTNTPrimed("grass", 1.0F, 1.0F);
	public static final RenderTNTPrimed i = new RenderTNTPrimed("stone", 1.0F, 1.0F);
	public static final RenderTNTPrimed j = new RenderTNTPrimed("stone", 1.0F, 1.5F);
	public static final RenderTNTPrimed k = new InventoryCrafting("stone", 1.0F, 1.0F);
	public static final RenderTNTPrimed l = new RenderTNTPrimed("cloth", 1.0F, 1.0F);
	public static final RenderTNTPrimed m = new CanvasMinecraftApplet("sand", 1.0F, 1.0F);
	public static final ln[] n = new ln[256];
	public static final boolean[] o = new boolean[256];
	public static final boolean[] p = new boolean[256];
	public static final int[] q = new int[256];
	public static final boolean[] r = new boolean[256];
	public static final int[] s = new int[256];
	public static final ln t = (new NBTTagInt(1, 1)).c(1.5F).b(10.0F).a(i);
	public static final ml u = (ml)(new ml(2)).c(0.6F).a(h);
	public static final ln v = (new ItemRedstone(3, 2)).c(0.5F).a(g);
	public static final ln w = (new ln(4, 16, EntitySkeleton.d)).c(2.0F).b(10.0F).a(i);
	public static final ln x = (new ln(5, 4, EntitySkeleton.c)).c(2.0F).b(5.0F).a(f);
	public static final ln y = (new ClassDo(6, 15)).c(0.0F).a(h);
	public static final ln z = (new ln(7, 17, EntitySkeleton.d)).c(-1.0F).b(6000000.0F).a(i);
	public static final ln A = (new ItemDoor(8, EntitySkeleton.f)).c(100.0F).d(3);
	public static final ln B = (new CraftingManager(9, EntitySkeleton.f)).c(100.0F).d(3);
	public static final ln C = (new ItemDoor(10, EntitySkeleton.g)).c(0.0F).a(1.0F).d(255);
	public static final ln D = (new CraftingManager(11, EntitySkeleton.g)).c(100.0F).a(1.0F).d(255);
	public static final ln E = (new Explosion(12, 18)).c(0.5F).a(m);
	public static final ln F = (new GuiControls(13, 19)).c(0.6F).a(g);
	public static final ln G = (new NBTTagShort(14, 32)).c(3.0F).b(5.0F).a(i);
	public static final ln H = (new NBTTagShort(15, 33)).c(3.0F).b(5.0F).a(i);
	public static final ln I = (new NBTTagShort(16, 34)).c(3.0F).b(5.0F).a(i);
	public static final ln J = (new lw(17)).c(2.0F).a(f);
	public static final RecipesCrafting K = (RecipesCrafting)(new RecipesCrafting(18, 52)).c(0.2F).d(1).a(h);
	public static final ln L = (new mt(19)).c(0.6F).a(h);
	public static final ln M = (new SlotCrafting(20, 49, EntitySkeleton.o, false)).c(0.3F).a(k);
	public static final ln N = null;
	public static final ln O = null;
	public static final ln P = null;
	public static final ln Q = null;
	public static final ln R = null;
	public static final ln S = null;
	public static final ln T = null;
	public static final ln U = null;
	public static final ln V = null;
	public static final ln W = null;
	public static final ln X = null;
	public static final ln Y = null;
	public static final ln Z = null;
	public static final ln aa = null;
	public static final ln ab = (new ln(35, 64, EntitySkeleton.k)).c(0.8F).a(l);
	public static final ln ac = null;
	public static final me ad = (me)(new me(37, 13)).c(0.0F).a(h);
	public static final me ae = (me)(new me(38, 12)).c(0.0F).a(h);
	public static final me af = (me)(new kn(39, 29)).c(0.0F).a(h).a(0.125F);
	public static final me ag = (me)(new kn(40, 28)).c(0.0F).a(h);
	public static final ln ah = (new RenderSorter(41, 39)).c(3.0F).b(10.0F).a(j);
	public static final ln ai = (new RenderSorter(42, 38)).c(5.0F).b(10.0F).a(j);
	public static final ln aj = (new nu(43, true)).c(2.0F).b(10.0F).a(i);
	public static final ln ak = (new nu(44, false)).c(2.0F).b(10.0F).a(i);
	public static final ln al = (new ln(45, 7, EntitySkeleton.d)).c(2.0F).b(10.0F).a(i);
	public static final ln am = (new ImageBuffer(46, 8)).c(0.0F).a(h);
	public static final ln an = (new WorldRenderer(47, 35)).c(1.5F).a(f);
	public static final ln ao = (new ln(48, 36, EntitySkeleton.d)).c(2.0F).b(10.0F).a(i);
	public static final ln ap = (new IChunkProvider(49, 37)).c(10.0F).b(2000.0F).a(i);
	public static final ln aq = (new lz(50, 80)).c(0.0F).a(0.9375F).a(f);
	public static final ns ar = (ns)(new ns(51, 31)).c(0.0F).a(1.0F).a(f);
	public static final ln as = (new IChunkLoader(52, 65)).c(5.0F).a(j);
	public static final ln at = new SoundManager(53, x);
	public static final ln au = (new RenderArrow(54)).c(2.5F).a(f);
	public static final ln av = (new TileEntitySign(55, 84)).c(0.0F).a(e);
	public static final ln aw = (new NBTTagShort(56, 50)).c(3.0F).b(5.0F).a(i);
	public static final ln ax = (new RenderSorter(57, 40)).c(5.0F).b(10.0F).a(j);
	public static final ln ay = (new ScaledResolution(58)).c(2.5F).a(f);
	public static final ln az = (new EntityExplodeFX(59, 88)).c(0.0F).a(h);
	public static final ln aA = (new ly(60)).c(0.6F).a(g);
	public static final ln aB = (new MaterialTransparent(61, false)).c(3.5F).a(i);
	public static final ln aC = (new MaterialTransparent(62, true)).c(3.5F).a(i).a(0.875F);
	public static final ln aD = (new lg(63, nn.class, true)).c(1.0F).a(f);
	public static final ln aE = (new BlockGlass(64, EntitySkeleton.c)).c(3.0F).a(f);
	public static final ln aF = (new BlockRedstoneOre(65, 83)).c(0.4F).a(f);
	public static final ln aG = (new TextureWaterFX(66, 128)).c(0.7F).a(j);
	public static final ln aH = new SoundManager(67, w);
	public static final ln aI = (new lg(68, nn.class, false)).c(1.0F).a(f);
	public static final ln aJ = (new nb(69, 96)).c(0.5F).a(f);
	public static final ln aK = (new PlayerController(70, t.aZ, GameSettings.b)).c(0.5F).a(i);
	public static final ln aL = (new BlockGlass(71, EntitySkeleton.e)).c(5.0F).a(j);
	public static final ln aM = (new PlayerController(72, x.aZ, GameSettings.a)).c(0.5F).a(f);
	public static final ln aN = (new Tessellator(73, 51, false)).c(3.0F).b(5.0F).a(i);
	public static final ln aO = (new Tessellator(74, 51, true)).a(0.625F).c(3.0F).b(5.0F).a(i);
	public static final ln aP = (new BlockDirt(75, 115, false)).c(0.0F).a(f);
	public static final ln aQ = (new BlockDirt(76, 99, true)).c(0.0F).a(0.5F).a(f);
	public static final ln aR = (new BlockFarmland(77, t.aZ)).c(0.5F).a(i);
	public static final ln aS = (new NBTTagList(78, 66)).c(0.1F).a(l);
	public static final ln aT = (new InventoryCraftResult(79, 67)).c(0.5F).d(3).a(k);
	public static final ln aU = (new BlockGravel(80, 66)).c(0.2F).a(l);
	public static final ln aV = (new GuiContainer(81, 70)).c(0.4F).a(l);
	public static final ln aW = (new IProgressUpdate(82, 72)).c(0.6F).a(g);
	public static final ln aX = (new BlockLever(83, 73)).c(0.0F).a(h);
	public static final ln aY = (new StepSound(84, 74)).c(2.0F).b(10.0F).a(i);
	public int aZ;
	public final int ba;
	protected float bb;
	protected float bc;
	public double bd;
	public double be;
	public double bf;
	public double bg;
	public double bh;
	public double bi;
	public RenderTNTPrimed bj;
	public float bk;
	public final EntitySkeleton bl;
	public float bm;
	public static final ln QuadWindowGlassBlock = (new SlotCrafting(90, 145, EntitySkeleton.o, false)).c(0.3F).a(k);
	public static final ln PillarBlock = (new ln(91, 144, EntitySkeleton.c)).c(2.0F).b(5.0F).a(f);
	public static final ln TileBlock = (new ln(92, 146, EntitySkeleton.d)).c(2.0F).b(10.0F).a(i);
	public static final ln TileBlock2 = (new ln(93, 147, EntitySkeleton.d)).c(2.0F).b(10.0F).a(i);
	public static final ln TileBlock2NonFucked = (new SlotCrafting(94, 147, EntitySkeleton.o, false)).c(0.3F).a(k);
	public static final ln dimensionFloorBlock = (new ln(95, 148, EntitySkeleton.d)).c(2.0F).b(10.0F).a(i);
	public static final ln dimensionWallBlock = (new ln(96, 149, EntitySkeleton.d)).c(2.0F).b(10.0F).a(i);
	public static final ln dbgBlock = (new ln(97, 150, EntitySkeleton.d)).c(2.0F).b(10.0F).a(i);
	public static final ln TileBlock3 = (new ln(98, 151, EntitySkeleton.d)).c(2.0F).b(10.0F).a(i);
	public static final ln TileBlock4 = (new ln(99, 152, EntitySkeleton.d)).c(2.0F).b(10.0F).a(i);
	public static final ln fakeGrass = (new BlockMultiSided(100, 153, 154, 155)).c(0.6F).a(h);
	public static final ln AltMojangHypostasisAnemo = (new ln(101, 156, EntitySkeleton.d)).c(2.0F).b(10.0F).a(i);
	public static final ln imgur9F0A3un = (new ln(102, 157, EntitySkeleton.d)).c(2.0F).b(10.0F).a(i);
	public static final ln yeahWeHadFunWithThisAsYouCanSee = (new ln(103, 158, EntitySkeleton.d)).c(2.0F).b(10.0F).a(i);
	public static final ln BarrierBlock = (new BlockHidable(104, 159, EntitySkeleton.o, false)).c(0.3F).a(k);
	public static final ln StairLadderBlock = (new BlockRedstoneOre(105, 161)).c(0.4F).a(f);
	public static final ln fakeDirt = (new ln(106, 162, EntitySkeleton.d)).c(0.6F).b(10.0F).a(h);
	public static final ln fakeRock = (new ln(107, 163, EntitySkeleton.d)).c(2.0F).b(10.0F).a(i);
	public static final ln fakeSand = (new Explosion(108, 164)).c(0.5F).a(m);
	public static final ln woolPink = (new ln(109, 165, EntitySkeleton.k)).c(0.8F).a(l);
	public static final ln woolBlue = (new ln(110, 166, EntitySkeleton.k)).c(0.8F).a(l);
	public static final ln woolGreen = (new ln(111, 167, EntitySkeleton.k)).c(0.8F).a(l);
	public static final ln woolBlack = (new ln(112, 168, EntitySkeleton.k)).c(0.8F).a(l);

	protected ln(int var1, EntitySkeleton var2) {
		this.bj = e;
		this.bk = 1.0F;
		this.bm = 0.6F;
		if(n[var1] != null) {
			throw new IllegalArgumentException("Slot " + var1 + " is already occupied by " + n[var1] + " when adding " + this);
		} else {
			this.bl = var2;
			n[var1] = this;
			this.ba = var1;
			this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
			p[var1] = this.b();
			q[var1] = this.b()?255:0;
			r[var1] = this.i();
		}
	}

	protected ln(int var1, int var2, EntitySkeleton var3) {
		this(var1, var3);
		this.aZ = var2;
	}

	protected ln a(RenderTNTPrimed var1) {
		this.bj = var1;
		return this;
	}

	protected ln d(int var1) {
		q[this.ba] = var1;
		return this;
	}

	protected ln a(float var1) {
		s[this.ba] = (int)(15.0F * var1);
		return this;
	}

	protected ln b(float var1) {
		this.bc = var1 * 3.0F;
		return this;
	}

	private boolean i() {
		return false;
	}

	public boolean c() {
		return true;
	}

	public int f() {
		return 0;
	}

	protected ln c(float var1) {
		this.bb = var1;
		if(this.bc < var1 * 5.0F) {
			this.bc = var1 * 5.0F;
		}

		return this;
	}

	protected void b(boolean var1) {
		o[this.ba] = var1;
	}

	public void a(float var1, float var2, float var3, float var4, float var5, float var6) {
		this.bd = (double)var1;
		this.be = (double)var2;
		this.bf = (double)var3;
		this.bg = (double)var4;
		this.bh = (double)var5;
		this.bi = (double)var6;
	}

	public float c(mz var1, int var2, int var3, int var4) {
		return var1.c(var2, var3, var4);
	}

	public boolean c(mz var1, int var2, int var3, int var4, int var5) {
		return var5 == 0 && this.be > 0.0D || var5 == 1 && this.bh < 1.0D || var5 == 2 && this.bf > 0.0D || var5 == 3 && this.bi < 1.0D || var5 == 4 && this.bd > 0.0D || var5 == 5 && this.bg < 1.0D || !var1.g(var2, var3, var4);
	}

	public int a(mz var1, int var2, int var3, int var4, int var5) {
		return this.a(var5, var1.e(var2, var3, var4));
	}

	public int a(int var1, int var2) {
		return this.getGLCallListForPass(var1);
	}

	public int getGLCallListForPass(int var1) {
		return this.aZ;
	}

	public EntityRenderer f(EntitySpider var1, int var2, int var3, int var4) {
		return EntityRenderer.b((double)var2 + this.bd, (double)var3 + this.be, (double)var4 + this.bf, (double)var2 + this.bg, (double)var3 + this.bh, (double)var4 + this.bi);
	}

	public void a(EntitySpider var1, int var2, int var3, int var4, EntityRenderer var5, ArrayList var6) {
		EntityRenderer var7 = this.d(var1, var2, var3, var4);
		if(var7 != null && var5.a(var7)) {
			var6.add(var7);
		}

	}

	public EntityRenderer d(EntitySpider var1, int var2, int var3, int var4) {
		return EntityRenderer.b((double)var2 + this.bd, (double)var3 + this.be, (double)var4 + this.bf, (double)var2 + this.bg, (double)var3 + this.bh, (double)var4 + this.bi);
	}

	public boolean b() {
		return true;
	}

	public boolean a(int var1, boolean var2) {
		return this.h();
	}

	public boolean h() {
		return true;
	}

	public void a(EntitySpider var1, int var2, int var3, int var4, Random var5) {
	}

	public void b(EntitySpider var1, int var2, int var3, int var4, Random var5) {
	}

	public void b(EntitySpider var1, int var2, int var3, int var4, int var5) {
	}

	public void a(EntitySpider var1, int var2, int var3, int var4, int var5) {
	}

	public int a() {
		return 10;
	}

	public void e(EntitySpider var1, int var2, int var3, int var4) {
	}

	public void b(EntitySpider var1, int var2, int var3, int var4) {
	}

	public int a(Random var1) {
		return 1;
	}

	public int a(int var1, Random var2) {
		return this.ba;
	}

	public float a(BlockMobSpawner var1) {
		return this.bb < 0.0F?0.0F:(!var1.b(this)?1.0F / this.bb / 100.0F:var1.a(this) / this.bb / 30.0F);
	}

	public void b_(EntitySpider var1, int var2, int var3, int var4, int var5) {
		this.a(var1, var2, var3, var4, var5, 1.0F);
	}

	public void a(EntitySpider var1, int var2, int var3, int var4, int var5, float var6) {
		if(!var1.v) {
			int var7 = this.a(var1.m);

			for(int var8 = 0; var8 < var7; ++var8) {
				if(var1.m.nextFloat() <= var6) {
					int var9 = this.a(var5, var1.m);
					if(var9 > 0) {
						EffectRenderer var11 = new EffectRenderer(var1, (double)var2 + (double)(var1.m.nextFloat() * 0.7F) + (double)0.15F, (double)var3 + (double)(var1.m.nextFloat() * 0.7F) + (double)0.15F, (double)var4 + (double)(var1.m.nextFloat() * 0.7F) + (double)0.15F, new TileEntityFurnace(var9));
						var11.c = 10;
						var1.a((EntityMinecart)var11);
					}
				}
			}

		}
	}

	public float a(EntityMinecart var1) {
		return this.bc / 5.0F;
	}

	public lv a(EntitySpider var1, int var2, int var3, int var4, BlockTNT var5, BlockTNT var6) {
		this.a((mz)var1, var2, var3, var4);
		var5 = var5.c((double)(-var2), (double)(-var3), (double)(-var4));
		var6 = var6.c((double)(-var2), (double)(-var3), (double)(-var4));
		BlockTNT var7 = var5.a(var6, this.bd);
		BlockTNT var8 = var5.a(var6, this.bg);
		BlockTNT var9 = var5.b(var6, this.be);
		BlockTNT var10 = var5.b(var6, this.bh);
		BlockTNT var11 = var5.c(var6, this.bf);
		BlockTNT var12 = var5.c(var6, this.bi);
		if(!this.a(var7)) {
			var7 = null;
		}

		if(!this.a(var8)) {
			var8 = null;
		}

		if(!this.b(var9)) {
			var9 = null;
		}

		if(!this.b(var10)) {
			var10 = null;
		}

		if(!this.c(var11)) {
			var11 = null;
		}

		if(!this.c(var12)) {
			var12 = null;
		}

		BlockTNT var13 = null;
		if(var7 != null && (var13 == null || var5.c(var7) < var5.c(var13))) {
			var13 = var7;
		}

		if(var8 != null && (var13 == null || var5.c(var8) < var5.c(var13))) {
			var13 = var8;
		}

		if(var9 != null && (var13 == null || var5.c(var9) < var5.c(var13))) {
			var13 = var9;
		}

		if(var10 != null && (var13 == null || var5.c(var10) < var5.c(var13))) {
			var13 = var10;
		}

		if(var11 != null && (var13 == null || var5.c(var11) < var5.c(var13))) {
			var13 = var11;
		}

		if(var12 != null && (var13 == null || var5.c(var12) < var5.c(var13))) {
			var13 = var12;
		}

		if(var13 == null) {
			return null;
		} else {
			byte var14 = -1;
			if(var13 == var7) {
				var14 = 4;
			}

			if(var13 == var8) {
				var14 = 5;
			}

			if(var13 == var9) {
				var14 = 0;
			}

			if(var13 == var10) {
				var14 = 1;
			}

			if(var13 == var11) {
				var14 = 2;
			}

			if(var13 == var12) {
				var14 = 3;
			}

			return new lv(var2, var3, var4, var14, var13.c((double)var2, (double)var3, (double)var4));
		}
	}

	private boolean a(BlockTNT var1) {
		return var1 != null && var1.b >= this.be && var1.b <= this.bh && var1.c >= this.bf && var1.c <= this.bi;
	}

	private boolean b(BlockTNT var1) {
		return var1 != null && var1.a >= this.bd && var1.a <= this.bg && var1.c >= this.bf && var1.c <= this.bi;
	}

	private boolean c(BlockTNT var1) {
		return var1 != null && var1.a >= this.bd && var1.a <= this.bg && var1.b >= this.be && var1.b <= this.bh;
	}

	public void c(EntitySpider var1, int var2, int var3, int var4) {
	}

	public int g() {
		return 0;
	}

	public boolean a(EntitySpider var1, int var2, int var3, int var4) {
		int var5 = var1.a(var2, var3, var4);
		return var5 == 0 || n[var5].bl.d();
	}

	public boolean a(EntitySpider var1, int var2, int var3, int var4, BlockMobSpawner var5) {
		return false;
	}

	public void a(EntitySpider var1, int var2, int var3, int var4, EntityMinecart var5) {
	}

	public void d(EntitySpider var1, int var2, int var3, int var4, int var5) {
	}

	public void b(EntitySpider var1, int var2, int var3, int var4, BlockMobSpawner var5) {
	}

	public void a(EntitySpider var1, int var2, int var3, int var4, EntityMinecart var5, BlockTNT var6) {
	}

	public void a(mz var1, int var2, int var3, int var4) {
	}

	public int d(mz var1, int var2, int var3, int var4) {
		return 0xFFFFFF;
	}

	public boolean b(mz var1, int var2, int var3, int var4, int var5) {
		return false;
	}

	public boolean d() {
		return false;
	}

	public void b(EntitySpider var1, int var2, int var3, int var4, EntityMinecart var5) {
	}

	public boolean c(EntitySpider var1, int var2, int var3, int var4, int var5) {
		return false;
	}

	public void e() {
	}

	public void a_(EntitySpider var1, int var2, int var3, int var4, int var5) {
		this.b_(var1, var2, var3, var4, var5);
	}

	public boolean g(EntitySpider var1, int var2, int var3, int var4) {
		return true;
	}

	static {
		for(int var0 = 0; var0 < 256; ++var0) {
			if(n[var0] != null) {
				EntityTNTPrimed.c[var0] = new TextureWaterFlowFX(var0 - 256);
			}
		}

	}
}
