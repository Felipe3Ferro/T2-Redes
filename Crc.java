import java.util.*;

class Crc {
    // create divideDataWithDivisor() method to get CRC
    static int[] divideDataWithDivisor(int oldData[], int divisor[]) {

        int rem[] = new int[divisor.length];
        int i;
        int data[] = new int[oldData.length + divisor.length];

        System.arraycopy(oldData, 0, data, 0, oldData.length);
        System.arraycopy(data, 0, rem, 0, divisor.length);

        for (i = 0; i < oldData.length; i++) {
            if (rem[0] == 1) {

                for (int j = 1; j < divisor.length; j++) {
                    rem[j - 1] = exorOperation(rem[j], divisor[j]);
                }
            } else {

                for (int j = 1; j < divisor.length; j++) {
                    rem[j - 1] = exorOperation(rem[j], 0);
                }
            }

            rem[divisor.length - 1] = data[i + divisor.length];
        }
        return rem;
    }

    static int exorOperation(int x, int y) {

        if (x == y) {
            return 0;
        }
        return 1;
    }

    static void receiveData(int data[], int divisor[]) {

        int rem[] = divideDataWithDivisor(data, divisor);

        for (int i = 0; i < rem.length; i++) {
            if (rem[i] != 0) {

                System.out.println("Currupted data received...");
                return;
            }
        }
        System.out.println("Data received without any error.");
    }
}