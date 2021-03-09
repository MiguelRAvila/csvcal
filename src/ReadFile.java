
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ReadFile {
    
    public List<Estudiante> readFile(){
        List<Estudiante> estudianteList = new ArrayList<>();
        //StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("entrada.csv"));
            String line;
            while((line = bufferedReader.readLine()) != null){                        
                String[] parts = line.split(",");            
                Estudiante estudiante = new Estudiante(Integer.valueOf(parts[0]), parts[1], parts[2], parts[3]);
                estudianteList.add(estudiante);
            }
        }catch (IOException e){
                System.out.println("Error: " + e.getMessage());
        }
        return estudianteList;
    }
}
