package net.minecraft.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lp implements BlockButton {
	private BlockMushroom a;
	private Map b = new HashMap();
	private List c = new ArrayList();
	private EntitySpider d;

	public lp(EntitySpider var1) {
		this.a = new BlockMushroom(var1, new byte['\u8000'], 0, 0);
		this.a.q = true;
		this.a.p = true;
		this.d = var1;
	}

	public boolean a(int var1, int var2) {
		RenderLiving var3 = new RenderLiving(var1, var2);
		return this.b.containsKey(var3);
	}

	public void c(int var1, int var2) {
		BlockMushroom var3 = this.b(var1, var2);
		if(!var3.q) {
			var3.e();
		}

		this.b.remove(new RenderLiving(var1, var2));
		this.c.remove(var3);
	}

	public BlockMushroom d(int var1, int var2) {
		RenderLiving var3 = new RenderLiving(var1, var2);
		byte[] var4 = new byte['\u8000'];
		BlockMushroom var5 = new BlockMushroom(this.d, var4, var1, var2);
		Arrays.fill(var5.f.a, (byte)-1);
		this.b.put(var3, var5);
		var5.c = true;
		return var5;
	}

	public BlockMushroom b(int var1, int var2) {
		RenderLiving var3 = new RenderLiving(var1, var2);
		BlockMushroom var4 = (BlockMushroom)this.b.get(var3);
		return var4 == null?this.a:var4;
	}

	public boolean a(boolean var1, nh var2) {
		return true;
	}

	public boolean a() {
		return false;
	}

	public boolean b() {
		return false;
	}

	public void a(BlockButton var1, int var2, int var3) {
	}
}
