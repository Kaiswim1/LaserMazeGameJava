import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public final class AnnotationValidator {

    // Private constructor to prevent instantiation
    private AnnotationValidator() {}

    // Entry point for validation rules
    public static void setRulesForClasses() {
        allClassMethodsMustContainParam(GameGraphics.class, RequireGraphics.class, java.awt.Graphics.class);
        allClassMethodsMustContainParam(Controls.class, RequireMouse.class, java.awt.event.MouseEvent.class);
    }

    /**
     * Checks that all methods of a target class annotated with a specified annotation
     * contain a parameter of a given type. Throws RuntimeException on failure.
     *
     * @param targetClass the class to validate
     * @param annotation  the annotation that triggers validation
     * @param param       the required parameter type that each method must have
     */
    private static void allClassMethodsMustContainParam(Class<?> targetClass,
                                                        Class<? extends Annotation> annotation,
                                                        Class<?> param) {
        // Skip validation if the annotation is not present on the class
        if (!targetClass.isAnnotationPresent(annotation)) return;

        for (Method method : targetClass.getDeclaredMethods()) {
            boolean hasParam = false;
            for (Class<?> paramType : method.getParameterTypes()) {
                if (param.isAssignableFrom(paramType)) {
                    hasParam = true;
                    break;
                }
            }
            if (!hasParam) {
                throw new RuntimeException("Class " + targetClass.getName() +
                        ", method " + method.getName() +
                        " must have a parameter of type " + param.getCanonicalName());
            }
        }
    }
}
