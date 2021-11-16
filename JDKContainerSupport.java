public class JDKContainerSupport {
    public static void main(String[] args){
        System.out.println( String.format("Runtime version, %s", System.getProperty("java.version")) );

        System.out.println( String.format("Available processors, %d", Runtime.getRuntime().availableProcessors()) );

        System.out.println( String.format("Max memory, %s", Runtime.getRuntime().maxMemory()) );
        System.out.println( String.format("Total memory, %s", Runtime.getRuntime().totalMemory()) );
        System.out.println( String.format("Free memory, %s", Runtime.getRuntime().freeMemory()) );
    }
}
