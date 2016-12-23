import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by mr on 12/20/16.
 */

public class AgencyFileWriter {

    public static void writeAgenciesToFile(LinkedList<Agency> agencies, String city){

        File file = new File("/Users/mr/Downloads/Agencies_" + city + ".txt");
        FileWriter writer = null;

        try{

            writer = new FileWriter(file);
            writer.write(agencies.toString());

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try{

                writer.close();

            } catch (IOException e) {

                e.printStackTrace();

            }
        }


    }

}
