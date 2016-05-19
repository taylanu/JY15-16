public class BotDriver            //in BotDriver.java
{
    public static void main(String[] arg) {
        Robot lisa = new Robot();
        Robot pete = new Robot(3, 5, "NORTH");
        System.out.println(lisa);
        System.out.println(pete);
        lisa.move();
        lisa.move();
        pete.turnLeft();
        pete.move();
        System.out.println(lisa);
        System.out.println(pete);
    }
}
