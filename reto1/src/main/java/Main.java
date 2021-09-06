import java.util.Scanner;
import java.util.HashMap;
/*
* Recomendaciones Generales:
*
*    -> El método run() funcionará como nuestro método principal
*    -> No declarar objetos de tipo Scanner, utilizar el método read() para solicitar datos al usuario.
*    -> Si requiere utilizar varias clases, estas NO deben ser tipo public.
*/
class Reto3{

    /**
    *  Este debe ser el único objeto de tipo Scanner en el código
    */
    private final Scanner scanner = new Scanner(System.in);

    /**
    * Este método es usado para solicitar datos al usuario
    * @return  Lectura de la siguiente linea del teclado
    */
    public String read(){
        return this.scanner.nextLine();
    }

    /**
    * método principal
    */
 public void run() {

        BaseDP listDP = new BaseDP();
        String option = read();
        String [] datos = read().split(" ");
        int code = Integer.parseInt(datos[0]);
        String name = datos[1];
        double price = Double.parseDouble(datos[2]);
        int inventory = Integer.parseInt(datos[3]);

        if (option.toUpperCase().equals("AGREGAR")){
            listDP.agregar(code, name, price, inventory);
            
        }else{
            if(option.toUpperCase().equals("BORRAR")){
                listDP.borrar(code);
            }else{
                if (option.toUpperCase().equals("ACTUALIZAR")){
                    listDP.actualizar(code, name, price, inventory);
                }else{
                    System.out.println("ERROR");
                }
            }
        }          
    }
}
class BaseDP {
    private HashMap<String,Productos> listaProductos;
public BaseDP() {
    this.listaProductos = new HashMap<String,Productos>();
    listaProductos.put("1", new Productos("Naranjas", 7000.0,35 ));
    listaProductos.put("2", new Productos("Limones", 2500.0, 15 ));
    listaProductos.put("3", new Productos("Peras", 	2700.0, 65 ));
    listaProductos.put("4", new Productos("Arandanos", 9300.0, 34 ));
    listaProductos.put("5", new Productos("Tomates", 2100.0, 42 ));
    listaProductos.put("6", new Productos("Fresas", 9100.0, 20 ));
    listaProductos.put("7", new Productos("Helado", 4500.0, 41 ));
    listaProductos.put("8", new Productos("Galletas", 500.0, 8 ));
    listaProductos.put("9", new Productos("Chocolates", 4500.0, 80 ));
    listaProductos.put("10", new Productos("Jamon", 17000.0,48 ));
    
}

public void agregar(int code, String name, double price, int inventory){
    if (!verExis(code)){
        Productos new_product = new Productos(name, price, inventory);
        listaProductos.put(String.valueOf(code), new_product);
        genInforme();
    }else {System.out.println("ERROR");}
}
public void actualizar(int code, String name, double price, int inventory){
    if (verExis(code)){
        Productos new_product = new Productos(name, price, inventory);
        listaProductos.put(String.valueOf(code), new_product);
        genInforme();
    }else {System.out.println("ERROR");}
}
public void borrar(int code){
    if (verExis(code)){
        listaProductos.remove(String.valueOf(code));
        genInforme();
    }else{System.out.println("ERROR");}
}
public void genInforme(){
        String higher_price_one ="";
        String higher_price_two ="";
        String higher_price_three ="";
        double priceMayor_one=0;
        double priceMayor_two=0;
        double priceMayor_three=0;
    
        for (String key: listaProductos.keySet()){
            if (listaProductos.get(key).getPrecio()>priceMayor_one){
                priceMayor_one=listaProductos.get(key).getPrecio();
                higher_price_one = listaProductos.get(key).getNombre();
            }
        }
        for (String key: listaProductos.keySet()){
            if (listaProductos.get(key).getPrecio()>priceMayor_two && listaProductos.get(key).getPrecio()<priceMayor_one){
                priceMayor_two=listaProductos.get(key).getPrecio();
                higher_price_two= listaProductos.get(key).getNombre();
            }
        }
        for (String key: listaProductos.keySet()){
            if (listaProductos.get(key).getPrecio()>priceMayor_three && listaProductos.get(key).getPrecio()<priceMayor_two){
                priceMayor_three = listaProductos.get(key).getPrecio();
                higher_price_three= listaProductos.get(key).getNombre();
            }
        }
        System.out.println(higher_price_one+" "+higher_price_two+" "+higher_price_three);
}
public Boolean verExis(int code){

    boolean band = false;
    Object[] keys = listaProductos.keySet().toArray();
    for (int i = 0; i < keys.length; i++) {
        if (keys[i].equals(String.valueOf(code))){
            band=true;        
        }
    }
    return band;   
}
}

class Productos {
    private String nombre;
    private double precio; 
    private int inventario;
   public Productos(String nombre, Double precio, int inventario) {
       this.nombre = nombre;
       this.precio = precio;
       this.inventario = inventario;
   }

   public String getNombre() {
       return nombre;
   }
   public void setNombre(String nombre) {
       this.nombre = nombre;
   }
   public double getPrecio() {
       return precio;
   }
   public void setPrecio(float precio) {
       this.precio = precio;
   }
   public int getInventario() {
       return inventario;
   }
   public void setInventario(int inventario) {
       this.inventario = inventario;
   }
}