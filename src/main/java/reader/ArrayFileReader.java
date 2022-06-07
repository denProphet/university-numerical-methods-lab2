package reader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayFileReader {

    public ArrayFileReader() {
    }

    public List<Double> getDoubleList(File file) throws IOException {
        List<Double> dataFromFile = new ArrayList<>();

        try( FileReader fr = new FileReader(file)) {
            Scanner scan = new Scanner(fr);
            while (scan.hasNextLine()) {
                String s = scan.nextLine();
                //дозволити і "." і "," при записі числа
                if (s.contains(",")) s = s.replace(",", ".");
                if(s.isEmpty()) continue;
                dataFromFile.add(Double.parseDouble(s));
            }
            return dataFromFile;
        }
    }
}
