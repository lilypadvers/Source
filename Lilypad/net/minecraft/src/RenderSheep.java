package net.minecraft.src;

public class RenderSheep extends EntityPlayer {
	private int bg;
	private double bh;
	private double bi;
	private double bj;
	private double bk;
	private double bl;
	float a = 0.0F;

	public RenderSheep(World var1, String var2) {
		super(var1);
		this.username = var2;
		this.yOffset = 0.0F;
		this.stepHeight = 0.0F;
		if(var2 != null && var2.length() > 0) {
			boolean var3 = System.getProperty("os.name").toLowerCase().indexOf("windows") == -1;
			this.skinUrl = "file:///" + (var3?".":"C:") + "/skincache/" + var2 + ".png";
			System.out.println("Loading texture " + this.skinUrl);
		}

		this.noClip = true;
		this.renderDistanceWeight = 10.0D;
	}

	public boolean attackEntityFrom(Entity entity, int damage) {
		return true;
	}

	public void setPositionAndRotation(double x, double y, double z, float rotationYaw, float rotationPitch, int newPosRotationIncrements) {
		this.yOffset = 0.0F;
		this.bh = x;
		this.bi = y;
		this.bj = z;
		this.bk = (double)rotationYaw;
		this.bl = (double)rotationPitch;
		this.bg = newPosRotationIncrements;
	}

	public void onUpdate() {
		super.onUpdate();
		this.prevLimbYaw = this.limbYaw;
		double var1 = this.posX - this.prevPosX;
		double var3 = this.posZ - this.prevPosZ;
		float var5 = MathHelper.sqrt_double(var1 * var1 + var3 * var3) * 4.0F;
		if(var5 > 1.0F) {
			var5 = 1.0F;
		}

		this.limbYaw += (var5 - this.limbYaw) * 0.4F;
		this.limbSwing += this.limbYaw;
	}

	public float getShadowSize() {
		return 0.0F;
	}

	public void onLivingUpdate() {
		super.updateEntityActionState();
		if(this.bg > 0) {
			double var1 = this.posX + (this.bh - this.posX) / (double)this.bg;
			double var3 = this.posY + (this.bi - this.posY) / (double)this.bg;
			double var5 = this.posZ + (this.bj - this.posZ) / (double)this.bg;

			double var7;
			for(var7 = this.bk - (double)this.rotationYaw; var7 < -180.0D; var7 += 360.0D) {
			}

			while(var7 >= 180.0D) {
				var7 -= 360.0D;
			}

			this.rotationYaw += (float)(var7 / (double)this.bg);
			this.rotationPitch += (float)((this.bl - (double)this.rotationPitch) / (double)this.bg);
			--this.bg;
			this.setPosition(var1, var3, var5);
			this.setRotation(this.rotationYaw, this.rotationPitch);
		}

		this.prevCameraYaw = this.cameraYaw;
		float var9 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
		float var2 = (float)Math.atan(-this.motionY * (double)0.2F) * 15.0F;
		if(var9 > 0.1F) {
			var9 = 0.1F;
		}

		if(!this.onGround || this.health <= 0) {
			var9 = 0.0F;
		}

		if(this.onGround || this.health <= 0) {
			var2 = 0.0F;
		}

		this.cameraYaw += (var9 - this.cameraYaw) * 0.4F;
		this.cameraPitch += (var2 - this.cameraPitch) * 0.8F;
	}
}
