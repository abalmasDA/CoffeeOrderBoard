
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Order {
    private int number;
    private String customerName;

    @Override
    public String toString() {
        return number + " | " + customerName;
    }


}
