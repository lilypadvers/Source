package net.minecraft.src;

import java.io.File;
import java.util.Random;
import paulscode.sound.SoundSystem;
import paulscode.sound.SoundSystemConfig;
import paulscode.sound.codecs.CodecJOrbis;
import paulscode.sound.codecs.CodecWav;
import paulscode.sound.libraries.LibraryLWJGLOpenAL;

public class ICamera {
	private SoundSystem a;
	private SoundPool b = new SoundPool();
	private SoundPool c = new SoundPool();
	private SoundPool d = new SoundPool();
	private int e = 0;
	private GameSettings f;
	private boolean g = false;
	private Random h = new Random();
	private int i = this.h.nextInt(12000);

	public void a(GameSettings var1) {
		this.c.isGetRandomSound = false;
		this.f = var1;
		if(!this.g && (var1 == null || var1.b || var1.a)) {
			this.d();
		}

	}

	private void d() {
		try {
			boolean var1 = this.f.b;
			boolean var2 = this.f.a;
			this.f.b = false;
			this.f.a = false;
			this.f.saveOptions();
			SoundSystemConfig.addLibrary(LibraryLWJGLOpenAL.class);
			SoundSystemConfig.setCodec("ogg", CodecJOrbis.class);
			SoundSystemConfig.setCodec("mus", CodecMus.class);
			SoundSystemConfig.setCodec("wav", CodecWav.class);
			this.a = new SoundSystem();
			this.f.b = var1;
			this.f.a = var2;
			this.f.saveOptions();
		} catch (Throwable var3) {
			var3.printStackTrace();
			System.err.println("error linking with the LibraryJavaSound plug-in");
		}

		this.g = true;
	}

	public void a() {
		if(!this.g && (this.f.b || this.f.a)) {
			this.d();
		}

		if(!this.f.a) {
			this.a.stop("BgMusic");
		}

	}

	public void b() {
		if(this.g) {
			this.a.cleanup();
		}

	}

	public void a(String var1, File var2) {
		this.b.addSound(var1, var2);
	}

	public void b(String var1, File var2) {
		this.c.addSound(var1, var2);
	}

	public void c(String var1, File var2) {
		this.d.addSound(var1, var2);
	}

	public void c() {
		if(this.g && this.f.a) {
			if(!this.a.playing("BgMusic") && !this.a.playing("streaming")) {
				if(this.i > 0) {
					--this.i;
					return;
				}

				SoundPoolEntry var1 = this.d.getRandomSound();
				if(var1 != null) {
					this.i = this.h.nextInt(24000) + 24000;
					this.a.backgroundMusic("BgMusic", var1.soundUrl, var1.soundName, false);
					this.a.play("BgMusic");
				}
			}

		}
	}

	public void a(EntityLiving var1, float var2) {
		if(this.g && this.f.b) {
			if(var1 != null) {
				float var3 = var1.prevRotationYaw + (var1.rotationYaw - var1.prevRotationYaw) * var2;
				double var4 = var1.prevPosX + (var1.posX - var1.prevPosX) * (double)var2;
				double var6 = var1.prevPosY + (var1.posY - var1.prevPosY) * (double)var2;
				double var8 = var1.prevPosZ + (var1.posZ - var1.prevPosZ) * (double)var2;
				float var10 = MathHelper.cos(-var3 * 0.017453292F - (float)Math.PI);
				float var11 = MathHelper.sin(-var3 * 0.017453292F - (float)Math.PI);
				float var12 = -var11;
				float var13 = 0.0F;
				float var14 = -var10;
				float var15 = 0.0F;
				float var16 = 1.0F;
				float var17 = 0.0F;
				this.a.setListenerPosition((float)var4, (float)var6, (float)var8);
				this.a.setListenerOrientation(var12, var13, var14, var15, var16, var17);
			}
		}
	}

	public void a(String var1, float var2, float var3, float var4, float var5, float var6) {
		if(this.g && this.f.b) {
			String var7 = "streaming";
			if(this.a.playing("streaming")) {
				this.a.stop("streaming");
			}

			if(var1 != null) {
				SoundPoolEntry var8 = this.c.getRandomSoundFromSoundPool(var1);
				if(var8 != null && var5 > 0.0F) {
					if(this.a.playing("BgMusic")) {
						this.a.stop("BgMusic");
					}

					float var9 = 16.0F;
					this.a.newStreamingSource(true, var7, var8.soundUrl, var8.soundName, false, var2, var3, var4, 2, var9 * 4.0F);
					this.a.setVolume(var7, 0.5F);
					this.a.play(var7);
				}

			}
		}
	}

	public void b(String var1, float var2, float var3, float var4, float var5, float var6) {
		if(this.g && this.f.b) {
			SoundPoolEntry var7 = this.b.getRandomSoundFromSoundPool(var1);
			if(var7 != null && var5 > 0.0F) {
				this.e = (this.e + 1) % 256;
				String var8 = "sound_" + this.e;
				float var9 = 16.0F;
				if(var5 > 1.0F) {
					var9 *= var5;
				}

				this.a.newSource(var5 > 1.0F, var8, var7.soundUrl, var7.soundName, false, var2, var3, var4, 2, var9);
				this.a.setPitch(var8, var6);
				if(var5 > 1.0F) {
					var5 = 1.0F;
				}

				this.a.setVolume(var8, var5);
				this.a.play(var8);
			}

		}
	}

	public void a(String var1, float var2, float var3) {
		if(this.g && this.f.b) {
			SoundPoolEntry var4 = this.b.getRandomSoundFromSoundPool(var1);
			if(var4 != null) {
				this.e = (this.e + 1) % 256;
				String var5 = "sound_" + this.e;
				this.a.newSource(false, var5, var4.soundUrl, var4.soundName, false, 0.0F, 0.0F, 0.0F, 0, 0.0F);
				if(var2 > 1.0F) {
					var2 = 1.0F;
				}

				var2 *= 0.25F;
				this.a.setPitch(var5, var3);
				this.a.setVolume(var5, var2);
				this.a.play(var5);
			}

		}
	}
}
