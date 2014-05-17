CREATE TABLE AUXILIAR(
AUX_ID VARCHAR2 (20) NOT NULL,
NOMBRE_AUX VARCHAR2 (50) NOT NULL,
APELLIDO_AUX VARCHAR2 (50) NOT NULL,
TELEFONO_AUX VARCHAR2 (20) NOT NULL, -- Falta normalizar Direccion, Programa acad�mico--
CONSTRAINT PK_AUX PRIMARY KEY (AUX_ID)
);

COMMENT ON TABLE AUXILIAR IS 'Es la entidad que contiene los datos del auxiliar o estudiante que postula o puede observar las convocatorias.';
COMMENT ON COLUMN AUXILIAR.AUX_ID IS 'Es la identificacion del auxiliar y la llave primaria';
COMMENT ON COLUMN AUXILIAR.NOMBRE_AUX IS 'Es el nombre del auxiliar';
COMMENT ON COLUMN AUXILIAR.APELLIDO_AUX IS 'Es el apellido del auxiliar';
COMMENT ON COLUMN AUXILIAR.TELEFONO_AUX IS 'Es el telefono del auxiliar';

CREATE TABLE SOLICITANTE (
SOLICITANTE_ID VARCHAR2 (20) NOT NULL,
NOMBRE_SOL VARCHAR2 (50) NOT NULL,
APELLIDO_SOL VARCHAR2 (50) NOT NULL,
TELEFONO_SOL VARCHAR2 (20) NOT NULL,--Falta normalizar area 