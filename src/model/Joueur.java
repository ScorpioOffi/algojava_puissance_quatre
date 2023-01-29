package model;

import java.util.Scanner;

public class Joueur {
    public static String couleur1 ="🔴" ;
    public static String couleur2 ="🟡" ;

    private static String nom;
    private static String look;
  


    public Joueur(String nom, String look) {
        setNom();
        setLook();
        setNom2();
        setLook2();

    }
  

    public static String getNom() {
        return nom;
    }

    public static String setNom() {
        Scanner input = new Scanner(System.in);
        System.out.println("Entrez votre nom");
        nom = input.nextLine();
        
        return nom;
    }

    public static String getLook() {
        return look;
    }

    public static void setLook() {

        Scanner scan = new Scanner(System.in);
        System.out.println("Choisissez votre symbole");
        look = scan.nextLine();
       
        
      

       
        System.out.println("1. 🐶");
        System.out.println("2. 🐱");
        System.out.println("3. 🐭");
        System.out.println("4. 🐹");
        System.out.println("5. 🐰");
        System.out.println("6. 🐻");
        System.out.println("7. 🐼");
        System.out.println("8. 🦁");
        System.out.println("9. 🐸");
       
        String look = scan.nextLine();

      
     
            
            switch (look) {
                case "1":
                    look = "🐶";
                    break;
                case "2":
                    look = "🐱";
                    break;
                case "3":
                    look = "🐭";
                    break;
                case "4":
                    look = "🐹";
                    break;
                case "5":
                    look = "🐰";
                    break;
                case "6":
                    look = "🐻";
                    break;
                case "7":
                    look = "🐼";
                    break;
                case "8":
                    look = "🦁";
                    break;
                case "9":
                    look = "🐸";
                    break;

              
                default:
                couleur1 = "🔴";
               
                break;
               

                }
           look = scan.nextLine();
           
            
            

        }

    
        public static Joueur creerJoueur1(){
            System.out.println("CUSTO Joueur 1");
            Joueur joueur = new Joueur(getNom(), getLook());
            return joueur;
    
        }
        private static String nom2;



        




        
        public String getNom2() {

            return setNom2();
        }
    
        public static String setNom2() {
            Scanner input = new Scanner(System.in);
            System.out.println("Entrez votre nom");
            nom2 = input.nextLine();
            
            return nom2;
        }
    
        public static String getLook2() {
            return setLook2();
        }
    
        public static String setLook2() {
    
            Scanner scan = new Scanner(System.in);
            System.out.println("Choisissez votre symbole");
            
           
            
          
    
           
            System.out.println("1. ⚽️");
            System.out.println("2. ⚽️");
            System.out.println("3. 🏈");
            System.out.println("4. ⚾️");
            System.out.println("5. 🏐");
            System.out.println("6. 🎾");
            System.out.println("7. 🥏");
            System.out.println("8. 🪀");
            System.out.println("9. 🎱");
           
            String look2 = scan.nextLine();
    
          
         
                
                switch (look2) {
                    case "1":
                        look2 = "⚽️";
                        break;
                    case "2":
                        look2 = "🏀";
                        break;
                    case "3":
                        look2 = "🏈";
                        break;
                    case "4":
                        look2 = "⚾️";
                        break;
                    case "5":
                        look2 = "🏐";
                        break;
                    case "6":
                        look2 = "🎾";
                        break;
                    case "7":
                        look2 = "🥏";
                        break;
                    case "8":
                        look2= "🪀";
                        break;
                    case "9":
                        look2 = "🎱 ";
                        break;
    
                  
                    default:
                    couleur2 = "🟡";
                   
                    break;
                   
    
                    }
               
                return look2;
    
            }
        public static Joueur creerJoueur2(){
            System.out.println("CUSTO Joueur 2");
        
            Joueur joueur2 = new Joueur (setNom2(), setLook2());
            return joueur2;
    
        }
    
    
    }
        
    

       
    

   








 




 


        

        
       
        

   
    
   
