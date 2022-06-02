package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class Render extends ItemBow {
	private EntityDiggingFX f = (EntityDiggingFX)this.d;
	private EntityDiggingFX g = new EntityDiggingFX(1.0F);
	private EntityDiggingFX h = new EntityDiggingFX(0.5F);
	private static final String[] i = new String[]{"cloth", "chain", "iron", "diamond", "gold"};

	public Render() {
		super(new EntityDiggingFX(0.0F), 0.5F);
	}

	protected boolean a(BlockMobSpawner var1, int var2) {
		TileEntityFurnace var3 = var1.b.d(3 - var2);
		if(var3 != null) {
			EntityTNTPrimed var4 = var3.a();
			if(var4 instanceof mf) {
				mf var5 = (mf)var4;
				this.a("/armor/" + i[var5.aX] + "_" + (var2 == 2?2:1) + ".png");
				EntityDiggingFX var6 = var2 == 2?this.h:this.g;
				var6.a.h = var2 == 0;
				var6.b.h = var2 == 0;
				var6.c.h = var2 == 1 || var2 == 2;
				var6.d.h = var2 == 1;
				var6.e.h = var2 == 1;
				var6.f.h = var2 == 2 || var2 == 3;
				var6.g.h = var2 == 2 || var2 == 3;
				this.a(var6);
				return true;
			}
		}

		return false;
	}

	public void a(BlockMobSpawner var1, double var2, double var4, double var6, float var8, float var9) {
		TileEntityFurnace var10 = var1.b.e();
		EntityDiggingFX var11 = (EntityDiggingFX)this.d;
		var11.i = var10 != null;
		super.a((RecipesIngots)var1, var2, var4 - (double)var1.ay, var6, var8, var9);
		var11.i = false;
		BlockDoor var12 = this.a();
		float var13 = 1.6F;
		float var14 = 0.016666668F * var13;
		GL11.glPushMatrix();
		GL11.glTranslatef((float)var2 + 0.0F, (float)var4 + 2.3F, (float)var6);
		GL11.glNormal3f(0.0F, 1.0F, 0.0F);
		GL11.glRotatef(-this.a.i, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(this.a.j, 1.0F, 0.0F, 0.0F);
		float var15 = var1.d(this.a.h);
		var14 = (float)((double)var14 * (Math.sqrt((double)var15) / 2.0D));
		GL11.glScalef(-var14, -var14, var14);
		String var16 = var1.i;
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDepthMask(false);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		NBTTagByteArray var17 = NBTTagByteArray.a;
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		var17.b();
		int var18 = var12.a(var16) / 2;
		var17.a(0.0F, 0.0F, 0.0F, 0.25F);
		var17.a((double)(-var18 - 1), -1.0D, 0.0D);
		var17.a((double)(-var18 - 1), 8.0D, 0.0D);
		var17.a((double)(var18 + 1), 8.0D, 0.0D);
		var17.a((double)(var18 + 1), -1.0D, 0.0D);
		var17.a();
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		var12.b(var16, -var12.a(var16) / 2, 0, 553648127);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glDepthMask(true);
		var12.b(var16, -var12.a(var16) / 2, 0, -1);
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glPopMatrix();
	}

	protected void a(BlockMobSpawner var1, float var2) {
		TileEntityFurnace var3 = var1.b.e();
		if(var3 != null) {
			GL11.glPushMatrix();
			this.f.d.b(0.0625F);
			GL11.glTranslatef(-0.0625F, 0.4375F, 0.0625F);
			float var4;
			if(var3.c < 256 && GuiCrafting.a(ln.n[var3.c].f())) {
				var4 = 0.5F;
				GL11.glTranslatef(0.0F, 0.1875F, -0.3125F);
				var4 *= 0.75F;
				GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
				GL11.glScalef(var4, -var4, var4);
			} else if(EntityTNTPrimed.c[var3.c].a()) {
				var4 = 0.625F;
				GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
				GL11.glScalef(var4, -var4, var4);
				GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
			} else {
				var4 = 0.375F;
				GL11.glTranslatef(0.25F, 0.1875F, -0.1875F);
				GL11.glScalef(var4, var4, var4);
				GL11.glRotatef(60.0F, 0.0F, 0.0F, 1.0F);
				GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(20.0F, 0.0F, 0.0F, 1.0F);
			}

			this.a.f.a(var3);
			GL11.glPopMatrix();
		}

	}

	protected void b(BlockMobSpawner var1, float var2) {
		float var3 = 0.9375F;
		GL11.glScalef(var3, var3, var3);
	}

	public void b() {
		this.f.j = 0.0F;
		this.f.setBlockBounds(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		this.f.d.a(0.0625F);
	}

	protected void a(RecipesIngots var1, float var2) {
		this.b((BlockMobSpawner)var1, var2);
	}

	protected boolean a(RecipesIngots var1, int var2) {
		return this.a((BlockMobSpawner)var1, var2);
	}

	protected void b(RecipesIngots var1, float var2) {
		this.a((BlockMobSpawner)var1, var2);
	}

	public void a(RecipesIngots var1, double var2, double var4, double var6, float var8, float var9) {
		this.a((BlockMobSpawner)var1, var2, var4, var6, var8, var9);
	}

	public void a(EntityMinecart var1, double var2, double var4, double var6, float var8, float var9) {
		this.a((BlockMobSpawner)var1, var2, var4, var6, var8, var9);
	}
}
