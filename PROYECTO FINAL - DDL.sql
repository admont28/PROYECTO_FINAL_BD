/* CONVENCIONES 
  TABLAS DE MAS DE 2 PALABRAS SE UTILIZAN LAS 3 PRIMERAS LETRAS DE CADA PALABRA PARA LA LLAVE PRIMARIA
  
  PARA LAS LLAVES FORANEAS SE UTILIZA LA SIGUIENTE SINTAXIS (CAMBIAR LO QUE ESTA EN MINUSCULA):
  FK_nombreTablaForanea_EN_TablaActual
  


*/


CREATE TABLE AUXILIAR(
AUX_ID VARCHAR2 (20) NOT NULL,
NOMBRE_AUX VARCHAR2 (50) NOT NULL,
APELLIDO_AUX VARCHAR2 (50) NOT NULL,
TELEFONO_AUX VARCHAR2 (20) NOT NULL, -- Falta normalizar Direccion, Programa académico--
CONSTRAINT PK_AUX PRIMARY KEY (AUX_ID)
);

COMMENT ON TABLE AUXILIAR IS 'Es la entidad que contiene los datos del auxiliar o estudiante que postula o puede observar las convocatorias.';
COMMENT ON COLUMN AUXILIAR.AUX_ID IS 'Es la identificacion del auxiliar y la llave primaria';

COMMENT ON COLUMN AUXILIAR.NOMBRE_AUX IS 'Es el nombre del auxiliar';
COMMENT ON COLUMN AUXILIAR.APELLIDO_AUX IS 'Es el apellido del auxiliar';
COMMENT ON COLUMN AUXILIAR.TELEFONO_AUX IS 'Es el telefono del auxiliar';

CREATE TABLE SOLICITANTE (
SOL_ID VARCHAR2 (20) NOT NULL,
NOMBRE_SOL VARCHAR2 (50) NOT NULL,
APELLIDO_SOL VARCHAR2 (50) NOT NULL,
TELEFONO_SOL VARCHAR2 (20) NOT NULL,--Falta normalizar area - Cargo - Direccion
CONSTRAINT PK_SOL PRIMARY KEY (SOL_ID),
);
COMMENT ON TABLE SOLICITANTE IS 'Es la entidad que contiene los datos del solicitante quien .';
COMMENT ON COLUMN AUXILIAR.AUX_ID IS 'Es la identificacion del auxiliar y la llave primaria';
COMMENT ON COLUMN AUXILIAR.NOMBRE_AUX IS 'Es el nombre del auxiliar';
COMMENT ON COLUMN AUXILIAR.APELLIDO_AUX IS 'Es el apellido del auxiliar';
COMMENT ON COLUMN AUXILIAR.TELEFONO_AUX IS 'Es el telefono del auxiliar';

/*
CREATE TABLE REGISTRO_EXTENDIDO(
REG_EXT_ID VARCHAR2 (20) NOT NULL,
ID_AUX VARCHAR2 (50) NOT NULL,
ID_PRO_ACA VARCHAR2 (50) NOT NULL,
VARCHAR2 (20) NOT NULL, -- 
CONSTRAINT PK_REG_EXT PRIMARY KEY (REG_EXT_ID)
);
*/
/*
CREATE TABLE ESPACIO_ACADEMICO(
  ESP_ACA_ID VARCHAR2(20) NOT NULL,
  NOMBRE_ESP_ACA VARCHAR2(50) NOT NULL,
  CONSTRAINT PK_ESP_ACA PRIMARY KEY (ESP_ACA_ID)
);
*/


/* TABLA INTERMEDIA (1 REG_EXT TIENE MUCHOS ESP_ACA Y 1 ESP_ACA PUEDE ESTAR EN MUCHOS REG_EXT)*/
/*
CREATE TABLE REGISTRO_EXTENDIDO_ESPACIO_ACADEMICO(
  ID_REG_EXT VARCHAR2(20) NOT NULL,
  ID_ESP_ACA VARCHAR2(20) NOT NULL,
  CALIFICACION NUMBER(1,3) NOT NULL,

  CONSTRAINT FK_REG_EXT FOREIGN KEY (ID_REG_EXT) REFERENCES REGISTRO_EXTENDIDO (REG_EXT_ID),
  CONSTRAINT FK_ESP_ACA FOREIGN KEY (ID_ESP_ACA) REFERENCES ESPACIO_ACADEMICO (ESP_ACA_ID)
);
*/

CREATE TABLE PROGRAMA_ACADEMICO(
  PRO_ACA_ID VARCHAR2(20) NOT NULL,
  NOMBRE_PRO_ACA VARCHAR2(50) NOT NULL,
  ID_FACULTAD VARCHAR2(2) NOT NULL,
  
  CONSTRAINT FK_FACULTAD_EN_PROGRAMA_ACADEMICO FOREIGN KEY (ID_FACULTAD) REFERENCES FACULTAD (FACULTAD_ID)
);

CREATE TABLE FACULTAD(
  FACULTAD_ID VARCHAR2(2) NOT NULL,
  NOMBRE_FACULTAD VARCHAR2(50) NOT NULL,
  ID_UNIVERSIDAD VARCHAR2(5) NOT NULL,
  
  CONSTRAINT FK_UNIVERSIDAD_EN_FACULTAD FOREIGN KEY (ID_UNIVERSIDAD) REFERENCES UNIVERSIDAD (UNIVERSIDAD_ID)
);

CREATE TABLE UNIVERSIDAD(
  UNIVERSIDAD_ID Varchar (20) NOT NULL,
  NOMBRE_UNIVERSIDAD VARCHAR (20) NOT NULL
);


CREATE TABLE HORARIO (
HOR_ID VARCHAR (20) NOT NULL,
FECHA_HOR DATE NOT NULL,
HORA_INI VARCHAR ()
);




