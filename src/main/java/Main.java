import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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


        Vector vector4 = Vector.getSumOfVector(vector1,vector2);

        LOGGER.info("sum ov v1 and v2, new v4 : "+vector4);

        vector4.vectorSub(vector2);

        LOGGER.info("vec4 sub vec2 : "+vector4);

        double angle = Vector.getAngleBetweenVectors(vector4,vector3);

        LOGGER.info("angle between vec4 and vec3 : "+angle);

        double angleTest = Vector.getAngleBetweenVectors(new Vector(1,2), new Vector(2,3));

        LOGGER.info("ANGLE TEST : " +angleTest);

        double vLength = Vector.getVectorLength(vector4);

        LOGGER.info("lenght of vector 4"+ vLength);

        Vector vectorNew = Vector.getVectorFromPoint(new Point(5,6), new Point(7,8));

        LOGGER.info("vector from points x5y6, x7y8 : " +vectorNew);
        List<Vector> vectors = new ArrayList<Vector>();

        try {
            vectors = JsonHandler.getVectorsFromJson();
        } catch (IOException e) {
            LOGGER.error("error : ",e);
        }
        double angleTest2 = Vector.getAngleBetweenVectors(vectors.get(0), vectors.get(1));
        LOGGER.info("VECTORS FROM JSON "+vectors);

        LOGGER.info("angle between vectors from JSON : "+angleTest2);
    }
}
