public class Program 
{
    public static final String CONSOLE_CLEAR = "\033[H\033[2J";
    public static void main(String[] args)
    {
        System.out.println(ConsoleColours.ANSI_BG_GREEN);
        System.out.println(ConsoleColours.ANSI_BRIGHT_YELLOW);
        System.out.println(CONSOLE_CLEAR);

        System.out.println("CO452 Programming Concepts 2022/23");
        System.out.println("==================================");
        System.out.println();
        System.out.println(" by Nicholas Day and Derek Peacock");
        System.out.println();

        InputReader reader = new InputReader();
        int age = reader.getInt("Please enter your age > ");

        //Week01 exercise01 = new Week01();
        //exercise01.run();
    }
}
