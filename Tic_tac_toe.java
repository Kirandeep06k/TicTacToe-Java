import java.util.*;
public class Tic_tac_toe
{
    static Scanner sc = new Scanner(System.in);
    public static void main(String args[])
    {
        System.out.println("Welcome to tic-tac-toe game!");
        System.out.println("\nThe program enters X for player 1 and O for player 2");
        System.out.println("\nPlayer 1 Enter your name");
        String p1 = sc.nextLine();
        System.out.println("\nPlayer 2 Enter your name");
        String p2 = sc.nextLine();
        System.out.println("\n*Note* : You are required to enter your placements(1-9) when your turn comes");
        String playAgain;
        do{
            char box[][];
            box = resetbox();
            playGame(box,p1,p2);
            System.out.println("Do you want to play again? (yes/no)");
            playAgain = sc.next();
        }while(playAgain.equalsIgnoreCase("yes"));
         System.out.println("-----------Game Over. Thank you for playing!------------");
    }
    
    static char[][] resetbox(){
        char box[][] = { 
                         {' ' , '|' , ' ' , '|' , ' '} ,
                         {'-' , '+' , '-' , '+' , '-'} ,
                         {' ' , '|' , ' ' , '|' , ' '} ,
                         {'-' , '+' , '-' , '+' , '-'} ,
                         {' ' , '|' , ' ' , '|' , ' '}
                         };
        printbox(box);
        return box;
    }
    
    static void playGame(char box[][], String p1, String p2){
        char symbol='X';
        int counter=0;
        String user;

      for(int i=1;i<=9;i++)
      {
            ++counter;
            if(counter%2!=0)
            {
            user = p1; // X
            }
            else
            user = p2; // O
            System.out.println(user+" enter your placement");
            int pos = sc.nextInt();
            
            
            if(user.equals(p1))
            symbol='X';
            
            if(user.equals(p2))
            symbol='O';
            
        boolean isvalidMove = isCellEmpty(box, pos);
        
        if(!isvalidMove){
            System.out.println("Invalid placement or position already filled. Try again!");
            --i;
            --counter;
            continue;
        }
        
        placeSymbol(box, symbol, pos);

        printbox(box);
        
        if(win(box,symbol))
        {
           System.out.println(user+ " wins");
           break;
        }
        else
        {
          if(counter==9)
            {
             System.out.println("Tie");
             break;
            }
        }
            
      }
    }
    
    static boolean isCellEmpty(char box[][], int pos){
        switch(pos) {
        case 1: return box[0][0] == ' ';
        case 2: return box[0][2] == ' ';
        case 3: return box[0][4] == ' ';
        case 4: return box[2][0] == ' ';
        case 5: return box[2][2] == ' ';
        case 6: return box[2][4] == ' ';
        case 7: return box[4][0] == ' ';
        case 8: return box[4][2] == ' ';
        case 9: return box[4][4] == ' ';
        default: return false;
        }
    }
    
    static void placeSymbol(char box[][], char symbol, int pos){
        switch(pos)
        {
            case 1:
                box[0][0]=symbol;
                break;
                
            case 2:
                box[0][2]=symbol;
                break;
                
            case 3:
                box[0][4]=symbol;
                break; 
                
            case 4:
                box[2][0]=symbol;
                break;  
                
            case 5:
                box[2][2]=symbol;
                break;
                
            case 6:
                box[2][4]=symbol;
                break;
                
            case 7:
                box[4][0]=symbol;
                break;
                
            case 8:
                box[4][2]=symbol;
                break;
                
            case 9:
                box[4][4]=symbol;
                break; 
                
            default:
                System.out.println("Invalid placement. Try again!");
                break;
        }
    }
    
    static boolean win(char box[][], char s){
        return
        (box[0][0]==s && box[0][2]==s && box[0][4]==s)||
        (box[2][0]==s && box[2][2]==s && box[2][4]==s) ||
        (box[4][0]==s && box[4][2]==s && box[4][4]==s) ||
        (box[0][0]==s && box[2][0]==s && box[4][0]==s) ||
        (box[0][2]==s && box[2][2]==s && box[4][2]==s) ||
        (box[0][4]==s && box[2][4]==s && box[4][4]==s) ||
        (box[0][0]==s && box[2][2]==s && box[4][4]==s) ||
        (box[0][4]==s && box[2][2]==s && box[4][0]==s);
    }
    public static void printbox(char box[][])
    {
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {
                System.out.print(box[i][j]);
            }
            System.out.println();
        }
    }
}