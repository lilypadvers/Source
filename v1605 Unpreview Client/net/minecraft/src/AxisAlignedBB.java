package net.minecraft.src;

public abstract class AxisAlignedBB {
	protected ThreadDownloadImage a;

	public abstract void a(EntityCreature var1, double var2, double var4, double var6, float var8);

	protected void a(String var1) {
		BlockRedstoneWire var2 = this.a.e;
		var2.b(var2.a(var1));
	}

	public void a(ThreadDownloadImage var1) {
		this.a = var1;
	}

	public BlockDoor a() {
		return this.a.a();
	}
}
