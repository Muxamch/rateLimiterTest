import org.apache.log4j.Logger;
import lombok.*;


@Getter
@AllArgsConstructor
@ToString
public class Vector {
    private static final Logger LOGGER = Logger.getLogger(Vector.class);
    private int x;
    private int y;

    public Vector(){
        this.x = 0;
        this.y = 0;
    }

    public static Vector sumOfVector(Vector vector1, Vector vector2){
        Vector vectorNew = new Vector();
        vectorNew.x = vector1.x + vector2.x;
        vectorNew.y = vector1.y + vector2.y;
        return vectorNew;
    }

    public Vector vectorAdd(Vector newV){
        this.x += newV.x;
        this.y += newV.y;
        return this;
    }

    public static Vector subtractionOnVector(Vector vector1, Vector vector2){
        Vector vectorNew = new Vector();
        vectorNew.x = vector1.x - vector2.x;
        vectorNew.y = vector1.y - vector2.y;

        return vectorNew;
    }

    public Vector vectorSub(Vector newV){
        this.x -= newV.x;
        this.y -= newV.y;
        return this;
    }

    public static double angleBetweenVectors(Vector vector1, Vector vector2){
        double angle = (vector1.x * vector2.x + vector1.y * vector2.y)/(Math.sqrt(vector1.x * vector1.x + vector1.y * vector1.y) * Math.sqrt(vector2.x * vector2.x + vector2.y * vector2.y));
        angle = Math.acos(angle);
        angle = Math.toDegrees(angle);

        return angle;
    }
}
