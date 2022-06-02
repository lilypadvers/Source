package net.minecraft.src;

import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.imageio.ImageIO;

class ko extends Thread {
	private TileEntitySignRenderer paramby2;
	private String paramString2;
	private TerrainTextureManager paramgr2;

	ko(TileEntitySignRenderer var1, String var2, TerrainTextureManager var3) {
		this.paramby2 = var1;
		this.paramString2 = var2;
		this.paramgr2 = var3;
	}

	public void run() {
		if(this.paramString2.startsWith("file:///")) {
			try {
				if(this.paramgr2 == null) {
					this.paramby2.a = ImageIO.read(new File(this.paramString2.substring(8)));
				} else {
					this.paramby2.a = this.paramgr2.a(ImageIO.read(new File(this.paramString2.substring(8))));
				}

				System.out.println("Loaded from local file");
			} catch (Exception var7) {
				var7.printStackTrace();
			}

		} else {
			HttpURLConnection var1 = null;

			try {
				URL var2 = new URL(this.paramString2);
				var1 = (HttpURLConnection)var2.openConnection();
				var1.setDoInput(true);
				var1.setDoOutput(false);
				var1.connect();
				if(var1.getResponseCode() != 404) {
					if(this.paramgr2 == null) {
						this.paramby2.a = ImageIO.read(var1.getInputStream());
					} else {
						this.paramby2.a = this.paramgr2.a(ImageIO.read(var1.getInputStream()));
					}

					return;
				}
			} catch (Exception var8) {
				var8.printStackTrace();
				return;
			} finally {
				var1.disconnect();
			}

		}
	}
}
