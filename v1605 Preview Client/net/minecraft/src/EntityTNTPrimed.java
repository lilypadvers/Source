package net.minecraft.src;

import java.util.Random;

public class EntityTNTPrimed {
	protected static Random b = new Random();
	public static EntityTNTPrimed[] c = new EntityTNTPrimed[32000];
	public static EntityTNTPrimed d = (new mg(0, 2)).a(82);
	public static EntityTNTPrimed e = (new ClippingHelperImplementation(1, 2)).a(98);
	public static EntityTNTPrimed f = (new EntityLiving(2, 2)).a(114);
	public static EntityTNTPrimed g = (new nk(3)).a(5);
	public static EntityTNTPrimed h = (new nv(4, 4)).a(10);
	public static EntityTNTPrimed i = (new ThreadSleepForever(5)).a(21);
	public static EntityTNTPrimed j = (new EntityTNTPrimed(6)).a(37);
	public static EntityTNTPrimed k = (new EntityTNTPrimed(7)).a(7);
	public static EntityTNTPrimed l = (new EntityTNTPrimed(8)).a(55);
	public static EntityTNTPrimed m = (new EntityTNTPrimed(9)).a(23);
	public static EntityTNTPrimed n = (new EntityTNTPrimed(10)).a(39);
	public static EntityTNTPrimed o = (new EnumOSIsom(11, 2)).a(66);
	public static EntityTNTPrimed p = (new EnumOSIsom(12, 0)).a(64);
	public static EntityTNTPrimed q = (new mg(13, 0)).a(80);
	public static EntityTNTPrimed r = (new ClippingHelperImplementation(14, 0)).a(96);
	public static EntityTNTPrimed s = (new EntityLiving(15, 0)).a(112);
	public static EntityTNTPrimed t = (new EnumOSIsom(16, 1)).a(65);
	public static EntityTNTPrimed u = (new mg(17, 1)).a(81);
	public static EntityTNTPrimed v = (new ClippingHelperImplementation(18, 1)).a(97);
	public static EntityTNTPrimed w = (new EntityLiving(19, 1)).a(113);
	public static EntityTNTPrimed x = (new EnumOSIsom(20, 3)).a(67);
	public static EntityTNTPrimed y = (new mg(21, 3)).a(83);
	public static EntityTNTPrimed z = (new ClippingHelperImplementation(22, 3)).a(99);
	public static EntityTNTPrimed A = (new EntityLiving(23, 3)).a(115);
	public static EntityTNTPrimed B = (new EntityTNTPrimed(24)).a(53).d();
	public static EntityTNTPrimed C = (new EntityTNTPrimed(25)).a(71);
	public static EntityTNTPrimed D = (new RecipesFood(26, 10)).a(72);
	public static EntityTNTPrimed E = (new EnumOSIsom(27, 0)).a(68);
	public static EntityTNTPrimed F = (new mg(28, 0)).a(84);
	public static EntityTNTPrimed G = (new ClippingHelperImplementation(29, 0)).a(100);
	public static EntityTNTPrimed H = (new EntityLiving(30, 0)).a(116);
	public static EntityTNTPrimed I = (new EntityTNTPrimed(31)).a(8);
	public static EntityTNTPrimed J = (new EntityTNTPrimed(32)).a(24);
	public static EntityTNTPrimed K = (new EntityTNTPrimed(33)).a(40);
	public static EntityTNTPrimed L = (new BlockWorkbench(34, 0)).a(128);
	public static EntityTNTPrimed M = (new BlockWorkbench(35, 1)).a(129);
	public static EntityTNTPrimed N = (new BlockWorkbench(36, 2)).a(130);
	public static EntityTNTPrimed O = (new BlockWorkbench(37, 3)).a(131);
	public static EntityTNTPrimed P = (new BlockWorkbench(38, 4)).a(132);
	public static EntityTNTPrimed Q = (new OSMap(39, ln.az.ba)).a(9);
	public static EntityTNTPrimed R = (new EntityTNTPrimed(40)).a(25);
	public static EntityTNTPrimed S = (new nv(41, 5)).a(41);
	public static EntityTNTPrimed T = (new mf(42, 0, 0, 0)).a(0);
	public static EntityTNTPrimed U = (new mf(43, 0, 0, 1)).a(16);
	public static EntityTNTPrimed V = (new mf(44, 0, 0, 2)).a(32);
	public static EntityTNTPrimed W = (new mf(45, 0, 0, 3)).a(48);
	public static EntityTNTPrimed X = (new mf(46, 1, 1, 0)).a(1);
	public static EntityTNTPrimed Y = (new mf(47, 1, 1, 1)).a(17);
	public static EntityTNTPrimed Z = (new mf(48, 1, 1, 2)).a(33);
	public static EntityTNTPrimed aa = (new mf(49, 1, 1, 3)).a(49);
	public static EntityTNTPrimed ab = (new mf(50, 2, 2, 0)).a(2);
	public static EntityTNTPrimed ac = (new mf(51, 2, 2, 1)).a(18);
	public static EntityTNTPrimed ad = (new mf(52, 2, 2, 2)).a(34);
	public static EntityTNTPrimed ae = (new mf(53, 2, 2, 3)).a(50);
	public static EntityTNTPrimed af = (new mf(54, 3, 3, 0)).a(3);
	public static EntityTNTPrimed ag = (new mf(55, 3, 3, 1)).a(19);
	public static EntityTNTPrimed ah = (new mf(56, 3, 3, 2)).a(35);
	public static EntityTNTPrimed ai = (new mf(57, 3, 3, 3)).a(51);
	public static EntityTNTPrimed aj = (new mf(58, 1, 4, 0)).a(4);
	public static EntityTNTPrimed ak = (new mf(59, 1, 4, 1)).a(20);
	public static EntityTNTPrimed al = (new mf(60, 1, 4, 2)).a(36);
	public static EntityTNTPrimed am = (new mf(61, 1, 4, 3)).a(52);
	public static EntityTNTPrimed an = (new EntityTNTPrimed(62)).a(6);
	public static EntityTNTPrimed ao = (new nv(63, 3)).a(87);
	public static EntityTNTPrimed ap = (new nv(64, 8)).a(88);
	public static EntityTNTPrimed aq = (new np(65)).a(26);
	public static EntityTNTPrimed ar = (new nv(66, 42)).a(11);
	public static EntityTNTPrimed as = (new lt(67)).a(42);
	public static EntityTNTPrimed at = (new ClippingHelper(68, EntitySkeleton.c)).a(43);
	public static EntityTNTPrimed au = (new SpawnerMonsters(69, 0)).a(74);
	public static EntityTNTPrimed av = (new SpawnerMonsters(70, ln.A.ba)).a(75);
	public static EntityTNTPrimed aw = (new SpawnerMonsters(71, ln.C.ba)).a(76);
	public static EntityTNTPrimed ax = (new RedstoneUpdateInfo(72, 0)).a(135);
	public static EntityTNTPrimed ay = (new GuiEditSign(73)).a(104);
	public static EntityTNTPrimed az = (new ClippingHelper(74, EntitySkeleton.e)).a(44);
	public static EntityTNTPrimed aA = (new RenderPlayer(75)).a(56);
	public static EntityTNTPrimed aB = (new GuiIngameMenu(76)).a(14);
	public static EntityTNTPrimed aC = (new lu(77)).a(136);
	public static EntityTNTPrimed aD = (new EntityTNTPrimed(78)).a(103);
	public static EntityTNTPrimed aE = (new EntityTNTPrimed(79)).a(77);
	public static EntityTNTPrimed aF = (new EntityTNTPrimed(80)).a(22);
	public static EntityTNTPrimed aG = (new EntityTNTPrimed(81)).a(57);
	public static EntityTNTPrimed aH = (new CanvasMojangLogo(82, ln.aX)).a(27);
	public static EntityTNTPrimed aI = (new EntityTNTPrimed(83)).a(58);
	public static EntityTNTPrimed aJ = (new EntityTNTPrimed(84)).a(59);
	public static EntityTNTPrimed aK = (new EntityTNTPrimed(85)).a(30);
	public static EntityTNTPrimed aL = (new RedstoneUpdateInfo(86, 1)).a(151);
	public static EntityTNTPrimed aM = (new RedstoneUpdateInfo(87, 2)).a(167);
	public static EntityTNTPrimed aN = (new EntityTNTPrimed(88)).a(12);
	public static EntityTNTPrimed aO = (new kv(2000, "hidden_den")).a(240);
	public static EntityTNTPrimed aP = (new kv(2001, "lemuria")).a(241);
	public final int aQ;
	protected int aR = 64;
	protected int aS = 32;
	protected int aT;
	protected boolean aU = false;

	protected EntityTNTPrimed(int var1) {
		this.aQ = 256 + var1;
		if(c[256 + var1] != null) {
			System.out.println("CONFLICT @ " + var1);
		}

		c[256 + var1] = this;
	}

	public EntityTNTPrimed a(int var1) {
		this.aT = var1;
		return this;
	}

	public int a(TileEntityFurnace var1) {
		return this.aT;
	}

	public boolean a(TileEntityFurnace var1, BlockMobSpawner var2, EntitySpider var3, int var4, int var5, int var6, int var7) {
		return false;
	}

	public float a(TileEntityFurnace var1, ln var2) {
		return 1.0F;
	}

	public TileEntityFurnace a(TileEntityFurnace var1, EntitySpider var2, BlockMobSpawner var3) {
		return var1;
	}

	public int b() {
		return this.aR;
	}

	public int c() {
		return this.aS;
	}

	public void a(TileEntityFurnace var1, RecipesIngots var2) {
	}

	public void a(TileEntityFurnace var1, int var2, int var3, int var4, int var5) {
	}

	public int a(EntityMinecart var1) {
		return 1;
	}

	public boolean a(ln var1) {
		return false;
	}

	public void b(TileEntityFurnace var1, RecipesIngots var2) {
	}

	public EntityTNTPrimed d() {
		this.aU = true;
		return this;
	}

	public boolean a() {
		return this.aU;
	}
}
