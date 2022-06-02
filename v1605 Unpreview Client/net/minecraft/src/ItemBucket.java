package net.minecraft.src;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.CopyOption;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ItemBucket extends Thread {
	public File a;
	private net.minecraft.client.Minecraft b;
	private boolean c = false;

	public ItemBucket(File var1, net.minecraft.client.Minecraft var2) {
		this.b = var2;
		this.setName("Resource unpack thread");
		this.setDaemon(true);
		this.a = new File(var1, "resources/");
		if(!this.a.exists() && !this.a.mkdirs()) {
			throw new RuntimeException("The working directory could not be created: " + this.a);
		}
	}

	void deleteDirectoryWalkTree(java.nio.file.Path var1) throws IOException {
		SimpleFileVisitor var2 = new SimpleFileVisitor() {
			public FileVisitResult visitFile(java.nio.file.Path var1, BasicFileAttributes var2) throws IOException {
				Files.delete(var1);
				return FileVisitResult.CONTINUE;
			}

			public FileVisitResult visitFileFailed(java.nio.file.Path var1, IOException var2) throws IOException {
				Files.delete(var1);
				return FileVisitResult.CONTINUE;
			}

			public FileVisitResult postVisitDirectory(java.nio.file.Path var1, IOException var2) throws IOException {
				if(var2 != null) {
					throw var2;
				} else {
					Files.delete(var1);
					return FileVisitResult.CONTINUE;
				}
			}

			public FileVisitResult postVisitDirectory(Object var1, IOException var2) throws IOException {
				return this.postVisitDirectory((java.nio.file.Path)var1, var2);
			}

			public FileVisitResult visitFileFailed(Object var1, IOException var2) throws IOException {
				return this.visitFileFailed((java.nio.file.Path)var1, var2);
			}

			public FileVisitResult visitFile(Object var1, BasicFileAttributes var2) throws IOException {
				return this.visitFile((java.nio.file.Path)var1, var2);
			}
		};
		Files.walkFileTree(var1, var2);
	}

	public void UnpackReader(BufferedReader var1) throws IOException {
		String var2;
		while((var2 = var1.readLine()) != null) {
			if(var2 != "") {
				String var3 = var2.replace("worldstatic", "saves").replace("sounddata", "resources");
				InputStream var4 = this.getClass().getResourceAsStream(var2);
				File var5 = new File(System.getProperty("user.dir") + var3);
				var5.mkdirs();
				Files.copy(var4, Paths.get(System.getProperty("user.dir") + var3, new String[0]), new CopyOption[]{StandardCopyOption.REPLACE_EXISTING});
				var4.close();
			}
		}

		System.out.println("Resources unpacked");
		var1.close();
	}

	public void run() {
		try {
			try {
				this.deleteDirectoryWalkTree(Paths.get(System.getProperty("user.dir") + "/resources/", new String[0]));
				this.a.mkdirs();
			} catch (Exception var5) {
				System.out.println("Error removing existing resources...");
			}

			SimpleDateFormat var1 = new SimpleDateFormat("HH");
			int var2 = Integer.parseInt(var1.format(Calendar.getInstance().getTime()));
			InputStream var3 = this.getClass().getResourceAsStream(var2 <= 22 && var2 >= 5?"/soundres.txt":"/soundres_a.txt");
			BufferedReader var4 = new BufferedReader(new InputStreamReader(var3));
			this.UnpackReader(var4);
			System.out.println(System.getProperty("user.dir") + "/saves/World2/");
			if(!(new File(System.getProperty("user.dir") + "/saves/World2/")).exists()) {
				var4 = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/wstatic_data.txt")));
				this.UnpackReader(var4);
			}

			this.a(this.a, "");
		} catch (Exception var6) {
			var6.printStackTrace();
			this.a(this.a, "");
		}

	}

	public void a() {
		this.a(this.a, "");
	}

	public void b() {
		this.c = true;
	}

	private void a(File var1, String var2) {
		File[] var3 = var1.listFiles();

		for(byte var4 = 0; var4 < var3.length; ++var4) {
			if(var3[var4].isDirectory()) {
				this.a(var3[var4], var2 + var3[var4].getName() + "/");
			} else {
				try {
					this.b.a(var2 + var3[var4].getName(), var3[var4]);
				} catch (Exception var6) {
					System.out.println("Failed to add " + var2 + var3[var4].getName());
				}
			}
		}

	}

	private void a(URL var1, String var2, long var3, int var5) {
		try {
			int var6 = var2.indexOf("/");
			String var7 = var2.substring(0, var6);
			if(!var7.equals("sound") && !var7.equals("newsound")) {
				if(var5 != 1) {
					return;
				}
			} else if(var5 != 0) {
				return;
			}

			File var8 = new File(this.a, var2);
			if(!var8.exists() || var8.length() != var3) {
				var8.getParentFile().mkdirs();
				String var9 = var2.replaceAll(" ", "%20");
				this.a(new URL(var1, var9), var8, var3);
				if(this.c) {
					return;
				}
			}

			this.b.a(var2, var8);
		} catch (Exception var10) {
			var10.printStackTrace();
		}

	}

	private void a(URL var1, File var2, long var3) {
	}
}
