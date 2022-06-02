package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class EntityItem extends EnumSkyBlock {
	private Map a = new HashMap();

	void a(DataOutput var1) {
		Iterator var2 = this.a.values().iterator();

		while(var2.hasNext()) {
			EnumSkyBlock var3 = (EnumSkyBlock)var2.next();
			EnumSkyBlock.a(var3, var1);
		}

		var1.writeByte(0);
	}

	void a(DataInput var1) {
		this.a.clear();

		EnumSkyBlock var2;
		while((var2 = EnumSkyBlock.b(var1)).a() != 0) {
			this.a.put(var2.b(), var2);
		}

	}

	public byte a() {
		return (byte)10;
	}

	public void a(String var1, EnumSkyBlock var2) {
		this.a.put(var1, var2.a(var1));
	}

	public void a(String var1, byte var2) {
		this.a.put(var1, (new BlockGrass(var2)).a((String)var1));
	}

	public void a(String var1, short var2) {
		this.a.put(var1, (new lh(var2)).a((String)var1));
	}

	public void a(String var1, int var2) {
		this.a.put(var1, (new EntityList(var2)).a((String)var1));
	}

	public void a(String var1, long var2) {
		this.a.put(var1, (new GuiInventory(var2)).a((String)var1));
	}

	public void a(String var1, float var2) {
		this.a.put(var1, (new RenderPig(var2)).a((String)var1));
	}

	public void a(String var1, double var2) {
		this.a.put(var1, (new MovementInputFromOptions(var2)).a((String)var1));
	}

	public void a(String var1, String var2) {
		this.a.put(var1, (new mr(var2)).a((String)var1));
	}

	public void a(String var1, byte[] var2) {
		this.a.put(var1, (new BlockFluid(var2)).a((String)var1));
	}

	public void a(String var1, EntityItem var2) {
		this.a.put(var1, var2.a((String)var1));
	}

	public void a(String var1, boolean var2) {
		this.a(var1, (byte)(var2?1:0));
	}

	public boolean b(String var1) {
		return this.a.containsKey(var1);
	}

	public byte c(String var1) {
		return !this.a.containsKey(var1)?0:((BlockGrass)this.a.get(var1)).a;
	}

	public short d(String var1) {
		return !this.a.containsKey(var1)?0:((lh)this.a.get(var1)).a;
	}

	public int e(String var1) {
		return !this.a.containsKey(var1)?0:((EntityList)this.a.get(var1)).a;
	}

	public long f(String var1) {
		return !this.a.containsKey(var1)?0L:((GuiInventory)this.a.get(var1)).a;
	}

	public float g(String var1) {
		return !this.a.containsKey(var1)?0.0F:((RenderPig)this.a.get(var1)).a;
	}

	public double h(String var1) {
		return !this.a.containsKey(var1)?0.0D:((MovementInputFromOptions)this.a.get(var1)).a;
	}

	public String i(String var1) {
		return !this.a.containsKey(var1)?"":((mr)this.a.get(var1)).a;
	}

	public byte[] j(String var1) {
		return !this.a.containsKey(var1)?new byte[0]:((BlockFluid)this.a.get(var1)).a;
	}

	public EntityItem k(String var1) {
		return !this.a.containsKey(var1)?new EntityItem():(EntityItem)this.a.get(var1);
	}

	public ItemPainting l(String var1) {
		return !this.a.containsKey(var1)?new ItemPainting():(ItemPainting)this.a.get(var1);
	}

	public boolean m(String var1) {
		return this.c(var1) != 0;
	}

	public String toString() {
		return "" + this.a.size() + " entries";
	}
}
