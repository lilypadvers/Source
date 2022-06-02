package net.minecraft.src;

import java.util.Random;
import net.minecraft.client.Minecraft;

public class EntityPlayerSP extends EntityPlayer {
	public MovementInput movementInput;
	private Minecraft mc;
	private Random rng = new Random();
	public int hunger = 0;
	public int dashTimer = 0;
	private int lastGroupX = 0;
	private int lastGroupY = 0;

	public EntityPlayerSP(Minecraft mc, World worldObj, Session session) {
		super(worldObj);
		this.mc = mc;
		if(session != null && session.username != null && session.username.length() > 0) {
			boolean var4 = System.getProperty("os.name").toLowerCase().indexOf("windows") == -1;
			this.skinUrl = "file:///" + (var4?".":"C:") + "/skincache/" + session.username + ".png";
			System.out.println("Loading texture " + this.skinUrl);
		}

		this.username = session.username;
	}

	public void updateEntityActionState() {
		super.updateEntityActionState();
		this.moveStrafing = this.movementInput.moveStrafe;
		this.moveForward = this.movementInput.moveForward;
		this.isJumping = this.movementInput.jump;
	}

	public void onLivingUpdate() {
		this.movementInput.updatePlayerMoveState(this);
		if(this.mc.options.numberOfOptions != 4 && this.mc.options.numberOfOptions != 0) {
			++this.hunger;
			if(this.hunger >= 1200) {
				this.attackEntityFrom((Entity)null, 2);
				this.hunger = 0;
			}
		}

		if(this.dashTimer > 0) {
			--this.dashTimer;
			if(this.dashTimer == 0) {
				this.mc.theWorld.playSoundEffect(this.posX, this.posY, this.posZ, "ext.recharg", 0.6F, 1.0F);
			}
		}

		int var1 = (int)this.posX / 32;
		int var2 = (int)this.posZ / 32;
		if(this.lastGroupX != var1 || this.lastGroupY != var2) {
			this.lastGroupX = var1;
			this.lastGroupY = var2;
			if(InputHandler.IsKeyDown(207) || this.rng.nextInt(100) > 90) {
				if(InputHandler.IsKeyDown(207)) {
					System.out.println("Taken the Titan\'s challenge. Good luck.");
				}

				this.worldObj.CueSpawnBossFrom((int)this.posX, (int)this.posZ);
			}
		}

		if(this.worldObj.milestone >= 10L) {
					}

		super.onLivingUpdate();
	}

	public void resetPlayerKeyState() {
		this.movementInput.resetKeyState();
	}

	public boolean attackEntityFrom(Entity entity, int damage) {
		if(this.mc.options.numberOfOptions != 4) {
			return super.attackEntityFrom(entity, damage);
		} else if(this.health <= 0) {
			return false;
		} else if((float)this.heartsLife > (float)this.heartsHalvesLife / 2.0F) {
			return false;
		} else {
			this.heartsLife = this.heartsHalvesLife;
			System.out.println("Damage taken: " + damage);
			if(this.inventory.getTotalArmorValue() == 0) {
				this.health = 0;
				this.onDeath((Entity)null);
				this.worldObj.playSoundAtEntity(this, "random.glass", 1.0F, 1.0F);
			} else {
				this.worldObj.playSoundAtEntity(this, "ext.crack", 1.0F, 1.0F);
				int var3 = 0;

				for(int var4 = 0; var4 != 4; ++var4) {
					var3 += this.inventory.armorItemInSlot(var4) == null?0:1;
				}

				this.inventory.damageArmor(damage * 16 / var3);
			}

			return true;
		}
	}

	public void handleKeyPress(int var1, boolean var2) {
		this.movementInput.checkKeyForMovementInput(var1, var2);
	}

	public void writeEntityToNBT(NBTTagCompound compoundTag) {
		super.writeEntityToNBT(compoundTag);
		compoundTag.setInteger("Score", this.score);
	}

	public void readEntityFromNBT(NBTTagCompound compoundTag) {
		super.readEntityFromNBT(compoundTag);
		this.score = compoundTag.getInteger("Score");
	}

	public void displayGUIChest(IInventory inventory) {
		this.mc.displayGuiScreen(new GuiChest(this.inventory, inventory));
	}

	public void a(WorldGenTrees var1) {
		this.mc.displayGuiScreen(new IProgressUpdate(var1));
	}

	public void displayWorkbenchGUI() {
		this.mc.displayGuiScreen(new GuiCrafting(this.inventory));
	}

	public void displayGUIFurnace(TileEntityFurnace furnaceTileEntity) {
		this.mc.displayGuiScreen(new GuiFurnace(this.inventory, furnaceTileEntity));
	}

	public void attackEntity(Entity entity) {
		int var2 = this.inventory.getDamageVsEntity(entity);
		if(var2 > 0) {
			entity.attackEntityFrom(this, var2);
			ItemStack var3 = this.s();
			if(var3 != null && entity instanceof EntityLiving) {
				var3.hitEntity((EntityLiving)entity);
				if(var3.stackSize <= 0) {
					var3.onItemDestroyedByUse(this);
					this.t();
				}
			}
		}

	}

	public void onItemPickup(Entity entity, int var2) {
		this.mc.effectRenderer.a(new EntityPickupFX(this.mc.theWorld, entity, this, -0.5F));
	}

	public int getPlayerArmorValue() {
		return this.inventory.getTotalArmorValue();
	}

	public void interactWithEntity(Entity entity) {
		if(!entity.interact(this)) {
			ItemStack var2 = this.s();
			if(var2 != null && entity instanceof EntityLiving) {
				var2.useItemOnEntity((EntityLiving)entity);
				if(var2.stackSize <= 0) {
					var2.onItemDestroyedByUse(this);
					this.t();
				}
			}

		}
	}

	public void sendChatMessage(String chatMessage) {
	}

	public void onPlayerUpdate() {
	}
}
