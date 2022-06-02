package net.minecraft.src;

import java.awt.Component;
import java.nio.IntBuffer;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Cursor;
import org.lwjgl.input.Mouse;

public class md {
	private Component c;
	private Cursor d;
	public int a;
	public int b;
	private int e = 10;

	public md(Component var1) {
		this.c = var1;
		IntBuffer var2 = BlockRedstoneTorch.c(1);
		var2.put(0);
		var2.flip();
		IntBuffer var3 = BlockRedstoneTorch.c(1024);

		try {
			this.d = new Cursor(32, 32, 16, 16, 1, var3, var2);
		} catch (LWJGLException var5) {
			var5.printStackTrace();
		}

	}

	public void a() {
		Mouse.setGrabbed(true);
		this.a = 0;
		this.b = 0;
	}

	public void b() {
		Mouse.setCursorPosition(this.c.getWidth() / 2, this.c.getHeight() / 2);
		Mouse.setGrabbed(false);
	}

	public void c() {
		if(InputHandler.gamepads != null) {
			for(int var1 = 0; var1 != InputHandler.gamepads.length; ++var1) {
				if(InputHandler.gamepads[var1] != null && (InputHandler.gamepads[var1].getRXAxisValue() != 0.0F || InputHandler.gamepads[var1].getRYAxisValue() != 0.0F) && (InputHandler.gamepads[var1].getRXAxisValue() != -1.0F || InputHandler.gamepads[var1].getRYAxisValue() != -1.0F)) {
					this.a = (int)(InputHandler.gamepads[var1].getRXAxisValue() * 10.0F);
					if(this.a > -1 && this.a < 1) {
						this.a = 0;
					}

					this.b = (int)(-InputHandler.gamepads[var1].getRYAxisValue() * 5.0F);
					if(this.b > -1 && this.b < 1) {
						this.b = 0;
					}

					if(this.a != 0 || this.b != 0) {
						return;
					}
				}
			}
		}

		this.a = Mouse.getDX();
		this.b = Mouse.getDY();
	}
}
