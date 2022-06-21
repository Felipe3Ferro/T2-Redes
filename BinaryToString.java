import java.util.Arrays;
import java.util.stream.Collectors;

public class BinaryToString {

    public static String binarytoStroiString(String input) {

        String raw = Arrays.stream(input.split(" "))
                .map(binary -> Integer.parseInt(binary, 2))
                .map(Character::toString)
                .collect(Collectors.joining()); // cut the space

        return raw;

    }

}