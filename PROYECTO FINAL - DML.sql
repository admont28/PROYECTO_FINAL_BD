/*INSERTAR EN CIUDAD*/
INSERT INTO CIUDAD (CIUDAD_ID, NOMBRE_CIUDAD)
VALUES ('1','ARMENIA');
INSERT INTO CIUDAD (CIUDAD_ID, NOMBRE_CIUDAD)
VALUES ('2','PEREIRA');
INSERT INTO CIUDAD (CIUDAD_ID, NOMBRE_CIUDAD)
VALUES ('3','CALARCA');
INSERT INTO CIUDAD (CIUDAD_ID, NOMBRE_CIUDAD)
VALUES ('4','TEBAIDA');
INSERT INTO CIUDAD (CIUDAD_ID, NOMBRE_CIUDAD)
VALUES ('5','MONTENEGRO');

/*INSERTAR EN DIRECCION*/
INSERT INTO DIRECCION (DIRECCION_ID, CALLE, CARRERA, NUMERO, ID_CIUDAD)
VALUES ('1','20','23','38','1');
INSERT INTO DIRECCION (DIRECCION_ID, CALLE, CARRERA, NUMERO, ID_CIUDAD)
VALUES ('2','60','39','34','2');
INSERT INTO DIRECCION (DIRECCION_ID, CALLE, CARRERA, NUMERO, ID_CIUDAD)
VALUES ('3','80','99','12','1');
INSERT INTO DIRECCION (DIRECCION_ID, CALLE, CARRERA, NUMERO, ID_CIUDAD)
VALUES ('4','90','78','19','3');
INSERT INTO DIRECCION (DIRECCION_ID, CALLE, CARRERA, NUMERO, ID_CIUDAD)
VALUES ('5','15','45','03','5');

/*INSERTAR EN UNIVERSIDAD*/
INSERT INTO UNIVERSIDAD (UNIVERSIDAD_ID, NOMBRE_UNIVERSIDAD, ID_DIRECCION)
VALUES ('1','UNIVERSIDAD DEL QUINDIO','3');

/*INSERTAR EN FACULTAD*/
INSERT INTO FACULTAD (FACULTAD_ID, NOMBRE_FACULTAD, ID_UNIVERSIDAD)
VALUES ('1','INGENIERIA','1');

/*INSERTAR EN SECRETARIA*/
INSERT INTO SECRETARIA (SECRETARIA_ID, NOMBRE_SECRETARIA, APELLIDO_SECRETARIA, TELEFONO_SECRETARIA, PASSWORD_SECRETARIA)
VALUES ('111222','CRISTINA','AGUILERA','7401454','12345');

/*INSERTAR EN CONSEJO_CURRICULAR*/
INSERT INTO CONSEJO_CURRICULAR (CONSEJO_CURRICULAR_ID, ID_SECRETARIA)
VALUES ('1','111222');

/*INSERTAR EN AREA*/
INSERT INTO AREA (AREA_ID, NOMBRE_AREA)
VALUES ('1','PROGRAMACION Y ALGORITMIA');
INSERT INTO AREA (AREA_ID, NOMBRE_AREA)
VALUES ('2','CIENCIAS BASICAS');
INSERT INTO AREA (AREA_ID, NOMBRE_AREA)
VALUES ('3','ELECTIVAS');
INSERT INTO AREA (AREA_ID, NOMBRE_AREA)
VALUES ('4','FISICA');
INSERT INTO AREA (AREA_ID, NOMBRE_AREA)
VALUES ('5','ADMINISTRATIVA');

/*INSERTAR EN CARGO*/
INSERT INTO CARGO (CARGO_ID, NOMBRE_CARGO)
VALUES ('1','DIRECTOR DE PROGRAMA');
INSERT INTO CARGO (CARGO_ID, NOMBRE_CARGO)
VALUES ('2','DOCENTE');
INSERT INTO CARGO (CARGO_ID, NOMBRE_CARGO)
VALUES ('3','JEFE DE AREA');
INSERT INTO CARGO (CARGO_ID, NOMBRE_CARGO)
VALUES ('4','DIRECTOR DE EXTENSION');
INSERT INTO CARGO (CARGO_ID, NOMBRE_CARGO)
VALUES ('5','COORDINADOR DE GRUPO DE INVESTIGACION');

/*INSERTAR EN PROGRAMA_ACADEMICO*/
INSERT INTO PROGRAMA_ACADEMICO (PROGRAMA_ACADEMICO_ID, NOMBRE_PROGRAMA, ID_FACULTAD, ID_CONSEJO_CURRICULAR)
VALUES ('1','INGENIERIA DE SISTEMAS Y COMPUTACION', '1', '1');

/*INSERTAR EN SOLICITANTE*/
INSERT INTO SOLICITANTE (SOLICITANTE_ID, NOMBRE_SOLICITANTE, APELLIDO_SOLICITANTE, TELEFONO_SOLICITANTE, ID_DIRECCION, ID_CARGO, ID_AREA, ID_CONSEJO_CURRICULAR, ID_PROGRAMA_ACADEMICO,PASSWORD_SOLICITANTE)
VALUES ('1','ROBINSON','PULGARIN', '3154191900', '1','1','5','1','1','12345');
INSERT INTO SOLICITANTE (SOLICITANTE_ID, NOMBRE_SOLICITANTE, APELLIDO_SOLICITANTE, TELEFONO_SOLICITANTE, ID_DIRECCION, ID_CARGO, ID_AREA, ID_CONSEJO_CURRICULAR, ID_PROGRAMA_ACADEMICO,PASSWORD_SOLICITANTE)
VALUES ('2','EDWIN','ROMERO', '3012234553', '2','3','2','1','1','12345');
INSERT INTO SOLICITANTE (SOLICITANTE_ID, NOMBRE_SOLICITANTE, APELLIDO_SOLICITANTE, TELEFONO_SOLICITANTE, ID_DIRECCION, ID_CARGO, ID_AREA, ID_CONSEJO_CURRICULAR, ID_PROGRAMA_ACADEMICO,PASSWORD_SOLICITANTE)
VALUES ('3','CRISTIAN','CANDELA', '3184728133', '3','5','1','1','1','12345');
INSERT INTO SOLICITANTE (SOLICITANTE_ID, NOMBRE_SOLICITANTE, APELLIDO_SOLICITANTE, TELEFONO_SOLICITANTE, ID_DIRECCION, ID_CARGO, ID_AREA, ID_CONSEJO_CURRICULAR, ID_PROGRAMA_ACADEMICO,PASSWORD_SOLICITANTE)
VALUES ('4','JENNY','RAMIREZ', '3114742904', '4','2','1','1','1','12345');
INSERT INTO SOLICITANTE (SOLICITANTE_ID, NOMBRE_SOLICITANTE, APELLIDO_SOLICITANTE, TELEFONO_SOLICITANTE, ID_DIRECCION, ID_CARGO, ID_AREA, ID_CONSEJO_CURRICULAR, ID_PROGRAMA_ACADEMICO,PASSWORD_SOLICITANTE)
VALUES ('5','FABER','GIRALDO', '3016481827', '5','4','3','1','1','12345');


/*INSERTAR EN JORNADA*/
INSERT INTO JORNADA (JORNADA_ID, NOMBRE_JORNADA)
VALUES ('1', 'DUIRNA');
INSERT INTO JORNADA (JORNADA_ID, NOMBRE_JORNADA)
VALUES ('2', 'NOCTURNA');

/*INSERTAR EN DIRECTORES*/
INSERT INTO DIRECTORES (ID_PROGRAMA, ID_SOLICITANTE,ID_JORNADA)
VALUES ('1', '1','1');
INSERT INTO DIRECTORES (ID_PROGRAMA, ID_SOLICITANTE,ID_JORNADA)
VALUES ('1', '5','2');

/*INSERTAR EN AUXILIAR*/
INSERT INTO AUXILIAR (AUXILIAR_ID, CODIGO_AUXILIAR, NOMBRE_AUXILIAR, APELLIDO_AUXILIAR, TELEFONO_AUXILIAR, ID_DIRECCION, ID_PROGRAMA_ACADEMICO, PASSWORD_AUX)
VALUES ('1','91080816','ALEXANDER','VARGAS','7401030','1','1','12345');
INSERT INTO AUXILIAR (AUXILIAR_ID, CODIGO_AUXILIAR, NOMBRE_AUXILIAR, APELLIDO_AUXILIAR, TELEFONO_AUXILIAR, ID_DIRECCION, ID_PROGRAMA_ACADEMICO, PASSWORD_AUX)
VALUES ('2','14219942','ANDRES','MONTOYA','3005529469','2','1','12345');
INSERT INTO AUXILIAR (AUXILIAR_ID, CODIGO_AUXILIAR, NOMBRE_AUXILIAR, APELLIDO_AUXILIAR, TELEFONO_AUXILIAR, ID_DIRECCION, ID_PROGRAMA_ACADEMICO, PASSWORD_AUX)
VALUES ('3','14135578','JEISON','BARBOSA','3117630511','3','1','12345');
INSERT INTO AUXILIAR (AUXILIAR_ID, CODIGO_AUXILIAR, NOMBRE_AUXILIAR, APELLIDO_AUXILIAR, TELEFONO_AUXILIAR, ID_DIRECCION, ID_PROGRAMA_ACADEMICO, PASSWORD_AUX)
VALUES ('4','38247560','DIANA','FARFAN','3135261570','4','1','12345');
INSERT INTO AUXILIAR (AUXILIAR_ID, CODIGO_AUXILIAR, NOMBRE_AUXILIAR, APELLIDO_AUXILIAR, TELEFONO_AUXILIAR, ID_DIRECCION, ID_PROGRAMA_ACADEMICO, PASSWORD_AUX)
VALUES ('5','2557234','YURI','BONILLA','3117806055','5','1','12345');

/*INSERTAR EN TIPO_REQUISITO*/
INSERT INTO TIPO_REQUISITO (TIPO_REQUISITO_ID, DESCRIPCION_TIPO_REQUISITO)
VALUES ('1','GENERAL');
INSERT INTO TIPO_REQUISITO (TIPO_REQUISITO_ID, DESCRIPCION_TIPO_REQUISITO)
VALUES ('2','ESPECIFICO');

/*INSERTAR EN REQUISITO*/
INSERT INTO REQUISITO (REQUISITO_ID, DESCRIPCION_REQUISITO, ID_TIPO_REQUISITO)
VALUES ('1','PROMEDIO SUPERIOR A 3,5','1' );
INSERT INTO REQUISITO (REQUISITO_ID, DESCRIPCION_REQUISITO, ID_TIPO_REQUISITO)
VALUES ('2','HABER APROBADO LA TOTALIDAD DE CREDITOS EN EL SEMESTRE ANTERIOR','1' );
INSERT INTO REQUISITO (REQUISITO_ID, DESCRIPCION_REQUISITO, ID_TIPO_REQUISITO)
VALUES ('3','APROBAR PRUEBA DE CONOCIMIENTO','2' );
INSERT INTO REQUISITO (REQUISITO_ID, DESCRIPCION_REQUISITO, ID_TIPO_REQUISITO)
VALUES ('4','HABER APROBADO CALCULO MULTIVARIADO Y VECTORIAL EN 5','2' );
INSERT INTO REQUISITO (REQUISITO_ID, DESCRIPCION_REQUISITO, ID_TIPO_REQUISITO)
VALUES ('5','ESTAR EN 5 SEMESTRE O SUPERIOR','2' );

/*INSERTAR EN SOLICITUD_AUXILIARES*/
INSERT INTO SOLICITUD_AUXILIARES (SOLICITUD_AUXILIARES_ID, CANTIDAD_AUXILIARES, CANTIDAD_HORAS, DESC_SOLICITUD_AUXILIARES, FECHA_CREACION, ID_SOLICITANTE)
VALUES ('1', 3, 5, 'SON LOS AUXILIARES SOLICITADOS PARA LOS CALCULOS','19/05/2014', 1 );
INSERT INTO SOLICITUD_AUXILIARES (SOLICITUD_AUXILIARES_ID, CANTIDAD_AUXILIARES, CANTIDAD_HORAS, DESC_SOLICITUD_AUXILIARES, FECHA_CREACION, ID_SOLICITANTE)
VALUES ('2', 4, 6, 'SON LOS AUXILIARES SOLICITADOS PARA BASES DE DATOS','18/05/2014', 2 );
INSERT INTO SOLICITUD_AUXILIARES (SOLICITUD_AUXILIARES_ID, CANTIDAD_AUXILIARES, CANTIDAD_HORAS, DESC_SOLICITUD_AUXILIARES, FECHA_CREACION, ID_SOLICITANTE)
VALUES ('3', 6, 8, 'SON LOS AUXILIARES SOLICITADOS EL LABORATORIO DE SISTEMAS','16/05/2014', 1 );
INSERT INTO SOLICITUD_AUXILIARES (SOLICITUD_AUXILIARES_ID, CANTIDAD_AUXILIARES, CANTIDAD_HORAS, DESC_SOLICITUD_AUXILIARES, FECHA_CREACION, ID_SOLICITANTE)
VALUES ('4', 5, 7, 'SON LOS AUXILIARES SOLICITADOS PARA INGENIERIA DE SOFTWARE','17/05/2014', 3 );
INSERT INTO SOLICITUD_AUXILIARES (SOLICITUD_AUXILIARES_ID, CANTIDAD_AUXILIARES, CANTIDAD_HORAS, DESC_SOLICITUD_AUXILIARES, FECHA_CREACION, ID_SOLICITANTE)
VALUES ('5', 7, 9, 'SON LOS AUXILIARES SOLICITADOS PARA EL SINFOCI','16/05/2014', 5 );

/*INSERTAR EN SOL_AUXILIARES_REQUISITOS*/
INSERT INTO SOL_AUXILIARES_REQUISITOS (ID_REQUISITO, ID_SOLICITUD_AUXILIARES)
VALUES ('1','1');
INSERT INTO SOL_AUXILIARES_REQUISITOS (ID_REQUISITO, ID_SOLICITUD_AUXILIARES)
VALUES ('2','1');
INSERT INTO SOL_AUXILIARES_REQUISITOS (ID_REQUISITO, ID_SOLICITUD_AUXILIARES)
VALUES ('3','5');
INSERT INTO SOL_AUXILIARES_REQUISITOS (ID_REQUISITO, ID_SOLICITUD_AUXILIARES)
VALUES ('4','3');
INSERT INTO SOL_AUXILIARES_REQUISITOS (ID_REQUISITO, ID_SOLICITUD_AUXILIARES)
VALUES ('5','2');
INSERT INTO SOL_AUXILIARES_REQUISITOS (ID_REQUISITO, ID_SOLICITUD_AUXILIARES)
VALUES ('1','4');

/*INSERTAR EN TIPO_AUXILIAR*/
INSERT INTO TIPO_AUXILIAR (TIPO_AUXILIAR_ID, DESCRIPCION_TIPO_AUXILIAR)
VALUES ('1','AUXILIAR DE SALA');
INSERT INTO TIPO_AUXILIAR (TIPO_AUXILIAR_ID, DESCRIPCION_TIPO_AUXILIAR)
VALUES ('2','AUXILIAR DE DOCENCIA');
INSERT INTO TIPO_AUXILIAR (TIPO_AUXILIAR_ID, DESCRIPCION_TIPO_AUXILIAR)
VALUES ('3','AUXILIAR DE INVESTIGACION');
INSERT INTO TIPO_AUXILIAR (TIPO_AUXILIAR_ID, DESCRIPCION_TIPO_AUXILIAR)
VALUES ('4','AUXILIAR ADMINISTRATIVO');
INSERT INTO TIPO_AUXILIAR (TIPO_AUXILIAR_ID, DESCRIPCION_TIPO_AUXILIAR)
VALUES ('5','AUXILIAR CONFIGURACION');

commit;
