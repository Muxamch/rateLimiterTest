import lombok.*;


@Getter
@AllArgsConstructor
public class Point {
    private int x;
    private int y;

    public Point(){
        this.x = 0;
        this.y = 0;
    }

}
