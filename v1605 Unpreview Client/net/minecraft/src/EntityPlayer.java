package net.minecraft.src;

public class EntityPlayer extends EntityMob {
	public EntityPlayer() {
		super(12, 0.0F);
		this.d = new TileEntitySpecialRenderer(0, 0);
		this.d.a(-3.0F, -4.0F, -6.0F, 6, 6, 8, 0.0F);
		this.d.a(0.0F, 6.0F, -8.0F);
		this.e = new TileEntitySpecialRenderer(28, 8);
		this.e.a(-4.0F, -10.0F, -7.0F, 8, 16, 6, 0.0F);
		this.e.a(0.0F, 5.0F, 2.0F);
	}
}
