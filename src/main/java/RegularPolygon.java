import java.util.Scanner;

public class RegularPolygon {
    private static double area=0;
    private static int n; //number of sides
    private static double side; //length of sides

    //method "main" to run
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        side = in.nextDouble();
        if(n<1){
            System.out.println("NO");
        }
        else if(side<0){
            System.out.println("NO");
        }
        else if(area<0){
            System.out.println("NO");
        }
        else{
            System.out.println(area(n,side));
        }
    }
    //method for area of a regular polygon
    public static double area (int n, double side){
        area = Math.pow(side,2)*n/(4*Math.tan(Math.toRadians(180/n)));
        return area;
    }
}
