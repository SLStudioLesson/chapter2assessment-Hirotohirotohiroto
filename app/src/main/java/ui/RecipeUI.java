package ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

import data.RecipeFileHandler;

public class RecipeUI {
    private BufferedReader reader;
    private RecipeFileHandler fileHandler;

    //コンストラクタ
    public RecipeUI() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        fileHandler = new RecipeFileHandler();
    }
    //コンストラクタ（引数あり）
    public RecipeUI(BufferedReader reader, RecipeFileHandler fileHandler) {
        this.reader = reader;
        this.fileHandler = fileHandler;
    }
    //入力受付
    public void displayMenu() {
        while (true) {
            try {
                System.out.println();
                System.out.println("Main Menu:");
                System.out.println("1: Display Recipes");
                System.out.println("2: Add New Recipe");
                System.out.println("3: Search Recipe");
                System.out.println("4: Exit Application");
                System.out.print("Please choose an option: ");
                //受け付けた値
                String choice = reader.readLine();
                //受け付けた値によって条件分岐
                switch (choice) {
                    case "1":
                        // 設問1: 一覧表示機能
                        displayRecipes();
                        break;
                    case "2":
                        addNewRecipe();
                        // 設問2: 新規登録機能
                        break;
                    case "3":
                        // 設問3: 検索機能
                        break;
                    case "4":
                        System.out.println("Exit the application.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please select again.");
                        break;
                }
            } catch (IOException e) {
                System.out.println("Error reading input from user: " + e.getMessage());
            }
        }
    }

    /**
     * 設問1: 一覧表示機能
     * RecipeFileHandlerから読み込んだレシピデータを整形してコンソールに表示します。
     */
    //レシピデータを表示するためのメソッド
    private void displayRecipes() {
        System.out.println("Recipes:");
        System.out.println("-----------------------------------");
        
        ArrayList<String> lesipi = fileHandler.readRecipes();
        for(String rh : lesipi){
            //System.out.print(rh.toString());
            System.out.print("Recipe Name: ");
            String[] a = rh.split(",");
            System.out.println(a[0]);
            System.out.print("Main Ingredients: ");
            for(int i = 1; i < a.length; i++){
                System.out.print(a[i]);
                if(i < a.length - 1){
                    System.out.print(", ");
                }
            }
            System.out.println("");
            System.out.println("-----------------------------------");
        }
        
        
    }

    /**
     * 設問2: 新規登録機能
     * ユーザーからレシピ名と主な材料を入力させ、RecipeFileHandlerを使用してrecipes.txtに新しいレシピを追加します。
     *
     * @throws java.io.IOException 入出力が受け付けられない
     */
    private void addNewRecipe() throws IOException {
        //入力受付
        System.out.print("Enter recipe name: ");
        String a1 = reader.readLine();
        System.out.print("Enter main ingredients (comma separated): ");
        String a2 = reader.readLine();
        //入力値をそれぞれ引数として渡す
        fileHandler.addRecipe(a1, a2);

        System.out.println("Recipe added successfully.");
    }

    /**
     * 設問3: 検索機能
     * ユーザーから検索クエリを入力させ、そのクエリに基づいてレシピを検索し、一致するレシピをコンソールに表示します。
     *
     * @throws java.io.IOException 入出力が受け付けられない
     */
    private void searchRecipe() throws IOException {

    }

}

