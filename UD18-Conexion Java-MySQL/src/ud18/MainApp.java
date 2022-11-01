package ud18;

public class MainApp {
	
	public static void main(String[] args) {
		Queries queries = new Queries();
		String[] basesDatos = new String[9];
		
		//Array con nombre de las bd
		
		basesDatos[0]="tienda_informatica";
		basesDatos[1]="empleados";
		basesDatos[2]="almacen";
		basesDatos[3]="peliculas_salas";
		basesDatos[4]="director";
		basesDatos[5]="piezas_proveedores";
		basesDatos[6]="cientificos";
		basesDatos[7]="grandes_almacenes";
		basesDatos[8]="investigador";
		
		//establecemos conexion (llamada funcion)
		queries.establecerConexion();
		
		//bucle de creacion bases de datos
		
		for(int i=0;i<9;i++) {
			queries.crearDB(basesDatos[i]);
		}
		
		//Tablas Ej 1.
		
		queries.crearTabla(basesDatos[0], "fabricantes"," (codigo INT NOT NULL AUTO_INCREMENT,"
				+ " nombre varchar(100) DEFAULT NULL,"
				+ " PRIMARY KEY (codigo))");
				
		queries.crearTabla(basesDatos[0], "articulos"," (codigo int NOT NULL AUTO_INCREMENT,"
				+ "  nombre varchar(100) NOT NULL,"
				+ "  precio int NOT NULL,"
				+ "  fabricante int NOT NULL,"
				+ "  PRIMARY KEY (codigo),"
				+ "	 FOREIGN KEY (fabricante) REFERENCES fabricantes(codigo) ON DELETE CASCADE ON UPDATE CASCADE) ");

		
		//Inserciones Ej 1.
		
		queries.insertarDatos(basesDatos[0], "INSERT INTO fabricantes(nombre)"
				+ "VALUES ('Lego'),"
				+ "('Playmobil'),"
				+ "('Scalestrix'),"
				+ "('Bizak'),"
				+ "('Famosa')");
				
		queries.insertarDatos(basesDatos[0], "INSERT INTO articulos(nombre,precio,fabricante)"
				+ "VALUES ('pieza','2',1),"
				+ "('muñeco articulado','18',2),"
				+ "('coche carreras','8',3),"
				+ "('cocodrilo sacamuelas','22',4),"
				+ "('muñeca','10',5)");
		
		
		//Tablas Ej 2.
		 
		queries.crearTabla(basesDatos[1], "departamentos"," (codigo int NOT NULL AUTO_INCREMENT,"
				+ "  nombre varchar(100) NOT NULL,"
				+ "  presupuesto int NOT NULL,"
				+ "  PRIMARY KEY (codigo))");
		 
		queries.crearTabla(basesDatos[1], "empleados"," (dni varchar(9) NOT NULL,"
				+ "  nombre varchar(100) NOT NULL,"
				+ "  apellidos varchar(255) NOT NULL,"
				+ "  departamento int NOT NULL,"
				+ "  PRIMARY KEY (dni),"
				+ "	 FOREIGN KEY (departamento) REFERENCES departamentos(codigo) ON DELETE CASCADE ON UPDATE CASCADE) ");
		 
		//Inserciones EJ 2.
		 
		queries.insertarDatos(basesDatos[1], "INSERT INTO departamentos(nombre,presupuesto)"
				+ "VALUES ('IT','150000'),"
				+ "('Tesoreria','200000'),"
				+ "('Prevision','300000'),"
				+ "('Finanzas','660000'),"
				+ "('Gestoria','101500')");
		 
		queries.insertarDatos(basesDatos[1], "INSERT INTO empleados(dni, nombre, apellidos, departamento)"
				+ "VALUES ('11111111A','Victor', 'Valdes', '1'),"
				+ "('22222222B','Marc Andre', 'Ter Stegen', '2'),"
				+ "('33333333C','Jose Manuel', 'Pinto', '2'),"
				+ "('44444444D','Albert', 'Jorquera', '3'),"
				+ "('55555555E','Claudio', 'Bravo', '3')");
				
		 
		//Tablas Ej 3.
		 
		queries.crearTabla(basesDatos[2], "almacenes"," (codigo int NOT NULL AUTO_INCREMENT,"
				+ "  lugar varchar(100) NOT NULL,"
				+ "  capacidad int NOT NULL,"
				+ "  PRIMARY KEY (codigo))");
		 
		queries.crearTabla(basesDatos[2], "cajas"," (numreferencia char(5) NOT NULL,"
				+ "  contenido varchar(100) NOT NULL,"
				+ "  valor int NOT NULL,"
				+ "  almacen int NOT NULL,"
				+ "  PRIMARY KEY (numreferencia),"
				+ "	 FOREIGN KEY (almacen) REFERENCES almacenes(codigo) ON DELETE CASCADE ON UPDATE CASCADE) ");
		 
		 
		//Inserciones Ej 3.
		 
		queries.insertarDatos(basesDatos[2], "INSERT INTO almacenes(lugar,capacidad)"
				+ "VALUES ('Tarragona','50'),"
				+ "('Constanti','150'),"
				+ "('Salou','200'),"
				+ "('Vilaseca','300'),"
				+ "('Valls','25000')");
		 
		queries.insertarDatos(basesDatos[2], "INSERT INTO cajas(numreferencia, contenido, valor, almacen)"
				+ "VALUES ('A1A1A','Regalos', 500, 1),"
				+ "('B2B2B','Muebles', 1300, 2),"
				+ "('C3C3C','Televisiones', 2500, 3),"
				+ "('D4D4D','Electrodomesticos', 3900, 5),"
				+ "('E5E5E','Pinceles', 1000, 4)");
		
		
		//Tablas Ej 4.
		
		queries.crearTabla(basesDatos[3], "peliculas"," (codigo int NOT NULL AUTO_INCREMENT,"
				+ "  nombre varchar(100) NOT NULL,"
				+ "  calificacionedad int DEFAULT NULL,"
				+ "  PRIMARY KEY (codigo))");
		
		queries.crearTabla(basesDatos[3], "salas"," (codigo int NOT NULL AUTO_INCREMENT,"
				+ "  nombre varchar(100) NOT NULL,"
				+ "  pelicula int DEFAULT NULL,"
				+ "  PRIMARY KEY (codigo),"
				+ "	 FOREIGN KEY (pelicula) REFERENCES peliculas(codigo) ON DELETE CASCADE ON UPDATE CASCADE)");
		
		
		//Inserciones EJ 4.
		
		queries.insertarDatos(basesDatos[3], "INSERT INTO peliculas(nombre,calificacionedad)"
				+ "VALUES ('Coach Carter','12'),"
				+ "('Hoosiers','16'),"
				+ "('Space Jam','3'),"
				+ "('Jesus Shuttlesworth','15'),"
				+ "('Hustle','18')");
		
		queries.insertarDatos(basesDatos[3], "INSERT INTO salas(nombre,pelicula)"
				+ "VALUES ('Sala 1',1),"
				+ "('Sala 2',2),"
				+ "('Sala 3',3),"
				+ "('Sala 4',5),"
				+ "('Sala 5',4)");		
		
		
		//Tablas Ej 5.
		
		queries.crearTabla(basesDatos[4], "despachos"," (numero smallint NOT NULL,"
				+ "  capacidad smallint NOT NULL,"
				+ "  PRIMARY KEY (numero))");
				
		queries.crearTabla(basesDatos[4], "directores","(dni varchar(8) NOT NULL,"
				+ "  nomapels varchar(255) NOT NULL,"
				+ "  dnijefe varchar(8) DEFAULT NULL,"
				+ "  despacho smallint DEFAULT NULL,"
				+ "  PRIMARY KEY (dni),"
				+ "  FOREIGN KEY (dnijefe) REFERENCES directores(dni) ON DELETE CASCADE ON UPDATE CASCADE,"
				+ "  FOREIGN KEY (despacho) REFERENCES despachos(numero) ON DELETE CASCADE ON UPDATE CASCADE);");		
		
		
		//Inserciones Ej 5.
		
		queries.insertarDatos(basesDatos[4], "INSERT INTO despachos(numero,capacidad)"
				+ "VALUES (11,3),"
				+ "(22,5),"
				+ "(33,8),"
				+ "(44,10),"
				+ "(55,7)");
		
		//Insertamos un director que sera el jefe de los demas directores
		queries.insertarDatos(basesDatos[4], "INSERT INTO directores(dni,nomapels,despacho)"
				+ "VALUES ('00000000Z','Adam Silver',11)");
		
		queries.insertarDatos(basesDatos[4], "INSERT INTO directores(dni,nomapels,dnijefe,despacho)"
				+ "VALUES ('1111111A','Ricky Rubio','00000000Z',22),"
				+ "('2222222B','Joan Carles Navarro','00000000Z',33),"
				+ "('3333333C','Pau Gasol','00000000Z',44),"
				+ "('4444444D','Marc Gasol','00000000Z',55)");
		
		
		//Tablas Ej 6.
		
		queries.crearTabla(basesDatos[5], "proveedores"," (id char(4) NOT NULL,"
				+ "  nombre varchar(100) NOT NULL,"
				+ "  PRIMARY KEY (id))");
		
		queries.crearTabla(basesDatos[5], "piezas"," (codigo INT NOT NULL AUTO_INCREMENT,"
				+ "  nombre varchar(100) NOT NULL,"
				+ "  PRIMARY KEY (codigo))");
				
		queries.crearTabla(basesDatos[5], "suministra","(codigopieza int NOT NULL,"
				+ "  idproveedor char(4) NOT NULL,"
				+ "  precio int NOT NULL,"
				+ "  PRIMARY KEY (codigopieza,idproveedor),"
				+ "  FOREIGN KEY (codigopieza) REFERENCES piezas(codigo) ON DELETE CASCADE ON UPDATE CASCADE,"
				+ "  FOREIGN KEY (idproveedor) REFERENCES proveedores(id) ON DELETE CASCADE ON UPDATE CASCADE);");	

		//Inserciones Ej 6.
		
		queries.insertarDatos(basesDatos[5], "INSERT INTO proveedores(id,nombre)"
				+ "VALUES ('1A','Mercedes'),"
				+ "('2B','Honda'),"
				+ "('3C','Renault'),"
				+ "('4D','Ferrari'),"
				+ "('5E','Red Bull')");	
	
		queries.insertarDatos(basesDatos[5], "INSERT INTO piezas(codigo,nombre)"
				+ "VALUES (1,'Compresor'),"
				+ "(2,'Bobina'),"
				+ "(3,'Cilindro'),"
				+ "(4,'Tubo'),"
				+ "(5,'Aleron')");		
		
		queries.insertarDatos(basesDatos[5], "INSERT INTO suministra(codigopieza,idproveedor,precio)"
				+ "VALUES (1,'A',500),"
				+ "(2,'C',180),"
				+ "(3,'D',1250),"
				+ "(4,'B',168),"
				+ "(5,'E',4000)");
		
		
		//Tablas Ej 7
		
		queries.crearTabla(basesDatos[6], "cientificos"," (dni VARCHAR(8) NOT NULL PRIMARY KEY,"
				+ " nomapels NVARCHAR(255) NOT NULL"
				+ " )");
				
		queries.crearTabla(basesDatos[6], "proyecto"," (id CHAR(4) NOT NULL PRIMARY KEY,"
				+ "  nombre VARCHAR(255) NOT NULL,"
				+ "  horas INT NOT NULL"
				+ "	)");
				
		queries.crearTabla(basesDatos[6], "asignadoa"," (cientifico VARCHAR(8) NOT NULL,"
				+ "  proyecto CHAR(4) NOT NULL,"
				+ "  FOREIGN KEY (cientifico) REFERENCES cientificos(dni) ON DELETE CASCADE ON UPDATE CASCADE,"
				+ "  FOREIGN KEY (proyecto) REFERENCES proyecto(id) ON DELETE CASCADE ON UPDATE CASCADE"
				+ "	)");

		
		//Inserciones Ej 7.
		
		queries.insertarDatos(basesDatos[6], "INSERT INTO cientificos(dni, nomapels)"
				+ "VALUES ('1111111A', 'Michael Jordan'),"
				+ "('2222222B', 'Scottie Pippen'),"
				+ "('3333333C', 'Dennis Roddman'),"
				+ "('4444444D', 'Horace Grant'),"
				+ "('5555555E', 'Ron Harper')");
				
		queries.insertarDatos(basesDatos[6], "INSERT INTO proyecto(id,nombre,horas)"
				+ "VALUES ('1','Air Jordan',1),"
				+ "('2','Sextete',2),"
				+ "('3','Mejor Defensor',3),"
				+ "('4','6o hombre',4),"
				+ "('5','Director equipo',5)");
				
		queries.insertarDatos(basesDatos[6], "INSERT INTO asignadoa(cientifico, proyecto)"
				+ "VALUES ('1111111A','1'),"
				+ "('2222222B','2'),"
				+ "('3333333C','3'),"
				+ "('4444444D','4'),"
				+ "('5555555E','5')");
			
		
		//Tablas Ej 8
		
		queries.crearTabla(basesDatos[7], "cajeros"," (codigo INT AUTO_INCREMENT PRIMARY KEY,"
				+ " nomapels NVARCHAR(255) NOT NULL"
				+ " )");
				
		queries.crearTabla(basesDatos[7], "productos"," (codigo INT AUTO_INCREMENT PRIMARY KEY,"
				+ "  nombre VARCHAR(100) NOT NULL,"
				+ "  precio INT NOT NULL"
				+ "	)");
				
		queries.crearTabla(basesDatos[7], "maquinasregistradoras"," (codigo INT AUTO_INCREMENT PRIMARY KEY,"
				+ "  piso INT NOT NULL"
				+ "	)");
		
		queries.crearTabla(basesDatos[7], "venta"," (cajero INT NOT NULL,"
				+ "  maquina INT NOT NULL,"
				+ "  producto INT NOT NULL,"
				+ "  PRIMARY KEY (cajero,maquina,producto),"
				+ "  FOREIGN KEY (cajero) REFERENCES cajeros(codigo) ON DELETE CASCADE ON UPDATE CASCADE,"
				+ "  FOREIGN KEY (maquina) REFERENCES maquinasregistradoras(codigo) ON DELETE CASCADE ON UPDATE CASCADE,"
				+ "  FOREIGN KEY (producto) REFERENCES productos(codigo) ON DELETE CASCADE ON UPDATE CASCADE"
				+ "	)");

		
		//Inserciones Ej 8.
		
		queries.insertarDatos(basesDatos[7], "INSERT INTO cajeros(nomapels)"
				+ "VALUES ('Joan Laporta'),"
				+ "('Florentino Perez'),"
				+ "('Enrique Cerezo'),"
				+ "('Peter Lim'),"
				+ "('Angel Martin')");
				
		queries.insertarDatos(basesDatos[7], "INSERT INTO productos(nombre,precio)"
				+ "VALUES ('Arroz',2),"
				+ "('Lentejas',3),"
				+ "('Pasta',4),"
				+ "('Pan',1),"
				+ "('Agua',2)");
				
		queries.insertarDatos(basesDatos[7], "INSERT INTO maquinasregistradoras(piso)"
				+ "VALUES (1),"
				+ "(1),"
				+ "(2),"
				+ "(3),"
				+ "(3)");
		
		queries.insertarDatos(basesDatos[7], "INSERT INTO venta(cajero,maquina,producto)"
				+ "VALUES (1, 1, 1),"
				+ "(2, 2, 2),"
				+ "(3, 3, 3),"
				+ "(4, 4, 4),"
				+ "(5, 5, 5)");
		
		
		//Tablas Ej 9
		
		queries.crearTabla(basesDatos[8], "facultad"," (codigo INT AUTO_INCREMENT PRIMARY KEY,"
				+ " nombre NVARCHAR(100) NOT NULL"
				+ " )");
				
		queries.crearTabla(basesDatos[8], "investigadores"," (dni VARCHAR(8) PRIMARY KEY,"
				+ "  nomapels NVARCHAR(255) NOT NULL,"
				+ "  facultad INT NOT NULL,"
				+ "	 FOREIGN KEY (facultad) REFERENCES facultad(codigo) ON DELETE CASCADE ON UPDATE CASCADE"
				+ "	)");
				
		queries.crearTabla(basesDatos[8], "equipos"," (numserie CHAR(4) PRIMARY KEY,"
				+ "  nombre NVARCHAR(100) NOT NULL,"
				+ "  facultad INT NOT NULL, "
				+ "  FOREIGN KEY (facultad) REFERENCES facultad(codigo) ON DELETE CASCADE ON UPDATE CASCADE"
				+ "	)");
				
		queries.crearTabla(basesDatos[8], "reserva"," (dni VARCHAR(8) NOT NULL,"
				+ "  numserie CHAR(4) NOT NULL,"
				+ "  comienzo DATE NOT NULL,"
				+ "  fin DATE NOT NULL,"
				+ "  PRIMARY KEY (dni,numserie),"
				+ "  FOREIGN KEY (dni) REFERENCES investigadores(dni) ON DELETE CASCADE ON UPDATE CASCADE,"
				+ "  FOREIGN KEY (numserie) REFERENCES equipos(numserie) ON DELETE CASCADE ON UPDATE CASCADE"
				+ "	)");
		
		
		//Inserciones Ej 9
		
		queries.insertarDatos(basesDatos[8], "INSERT INTO facultad(nombre)"
				+ "VALUES ('Deporte'),"
				+ "('Derecho'),"
				+ "('Geografia'),"
				+ "('Salud'),"
				+ "('Ingenieria')");
						
		queries.insertarDatos(basesDatos[8], "INSERT INTO investigadores(dni, nomapels, facultad)"
				+ "VALUES ('1111111A', 'Luis Aragones',1),"
				+ "('2222222B','Baltasar Garzon',2),"
				+ "('3333333C','Tomas Molina',3),"
				+ "('4444444D','Miguel Servet',4),"
				+ "('5555555E','Pedro Duque',5)");
						
		queries.insertarDatos(basesDatos[8], "INSERT INTO equipos(numserie, nombre, facultad)"
				+ "VALUES ('1111','E1',1),"
				+ "('2222','E2',2),"
				+ "('3333','E3',3),"
				+ "('4444','E4',4),"
				+ "('5555','E5',5)");
				
		queries.insertarDatos(basesDatos[8], "INSERT INTO reserva(dni, numserie, comienzo, fin)"
				+ "VALUES ('1111111A','1111', '2022-01-01','2022-02-01'),"
				+ "('2222222B','2222', '2022-02-02','2022-03-02'),"
				+ "('3333333C','3333', '2022-03-03','2022-04-03'),"
				+ "('4444444D','4444', '2022-04-04','2022-05-04'),"
				+ "('5555555E','5555', '2022-05-05','2022-06-05')");
		
		queries.cerrarConexion();
		
	}

}
