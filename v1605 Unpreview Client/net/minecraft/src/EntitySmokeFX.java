package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class EntitySmokeFX {
	private net.minecraft.client.Minecraft a;
	private TileEntityFurnace b = null;
	private float c = 0.0F;
	private float d = 0.0F;
	private GuiCrafting e = new GuiCrafting();

	public EntitySmokeFX(net.minecraft.client.Minecraft var1) {
		this.a = var1;
	}

	public void a(TileEntityFurnace var1) {
		GL11.glPushMatrix();
		if(var1.c < 256 && GuiCrafting.a(ln.n[var1.c].f())) {
			GL11.glBindTexture(GL11.GL_TEXTURE_2D, this.a.n.a("/terrain.png"));
			this.e.a(ln.n[var1.c]);
		} else {
			if(var1.c < 256) {
				GL11.glBindTexture(GL11.GL_TEXTURE_2D, this.a.n.a("/terrain.png"));
			} else {
				GL11.glBindTexture(GL11.GL_TEXTURE_2D, this.a.n.a("/gui/items.png"));
			}

			NBTTagByteArray var2 = NBTTagByteArray.a;
			float var3 = (float)(var1.b() % 16 * 16 + 0) / 256.0F;
			float var4 = (float)(var1.b() % 16 * 16 + 16) / 256.0F;
			float var5 = (float)(var1.b() / 16 * 16 + 0) / 256.0F;
			float var6 = (float)(var1.b() / 16 * 16 + 16) / 256.0F;
			float var7 = 1.0F;
			float var8 = 0.0F;
			float var9 = 0.3F;
			GL11.glEnable('\u803a');
			GL11.glTranslatef(-var8, -var9, 0.0F);
			float var10 = 1.5F;
			GL11.glScalef(var10, var10, var10);
			GL11.glRotatef(50.0F, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(335.0F, 0.0F, 0.0F, 1.0F);
			GL11.glTranslatef(-0.9375F, -0.0625F, 0.0F);
			float var11 = 0.0625F;
			var2.b();
			var2.b(0.0F, 0.0F, 1.0F);
			var2.a(0.0D, 0.0D, 0.0D, (double)var4, (double)var6);
			var2.a((double)var7, 0.0D, 0.0D, (double)var3, (double)var6);
			var2.a((double)var7, 1.0D, 0.0D, (double)var3, (double)var5);
			var2.a(0.0D, 1.0D, 0.0D, (double)var4, (double)var5);
			var2.a();
			var2.b();
			var2.b(0.0F, 0.0F, -1.0F);
			var2.a(0.0D, 1.0D, (double)(0.0F - var11), (double)var4, (double)var5);
			var2.a((double)var7, 1.0D, (double)(0.0F - var11), (double)var3, (double)var5);
			var2.a((double)var7, 0.0D, (double)(0.0F - var11), (double)var3, (double)var6);
			var2.a(0.0D, 0.0D, (double)(0.0F - var11), (double)var4, (double)var6);
			var2.a();
			var2.b();
			var2.b(-1.0F, 0.0F, 0.0F);

			int var12;
			float var13;
			float var14;
			float var15;
			for(var12 = 0; var12 < 16; ++var12) {
				var13 = (float)var12 / 16.0F;
				var14 = var4 + (var3 - var4) * var13 - 0.001953125F;
				var15 = var7 * var13;
				var2.a((double)var15, 0.0D, (double)(0.0F - var11), (double)var14, (double)var6);
				var2.a((double)var15, 0.0D, 0.0D, (double)var14, (double)var6);
				var2.a((double)var15, 1.0D, 0.0D, (double)var14, (double)var5);
				var2.a((double)var15, 1.0D, (double)(0.0F - var11), (double)var14, (double)var5);
			}

			var2.a();
			var2.b();
			var2.b(1.0F, 0.0F, 0.0F);

			for(var12 = 0; var12 < 16; ++var12) {
				var13 = (float)var12 / 16.0F;
				var14 = var4 + (var3 - var4) * var13 - 0.001953125F;
				var15 = var7 * var13 + 0.0625F;
				var2.a((double)var15, 1.0D, (double)(0.0F - var11), (double)var14, (double)var5);
				var2.a((double)var15, 1.0D, 0.0D, (double)var14, (double)var5);
				var2.a((double)var15, 0.0D, 0.0D, (double)var14, (double)var6);
				var2.a((double)var15, 0.0D, (double)(0.0F - var11), (double)var14, (double)var6);
			}

			var2.a();
			var2.b();
			var2.b(0.0F, 1.0F, 0.0F);

			for(var12 = 0; var12 < 16; ++var12) {
				var13 = (float)var12 / 16.0F;
				var14 = var6 + (var5 - var6) * var13 - 0.001953125F;
				var15 = var7 * var13 + 0.0625F;
				var2.a(0.0D, (double)var15, 0.0D, (double)var4, (double)var14);
				var2.a((double)var7, (double)var15, 0.0D, (double)var3, (double)var14);
				var2.a((double)var7, (double)var15, (double)(0.0F - var11), (double)var3, (double)var14);
				var2.a(0.0D, (double)var15, (double)(0.0F - var11), (double)var4, (double)var14);
			}

			var2.a();
			var2.b();
			var2.b(0.0F, -1.0F, 0.0F);

			for(var12 = 0; var12 < 16; ++var12) {
				var13 = (float)var12 / 16.0F;
				var14 = var6 + (var5 - var6) * var13 - 0.001953125F;
				var15 = var7 * var13;
				var2.a((double)var7, (double)var15, 0.0D, (double)var3, (double)var14);
				var2.a(0.0D, (double)var15, 0.0D, (double)var4, (double)var14);
				var2.a(0.0D, (double)var15, (double)(0.0F - var11), (double)var4, (double)var14);
				var2.a((double)var7, (double)var15, (double)(0.0F - var11), (double)var3, (double)var14);
			}

			var2.a();
			GL11.glDisable('\u803a');
		}

		GL11.glPopMatrix();
	}

	public void a(float var1) {
		float var2 = this.d + (this.c - this.d) * var1;
		GuiDeleteWorld var3 = this.a.g;
		GL11.glPushMatrix();
		GL11.glRotatef(var3.aq + (var3.ao - var3.aq) * var1, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(var3.ap + (var3.an - var3.ap) * var1, 0.0F, 1.0F, 0.0F);
		BlockOre.b();
		GL11.glPopMatrix();
		float var4 = this.a.e.c(ModelPig.b(var3.ah), ModelPig.b(var3.ai), ModelPig.b(var3.aj));
		GL11.glColor4f(var4, var4, var4, 1.0F);
		float var5;
		float var6;
		float var7;
		float var8;
		if(this.b != null) {
			GL11.glPushMatrix();
			var5 = 0.8F;
			var6 = var3.d(var1);
			var7 = ModelPig.a(var6 * (float)Math.PI);
			var8 = ModelPig.a(ModelPig.c(var6) * (float)Math.PI);
			GL11.glTranslatef(-var8 * 0.4F, ModelPig.a(ModelPig.c(var6) * (float)Math.PI * 2.0F) * 0.2F, -var7 * 0.2F);
			GL11.glTranslatef(0.7F * var5, -0.65F * var5 - (1.0F - var2) * 0.6F, -0.9F * var5);
			GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
			GL11.glEnable('\u803a');
			var6 = var3.d(var1);
			var7 = ModelPig.a(var6 * var6 * (float)Math.PI);
			var8 = ModelPig.a(ModelPig.c(var6) * (float)Math.PI);
			GL11.glRotatef(-var7 * 20.0F, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(-var8 * 20.0F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(-var8 * 80.0F, 1.0F, 0.0F, 0.0F);
			var6 = 0.4F;
			GL11.glScalef(var6, var6, var6);
			this.a(this.b);
			GL11.glPopMatrix();
		} else {
			GL11.glPushMatrix();
			var5 = 0.8F;
			var6 = var3.d(var1);
			var7 = ModelPig.a(var6 * (float)Math.PI);
			var8 = ModelPig.a(ModelPig.c(var6) * (float)Math.PI);
			GL11.glTranslatef(-var8 * 0.3F, ModelPig.a(ModelPig.c(var6) * (float)Math.PI * 2.0F) * 0.4F, -var7 * 0.4F);
			GL11.glTranslatef(0.8F * var5, -0.75F * var5 - (1.0F - var2) * 0.6F, -0.9F * var5);
			GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
			GL11.glEnable('\u803a');
			var6 = var3.d(var1);
			var7 = ModelPig.a(var6 * var6 * (float)Math.PI);
			var8 = ModelPig.a(ModelPig.c(var6) * (float)Math.PI);
			GL11.glRotatef(var8 * 70.0F, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(-var7 * 20.0F, 0.0F, 0.0F, 1.0F);
			GL11.glBindTexture(GL11.GL_TEXTURE_2D, this.a.n.a(this.a.g.aV, this.a.g.v()));
			GL11.glTranslatef(-1.0F, 3.6F, 3.5F);
			GL11.glRotatef(120.0F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(200.0F, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(-135.0F, 0.0F, 1.0F, 0.0F);
			GL11.glScalef(1.0F, 1.0F, 1.0F);
			GL11.glTranslatef(5.6F, 0.0F, 0.0F);
			TileEntityMobSpawnerRenderer var9 = RenderSpider.a.a((EntityMinecart)this.a.g);
			Render var10 = (Render)var9;
			var8 = 1.0F;
			GL11.glScalef(var8, var8, var8);
			var10.b();
			GL11.glPopMatrix();
		}

		GL11.glDisable('\u803a');
		BlockOre.a();
	}

	public void b(float var1) {
		GL11.glDisable(GL11.GL_ALPHA_TEST);
		int var2;
		if(this.a.g.aQ > 0) {
			var2 = this.a.n.a("/terrain.png");
			GL11.glBindTexture(GL11.GL_TEXTURE_2D, var2);
			this.d(var1);
		}

		if(this.a.g.G()) {
			var2 = ModelPig.b(this.a.g.ah);
			int var3 = ModelPig.b(this.a.g.ai);
			int var4 = ModelPig.b(this.a.g.aj);
			int var5 = this.a.n.a("/terrain.png");
			GL11.glBindTexture(GL11.GL_TEXTURE_2D, var5);
			int var6 = this.a.e.a(var2, var3, var4);
			if(ln.n[var6] != null) {
				this.a(var1, ln.n[var6].getGLCallListForPass(2));
			}
		}

		if(this.a.g.a((EntitySkeleton)EntitySkeleton.f)) {
			var2 = this.a.n.a("/water.png");
			GL11.glBindTexture(GL11.GL_TEXTURE_2D, var2);
			this.c(var1);
		}

		GL11.glEnable(GL11.GL_ALPHA_TEST);
	}

	private void a(float var1, int var2) {
		NBTTagByteArray var3 = NBTTagByteArray.a;
		this.a.g.a(var1);
		float var4 = 0.1F;
		GL11.glColor4f(var4, var4, var4, 0.5F);
		GL11.glPushMatrix();
		float var5 = -1.0F;
		float var6 = 1.0F;
		float var7 = -1.0F;
		float var8 = 1.0F;
		float var9 = -0.5F;
		float var10 = 0.0078125F;
		float var11 = (float)(var2 % 16) / 256.0F - var10;
		float var12 = ((float)(var2 % 16) + 15.99F) / 256.0F + var10;
		float var13 = (float)(var2 / 16) / 256.0F - var10;
		float var14 = ((float)(var2 / 16) + 15.99F) / 256.0F + var10;
		var3.b();
		var3.a((double)var5, (double)var7, (double)var9, (double)var12, (double)var14);
		var3.a((double)var6, (double)var7, (double)var9, (double)var11, (double)var14);
		var3.a((double)var6, (double)var8, (double)var9, (double)var11, (double)var13);
		var3.a((double)var5, (double)var8, (double)var9, (double)var12, (double)var13);
		var3.a();
		GL11.glPopMatrix();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	}

	private void c(float var1) {
		NBTTagByteArray var2 = NBTTagByteArray.a;
		float var3 = this.a.g.a(var1);
		GL11.glColor4f(var3, var3, var3, 0.5F);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glPushMatrix();
		float var4 = 4.0F;
		float var5 = -1.0F;
		float var6 = 1.0F;
		float var7 = -1.0F;
		float var8 = 1.0F;
		float var9 = -0.5F;
		float var10 = -this.a.g.an / 64.0F;
		float var11 = this.a.g.ao / 64.0F;
		var2.b();
		var2.a((double)var5, (double)var7, (double)var9, (double)(var4 + var10), (double)(var4 + var11));
		var2.a((double)var6, (double)var7, (double)var9, (double)(0.0F + var10), (double)(var4 + var11));
		var2.a((double)var6, (double)var8, (double)var9, (double)(0.0F + var10), (double)(0.0F + var11));
		var2.a((double)var5, (double)var8, (double)var9, (double)(var4 + var10), (double)(0.0F + var11));
		var2.a();
		GL11.glPopMatrix();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glDisable(GL11.GL_BLEND);
	}

	private void d(float var1) {
		NBTTagByteArray var2 = NBTTagByteArray.a;
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.9F);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		float var3 = 1.0F;

		for(int var4 = 0; var4 < 2; ++var4) {
			GL11.glPushMatrix();
			int var5 = ln.ar.aZ + var4 * 16;
			int var6 = (var5 & 15) << 4;
			int var7 = var5 & 240;
			float var8 = (float)var6 / 256.0F;
			float var9 = ((float)var6 + 15.99F) / 256.0F;
			float var10 = (float)var7 / 256.0F;
			float var11 = ((float)var7 + 15.99F) / 256.0F;
			float var12 = (0.0F - var3) / 2.0F;
			float var13 = var12 + var3;
			float var14 = 0.0F - var3 / 2.0F;
			float var15 = var14 + var3;
			float var16 = -0.5F;
			GL11.glTranslatef((float)(-(var4 * 2 - 1)) * 0.24F, -0.3F, 0.0F);
			GL11.glRotatef((float)(var4 * 2 - 1) * 10.0F, 0.0F, 1.0F, 0.0F);
			var2.b();
			var2.a((double)var12, (double)var14, (double)var16, (double)var9, (double)var11);
			var2.a((double)var13, (double)var14, (double)var16, (double)var8, (double)var11);
			var2.a((double)var13, (double)var15, (double)var16, (double)var8, (double)var10);
			var2.a((double)var12, (double)var15, (double)var16, (double)var9, (double)var10);
			var2.a();
			GL11.glPopMatrix();
		}

		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glDisable(GL11.GL_BLEND);
	}

	public void a() {
		this.d = this.c;
		GuiDeleteWorld var1 = this.a.g;
		TileEntityFurnace var2 = var1.b.e();
		float var4 = 0.4F;
		float var5 = var2 == this.b?1.0F:0.0F;
		float var6 = var5 - this.c;
		if(var6 < -var4) {
			var6 = -var4;
		}

		if(var6 > var4) {
			var6 = var4;
		}

		this.c += var6;
		if(this.c < 0.1F) {
			this.b = var2;
		}

	}

	public void b() {
		this.c = 0.0F;
	}

	public void c() {
		this.c = 0.0F;
	}
}
