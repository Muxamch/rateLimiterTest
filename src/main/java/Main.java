import org.apache.log4j.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        Vector vector1 = new Vector(2,3);
        Vector vector2 = new Vector(6,-5);

        LOGGER.info("vectors : "+vector1+" , "+vector2);

        Vector vector3 = new Vector(2,-5);

        LOGGER.info("new vector : "+vector3);

        vector1.vectorAdd(vector3);

        LOGGER.info("add v3 to v1 : "+vector1);


        Vector vector4 = Vector.sumOfVector(vector1,vector2);

        LOGGER.info("sum ov v1 and v2, new v4 : "+vector4);

        vector4.vectorSub(vector2);

        LOGGER.info("vec4 sub vec2 : "+vector4);

        double angle = Vector.angleBetweenVectors(vector4,vector3);

        LOGGER.info("angle between vec4 and vec3 : "+angle);

    }
}
