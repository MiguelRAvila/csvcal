
import java.io.File;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {               
        
        //leer la lista
        //columna: matricula, primer apellido, segundo apellido y nombres
        ReadFile readFile = new ReadFile();
        List<Estudiante> estudianteList = readFile.readFile();
                
        //Capturar calificaciones
        Scanner scanner = new Scanner(System.in);
        float calificacion;
        int auxCal;
        for(Estudiante element : estudianteList){            
            while(true){
                System.out.println("Introduzca calificacion (1-100) de " + element.getNombres() + ":");
                calificacion = scanner.nextFloat();
                if( calificacion<1 || calificacion>100 || calificacion%1 != 0){
                    System.out.println("Calificacion invalida. Intente de nuevo");
                }else {
                    break;
                }
            }
            auxCal = (int) calificacion;
            element.setCalificacion(auxCal);
        }
        
        //Verificar que todos los estudiantes tienen calificacion
        for(Estudiante element : estudianteList){
            if(element.getCalificacion() == -1){
                System.out.println("No se puede generar archivo de calificaciones. A uno o más alumnos no se les ha capturado su calificacion");                
                break;
            }
        }
                
        //Generar archivo de calificaciones (opcional)
        Scanner read = new Scanner(System.in);
        String opcion;
        System.out.println("Desea generar el archivo de calificaciones? (y/n)");
        opcion = read.nextLine();
        
        if (opcion.equals("y")) {
            File file = new File("salida.csv");
            file.delete();
            CreateFile createFile = new CreateFile();
            createFile.createFile(estudianteList);
        }else {
            System.out.println("No se genero el archivo");
        }
                
    }
    
}



