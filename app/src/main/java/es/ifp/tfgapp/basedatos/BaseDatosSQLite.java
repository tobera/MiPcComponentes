package es.ifp.tfgapp.basedatos;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class BaseDatosSQLite extends SQLiteOpenHelper {
    protected SQLiteDatabase baseDatos;

    public BaseDatosSQLite(Context context) {
        super(context, "Componentes", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase baseDatos) {

        baseDatos.execSQL("CREATE table procesadores (id integer primary key autoincrement not null,rango int,marca text,modelo text,precio int, descripcion text)");
        baseDatos.execSQL("CREATE table placasbase (id integer primary key autoincrement not null,rango int,marca text,modelo text,precio int, descripcion text, marcaCompatible text)");
        baseDatos.execSQL("CREATE table discosduros (id integer primary key autoincrement not null,rango int,tipo text,marca text,modelo text,precio int, descripcion text)");
        baseDatos.execSQL("CREATE table tarjetasgraficas (id integer primary key autoincrement not null,rango int,fabricante text,marca text,modelo text,precio int, descripcion text)");
        baseDatos.execSQL("CREATE table memoriasram (id integer primary key autoincrement not null,rango int,marca text,modelo text,precio int, descripcion text)");
        baseDatos.execSQL("CREATE table fuentesalimentacion (id integer primary key autoincrement not null,rango int,marca text,modelo text,precio int, descripcion text)");
        baseDatos.execSQL("CREATE table refrigeraciones (id integer primary key autoincrement not null,rango int,tipo text,marca text,modelo text,precio int, descripcion text)");
        baseDatos.execSQL("CREATE table cajas (id integer primary key autoincrement not null,rango int,marca text,modelo text,precio int, descripcion text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        baseDatos.execSQL("DROP TABLE IF EXISTS procesadores");
        baseDatos.execSQL("DROP TABLE IF EXISTS placasbase");
        baseDatos.execSQL("DROP TABLE IF EXISTS discosduros");
        baseDatos.execSQL("DROP TABLE IF EXISTS tarjetasgraficas");
        baseDatos.execSQL("DROP TABLE IF EXISTS memoriasram");
        baseDatos.execSQL("DROP TABLE IF EXISTS fuentesalimentacion");
        baseDatos.execSQL("DROP TABLE IF EXISTS refrigeraciones");
        baseDatos.execSQL("DROP TABLE IF EXISTS cajas");
    }

    public void insertarProcesadores() {
        baseDatos = this.getReadableDatabase();
        //GAMMA BAJA INTEL
        baseDatos.execSQL("INSERT INTO `procesadores` (`rango`,`marca`, `modelo`,`precio`,`descripcion`) VALUES ( 1,'INTEL', 'Intel Core i3-9100F',120,'Procesador de 4 nucleos, con frecuencias maximas de 4,2 GHz compatible con Socket LGA 1151. No incluye grafica integrada. Perfecto para tareas de ofimatica y reproduccion de multimedia. Tambien encaja en presupuestos gaming de gama media y gama baja. '), ( 1,'INTEL', 'Intel Core i3-10100F',80,'Procesador de 4 nucleos, con frecuencias maximas hasta 4,3 GHz, compatible con Socket LGA 1200. No incluye grafica integrada. Perfecto para tareas de ofimatica y reproduccion de multimedia. Tambien encaja en presupuestos gaming de gama media y gama baja. Es ligeramente superior al i3-9100F'),(1,'INTEL','Intel Core i3-10105',115,'Procesador de 4 nucleos, con frecuencias maximas de 4,4 GHz, compatible con Socket LGA 1200. Perfecto para tareas de ofimatica y reproduccion de multimedia. Tambien encaja en presupuestos gaming de gama media y gama baja. Es ligeramente superior en rendimiento al i3-10100F.'), (1,'INTEL','Intel Core i3-12100',140,'Tiene 4 Nucleos con una frecuencia maxima de hasta 4,3 Ghz. Presenta la nueva arquitectura de Intel de 14 nanometros compatible con Socket LGA 1700. Perfecto para tareas de ofimatica y reproduccion de multimedia. Tambien encaja en presupuestos gaming de gama media y gama baja. Es ligeramente superior en rendimiento al i3-10105.'),(1,'INTEL','Intel Core i3-12100F',110,'Presenta 4 nucleos con frecuencias maximas de hasta 4,3 Ghz. Utiliza la nueva arquitectura de Intel de 14 nanometros, compatible con Socket LGA 1700. No tiene grafica integrada. Es ideal para tareas de ofimatica y reproduccion de multimedia. Tambien puede encajar en presupuestos gaming de gama media y gama baja. Su rendimiento es algo superior al i3-11400.');");
        //GAMMA MEDIA INTEL
        baseDatos.execSQL("INSERT INTO `procesadores` (`rango`,`marca`, `modelo`,`precio`,`descripcion`) VALUES (2,'INTEL','Intel Core i5-11400F',140,'Procesador de 6 nucleos, con frecuencias maximas de 4,4 Ghz compatible con Socket LGA 1200. No incluye grafica integrada. Presenta un rendimiento ideal para presupuestos gaming de gama media y para tareas de edicion de multimedia sencillas.' ),( 2,'INTEL', 'Intel Core i5-12400',180,'Procesador de 6 nucleos, con frecuencias maximas de 4,4 Ghz compatible con Socket LGA 1700. Presenta un rendimiento ideal para presupuestos gaming de gama media y para tareas de edicion de multimedia sencillas. Es ligeramente superior en rendimiento al i5-11400.'), ( 2,'INTEL', 'Intel Core i5-12600',250,'Procesador de 6 nucleos, con frecuencias maximas de 4,8 Ghz compatible con Socket LGA 1700. Presenta un rendimiento ideal para presupuestos gaming de gama media y para tareas de edicion de multimedia sencillas. Su rendimiento es superior al i5-12400'),(2,'INTEL','Intel Core i5-12600K',280,'Procesador de 10 nucleos (6 Performance-cores y 4 Efficient-cores), con frecuencias maximas de 4,9 Ghz (Performance-cores) y 3,6 Ghz (Efficient-cores), compatible con Socket LGA 1700. Permite realizar overclock. Presenta un rendimiento ideal para presupuestos gaming de gama media y alta y para tareas de edicion de multimedia. Es superior en rendimiento al i5-12600'),(2,'INTEL','Intel Core i5-12600KF',290,'Procesador de 10 nucleos (6 Performance-cores y 4 Efficient-cores), con frecuencias maximas de 4,9 Ghz (Performance-cores) y 3,6 Ghz (Efficient-cores), compatible con Socket LGA 1700. Permite realizar overclock. No tiene grafica integrada. Presenta un rendimiento ideal para presupuestos gaming de gama media y alta y para tareas de edicion de multimedia. Es superior en rendimiento al i5-12600.');");
        //GAMMA ALTA INTEL
        baseDatos.execSQL("INSERT INTO `procesadores` (`rango`,`marca`, `modelo`,`precio`,`descripcion`) VALUES (3,'INTEL','Intel Core i7-11700KF',310,'Procesador de 8 nucleos, con frecuencias maximas de 5 Ghz compatible con Socket LGA 1200. No incluye grafica integrada. Presenta un gran rendimiento tanto en gaming como en tareas de compresion y descompresion de archivos y edicion de videos.'),(3, 'INTEL', 'Intel Core i7-12700',380,'Procesador de 12 nucleos (8 Performance-cores y 4 Efficient-cores), con frecuencias maximas de 4,9 Ghz (Performance-cores) y 3,6 Ghz (Efficient-cores). Compatible con Socket LGA 1700. Presenta un gran rendimiento tanto en gaming como en tareas de compresion y descompresion de archivos y edicion de videos.') ,( 3,'INTEL', 'Intel Core i7-12700K',410,'Procesador de 12 nucleos (8 Performance-cores y 4 Efficient-cores), con frecuencias maximas de 5,0 Ghz (Performance-cores) y 3,8 Ghz (Efficient-cores). Compatible con Socket LGA 1700.Permite hacer overclock. Presenta un gran rendimiento tanto en gaming como en tareas de compresion y descompresion de archivos y edicion de videos.'), (3,'INTEL','Intel Core i9-12900K',610,'Procesador de 16 nucleos (8 Performance-cores y 8 Efficient-cores), con frecuencias maximas de 5,2 Ghz (Performance-cores) y 3,9 Ghz (Efficient-cores). Compatible con Socket LGA 1700. Presenta un espectacular rendimiento tanto en gaming como en tareas de compresion y descompresion de archivos y edicion de videos.'),(3,'INTEL','Intel Core i9-12900KS',790,'Procesador de 16 nucleos (8 Performance-cores y 8 Efficient-cores), con frecuencias maximas de 5,5 Ghz (Performance-cores) y 4,0 Ghz (Efficient-cores). Compatible con Socket LGA 1700. Presenta un mayor consumo respecto a su version K. Presenta un espectacular rendimiento tanto en gaming como en tareas de compresion y descompresion de archivos y edicion de videos.');");
        //GAMMA BAJA AMD
        baseDatos.execSQL("INSERT INTO `procesadores` (`rango`,`marca`, `modelo`,`precio`,`descripcion`) VALUES ( 1,'AMD', 'AMD Ryzen 3 4100',100,'Procesador de 4 nucleos, con frecuencias maximas de 4,0 Ghz, compatible con Socket AM4. No incluye grafica integrada. Perfecto para tareas de ofimatica y reproduccion de multimedia.'), ( 1,'AMD', 'AMD Ryzen 5 2600',160,'Procesador de 6 nucleos con una frecuencia maxima de 3,9 Ghz.Compatible con Socket AM4. No incluye grafica integrada. Perfecto para tareas de ofimatica y reproduccion de multimedia.'), (1,'AMD','AMD Ryzen 5 2600X',180,'Procesador de 6 nucleos con una frecuencia maxima de 4,2 Ghz.Compatible con Socket AM4. No incluye grafica integrada. Permite hacer overclock. Perfecto para tareas de ofimatica y reproduccion de multimedia. Tambien presenta un buen rendimiento en render 3D por lo que se puede utilizar para gaming en calidades bajas.'),(1,'AMD','AMD Ryzen 5 3600',200,'Procesador de 6 nucleos con una frecuencia maxima de 4,2 Ghz.Compatible con Socket AM4. No incluye grafica integrada. Perfecto para tareas de ofimatica y reproduccion de multimedia.Tambien presenta un buen rendimiento en render 3D por lo que se puede utilizar para gaming en calidades bajas.'),(1,'AMD','AMD Ryzen 5 3600X',220,'Procesador de 6 nucleos con una frecuencia maxima de 4,4 Ghz.Compatible con Socket AM4. No incluye grafica integrada. Permite hacer overclock. Perfecto para tareas de ofimatica y reproduccion de multimedia.Tambien presenta un buen rendimiento en render 3D por lo que se puede utilizar para gaming en calidades bajas.');");
        //GAMMA MEDIA AMD
        baseDatos.execSQL("INSERT INTO `procesadores` (`rango`,`marca`, `modelo`,`precio`,`descripcion`) VALUES ( 2,'AMD', 'AMD Ryzen 5 3600XT',290,'Procesador de 6 nucleos, con frecuencias maximas de 4,5 Ghz, compatible con Socket AM4. No incluye grafica integrada.Permite hacer Overclock. Presenta un gran rendimiento en gaming y en tareas de rendimiento mono y multi nucleo.'), ( 2,'AMD', 'AMD Ryzen 7 3700X',300,'Procesador de 8 nucleos, con frecuencias maximas de 4,4 Ghz, compatible con Socket AM4. No incluye grafica integrada.Permite hacer Overclock. Presenta un gran rendimiento en gaming y en tareas de rendimiento mono y multi nucleo.'), (2,'AMD','AMD Ryzen 5 5600',220,'Procesador de 6 nucleos, con frecuencias maximas de 4,4 Ghz, compatible con Socket AM4. No incluye grafica integrada. Presenta un gran rendimiento en gaming y en tareas de rendimiento mono y multi nucleo.'),(2,'AMD','AMD Ryzen 5 5600X',240,'Procesador de 6 nucleos, con frecuencias maximas de 4,4 Ghz, compatible con Socket AM4. No incluye grafica integrada.Permite hacer Overclock. Presenta un gran rendimiento en gaming y en tareas de rendimiento mono y multi nucleo.'),(2,'AMD','AMD Ryzen 7 5700X',320,'Procesador de 8 nucleos, con frecuencias maximas de 4,6 Ghz, compatible con Socket AM4. No incluye grafica integrada.Permite hacer Overclock. Presenta un gran rendimiento en gaming y en tareas de rendimiento mono y multi nucleo.');");
        //GAMMA ALTA AMD
        baseDatos.execSQL("INSERT INTO `procesadores` (`rango`,`marca`, `modelo`,`precio`,`descripcion`) VALUES (3,'AMD','AMD Ryzen 7 5800',300,'Procesador de 8 nucleos, con frecuencias maximas de 4,6 Ghz, compatible con Socket AM4. No incluye grafica integrada.Presenta un gran rendimiento en gaming y en tareas de rendimiento mono y multi nucleo.'),( 3,'AMD', 'AMD Ryzen 7 5800X',340,'Procesador de 8 nucleos, con frecuencias maximas de 4,7 Ghz, compatible con Socket AM4. No incluye grafica integrada.Permite hacer Overclock. Presenta un increible rendimiento en gaming y en tareas renderizado y edificion de videos y contenido 3D.'), ( 3,'AMD', 'AMD Ryzen 9 5900X',440,'Procesador de 12 nucleos, con frecuencias maximas de 4,8 Ghz, compatible con Socket AM4. No incluye grafica integrada.Permite hacer Overclock. Presenta un espectacular rendimiento  en gaming y en tareas de rendimiento mono y multi nucleo.'), (3,'AMD','AMD Ryzen 9 5950X',620,'Procesador de 16 nucleos, con frecuencias maximas de 4,9 Ghz, compatible con Socket AM4. No incluye grafica integrada.Permite hacer Overclock. Presenta un increible rendimiento en gaming y en tareas de rendimiento mono y multi nucleo. Ideal para edicion de videos en alta calidad y aplicacion de renderizado en 3D'),(3,'AMD','AMD Ryzen Threadripper 3960X',1920,'Procesador de 24 nucleos, con frecuencias maximas de 4,5 Ghz, compatible con Socket TRX4. No incluye grafica integrada.Permite hacer Overclock. Presenta un rendimiento unico en renderizado de texturas, y videos en calidad extrema. Ideal para profesionales del sector de edicion tanto de video como 3D.');");
    }

    public void insertarPlacasBase() {
        //GAMMA BAJA INTEL
        baseDatos.execSQL("INSERT INTO `placasbase` (`rango`,`marca`, `modelo`,`precio`,`descripcion`,`marcaCompatible`) VALUES (1,'ASRock','H310CM-HDV/M.2',80,'Formato Micro ATX. Socket LGA 1151. Soporte de Memoria de hasta 2666 Mhz (2 RANURAS). 2 conectores para ventiladores. Conexion Ethernet','INTEL'),(1, 'MSI', 'H510M',70,'Formato Micro ATX. Socket LGA 1200. Soporte de Memoria de hasta 3200 Mhz (2 RANURAS). 3 conectores para ventiladores. Conexion Ethernet.Conexion M.2 de 32 Gbps','INTEL'), (1, 'Asus', 'Prime H410M-K R2.0',70,'Formato Micro ATX. Socket LGA 1200. Soporte de Memoria de hasta 2933 Mhz (2 RANURAS). 2 conectores para ventiladores. Conexion Ethernet. Conexion M.2 de 32 Gbps','INTEL'),(1,'Asus','Prime H610M-K D4',94,'Formato Micro ATX. Socket LGA 1700. Soporte de Memoria de hasta 3200 Mhz (4 RANURAS). 1 conector para ventilador. Conexion Ethernet.Conexion M.2 de 32 Gbps','INTEL'),(1,'MSI ','PRO B660M-B DDR4',120,'Formato Micro ATX. Socket LGA 1700. Soporte de Memoria de hasta 4600 Mhz (2 RANURAS). 2 conectores para ventiladores. Conexion Ethernet.Conexion M.2 de 32 Gbps con disipador.','INTEL')");
        //GAMMA MEDIA INTEL
        baseDatos.execSQL("INSERT INTO `placasbase` (`rango`,`marca`, `modelo`,`precio`,`descripcion`,`marcaCompatible`) VALUES (2,'MSI','MPG B560I GAMING EDGE WIFI SOCKET 1200',160,'Formato Micro ATX. Socket LGA 1200. Soporte de Memoria de hasta 3200 Mhz (2 RANURAS). 3 conectores para ventiladores. Conexion Inalambrica con Antenas + Ethernet. 2 Ranuras de Conexion M.2 de 32 Gbps con disipador. Soporte de diversas tecnologias de RGB','INTEL'),(2, 'Asus', 'Prime B660M-A WIFI D4',160,'Formato Micro ATX. Socket LGA 1700. Soporte de Memoria de hasta 5333 Mhz (4 RANURAS). 2 conectores para ventiladores.Conexion Inalambrica con Antenas + Ethernet. 2 Ranuras de Conexion M.2 de 32 Gbps con disipador uno de ellos. Soporte de diversas tecnologias de RGB.','INTEL'), (2, 'MSI', 'MAG B660M BAZOOKA DDR4',170,'Formato Micro ATX. Socket LGA 1700. Soporte de Memoria de hasta 4800 Mhz (4 RANURAS). 4 conectores para ventiladores.Conexion Ethernet. 2 Ranuras de Conexion M.2 de 32 Gbps con disipador uno de ellos. Soporte de diversas tecnologias de RGB.','INTEL'),(2,'Asrock','B660 Steel Legend',185,'Formato ATX. Socket LGA 1700. Soporte de Memoria de hasta 5333+ Mhz (4 RANURAS). 3 conectores para ventiladores.Conexion Ethernet. 2 Ranuras de Conexion M.2 de 32 Gbps con disipador uno de ellos. Soporte de diversas tecnologias de RGB.','INTEL'),(2,'Asus ','TUF GAMING B660-PLUS WIFI D4',170,'Formato ATX. Socket LGA 1700. Soporte de Memoria de hasta 5333 Mhz (4 RANURAS). 2 conectores para ventiladores.Conexion Inalambrica con Antenas + Ethernet. 2 Ranuras de Conexion M.2 de 32 Gbps con disipador uno de ellos. Soporte de diversas tecnologias de RGB.','INTEL')");
        //GAMMA ALTA INTEL
        baseDatos.execSQL("INSERT INTO `placasbase` (`rango`,`marca`, `modelo`,`precio`,`descripcion`,`marcaCompatible`) VALUES (3,'AsRock','Z590 PG Velocita Socket 1200',290,'Formato ATX. Socket LGA 1200. Soporte de Memoria de hasta 4800 Mhz (4 RANURAS). 5 conectores para ventiladores.Conexion Ethernet. 3 Ranuras de Conexion M.2. Soporte de diversas tecnologias de RGB. Modulo de VRMs excelente para hacer Overclock de forma segura.','INTEL'),(3, 'Gigabyte', 'B660I AORUS PRO DDR4',230,'Formato Micro ATX. Socket LGA 1700. Soporte de Memoria de hasta 5333 Mhz (2 RANURAS). 1 conector para ventiladores.Conexion Inalambrica (no Incluye las antenas)+ Ethernet. 1 Ranuras de Conexion M.2 de 32 Gbps con disipador. Soporte de diversas tecnologias de RGB.','INTEL'), (3, 'MSI', 'MPG Z690 CARBON WIFI',460,'Formato ATX. Socket LGA 1700. Soporte de Memoria de hasta 6666+ Mhz (4 RANURAS). 4 conectores para ventiladores.Conexion Inalambrica con Antenas + Ethernet. 5 Ranuras de Conexion M.2 con disipador. Soporte de diversas tecnologias de RGB. Incluye un gran modulo VRM para hacer Overclock con seguridad.','INTEL'),(3,'Asus','B660 Steel Legend',185,'Formato ATX. Socket LGA 1700. Soporte de Memoria de hasta 5333+ Mhz (4 RANURAS). 3 conectores para ventiladores.Conexion Ethernet. 2 Ranuras de Conexion M.2 de 32 Gbps con disipador uno de ellos. Soporte de diversas tecnologias de RGB.','INTEL'),(3,'MSI ','MEG Z690 GODLIKE Gaming',2200,'Formato E-ATX. Socket LGA 1700. Soporte de Memoria de hasta 6666+ Mhz (4 RANURAS). 8 conectores para ventiladores.Conexion Wireless + Ethernet. 6 Ranuras de Conexion M.2 PCIe 4.0. Solucion termica definitiva para VRMs, incluye una pantalla LCD IPS.','INTEL')");
        //GAMMA BAJA AMD
        baseDatos.execSQL("INSERT INTO `placasbase` (`rango`,`marca`, `modelo`,`precio`,`descripcion`,`marcaCompatible`) VALUES (1, 'Gigabyte', 'B450M S2H',60,'Formato Micro ATX. Socket AM4 . Soporte de Memoria de hasta 3200 Mhz (2 RANURAS). 2 conectores para ventiladores. Conexion Ethernet','AMD'), (1, 'MSI', 'A520M-A PRO',60,'Formato Micro ATX. Socket AM4. Soporte de Memoria de hasta 4600 Mhz (2 RANURAS). 2 conectores para ventiladores. Conexion Ethernet. Conexion M.2 ','AMD'), (1,'Asrock','B450M-HDV R4.0',65,'Formato Micro ATX. Socket AM4. Soporte de Memoria de hasta 3200 Mhz (2 RANURAS). 2 conectores para ventiladores. Conexion Ethernet. Conexion M.2','AMD'),(1,'MSI','B550M-A PRO',70,'Formato Micro ATX. Socket AM4. Soporte de Memoria de hasta 4600 Mhz (2 RANURAS). 2 conectores para ventiladores. Conexion Ethernet. Conexion M.2','AMD'),(1,'Asus','Prime B550M-A',100,'Formato Micro ATX. Socket LGA 1151. Soporte de Memoria de hasta 4600 Mhz (4 RANURAS). 2 conectores para ventiladores. Conexion Ethernet. Conexion M.2','AMD')");
        //GAMMA MEDIA AMD
        baseDatos.execSQL("INSERT INTO `placasbase` (`rango`,`marca`, `modelo`,`precio`,`descripcion`,`marcaCompatible`) VALUES (2, 'ASRock', 'B550M Pro4',112,'Formato Micro ATX. Socket AM4 . Soporte de Memoria de hasta 4733+ Mhz (4 RANURAS). 4 conectores para ventiladores. Conexion Ethernet. 2 Conexiones M.2 y cabezales con soporte para RGB y ARGB','AMD'), (2, 'ASRock', 'B550 Phantom Gaming 4',116,'Formato ATX. Socket AM4 . Soporte de Memoria de hasta 4533 Mhz (4 RANURAS). 4 conectores para ventiladores. Conexion Ethernet. 2 Conexiones M.2 y cabezales con soporte para RGB y ARGB','AMD'), (2,'Asus','ROG Strix B550-I Gaming',280,'Formato Micro ATX. Socket AM4 . Soporte de Memoria de hasta 5000 Mhz (4 RANURAS). 1 conector para ventiladores. Conexion Wireless + Ethernet. 1 Conexion M.2 y cabezales con soporte para RGB y ARGB','AMD'),(2,'Gigabyte','X570S UD',144,'Formato ATX. Socket AM4 . Soporte de Memoria de hasta 5100 Mhz (4 RANURAS). 3 conectores para ventiladores. Conexion Ethernet. 3 Conexiones M.2 y cabezales con soporte para RGB y ARGB','AMD'),(2,'MSI','MPG X570 GAMING PLUS',210,'Formato ATX. Socket AM4 . Soporte de Memoria de hasta 5333 Mhz (4 RANURAS). 4 conectores para ventiladores. Conexion Ethernet. 2 Conexiones M.2 y cabezales con soporte para RGB y ARGB','AMD')");
        //GAMMA ALTA AMD
        baseDatos.execSQL("INSERT INTO `placasbase` (`rango`,`marca`, `modelo`,`precio`,`descripcion`,`marcaCompatible`) VALUES (3, 'Asus', 'ROG Crosshair VIII Impact',350,'Formato ATX. Socket AM4 . Soporte de Memoria de hasta 4800 Mhz (4 RANURAS). 3 conector para ventiladores. Wireless + Conexion Ethernet. 2 Conexiones M.2 con disipadores y cabezales con soporte para RGB y ARGB. Gran modulo de VRMs para hacer overclock con seguridad.','AMD'), (3, 'ASRock', 'X570 Taichi',390,'Formato ATX. Socket AM4 . Soporte de Memoria de hasta 4600+ Mhz (4 RANURAS). 4 conector para ventiladores. Wireless + Conexion Ethernet. 3 Conexiones M.2 con disipadores y cabezales con soporte para RGB y ARGB. Gran modulo de VRMs para hacer overclock con seguridad.','AMD'), (3,'Asus','ROG Crosshair VIII Dark Hero',400,'Formato ATX. Socket AM4 . Soporte de Memoria de hasta 4866 Mhz (4 RANURAS). 3 conector para ventiladores. Wireless + Conexion Ethernet. 2 Conexiones M.2 con disipadores y cabezales con soporte para RGB y ARGB. Gran modulo de VRMs para hacer overclock con seguridad.','AMD'),(3,'Gigabyte','X570 AORUS Xtreme',720,'Formato ATX. Socket AM4 . Soporte de Memoria de hasta 4400 Mhz (4 RANURAS). 4 conector para ventiladores. Wireless + Conexion Ethernet. 2 Conexiones M.2 con disipadores y cabezales con soporte para RGB y ARGB. Gran modulo de VRMs para hacer overclock con seguridad.Incluye botones de encendido y reset desde la placa.','AMD'),(3,'Gigabyte','TRX40 Aorus Master',580,'Formato ATX. Socket TRX4 . Soporte de Memoria de hasta 4400 Mhz (8 RANURAS). 6 conector para ventiladores. Wireless + Conexion Ethernet. 3 Conexiones M.2 con disipadores y cabezales con soporte para RGB y ARGB. Gran modulo de VRMs para hacer overclock con seguridad. Soporte para varias GPUs','AMD');");
    }

    public void insertarDiscosDuros() {
        //GAMA BAJA HDD
        baseDatos.execSQL("INSERT INTO `discosduros` (`rango`,`tipo`,`marca`, `modelo`,`precio`,`descripcion`) VALUES (1,'HDD','Toshiba','P300 1TB 7200RPM',33,'Ofrece 1TB de Almacenamiento, su velocidad de rotacion es de 7200 RPM.'), (1,'HDD','Western Digital','Blue 1TB',42,'Ofrece 1TB de Almacenamiento, su velocidad de rotacion es de 7200 RPM.'), (1,'HDD','Seagate','BarraCuda 1TB',42,'Ofrece 1TB de Almacenamiento, su velocidad de rotacion es de 7200 RPM.'),(1,'HDD','Seagate','Skyhawk Surveillance 1TB',42,'Ofrece 1TB de Almacenamiento, ofrece velocidades de hasta 180 MiB/s'),(1,'HDD','Western Digital','Purple 1TB',53,'Ofrece 1TB de Almacenamiento, su velocidad de rotacion es de 5400 RPM. Ofrece velocidades de transferencia de hasta 210 MiB/s')");
        //GAMMA MEDIA HDD
        baseDatos.execSQL("INSERT INTO `discosduros` (`rango`,`tipo`,`marca`, `modelo`,`precio`,`descripcion`) VALUES (2,'HDD','Seagate','IronWolf NAS 1TB',60,'Ofrece 1TB de Almacenamiento, su velocidad de rotacion es de 5900 RPM. Ofrece velocidades de hasta 180 MiB/s. Preparado especialmente para ser montado en sistemas de almacenamiento NAS'), (2,'HDD','Western Digital','NAS Red 1TB',63,'Ofrece 1TB de Almacenamiento, su velocidad de rotacion es de 5900 RPM. Ofrece velocidades de hasta 200 MiB/s. Preparado especialmente para ser montado en sistemas de almacenamiento NAS'), (2,'HDD','Western Digital','Purple 2TB',60,'Ofrece 2TB de Almacenamiento, su velocidad de rotacion es de 5900 RPM. Ofrece velocidades de hasta 190 MiB/s.'),(2,'HDD','Seagate','Skyhawk 2TB',82,'Ofrece 2TB de Almacenamiento, ofrece velocidades de hasta 180 MiB/s'),(2,'HDD','Western Digital','Black 1TB',42,'Ofrece 1TB de Almacenamiento, ofrece velocidades de hasta 300 MiB/s. Su velocidad de rotacion llega hasta 7200 RPM')");
        //GAMMA ALTA HDD
        baseDatos.execSQL("INSERT INTO `discosduros` (`rango`,`tipo`,`marca`, `modelo`,`precio`,`descripcion`) VALUES (3,'HDD','Western Digital','Purple 3TB',85,'Ofrece 3TB de Almacenamiento, su velocidad de rotacion es de 5900 RPM. Ofrece velocidades de hasta 190 MiB/s.'), (3,'HDD','Western Digital','Gold Enterprise Class 6TB',250,'Ofrece 6TB de Almacenamiento, su velocidad de rotacion es de 7200 RPM. Ofrece velocidades de hasta 255 MiB/s.'), (3,'HDD','Seagate','IronWolf 4TB',108,'Ofrece 4TB de Almacenamiento, su velocidad de rotacion es de 5900 RPM. Ofrece velocidades de hasta 180 MiB/s. Preparado especialmente para ser instalado en sistemas de almacenamiento NAS'),(3,'HDD','Seagate','Seagate Barracuda Compute 4TB',110,'Ofrece 4TB de Almacenamiento, su velocidad de rotacion es de 5400 RPM. Ofrece velocidades de hasta 180 MiB/s.'),(3,'HDD','Western Digital','Purple 6TB',184,'Ofrece 6TB de Almacenamiento, su velocidad de rotacion es de 5700 RPM. Ofrece velocidades de hasta 190 MiB/s.')");
        //GAMMA BAJA SSD
        baseDatos.execSQL("INSERT INTO `discosduros` (`rango`,`tipo`,`marca`, `modelo`,`precio`,`descripcion`) VALUES (1,'SSD','PNY','CS900 120GB',29,'Ofrece 120 GB de Almacenamiento, su velocidad de lectura/escritura es de 515MB/s y 490MB/s'), (1,'SSD','Kingston','A400 120GB',23,'Ofrece 120 GB de Almacenamiento, su velocidad de lectura/escritura es de 500MB/s y 320MB/s'), (1,'SSD','Intenso','Top 128GB',24,'Ofrece 128 GB de Almacenamiento, su velocidad de lectura/escritura es de 300MB/s y 520MB/s'),(1,'SSD','Patriot','P210 128GB',25,'Ofrece 120 GB de Almacenamiento, su velocidad de lectura/escritura es de 450MB/s y 430MB/s'),(1,'SSD','Gigabyte','120GB',28,'Ofrece 120 GB de Almacenamiento, su velocidad de lectura/escritura es de 500MB/s y 380MB/s')");
        //GAMMA MEDIA SSD
        baseDatos.execSQL("INSERT INTO `discosduros` (`rango`,`tipo`,`marca`, `modelo`,`precio`,`descripcion`) VALUES (2,'SSD','Crucial','BX500 480GB',55,'Ofrece 480 GB de Almacenamiento, su velocidad de lectura/escritura es de 540MB/s y 500MB/s'), (2,'SSD','GoodRam','CL100 480GB',59,'Ofrece 480 GB de Almacenamiento, su velocidad de lectura/escritura es de 540MB/s y 460MB/s'), (2,'SSD','Gigabyte','SSD 480GB',58,'Ofrece 480 GB de Almacenamiento, su velocidad de lectura/escritura es de 550MB/s y 480MB/s'),(2,'SSD','PNY','CS900 480GB',61,'Ofrece 480 GB de Almacenamiento, su velocidad de lectura/escritura es de 555MB/s y 470MB/s'),(2,'SSD','Samsung','870 EVO 500GB',78,'Ofrece 500 GB de Almacenamiento, su velocidad de lectura/escritura es de 560MB/s y 530MB/s')");
        //GAMMA ALTA SSD
        baseDatos.execSQL("INSERT INTO `discosduros` (`rango`,`tipo`,`marca`, `modelo`,`precio`,`descripcion`) VALUES (3,'SSD','Samsung','870 EVO 1TB',130,'Ofrece 1TB  de Almacenamiento, su velocidad de lectura/escritura es de 560MB/s y 530MB/s'), (3,'SSD','GoodRam','CX400 1TB',108,'Ofrece 1TB de Almacenamiento, su velocidad de lectura/escritura es de 550MB/s y 450MB/s'), (3,'SSD','Western Digital','3D Nand Blue 1TB',103,'Ofrece 1TB de Almacenamiento, su velocidad de lectura/escritura es de 550MB/s y 525MB/s'),(3,'SSD','HP','S700 1TB',139,'Ofrece 1TB de Almacenamiento, su velocidad de lectura/escritura es de 561MB/s y 523MB/s'),(3,'SSD','Kingston','KC600 1TB SSD',29,'Ofrece 1TB de Almacenamiento, su velocidad de lectura/escritura es de 550MB/s y 520MB/s')");
        //GAMMA BAJA M.2
        baseDatos.execSQL("INSERT INTO `discosduros` (`rango`,`tipo`,`marca`, `modelo`,`precio`,`descripcion`) VALUES (1,'M.2','Kingston','A400 240GB M.2',45,'Ofrece 240 GB de Almacenamiento, su velocidad de lectura/escritura es de 500MB/s y 350MB/s'), (1,'M.2','Emtec','Power Pro X300 128GB M.2',33,'Ofrece 128 GB de Almacenamiento, su velocidad de lectura/escritura es de 1500MB/s y 1500MB/s'), (1,'M.2','Gigabyte','128GB M.2',38,'Ofrece 128 GB de Almacenamiento, su velocidad de lectura/escritura es de 1550MB/s y 550MB/s'),(1,'M.2','PNY','CS900 250GB M.2',43,'Ofrece 250 GB de Almacenamiento, su velocidad de lectura/escritura es de 535MB/s y 500MB/s'),(1,'M.2','Samsung','860 EVO M.2 250GB',51,'Ofrece 250 GB de Almacenamiento, su velocidad de lectura/escritura es de 550MB/s y 520MB/s')");
        //GAMME MEDIA M.2
        baseDatos.execSQL("INSERT INTO `discosduros` (`rango`,`tipo`,`marca`, `modelo`,`precio`,`descripcion`) VALUES (2,'M.2','Samsung','980 500GB NVMe M.2',63,'Ofrece 500 GB de Almacenamiento, su velocidad de lectura/escritura es de 3100MB/s y 2600MB/s'), (2,'M.2','Western Digital','Black SN750 500GB',75,'Ofrece 500 GB de Almacenamiento, su velocidad de lectura/escritura es de 3600MB/s y 3000MB/s'), (2,'M.2','PNY','CS900 500GB M.2',58,'Ofrece 500 GB de Almacenamiento, su velocidad de lectura/escritura es de 550MB/s y 515MB/s'),(2,'M.2','MSI','Spatium M390 500GB M.2',77,'Ofrece 500 GB de Almacenamiento, su velocidad de lectura/escritura es de 3300MB/s y 2300MB/s'),(2,'M.2','Corsair','Force MP510 500GB NVMe M.2',88,'Ofrece 500 GB de Almacenamiento, su velocidad de lectura/escritura es de 3480MB/s y 2000MB/s')");
        //GAMMA ALTA M.2
        baseDatos.execSQL("INSERT INTO `discosduros` (`rango`,`tipo`,`marca`, `modelo`,`precio`,`descripcion`) VALUES (3,'M.2','Gigabyte','Aorus NVMe Gen4 1TB M.2',135,'Ofrece 1TB de Almacenamiento, su velocidad de lectura/escritura es de 500MB/s y 4400MB/s'), (3,'M.2','Corsair','Force Series MP600 1TB M.2',153,'Ofrece 1TB de Almacenamiento, su velocidad de lectura/escritura es de 4950MB/s y 4250MB/s'), (3,'M.2','Western Digital','Black SN750 1TB NVMe M.2',124,'Ofrece 1 TB de Almacenamiento, su velocidad de lectura/escritura es de 3600MB/s y 3600MB/s'),(3,'M.2','Adata','SwordFish 1TB NVMe M.2',111,'Ofrece 120 GB de Almacenamiento, su velocidad de lectura/escritura es de 1800MB/s y 1400MB/s'),(3,'M.2','Corsair','P5 1TB NVMe M.2',142,'Ofrece 1 TB de Almacenamiento, su velocidad de lectura/escritura es de 3400MB/s y 3000MB/s')");
    }

    public void insertarTarjetasGraficas() {
        //GAMMA BAJA AMD
        baseDatos.execSQL("INSERT INTO `tarjetasgraficas` (`rango`,`fabricante`,`marca`, `modelo`,`precio`,`descripcion`) VALUES (1,'AMD','MSI','Radeon RX 6400 AERO',195,'Tiene 768 Cuda Cores. Ofrece frecuencias de hasta 2320 Mhz. Tiene 4GB de memoria VRAM GDDR6. Tiene un solo ventilador.'), (1,'AMD','MSI','Radeon RX 6500XT MECH',270,'Tiene 1024 Cuda Cores. Ofrece frecuencias de hasta 2825 Mhz. Tiene 4GB de memoria VRAM GDDR6. Tiene dos ventiladores.'), (1,'AMD','Gigabyte','Radeon RX 6500 XT EAGLE',329,'Tiene 1024 Cuda Cores. Ofrece frecuencias de hasta 2815 Mhz. Tiene 4GB de memoria VRAM GDDR6. Tiene dos ventiladores.'),(1,'AMD','Gigabyte','Radeon RX 6500 XT GAMING OC',350,'Tiene 1024 Cuda Cores. Ofrece frecuencias de hasta 2825 Mhz. Tiene 4GB de memoria VRAM GDDR6. Tiene tres ventiladores.'),(1,'AMD','ASRock','Radeon RX 6400 Challenger ITX',300,'Tiene 768 Cuda Cores. Ofrece frecuencias de hasta 2320 Mhz. Tiene 4GB de memoria VRAM GDDR6. Tiene un solo ventilador.')");
        //GAMMA MEDIA AMD
        baseDatos.execSQL("INSERT INTO `tarjetasgraficas` (`rango`,`fabricante`,`marca`, `modelo`,`precio`,`descripcion`) VALUES (2,'AMD','MSI','Radeon RX 6600 MECH',370,'Tiene 1792 Cuda Cores. Ofrece frecuencias de hasta 2491 Mhz. Tiene 8GB de memoria VRAM GDDR6. Tiene dos ventiladores.'), (2,'AMD','Sapphire','Nitro+ Radeon RX 6600XT',450,'Tiene 2048 Cuda Cores. Ofrece frecuencias de hasta 2610 Mhz. Tiene 8GB de memoria VRAM GDDR6. Tiene dos ventiladores.'), (2,'AMD','Asus','Dual Radeon RX 6600XT',470,'Tiene 2048 Cuda Cores. Ofrece frecuencias de hasta 2610 Mhz. Tiene 8GB de memoria VRAM GDDR6. Tiene dos ventiladores.'),(2,'AMD','Sapphire','Pulse Radeon RX 6600XT',600,'Tiene 2048 Cuda Cores. Ofrece frecuencias de hasta 2590 Mhz. Tiene 8GB de memoria VRAM GDDR6. Tiene dos ventiladores.'),(2,'AMD','Gigabyte','Radeon RX 6600XT',580,'Tiene 2048 Cuda Cores. Ofrece frecuencias de hasta 2610 Mhz. Tiene 8GB de memoria VRAM GDDR6. Tiene tres ventiladores.')");
        //GAMMA ALTA AMD
        baseDatos.execSQL("INSERT INTO `tarjetasgraficas` (`rango`,`fabricante`,`marca`, `modelo`,`precio`,`descripcion`) VALUES (3,'AMD','Asus','TUF Gaming Radeon RX 6700XT',920,'Tiene 2560 Cuda Cores. Ofrece frecuencias de hasta 2580 Mhz. Tiene 12GB de memoria VRAM GDDR6. Tiene tres ventiladores.'), (3,'AMD','Asus','TUF Radeon RX6800',1100,'Tiene 3840 Cuda Cores. Ofrece frecuencias de hasta 2190 Mhz. Tiene 16GB de memoria VRAM GDDR6. Tiene tres ventiladores.'), (3,'AMD','Gigabyte','AORUS Radeon RX 6800XT MASTER',1320,'Tiene 4608 Cuda Cores. Ofrece frecuencias de hasta 2250 Mhz. Tiene 16GB de memoria VRAM GDDR6. Tiene tres ventiladores.'),(3,'AMD','Sapphire','NITRO+ Radeon RX 6900XT',1100,'Tiene 5120 Cuda Cores. Ofrece frecuencias de hasta 2365 Mhz. Tiene 16GB de memoria VRAM GDDR6. Tiene tres ventiladores.'),(3,'AMD','PowerColor','RX 6900 XT Ultimate',1400,'Tiene 5120 Cuda Cores. Ofrece frecuencias de hasta 2425 Mhz. Tiene 16GB de memoria VRAM GDDR6. Tiene tres ventiladores.')");
        //GAMMA BAJA NVIDIA
        baseDatos.execSQL("INSERT INTO `tarjetasgraficas` (`rango`,`fabricante`,`marca`, `modelo`,`precio`,`descripcion`) VALUES (1,'NVIDIA','Zotac','GTX 1650',220,'Tiene 896 Cuda Cores. Ofrece frecuencias de hasta 1695 Mhz. Tiene 4GB de memoria VRAM GDDR5. Tiene un solo ventilador.'), (1,'NVIDIA','KFA2','GTX 1050 Ti',200,'Tiene 768 Cuda Cores. Ofrece frecuencias de hasta 1800 Mhz. Tiene 4GB de memoria VRAM GDDR5. Tiene dos ventiladores.'),(1,'NVIDIA','MSI','GTX 1650 D6 VENTUS XS',220,'Tiene 896 Cuda Cores. Ofrece frecuencias de hasta 1620 Mhz. Tiene 4GB de memoria VRAM GDDR5. Tiene dos ventiladores.'),(1,'NVIDIA','Asus','TUF Gaming GTX 1650',240,'Tiene 896 Cuda Cores. Ofrece frecuencias de hasta 1620 Mhz. Tiene 4GB de memoria VRAM GDDR5. Tiene dos ventiladores.'),(1,'NVIDIA','Zotac','RTX 3050 Twin Edge',275,'Tiene 2560 Cuda Cores. Ofrece frecuencias de hasta 1777 Mhz. Tiene 8GB de memoria VRAM GDDR6. Tiene dos ventiladores.')");
        //GAMMA MEDIA NVIDIA
        baseDatos.execSQL("INSERT INTO `tarjetasgraficas` (`rango`,`fabricante`,`marca`, `modelo`,`precio`,`descripcion`) VALUES (2,'NVIDIA','Asus','RTX 2060 EVO',430,'Tiene 2176 Cuda Cores. Ofrece frecuencias de hasta 1680 Mhz. Tiene 12GB de memoria VRAM GDDR6. Tiene dos ventiladores.'),(2,'NVIDIA','Gainward','RTX 3060 Ghost',430,'Tiene 3584 Cuda Cores. Ofrece frecuencias de hasta 1777 Mhz. Tiene 12GB de memoria VRAM GDDR6. Tiene dos ventiladores.'), (2,'NVIDIA','Inno3D','RTX 3060 Twin X2 LHR',530,'Tiene 3584 Cuda Cores. Ofrece frecuencias de hasta 1777 Mhz. Tiene 12GB de memoria VRAM GDDR6. Tiene dos ventiladores. Al ser la version LHR (Low-Hash-Rate) ofrece un rendimiento reducido en la mineria de criptos'),(2,'NVIDIA','Inno3D','RTX 3060 Ti TWIN X2 LHR',530,'Tiene 4864 Cuda Cores. Ofrece frecuencias de hasta 1665 Mhz. Tiene 8GB de memoria VRAM GDDR6. Tiene dos ventiladores. Al ser la version LHR (Low-Hash-Rate) ofrece un rendimiento reducido en la mineria de criptos'),(2,'NVIDIA','Asus','TUF RTX 3060 LHR V2',530,'Tiene 3584 Cuda Cores. Ofrece frecuencias de hasta 1852 Mhz. Tiene 12GB de memoria VRAM GDDR6. Tiene tres ventiladores. Al ser la version LHR (Low-Hash-Rate) ofrece un rendimiento reducido en la mineria de criptos')");
        //GAMMA ALTA NVIDIA
        baseDatos.execSQL("INSERT INTO `tarjetasgraficas` (`rango`,`fabricante`,`marca`, `modelo`,`precio`,`descripcion`) VALUES (3,'NVIDIA','Inno3D','RTX 3070 Twin X2',680,'Tiene 5888 Cuda Cores. Ofrece frecuencias de hasta 1740 Mhz. Tiene 8GB de memoria VRAM GDDR6X. Tiene dos ventiladores. Este modelo es una version LHR (Low-Hash-Rate) por lo que ofrece un rendimiento reducido en la mineria de criptos'),(3,'NVIDIA','Zotac','RTX 3070 Ti Trinity',800,'Tiene 6144 Cuda Cores. Ofrece frecuencias de hasta 1800 Mhz. Tiene 8GB de memoria VRAM GDDR6X. Tiene tres ventiladores. Es una version LHR (Low-Hash-Rate) por lo que ofrece un rendimiento reducido en la mineria de criptos'), (3,'NVIDIA','EVGA','RTX 3080 XC3 BLACK',1000,'Tiene 8704 Cuda Cores. Ofrece frecuencias de hasta 1800 Mhz. Tiene 10GB de memoria VRAM GDDR6X. Tiene tres ventiladores. Es una version LHR (Low-Hash-Rate) por lo que ofrece un rendimiento reducido en la mineria de criptos'),(3,'NVIDIA','MSI','RTX 3080 Ti VENTUS 3X',1560,'Tiene 10240 Cuda Cores. Ofrece frecuencias de hasta 1700 Mhz. Tiene 12GB de memoria VRAM GDDR6. Tiene tres ventiladores. Al ser la version LHR (Low-Hash-Rate) ofrece un rendimiento reducido en la mineria de criptos'),(3,'NVIDIA','Inno3D','RTX 3090 Ti X3 OC Gaming',2100,'Tiene 10752 Cuda Cores. Ofrece frecuencias de hasta 1890 Mhz. Tiene 24GB de memoria VRAM GDDR6X. Tiene tres ventiladores. Al ser la version LHR (Low-Hash-Rate) ofrece un rendimiento reducido en la mineria de criptos')");

    }

    public void insertarMemoriasRam() {

        //GAMMA BAJA
        baseDatos.execSQL("INSERT INTO `memoriasram` (`rango`,`marca`, `modelo`,`precio`,`descripcion`) VALUES (1,'Crucial','Ballistix Red 16GB (2x8GB) 3000Mhz',75,'Son 16GB GDDR4 con velocidades de 3000 Mhz y una latencia de CL16. Dual Channel'),(1,'Kingston','Fury Beast 16 GB (2X8GB) 3200Mhz',75,'Son 16GB GDDR4 con velocidades de 3200 Mhz y una latencia de CL16. Dual Channel'), (1,'Team Group Dark Z','Black 16 GB (2X8GB) 3200Mhz',70,'Son 16GB GDDR4 con velocidades de 3200 Mhz y una latencia de CL16. Dual Channel'),(1,'Corsair','Vengance LPX 16GB (2X8GB) 3200Mhz',73,'Son 16GB GDDR4 con velocidades de 3200 Mhz y una latencia de CL16. Dual Channel'),(1,'Adata','XPG Spectrix D60G 16(1X16GB) 3200Mhz',75,'Son 16GB GDDR4 con velocidades de 3000 Mhz y una latencia de CL16. Single channel')");
        //GAMMA MEDIA
        baseDatos.execSQL("INSERT INTO `memoriasram` (`rango`,`marca`, `modelo`,`precio`,`descripcion`) VALUES (2,'Corsair','Vengance RGB 32 GB (2X16GB) 3200Mhz',145,'Son 32GB GDDR4 con velocidades de 3200 Mhz y una latencia de CL16. Dual Channel'),(2,'Thermaltake','Toughram XG RGB 16GB (2X8GB) 4000Mhz',150,'Son 16GB GDDR4 con velocidades de 4000 Mhz y una latencia de CL18. Dual Channel'), (2,'G.Skill','Trident Z RGB 32GB (2X16GB) 3200Mhz',173,'Son 32GB GDDR4 con velocidades de 3200 Mhz y una latencia de CL16. Dual Channel'),(2,'Crucial','Ballistix RGB Red 32GB (2x16GB) 3200 MHz',157,'Son 32GB GDDR4 con velocidades de 3200 Mhz y una latencia de CL16. Dual Channel'),(2,'HyperX','Predator 16GB (2x8GB) 4000MHz',164,'Son 16GB GDDR4 con velocidades de 4000 Mhz y una latencia de CL19. Dual Channel')");
        //GAMMA ALTA
        baseDatos.execSQL("INSERT INTO `memoriasram` (`rango`,`marca`, `modelo`,`precio`,`descripcion`) VALUES (3,'Corsair','Dominator Platinum RGB 16GB (2x8GB) 4000Mhz',340,'Son 16GB GDDR4 con velocidades de 4000 Mhz y una latencia de CL18. Dual Channel'),(3,'Team Group','T-Force Xtreem ARGB White 64GB (2x32GB) 3600MHz',370,'Son 64GB GDDR4 con velocidades de 3600 Mhz y una latencia de CL18. Dual Channel'), (3,'G.Skill','Trident Z RGB 64GB (4x16GB) 3600 Mhz',460,'Son 64GB GDDR4 con velocidades de 3600 Mhz y una latencia de CL16. Double Dual Channel'),(3,'Corsair','Dominator Platinum 64GB (8x8GB) 4000 Mhz',1040,'Son 64GB GDDR4 con velocidades de 4000 Mhz y una latencia de CL19. 8 sticks de 8 GB cada uno'),(3,'G.Skill','Trident Z RGB 32GB (4x8GB) 4000 Mhz',470,'Son 32GB GDDR4 con velocidades de 4000 Mhz y una latencia de CL15. Double Dual Channel')");
    }

    public void insertarFuentesAlimentacion() {

        //GAMMA BAJA
        baseDatos.execSQL("INSERT INTO `fuentesalimentacion` (`rango`,`marca`, `modelo`,`precio`,`descripcion`) VALUES (1,'Cooler Master','MWE 750 Bronze V2 80 Plus Bronze 750W',62,'Ofrece una potencia maxima de hasta 750W, tiene certificacion 80 PLUS Bronze. No es modular'),(1,'Cougar','VTE 80 Plus Bronze 600W',55,'Ofrece una potencia maxima de hasta 600W, tiene certificacion 80 PLUS Bronze. No es modular'), (1,'Corsair','TX750M 750W Semi Modular',62,'Ofrece una potencia maxima de hasta 750W, tiene certificacion 80 PLUS Gold.Es Semi-modular'),(1,'Thermaltake','Hamburg Pro RGB 80 Plus Bronze 550W',62,'Ofrece una potencia maxima de hasta 550W, tiene certificacion 80 PLUS Bronze. No es modular'),(1,'EVGA','600 W 80 Plus 600W',62,'Ofrece una potencia maxima de hasta 6000W, tiene certificacion 80 PLUS (la mas baja) . No es modular')");
        //GAMMA MEDIA
        baseDatos.execSQL("INSERT INTO `fuentesalimentacion` (`rango`,`marca`, `modelo`,`precio`,`descripcion`) VALUES (2,'Asus','ROG Strix 750G 80 Plus Gold 750W Modular',165,'Ofrece una potencia maxima de hasta 750W, tiene certificacion 80 PLUS GOLD. Es completamente modular'),(2,'Cooler Master','V850 80 Plus Platinum 850W Modular',62,'Ofrece una potencia maxima de hasta 850W, tiene certificacion 80 PLUS Platinum. Es completamente modular'), (2,'NZXT','C850 80 Plus Gold 850W Modular',110,'Ofrece una potencia maxima de hasta 850W, tiene certificacion 80 PLUS GOLD.Es modular'),(2,'Corsair','RM750X White (2018) 80 Plus Gold 750W Modular',110,'Ofrece una potencia maxima de hasta 750W, tiene certificacion 80 PLUS GOLD. Es modular. Color blanco, version del 2018'),(2,'be quiet','Pure Power 11 CM 80 Plus Gold 700W Semi Modular',110,'Ofrece una potencia maxima de hasta 700W, tiene certificacion 80 PLUS GOLD. Es Semi-modular')");
        //GAMMA ALTA
        baseDatos.execSQL("INSERT INTO `fuentesalimentacion` (`rango`,`marca`, `modelo`,`precio`,`descripcion`) VALUES (3,'Cooler Master','V1000 80 Plus Platinum 1000W Modular',210,'Ofrece una potencia maxima de hasta 100W, tiene certificacion 80 PLUS Platinum.Es modular'),(3,'Asus','ROG Strix 850G White Edition 80 Plus Gold 850W',205,'Ofrece una potencia maxima de hasta 850W, tiene certificacion 80 PLUS GOLD. Es modular. Color completamente blanco'), (3,'Thermaltake','ToughPower DPS G 80 Plus Premium 1050W Modular',320,'Ofrece una potencia maxima de hasta 1050W, tiene certificacion 80 PLUS Platinum. Es completamente modular. Ofrece multitud de conectores para setup multi-gpu '),(3,'Asus','ROG Thor 1000P2 80 Plus Platinum 1000W Modular',365,'Ofrece una potencia maxima de hasta 1000W, tiene certificacion 80 PLUS Platinum. Es modular. Ofrece multitud de conectores para setup multi-gpu'),(3,'Asus','ROG Thor 850P 80 Plus Platinum 850W Modular',265,'Ofrece una potencia maxima de hasta 850W, tiene certificacion 80 PLUS Platinum. Es modular. Ofrece multitud de conectores para setup multi-gpu. Color negro mate.')");
    }

    public void insertarRefrigeraciones() {

        //GAMMA BAJA AIRE
        baseDatos.execSQL("INSERT INTO `refrigeraciones` (`rango`,`tipo`,`marca`, `modelo`,`precio`,`descripcion`) VALUES (1,'AIRE','Cooler Master','Hyper TX3 EVO',20,'Compatible con Socket Intel y AMD. Altura maxima de 136mm. Peso de 380 gramos. Presion del aire producido por el ventilador de entre 0.35 y 2.63 mmH2O'), (1,'AIRE','NOX','Hummer H-212',23,'Compatible con Socket Intel y AMD. Altura maxima de 140mm. Peso de 450 gramos. Flujo de aire del ventilador de 56 CFM'), (1,'AIRE','Antec','A40 Pro',25,'Compatible con Socket Intel y AMD. Altura maxima de 136mm. Peso de 570 gramos. Maximo flujo de aire producido por el ventilador es de 38 CFM'),(1,'AIRE','Raijintek','Leto LED RGB',29,'Compatible con Socket Intel y AMD. Altura maxima de 157mm. Peso de 650 gramos. Presion del aire producido por el ventilador de entre 0.35 y 1,2 mmH2O'),(1,'AIRE','DeepCool','Gammaxx GT ARGB',35,'Compatible con Socket Intel y AMD. Altura maxima de 158mm. Peso de 680 gramos. Presion del aire producido por el ventilador de entre 0.35 y 2.1 mmH2O. Maximo flujo de aire es de 64,5 CFM')");
        //GAMMA MEDIA AIRE
        baseDatos.execSQL("INSERT INTO `refrigeraciones` (`rango`,`tipo`,`marca`, `modelo`,`precio`,`descripcion`) VALUES (2,'AIRE','Cryorig','H7 Plus CPU',48,'Compatible con Socket Intel y AMD. Altura maxima de 145mm. Peso de 845 gramos. Presion del aire producido por el ventilador de entre 0.35 y 1,65 mmH2O. Incluye 2 ventiladores para montar un sistema push-pull mejorando el rendimiento'), (2,'AIRE','DeepCool','Neptwin RGB',50,'Compatible con Socket Intel y AMD. Altura maxima de 158mm. Peso de 1123 gramos. Presion del aire producido por el ventilador de entre 0.35 y 1.66 mmH2O. Maximo flujo de aire del ventilador es de 56.5 CFM. Incluye dos ventiladores para montaje de sistema push-pull mejorando el rendimiento.'), (2,'AIRE','Scythe','Mugen 5 Rev.B',60,'Compatible con Socket Intel y AMD. Altura maxima de 120mm. Peso de 890 gramos. Presion del aire producido por el ventilador de entre 0.076 y 1.05 mmH2O. Maximo flujo de aire del ventilador es de 52 CFM.'),(2,'AIRE','Cooler Master','MasterAir MA612 Stealth',57,'Compatible con Socket Intel y AMD. Altura maxima de 158mm. Peso de 900 gramos. Presion del aire producido por el ventilador de entre 0.35 y 2.52 mmH2O. Maximo flujo de aire producido por el ventilador es de 62 CFM'),(2,'AIRE','Arctic','Freezer 50 TR ARGB',68,'Compatible con Socket Intel y AMD. Altura maxima de 165mm. Peso de 1250 gramos. Presion del aire producido por el ventilador de entre 0.35 y 1.5 mmH2O. Incluye dos ventiladores para montar un sistema push-pull mejorando asi el rendimiento')");
        //GAMMA ALTA AIRE
        baseDatos.execSQL("INSERT INTO `refrigeraciones` (`rango`,`tipo`,`marca`, `modelo`,`precio`,`descripcion`) VALUES (3,'AIRE','Cooler Master','MasterAir MA620P RGB',80,'Compatible con Socket Intel y AMD. Altura maxima de 158mm. Peso de 850 gramos. Presion del aire producido por el ventilador de entre 0.35 y 1.65 mmH2O. Maximo flujo de aire producido por el ventilador es de 53.4 CFM. Incluye dos ventiladores para montar un sistema push-pull mejorando asi el rendimiento.'), (3,'AIRE','DeepCool','GamerStorm Fryzen',85,'Compatible con Socket Intel y AMD. Altura maxima de 164mm. Peso de 1190 gramos. Maximo flujo de aire producido por el ventilador es de hasta 64 CFM'), (3,'AIRE','Gigabyte','AORUS ATC800 RGB',87,'Compatible con Socket Intel y AMD. Altura maxima de 163mm. Peso de 1000 gramos. Presion del aire producido por el ventilador de entre 0.18 y 2 mmH2O. Maximo flujo de aire del ventilador es de 52 CFM. Incluye dos ventiladores (push-pull)'),(3,'AIRE','be quiet','Dark Rock Pro TR4 Negro',20,'Compatible con Socket AMD TR4 (para Threadripper). Altura maxima de 163mm. Peso de 1180 gramos. Es capaz de refrigerar los procesadores Threadripper de AMD y ofrece un nivel de ruido muy bajo en comparacion con el mercado.'),(3,'AIRE','Noctua','NH-D15',96,'Compatible con Socket Intel y AMD. Altura maxima de 165mm. Peso de 1320 gramos. Sus ventiladores presentan un caudal maximo de aire de 140,2 m3/h, siendo la opcion de refrigeracion con mejor rendimiento del mercado.')");
        //GAMMA BAJA LIQUIDA
        baseDatos.execSQL("INSERT INTO `refrigeraciones` (`rango`,`tipo`,`marca`, `modelo`,`precio`,`descripcion`) VALUES (1,'LIQUIDA','Coolbox','DeepRunny LED 120mm',40,'Compatible con Socket Intel y AMD. La longitud del radiador es de 120mm. El motor de la bomba de aire puede llegar hasta 2100 RPM y la refrigeracion posee un maximo flujo de aire de 74.5 CFM. Su nivel de ruido maximo es de 35,2 dB'), (1,'LIQUIDA','Cooler Master','MasterLiquid ML120L V2 RGB',48,'Compatible con Socket Intel y AMD. La longitud del radiador es de 120mm. El motor de la bomba de aire puede llegar hasta 1800 RPM y la refrigeracion posee un maximo flujo de aire de 62 CFM. Su nivel de ruido maximo es de 27 dB'), (1,'LIQUIDA','Corsair','Hydro Series H45',73,'Compatible con Socket Intel y AMD. La longitud del radiador es de 120mm. El motor de la bomba de aire puede llegar hasta 2300 RPM y la refrigeracion posee un maximo flujo de aire de 94 CFM. Su nivel de ruido maximo es de 31 dB'),(1,'LIQUIDA','Enermax','Liqmax III RGB 120mm',59,'Compatible con Socket Intel y AMD. La longitud del radiador es de 120mm. El motor de la bomba de aire puede llegar hasta 2000 RPM y la refrigeracion posee un maximo flujo de aire de 90 CFM. Su nivel de ruido maximo es de 32 dB'),(1,'LIQUIDA','Deepcool','Gammaxx L120T Red',58,'Compatible con Socket Intel y AMD. La longitud del radiador es de 120mm. El motor de la bomba de aire puede llegar hasta 2400 RPM y la refrigeracion posee un maximo flujo de aire de 69.34 CFM. Su nivel de ruido maximo es de 30 dB')");
        //GAMMA MEDIA LIQUIDA
        baseDatos.execSQL("INSERT INTO `refrigeraciones` (`rango`,`tipo`,`marca`, `modelo`,`precio`,`descripcion`) VALUES (2,'LIQUIDA','Cooler Master','Masterliquid ML280 Mirror',80,'Compatible con Socket Intel y AMD. La longitud del radiador es de 280mm. El motor de la bomba de aire puede llegar hasta 1800 RPM y la refrigeracion posee un maximo flujo de aire de 67 CFM. Su nivel de ruido maximo es de 27 dB. Incluye 2 ventiladores'), (2,'LIQUIDA','Cougar','AQUA 240',90,'Compatible con Socket Intel y AMD. La longitud del radiador es de 240mm. El motor de la bomba de aire puede llegar hasta 3200 RPM y la refrigeracion posee un maximo flujo de aire de 70 CFM. Su nivel de ruido maximo es de 31 dB'), (2,'LIQUIDA','Cooler Master','Masterliquid ML360 Mirror',90,'Compatible con Socket Intel y AMD. La longitud del radiador es de 360mm. El motor de la bomba de aire puede llegar hasta 1800 RPM y la refrigeracion posee un maximo flujo de aire de 62 CFM. Su nivel de ruido maximo es de 27 dB. Incluye 3 ventiladores'),(2,'LIQUIDA','Lian Li','Galahad 360 ARGB Blanco',48,'Compatible con Socket Intel y AMD. La longitud del radiador es de 360mm. El motor de la bomba de aire puede llegar hasta 2100 RPM y la refrigeracion posee un maximo flujo de aire de 69.20 CFM. Su nivel de ruido maximo es de 32 dB'),(2,'LIQUIDA','Alphacool','Eisbaer LT360',107,'Compatible con Socket Intel y AMD. La longitud del radiador es de 360mm. El motor de la bomba de aire puede llegar hasta 2600 RPM y la refrigeracion posee un maximo flujo de aire de 73.4 CFM. Su nivel de ruido maximo es de 29.3 dB')");
        //GAMMA ALTA LIQUIDA
        baseDatos.execSQL("INSERT INTO `refrigeraciones` (`rango`,`tipo`,`marca`, `modelo`,`precio`,`descripcion`) VALUES (3,'LIQUIDA','Gigabyte','AORUS WATERFORCE X 280 RGB',200,'Compatible con Socket Intel y AMD. La longitud del radiador es de 280mm. El motor de la bomba de aire puede llegar hasta 2300 RPM y la refrigeracion posee un maximo flujo de aire de 90 CFM. Su nivel de ruido maximo es de 44.5 dB'), (3,'LIQUIDA','NZXT','Kraken X73 Blanco RGB (360mm)',205,'Compatible con Socket Intel y AMD. La longitud del radiador es de 360mm. El motor de la bomba de aire puede llegar hasta 3000 RPM y la refrigeracion posee un maximo flujo de aire de 52 CFM. Su nivel de ruido maximo es de 33 dB'), (3,'LIQUIDA','Cooler Master','Masterliquid 360 Sub Zero 360mm',300,'Compatible con Socket Intel . La longitud del radiador es de 360mm. El motor de la bomba de aire puede llegar hasta 3500 RPM y la refrigeracion posee un maximo flujo de aire de 62 CFM. Su nivel de ruido maximo es de 59 dB (por ventilador). Ofrece una tecnologia unica que baja las temperaturas del procesador mas que ninguna otra solucion del mercado. Tiene un alto consumo'),(3,'LIQUIDA','Corsair','iCUE H170i ELITE LCD',320,'Compatible con Socket Intel y AMD. La longitud del radiador es de 360mm. El motor de la bomba de aire puede llegar hasta 2000 RPM y la refrigeracion posee un maximo flujo de aire de 82.9 CFM (por ventildor). Su nivel de ruido maximo es de 31.8 dB. Tiene una pantalla LCD configurable para mostrar contenido personalizado.'),(3,'LIQUIDA','Asus','ROG Ryujin II 360',330,'Compatible con Socket Intel y AMD. La longitud del radiador es de 360mm. El motor de la bomba de aire puede llegar hasta 3000 RPM y la refrigeracion posee un maximo flujo de aire de 71.6 CFM (por ventilador). Su nivel de ruido maximo es de 29.7 dB. Tiene una pantalla configurable para mostrar contenido personalizado.')");
    }

    public void insertarCajas() {
        //GAMMA BAJA
        baseDatos.execSQL("INSERT INTO `cajas` (`rango`,`marca`, `modelo`,`precio`,`descripcion`) VALUES (1,'Cougar','MG120-G Cristal Templado / Negro',40,'Torre de dimensiones reducidas. Compatible con placas base mini ITX y micro ATX. Dimensiones de 210x415x400(mm). Permite la instalacion de refrigeracion liquida de hasta 280mm en el frontal y 240 mm en la parte superior. Soporte para graficas de hasta 330mm de largo. Soporte para disipadores de hasta 175mm de alto'),(1,'Antec','DP301M Gaming Cristal Templado',55,'Torre de dimensiones reducidas. Compatible con placas base mini ITX y micro ATX. Dimensiones de 210x420x402(mm). Permite la instalacion de refrigeracion liquida de hasta 280mm en el frontal y 280 mm en la parte superior. Soporte para graficas de hasta 360mm de largo. Soporte para disipadores de hasta 160mm de alto'), (1,'Cooler Master','MasterBox Q300L',50,'Torre de dimensiones reducidas. Compatible con placas base mini ITX y micro ATX. Dimensiones de 230x387x378(mm). Permite la instalacion de refrigeracion liquida de hasta 240mm en el frontal. Soporte para graficas de hasta 360mm de largo. Soporte para disipadores de hasta 157mm de alto'),(1,'Nox','Hummer TGM RGB Cristal Templado',65,'Torre de dimensiones medias. Compatible con placas base Mini ITX, Micro ATX y ATX. Dimensiones de 198x440x420(mm). Permite la instalacion de refrigeracion liquida de hasta 240mm en el frontal. Soporte para graficas de hasta 310mm de largo. Soporte para disipadores de hasta 157mm de alto'),(1,'Antec','NX210 Cristal Templado',48,'Torre de dimensiones medias. Compatible con placas base Mini ITX, Micro ATX y ATX. Dimensiones de 395x210x445(mm). Permite la instalacion de refrigeracion liquida de hasta 240mm en el frontal y 140 mm en la parte trasera. Soporte para graficas de hasta 310mm de largo. Soporte para disipadores de hasta 155mm de alto')");
        //GAMMA MEDIA
        baseDatos.execSQL("INSERT INTO `cajas` (`rango`,`marca`, `modelo`,`precio`,`descripcion`) VALUES (2,'Lian Li','PC-O11 Air Cristal Templado / Negro',90,'Torre de dimensiones medias. Compatible con placas base E-ATX, ATX y Micro- ATX. Dimensiones de 270x465x476(mm). Permite la instalacion de refrigeracion liquida de hasta 360mm en la parte superior, 360 mm en la parte inferior y 360 en el panel lateral. Soporte para graficas de hasta 420mm de largo. Soporte para disipadores de hasta 155mm de alto'),(2,'Cooler Master','MasterBox MB530P Cristal Templado',94,'Torre de dimensiones medias. Compatible con placas base Mini ITX, Micro ATX y ATX. Dimensiones de 489x229x469(mm). Permite la instalacion de refrigeracion liquida de hasta 360mm en el frontal y 280 mm en la parte superior. Soporte para graficas de hasta 410mm de largo. Soporte para disipadores de hasta 165mm de alto'), (2,'Lian Li','LANCOOL II Mesh RGB White Cristal Templado',120,'Torre de dimensiones medias. Compatible con placas base E-ATX, ATX, MICRO-ATX y Mini-ITX. Dimensiones de 493x229x478(mm). Permite la instalacion de refrigeracion liquida de hasta 360mm en el frontal y 240 mm en la parte superior. Soporte para graficas de hasta 384mm de largo. Soporte para disipadores de hasta 176mm de alto'),(2,'Corsair','iCUE 220T RGB Airflow Cristal Templado / Blanco',100,'Torre de dimensiones medias. Compatible con placas base mini ITX, micro ATX y ATX. Dimensiones de 395x210x450(mm). Permite la instalacion de refrigeracion liquida de hasta 360mm en el frontal, 240 mm en la parte superior y 120mm en la parte trasera. Soporte para graficas de hasta 300mm de largo. Soporte para disipadores de hasta 160mm de alto'),(2,'Nox','Hummer TGX Rainbow Negro',104,'Torre de dimensiones medias-grandes. Compatible con placas base E-ATX, ATX, Micro-ATX y Mini ITX. Dimensiones de 235x515x500(mm). Permite la instalacion de refrigeracion liquida de hasta 360mm en el frontal, 360 mm en la parte superior y 140mm en la parte trasera. Soporte para graficas de hasta 430mm de largo. Soporte para disipadores de hasta 175mm de alto')");
        //GAMMA ALTA
        baseDatos.execSQL("INSERT INTO `cajas` (`rango`,`marca`, `modelo`,`precio`,`descripcion`) VALUES (3,'Lian Li','Odyssey X Silver E-ATX',320,'Torre de dimensiones grandes. Compatible con placas base EEB, E-ATX, ATX, Micro-ATX y Mini-ITX. Dimensiones de 537x367x597(mm). Permite la instalacion de refrigeracion liquida de hasta 360mm en el frontal y 360 mm en la parte superior. Soporte para graficas de hasta 423mm de largo. Soporte para disipadores de hasta 167mm de alto'),(3,'Jonsbo','TR03-A Silver Cristal Templado',233,'Torre de dimensiones grandes con forma personalizada. Compatible con placas base mini ITX ,micro ATX y ATX. Dimensiones de 238x673x595(mm). Permite la instalacion de refrigeracion liquida de hasta 360mm en el frontal y 240 mm en la parte inferior. Soporte para graficas de hasta 460mm de largo. Soporte para disipadores de hasta 175mm de alto'), (3,'Cooler Master','Mastercase H500P Mesh ARGB Cristal Templado',195,'Torre de dimensiones grandes. Compatible con placas base Mini-ITX, Micro-ATX, ATX y E-ATX. Dimensiones de 544x242x542(mm). Permite la instalacion de refrigeracion liquida de hasta 360mm en el frontal y 360 mm en la parte superior. Soporte para graficas de hasta 400mm de largo. Soporte para disipadores de hasta 190mm de alto'),(3,'Corsair','Obsidian 1000D Cristal Templado',590,'Torre de dimensiones enormes. Compatible con Placas Base E-ATX, ATX, Micro-ATX, Mini-ITX. Dimensiones de 307x693x697(mm). Permite la instalacion de refrigeracion liquida de hasta 480mm en el frontal y 360 mm en la parte superior. Soporte para graficas de hasta 400mm de largo. Soporte para disipadores de hasta 180mm de alto. Permite el montaje de dos sistemas en el mismo chasis'),(3,'Corsair','5000T RGB Negro',400,'Torre de dimensiones grandes. Compatible con Placas Base E-ATX, ATX, Micro-ATX, Mini-ITX. Dimensiones de 251x530x560(mm). Permite la instalacion de refrigeracion liquida de hasta 360mm en el frontal y 360 mm en la parte superior. Soporte para graficas de hasta 400mm de largo. Soporte para disipadores de hasta 170mm de alto.')");

    }

    public int numberOfProcesadores() {
        int num;
        baseDatos = this.getReadableDatabase();
        num = (int) DatabaseUtils.queryNumEntries(baseDatos, "procesadores");
        //  baseDatos.close();
        return num;
    }

    public int numberOfPlacasBase() {
        int num2;
        baseDatos = this.getReadableDatabase();
        num2 = (int) DatabaseUtils.queryNumEntries(baseDatos, "placasbase");
        //  baseDatos.close();
        return num2;
    }

    public int numberOfDiscosDuros() {
        int num;
        baseDatos = this.getReadableDatabase();
        num = (int) DatabaseUtils.queryNumEntries(baseDatos, "discosduros");
        //   baseDatos.close();
        return num;
    }

    public int numberOfTarjetasGraficas() {
        int num;
        baseDatos = this.getReadableDatabase();
        num = (int) DatabaseUtils.queryNumEntries(baseDatos, "tarjetasgraficas");
        //   baseDatos.close();
        return num;
    }

    public int numberOfMemoriasRam() {
        int num;
        baseDatos = this.getReadableDatabase();
        num = (int) DatabaseUtils.queryNumEntries(baseDatos, "memoriasram");
        //   baseDatos.close();
        return num;
    }

    public int numberOfFuentesAlimentacion() {
        int num;
        baseDatos = this.getReadableDatabase();
        num = (int) DatabaseUtils.queryNumEntries(baseDatos, "fuentesalimentacion");
        //   baseDatos.close();
        return num;
    }

    public int numberOfRefrigeraciones() {
        int num;
        baseDatos = this.getReadableDatabase();
        num = (int) DatabaseUtils.queryNumEntries(baseDatos, "refrigeraciones");
        //  baseDatos.close();
        return num;
    }

    public int numberOfCajas() {
        int num;
        baseDatos = this.getReadableDatabase();
        num = (int) DatabaseUtils.queryNumEntries(baseDatos, "cajas");
        //   baseDatos.close();
        return num;
    }

    @SuppressLint({"Range", "Recycle"})
    public ArrayList<String> getProcesadorRango(int rango, String marca) {
        ArrayList<String> filasProcesador = new ArrayList<>();
        Cursor res;
        String contenido;

        if (numberOfProcesadores() > 0) {
            baseDatos = this.getReadableDatabase();
            res = baseDatos.rawQuery("SELECT `id`,`marca`,`modelo` FROM `procesadores` WHERE `rango` = " + rango + " AND `marca` LIKE + '" + marca + "' ", null);
            res.moveToFirst();
            while (!res.isAfterLast()) {
                contenido = res.getString(res.getColumnIndex("id")) + ".-" + res.getString(res.getColumnIndex("modelo"));
                filasProcesador.add(contenido);
                res.moveToNext();
            }
        }
        return filasProcesador;
    }

    @SuppressLint({"Range", "Recycle"})
    public ArrayList<String> getProcesadorInfo(int id) {
        ArrayList<String> filasProcesador = new ArrayList<>();
        Cursor res;
        String contenido;
        if (numberOfProcesadores() > 0) {
            baseDatos = this.getReadableDatabase();
            res = baseDatos.rawQuery("SELECT `precio`,`descripcion` FROM `procesadores` WHERE `id` = " + id + "", null);
            res.moveToNext();
            while (!res.isAfterLast()) {
                contenido = "\tPRECIO " + res.getString(res.getColumnIndex("precio")) + "€" + "\n\tDESCRIPCION DEL PRODUCTO \n" + res.getString(res.getColumnIndex("descripcion"));
                filasProcesador.add(contenido);
                res.moveToNext();
            }
        }
        return filasProcesador;
    }

    @SuppressLint({"Range", "Recycle"})
    public ArrayList<String> getProcesadorMarca(int id) {
        ArrayList<String> filasProcesador = new ArrayList<>();
        Cursor res;
        String contenido;
        res = baseDatos.rawQuery("SELECT `marca` FROM `procesadores` WHERE `id` = " + id + "", null);
        res.moveToNext();
        while (!res.isAfterLast()) {
            contenido = res.getString(res.getColumnIndex("marca"));
            filasProcesador.add(contenido);
            res.moveToNext();
        }
        return filasProcesador;
    }
    @SuppressLint({"Range", "Recycle"})
    public ArrayList<String> getProcesadorID(int id) {
        ArrayList<String> filasProcesador = new ArrayList<>();
        Cursor res;
        String contenido;
        res = baseDatos.rawQuery("SELECT `marca`,`modelo` FROM `procesadores` WHERE `id` = " + id + "", null);
        res.moveToNext();
        while (!res.isAfterLast()) {
            contenido = res.getString(res.getColumnIndex("marca")) + "  " + res.getString(res.getColumnIndex("modelo"));
            filasProcesador.add(contenido);
            res.moveToNext();
        }
        return filasProcesador;
    }

    @SuppressLint({"Range", "Recycle"})
    public ArrayList<String> getPlacasbaseRango(int rango, String marcaCompatible) {
        ArrayList<String> filasPlacabase = new ArrayList<>();
        Cursor res;
        String contenido;

        if (numberOfPlacasBase() > 0) {
            baseDatos = this.getReadableDatabase();
            res = baseDatos.rawQuery("SELECT `id`,`marca`,`modelo` FROM `placasbase` WHERE `rango` = " + rango + " AND `marcaCompatible` LIKE + '" + marcaCompatible + "' ", null);
            res.moveToFirst();
            while (!res.isAfterLast()) {
                contenido = res.getString(res.getColumnIndex("id")) + ".- " + res.getString(res.getColumnIndex("marca")) + " " + res.getString(res.getColumnIndex("modelo"));
                filasPlacabase.add(contenido);
                res.moveToNext();
            }
        }
        return filasPlacabase;
    }

    @SuppressLint({"Range", "Recycle"})
    public ArrayList<String> getPlacaBaseInfo(int id) {
        ArrayList<String> filasPlacabase = new ArrayList<>();
        Cursor res;
        String contenido;
        if (numberOfPlacasBase() > 0) {
            baseDatos = this.getReadableDatabase();
            res = baseDatos.rawQuery("SELECT `precio`,`descripcion` FROM `placasbase` WHERE `id` = " + id + "", null);
            res.moveToNext();
            while (!res.isAfterLast()) {
                contenido = "\tPRECIO " + res.getString(res.getColumnIndex("precio")) + "€" + "\n\tDESCRIPCION DEL PRODUCTO \n" + res.getString(res.getColumnIndex("descripcion"));
                filasPlacabase.add(contenido);
                res.moveToNext();
            }
        }
        return filasPlacabase;
    }
    @SuppressLint({"Range", "Recycle"})
    public ArrayList<String> getPlacaBaseID(int id) {
        ArrayList<String> filasPlacabase = new ArrayList<>();
        Cursor res;
        String contenido;
        res = baseDatos.rawQuery("SELECT `marca`,`modelo` FROM `placasbase` WHERE `id` = " + id + "", null);
        res.moveToNext();
        while (!res.isAfterLast()) {
            contenido = res.getString(res.getColumnIndex("marca")) + "  " + res.getString(res.getColumnIndex("modelo"));
            filasPlacabase.add(contenido);
            res.moveToNext();
        }
        return filasPlacabase;
    }


    @SuppressLint({"Range", "Recycle"})
    public ArrayList<String> getDiscosdurosRango(int rango, String tipo) {
        ArrayList<String> filasDiscosduros = new ArrayList<>();
        Cursor res;
        String contenido;

        if (numberOfDiscosDuros() > 0) {
            baseDatos = this.getReadableDatabase();
            res = baseDatos.rawQuery("SELECT `id`,`marca`,`modelo` FROM `discosduros` WHERE `rango` = " + rango + " AND `tipo` LIKE + '" + tipo + "' ", null);
            res.moveToFirst();
            while (!res.isAfterLast()) {
                contenido = res.getString(res.getColumnIndex("id")) + ".- " + res.getString(res.getColumnIndex("marca")) + " " + res.getString(res.getColumnIndex("modelo"));
                filasDiscosduros.add(contenido);
                res.moveToNext();
            }
        }
        return filasDiscosduros;
    }

    @SuppressLint({"Range", "Recycle"})
    public ArrayList<String> getDiscosdurosInfo(int id) {
        ArrayList<String> filasDiscosDuros = new ArrayList<>();
        Cursor res;
        String contenido;
        if (numberOfDiscosDuros() > 0) {
            baseDatos = this.getReadableDatabase();
            res = baseDatos.rawQuery("SELECT `precio`,`descripcion` FROM `discosduros` WHERE `id` = " + id + "", null);
            res.moveToNext();
            while (!res.isAfterLast()) {
                contenido = "\tPRECIO " + res.getString(res.getColumnIndex("precio")) + "€" + "\n\tDESCRIPCION DEL PRODUCTO \n" + res.getString(res.getColumnIndex("descripcion"));
                filasDiscosDuros.add(contenido);
                res.moveToNext();
            }
        }
        return filasDiscosDuros;
    }
    @SuppressLint({"Range", "Recycle"})
    public ArrayList<String> getDiscoDuroID(int id) {
        ArrayList<String> filasDiscosDuros = new ArrayList<>();
        Cursor res;
        String contenido;
        res = baseDatos.rawQuery("SELECT `marca`,`modelo` FROM `discosduros` WHERE `id` = " + id + "", null);
        res.moveToNext();
        while (!res.isAfterLast()) {
            contenido = res.getString(res.getColumnIndex("marca")) + "  " + res.getString(res.getColumnIndex("modelo"));
            filasDiscosDuros.add(contenido);
            res.moveToNext();
        }
        return filasDiscosDuros;
    }

    @SuppressLint({"Range", "Recycle"})
    public ArrayList<String> getTarjetasGraficasRango(int rango, String fabricante) {
        ArrayList<String> filasTarjetasGraficas = new ArrayList<>();
        Cursor res;
        String contenido;

        if (numberOfTarjetasGraficas() > 0) {
            baseDatos = this.getReadableDatabase();
            res = baseDatos.rawQuery("SELECT `id`,`marca`,`modelo` FROM `tarjetasgraficas` WHERE `rango` = " + rango + " AND `fabricante` LIKE + '" + fabricante + "' ", null);
            res.moveToFirst();
            while (!res.isAfterLast()) {
                contenido = res.getString(res.getColumnIndex("id")) + ".- " + res.getString(res.getColumnIndex("marca")) + " " + res.getString(res.getColumnIndex("modelo"));
                filasTarjetasGraficas.add(contenido);
                res.moveToNext();
            }
        }
        return filasTarjetasGraficas;
    }

    @SuppressLint({"Range", "Recycle"})
    public ArrayList<String> getTarjetasGraficasInfo(int id) {
        ArrayList<String> filasTarjetasGraficas = new ArrayList<>();
        Cursor res;
        String contenido;
        if (numberOfDiscosDuros() > 0) {
            baseDatos = this.getReadableDatabase();
            res = baseDatos.rawQuery("SELECT `precio`,`descripcion` FROM `tarjetasgraficas` WHERE `id` = " + id + "", null);
            res.moveToNext();
            while (!res.isAfterLast()) {
                contenido = "\tPRECIO " + res.getString(res.getColumnIndex("precio")) + "€" + "\n\tDESCRIPCION DEL PRODUCTO \n" + res.getString(res.getColumnIndex("descripcion"));
                filasTarjetasGraficas.add(contenido);
                res.moveToNext();
            }
        }
        return filasTarjetasGraficas;
    }
    @SuppressLint({"Range", "Recycle"})
    public ArrayList<String> getTarjetaGraficaID(int id) {
        ArrayList<String> filasTarjetasGraficas = new ArrayList<>();
        Cursor res;
        String contenido;
        res = baseDatos.rawQuery("SELECT `marca`,`modelo` FROM `tarjetasgraficas` WHERE `id` = " + id + "", null);
        res.moveToNext();
        while (!res.isAfterLast()) {
            contenido = res.getString(res.getColumnIndex("marca")) + "  " + res.getString(res.getColumnIndex("modelo"));
            filasTarjetasGraficas.add(contenido);
            res.moveToNext();
        }
        return filasTarjetasGraficas;
    }

    @SuppressLint({"Range", "Recycle"})
    public ArrayList<String> getMemoriasramRango(int rango) {
        ArrayList<String> filasMemoriasram = new ArrayList<>();
        Cursor res;
        String contenido;

        if (numberOfMemoriasRam() > 0) {
            baseDatos = this.getReadableDatabase();
            res = baseDatos.rawQuery("SELECT `id`,`marca`,`modelo` FROM `memoriasram` WHERE `rango` = " + rango + "", null);
            res.moveToFirst();
            while (!res.isAfterLast()) {
                contenido = res.getString(res.getColumnIndex("id")) + ".- " + res.getString(res.getColumnIndex("marca")) + " " + res.getString(res.getColumnIndex("modelo"));
                filasMemoriasram.add(contenido);
                res.moveToNext();
            }
        }
        return filasMemoriasram;
    }

    @SuppressLint({"Range", "Recycle"})
    public ArrayList<String> getMemoriasramInfo(int id) {
        ArrayList<String> filasMemoriasram = new ArrayList<>();
        Cursor res;
        String contenido;
        if (numberOfDiscosDuros() > 0) {
            baseDatos = this.getReadableDatabase();
            res = baseDatos.rawQuery("SELECT `precio`,`descripcion` FROM `memoriasram` WHERE `id` = " + id + "", null);
            res.moveToNext();
            while (!res.isAfterLast()) {
                contenido = "\tPRECIO " + res.getString(res.getColumnIndex("precio")) + "€" + "\n\tDESCRIPCION DEL PRODUCTO \n" + res.getString(res.getColumnIndex("descripcion"));
                filasMemoriasram.add(contenido);
                res.moveToNext();
            }
        }
        return filasMemoriasram;
    }
    @SuppressLint({"Range", "Recycle"})
    public ArrayList<String> getMemoriaRamID(int id) {
        ArrayList<String> filasMemoriasram = new ArrayList<>();
        Cursor res;
        String contenido;
        res = baseDatos.rawQuery("SELECT `marca`,`modelo` FROM `memoriasram` WHERE `id` = " + id + "", null);
        res.moveToNext();
        while (!res.isAfterLast()) {
            contenido = res.getString(res.getColumnIndex("marca")) + "  " + res.getString(res.getColumnIndex("modelo"));
            filasMemoriasram.add(contenido);
            res.moveToNext();
        }
        return filasMemoriasram;
    }

    @SuppressLint({"Range", "Recycle"})
    public ArrayList<String> getFuentesalimentacionRango(int rango) {
        ArrayList<String> filasFuentesalimentacion = new ArrayList<>();
        Cursor res;
        String contenido;

        if (numberOfFuentesAlimentacion() > 0) {
            baseDatos = this.getReadableDatabase();
            res = baseDatos.rawQuery("SELECT `id`,`marca`,`modelo` FROM `fuentesalimentacion` WHERE `rango` = " + rango + "", null);
            res.moveToFirst();
            while (!res.isAfterLast()) {
                contenido = res.getString(res.getColumnIndex("id")) + ".- " + res.getString(res.getColumnIndex("marca")) + " " + res.getString(res.getColumnIndex("modelo"));
                filasFuentesalimentacion.add(contenido);
                res.moveToNext();
            }
        }
        return filasFuentesalimentacion;
    }

    @SuppressLint({"Range", "Recycle"})
    public ArrayList<String> getFuentesalimentacionInfo(int id) {
        ArrayList<String> filasFuentesalimentacion = new ArrayList<>();
        Cursor res;
        String contenido;
        if (numberOfFuentesAlimentacion() > 0) {
            baseDatos = this.getReadableDatabase();
            res = baseDatos.rawQuery("SELECT `precio`,`descripcion` FROM `fuentesalimentacion` WHERE `id` = " + id + "", null);
            res.moveToNext();
            while (!res.isAfterLast()) {
                contenido = "\tPRECIO " + res.getString(res.getColumnIndex("precio")) + "€" + "\n\tDESCRIPCION DEL PRODUCTO \n" + res.getString(res.getColumnIndex("descripcion"));
                filasFuentesalimentacion.add(contenido);
                res.moveToNext();
            }
        }
        return filasFuentesalimentacion;
    }
    @SuppressLint({"Range", "Recycle"})
    public ArrayList<String> getFuenteAlimentacionID(int id) {
        ArrayList<String> filasFuentesalimentacion = new ArrayList<>();
        Cursor res;
        String contenido;
        res = baseDatos.rawQuery("SELECT `marca`,`modelo` FROM `fuentesalimentacion` WHERE `id` = " + id + "", null);
        res.moveToNext();
        while (!res.isAfterLast()) {
            contenido = res.getString(res.getColumnIndex("marca")) + "  " + res.getString(res.getColumnIndex("modelo"));
            filasFuentesalimentacion.add(contenido);
            res.moveToNext();
        }
        return filasFuentesalimentacion;
    }

    @SuppressLint({"Range", "Recycle"})
    public ArrayList<String> getRefrigeracionesRango(int rango, String tipo) {
        ArrayList<String> filasRefrigeraciones = new ArrayList<>();
        Cursor res;
        String contenido;

        if (numberOfRefrigeraciones() > 0) {
            baseDatos = this.getReadableDatabase();
            res = baseDatos.rawQuery("SELECT `id`,`marca`,`modelo` FROM `refrigeraciones` WHERE `rango` = " + rango + " AND `tipo` LIKE + '" + tipo + "' ", null);
            res.moveToFirst();
            while (!res.isAfterLast()) {
                contenido = res.getString(res.getColumnIndex("id")) + ".- " + res.getString(res.getColumnIndex("marca")) + " " + res.getString(res.getColumnIndex("modelo"));
                filasRefrigeraciones.add(contenido);
                res.moveToNext();
            }
        }
        return filasRefrigeraciones;
    }

    @SuppressLint({"Range", "Recycle"})
    public ArrayList<String> getRefrigeracionesInfo(int id) {
        ArrayList<String> filasRefrigeraciones = new ArrayList<>();
        Cursor res;
        String contenido;
        if (numberOfRefrigeraciones() > 0) {
            baseDatos = this.getReadableDatabase();
            res = baseDatos.rawQuery("SELECT `precio`,`descripcion` FROM `refrigeraciones` WHERE `id` = " + id + "", null);
            res.moveToNext();
            while (!res.isAfterLast()) {
                contenido = "\tPRECIO " + res.getString(res.getColumnIndex("precio")) + "€" + "\n\tDESCRIPCION DEL PRODUCTO \n" + res.getString(res.getColumnIndex("descripcion"));
                filasRefrigeraciones.add(contenido);
                res.moveToNext();
            }
        }
        return filasRefrigeraciones;
    }
    @SuppressLint({"Range", "Recycle"})
    public ArrayList<String> getRefrigeracionID(int id) {
        ArrayList<String> filasRefrigeraciones = new ArrayList<>();
        Cursor res;
        String contenido;
        res = baseDatos.rawQuery("SELECT `marca`,`modelo` FROM `refrigeraciones` WHERE `id` = " + id + "", null);
        res.moveToNext();
        while (!res.isAfterLast()) {
            contenido = res.getString(res.getColumnIndex("marca")) + "  " + res.getString(res.getColumnIndex("modelo"));
            filasRefrigeraciones.add(contenido);
            res.moveToNext();
        }
        return filasRefrigeraciones;
    }

    @SuppressLint({"Range", "Recycle"})
    public ArrayList<String> getCajasRango(int rango) {
        ArrayList<String> filasCajas = new ArrayList<>();
        Cursor res;
        String contenido;

        if (numberOfCajas() > 0) {
            baseDatos = this.getReadableDatabase();
            res = baseDatos.rawQuery("SELECT `id`,`marca`,`modelo` FROM `cajas` WHERE `rango` = " + rango + " ", null);
            res.moveToFirst();
            while (!res.isAfterLast()) {
                contenido = res.getString(res.getColumnIndex("id")) + ".- " + res.getString(res.getColumnIndex("marca")) + " " + res.getString(res.getColumnIndex("modelo"));
                filasCajas.add(contenido);
                res.moveToNext();
            }
        }
        return filasCajas;
    }
    @SuppressLint({"Range", "Recycle"})
    public ArrayList<String> getCajasInfo(int id) {
        ArrayList<String> filasCajas = new ArrayList<>();
        Cursor res;
        String contenido;
        if (numberOfCajas() > 0) {
            baseDatos = this.getReadableDatabase();
            res = baseDatos.rawQuery("SELECT `precio`,`descripcion` FROM `cajas` WHERE `id` = " + id + "", null);
            res.moveToNext();
            while (!res.isAfterLast()) {
                contenido = "\tPRECIO " + res.getString(res.getColumnIndex("precio")) + "€" + "\n\tDESCRIPCION DEL PRODUCTO \n" + res.getString(res.getColumnIndex("descripcion"));
                filasCajas.add(contenido);
                res.moveToNext();
            }
        }
        return filasCajas;
    }
    @SuppressLint({"Range", "Recycle"})
    public ArrayList<String> getCajaID(int id) {
        ArrayList<String> filasCajas = new ArrayList<>();
        Cursor res;
        String contenido;
        res = baseDatos.rawQuery("SELECT `marca`,`modelo` FROM `cajas` WHERE `id` = " + id + "", null);
        res.moveToNext();
        while (!res.isAfterLast()) {
            contenido = res.getString(res.getColumnIndex("marca")) + "  " + res.getString(res.getColumnIndex("modelo"));
            filasCajas.add(contenido);
            res.moveToNext();
        }
        return filasCajas;
    }

}
