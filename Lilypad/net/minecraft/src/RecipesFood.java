package net.minecraft.src;

public class RecipesFood {
	public void addRecipes(CraftingManager craftingManager) {
		craftingManager.addRecipe(new ItemStack(Item.bowlSoup), new Object[]{"Y", "X", "#", Character.valueOf('X'), Block.ag, Character.valueOf('Y'), Block.ah, Character.valueOf('#'), Item.bowlEmpty});
		craftingManager.addRecipe(new ItemStack(Item.bowlSoup), new Object[]{"Y", "X", "#", Character.valueOf('X'), Block.ah, Character.valueOf('Y'), Block.ag, Character.valueOf('#'), Item.bowlEmpty});
	}
}
