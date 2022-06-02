package net.minecraft.src;

public class BlockFlower extends MovingObjectPosition {
	public BlockFlower(net.minecraft.client.Minecraft var1) {
		super(var1);
		this.b = true;
	}

	public void calculateConnectedTracks() {
	}

	public void b(BlockMobSpawner var1) {
		for(int var2 = 0; var2 < 9; ++var2) {
			if(var1.b.a[var2] == null) {
				this.a.g.b.a[var2] = new TileEntityFurnace(((ln)EntityPlayerSP.a.get(var2)).ba);
			} else {
				this.a.g.b.a[var2].a = 1;
			}
		}

	}

	public boolean e() {
		return false;
	}

	public void a(EntitySpider var1) {
		super.a(var1);
	}

	public void d() {
	}
}
