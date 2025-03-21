class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> src = new ArrayList<>(Arrays.asList(supplies));
        List<String> finishList = new ArrayList<>();
        for (String s : supplies) {
            finishList.add(s);
        }

        int len = recipes.length;
        boolean check = false;
        while (!check) {
            check = true;
            for (int i = 0; i < len; i++) {
                List<String> ingredient = ingredients.get(i);
                int before = ingredient.size();
                ingredient.removeAll(finishList);
                int after = ingredient.size();
                if (before > after) {
                    if (after == 0) {
                        finishList.add(recipes[i]);
                    }
                    check = false;
                }
            }
        }

        finishList.removeAll(src);
        return finishList;
    }
}
 