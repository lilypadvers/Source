package net.minecraft.src;

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.util.ArrayList;
import java.util.List;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class CanvasIsomPreview extends lb {
	protected net.minecraft.client.Minecraft b;
	public int c;
	public int d;
	protected List e = new ArrayList();
	public boolean running = false;
	protected BlockDoor g;
	public static String currentID = "";

	public void a(int var1, int var2, float var3) {
		for(int var4 = 0; var4 < this.e.size(); ++var4) {
			((EntitySplashFX)this.e.get(var4)).a(this.b, var1, var2);
		}

	}

	protected void a(char var1, int var2) {
		if(var2 == 1) {
			this.b.a((CanvasIsomPreview)null);
			this.b.e();
		}

	}

	public static String c() {
		try {
			Transferable var0 = Toolkit.getDefaultToolkit().getSystemClipboard().getContents((Object)null);
			if(var0 != null && var0.isDataFlavorSupported(DataFlavor.stringFlavor)) {
				return (String)var0.getTransferData(DataFlavor.stringFlavor);
			}
		} catch (Exception var1) {
		}

		return null;
	}

	protected void a(int var1, int var2, int var3) {
		if(var3 == 0) {
			for(int var4 = 0; var4 < this.e.size(); ++var4) {
				EntitySplashFX var5 = (EntitySplashFX)this.e.get(var4);
				if(var5.a(var1, var2)) {
					this.b.A.a("random.click", 1.0F, 1.0F);
					this.a(var5);
				}
			}
		}

	}

	protected void b(int var1, int var2, int var3) {
	}

	protected void a(EntitySplashFX var1) {
	}

	public void a(net.minecraft.client.Minecraft var1, int var2, int var3) {
		this.b = var1;
		this.g = var1.o;
		this.c = var2;
		this.d = var3;
		this.a();
	}

	public void a() {
	}

	public void render() {
		while(Mouse.next()) {
			this.e();
		}

		while(Keyboard.next()) {
			this.f();
		}

	}

	public void e() {
		if(Mouse.getEventButtonState()) {
			this.a(Mouse.getEventX() * this.c / this.b.c, this.d - Mouse.getEventY() * this.d / this.b.d - 1, Mouse.getEventButton());
		} else {
			this.b(Mouse.getEventX() * this.c / this.b.c, this.d - Mouse.getEventY() * this.d / this.b.d - 1, Mouse.getEventButton());
		}

	}

	public void f() {
		if(Keyboard.getEventKeyState()) {
			if(Keyboard.getEventKey() == Keyboard.KEY_NUMPAD1) {
				currentID = currentID + '1';
				System.out.println("Current entered ID: " + currentID);
			} else if(Keyboard.getEventKey() == Keyboard.KEY_NUMPAD2) {
				currentID = currentID + '2';
				System.out.println("Current entered ID: " + currentID);
			} else if(Keyboard.getEventKey() == Keyboard.KEY_NUMPAD3) {
				currentID = currentID + '3';
				System.out.println("Current entered ID: " + currentID);
			} else if(Keyboard.getEventKey() == Keyboard.KEY_NUMPAD4) {
				currentID = currentID + '4';
				System.out.println("Current entered ID: " + currentID);
			} else if(Keyboard.getEventKey() == Keyboard.KEY_NUMPAD5) {
				currentID = currentID + '5';
				System.out.println("Current entered ID: " + currentID);
			} else if(Keyboard.getEventKey() == Keyboard.KEY_NUMPAD6) {
				currentID = currentID + '6';
				System.out.println("Current entered ID: " + currentID);
			} else if(Keyboard.getEventKey() == Keyboard.KEY_NUMPAD7) {
				currentID = currentID + '7';
				System.out.println("Current entered ID: " + currentID);
			} else if(Keyboard.getEventKey() == Keyboard.KEY_NUMPAD8) {
				currentID = currentID + '8';
				System.out.println("Current entered ID: " + currentID);
			} else if(Keyboard.getEventKey() == Keyboard.KEY_NUMPAD9) {
				currentID = currentID + '9';
				System.out.println("Current entered ID: " + currentID);
			} else if(Keyboard.getEventKey() == Keyboard.KEY_NUMPAD0) {
				currentID = currentID + '0';
				System.out.println("Current entered ID: " + currentID);
			} else if(Keyboard.getEventKey() == Keyboard.KEY_SUBTRACT) {
				currentID = "";
			} else if(Keyboard.getEventKey() == Keyboard.KEY_ADD) {
				try {
					if(ln.n.length > Integer.parseInt(currentID) && ln.n[Integer.parseInt(currentID)] != null) {
						if(Integer.parseInt(currentID) == 97) {
							Sys.alert("", "Block not available in preview version");
						} else {
							this.b.g.a(new TileEntityFurnace(ln.n[Integer.parseInt(currentID)], 64), true);
							System.out.println("Given block to the player");
						}
					} else if(EntityTNTPrimed.c[Integer.parseInt(currentID)] != null) {
						this.b.g.a(new TileEntityFurnace(EntityTNTPrimed.c[Integer.parseInt(currentID)], 1), true);
						System.out.println("Given item to the player");
					} else {
						System.out.println("No block or item with ID " + currentID);
					}
				} catch (Exception var2) {
					var2.printStackTrace();
				}
			}

			if(Keyboard.getEventKey() == Keyboard.KEY_F11) {
				this.b.h();
				return;
			}

			this.a(Keyboard.getEventCharacter(), Keyboard.getEventKey());
		}

	}

	public void g() {
	}

	public void h() {
	}

	public void i() {
		this.setBrightness(0);
	}

	public void setBrightness(int var1) {
		if(this.b.e != null) {
			this.a(0, 0, this.c, this.d, -1072689136, -804253680);
		} else {
			this.b(var1);
		}

	}

	public void b(int var1) {
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_FOG);
		NBTTagByteArray var2 = NBTTagByteArray.a;
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, this.b.n.a("/dirt.png"));
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		var2.b();
		var2.b(4210752);
		var2.a(0.0D, (double)this.d, 0.0D, 0.0D, (double)((float)this.d / 32.0F + (float)var1));
		var2.a((double)this.c, (double)this.d, 0.0D, (double)((float)this.c / 32.0F), (double)((float)this.d / 32.0F + (float)var1));
		var2.a((double)this.c, 0.0D, 0.0D, (double)((float)this.c / 32.0F), (double)(0 + var1));
		var2.a(0.0D, 0.0D, 0.0D, 0.0D, (double)(0 + var1));
		var2.a();
	}

	public boolean b() {
		return true;
	}

	public void a(boolean var1, int var2) {
	}

	static {
		currentID = "";
	}
}
