public class Main {
    public static void main(String[] args) {
        /**
         * Makes sure that all classes adhere to the rules defined by
         * custom-made annotations.
         * Annotations include:
         * @RequireGraphics -> Forces all methods inside an annotated class to contain a java.awt.graphics parameter
         * @RequireMouse -> Forces all methods inside an annotated class to contain a java.awt.event.MouseEvent parameter
         * */
        AnnotationValidator.setRulesForClasses();

        /**
         * Let's launch the Laser Maze Game!
         */
        new Game();
    }
}
