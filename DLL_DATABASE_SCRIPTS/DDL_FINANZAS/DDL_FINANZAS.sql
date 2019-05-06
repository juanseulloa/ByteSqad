/*==============================================================*/
/* DBMS name:      PostgreSQL 9.x                               */
/* Created by:     THE ALIRIOS		                            */
/*==============================================================*/

/*==============================================================*/
/* Table: PLAN_CONTABLE                                         */
/*==============================================================*/
CREATE TABLE "FINANZAS".PLAN_CONTABLE(
	CODIGO INTEGER PRIMARY KEY NOT NULL,
	NOMBRE CHARACTER VARYING (100) NOT NULL,
	DESCRIPCION  CHARACTER VARYING (300) NOT NULL,
	TIPO  INTEGER NOT NULL,
	VIGENCIA DATE NOT NULL,
	CODIGO_PADRE  INTEGER
);

COMMENT ON TABLE "FINANZAS".PLAN_CONTABLE
    IS 'Tabla donde se almacenan todo el plan unico de cuentas ';

COMMENT ON COLUMN "FINANZAS".PLAN_CONTABLE.CODIGO IS 'Código de la cuenta – PUC';
COMMENT ON COLUMN "FINANZAS".PLAN_CONTABLE.NOMBRE IS 'NOMBRE de la cuenta';
COMMENT ON COLUMN "FINANZAS".PLAN_CONTABLE.DESCRIPCION IS 'Descripción de la cuenta';
COMMENT ON COLUMN "FINANZAS".PLAN_CONTABLE.TIPO IS 'Clase(1), grupo(2),cuenta(3), subcuenta(4)';
COMMENT ON COLUMN "FINANZAS".PLAN_CONTABLE.VIGENCIA IS 'Fecha de inicio de VIGENCIA';
COMMENT ON COLUMN "FINANZAS".PLAN_CONTABLE.CODIGO_PADRE IS 'Identificador de padre';

ALTER TABLE "FINANZAS".PLAN_CONTABLE
   ADD CONSTRAINT "Fk_PLANCONTABLE_PLANCONTABLE" FOREIGN KEY (CODIGO_PADRE)
        REFERENCES "FINANZAS".PLAN_CONTABLE(CODIGO);


/*==============================================================*/
/* Table: PERIODO                                               */
/*==============================================================*/
CREATE TABLE "FINANZAS".PERIODO
(
   CODIGO            SERIAL PRIMARY KEY NOT NULL ,
   FECHA_INICIO      DATE NOT NULL,
   FECHA_FIN      DATE NOT NULL,
   ESTADO      BOOLEAN NOT NULL
   
);

COMMENT ON TABLE "FINANZAS".PERIODO
    IS 'Tabla donde se almacenan el periodo contable ';

COMMENT ON COLUMN "FINANZAS".PERIODO.CODIGO IS 'codigo del periodo';
COMMENT ON COLUMN "FINANZAS".PERIODO.FECHA_INICIO IS 'fecha inicio';
COMMENT ON COLUMN "FINANZAS".PERIODO.FECHA_FIN IS 'fecha final';
COMMENT ON COLUMN "FINANZAS".PERIODO.ESTADO IS 'Activo (1), inactivo (0)';

/*==============================================================*/
/* Table: LIBRO_MAYOR                                           */
/*==============================================================*/
CREATE TABLE "FINANZAS".LIBRO_MAYOR(
    PLAN_CONTABLE_COD SERIAL NOT NULL,
    PERIODO_COD INTEGER NOT NULL,
    DEBE DECIMAL NOT NULL,
    HABER DECIMAL NOT NULL,
    FECHA DATE NOT NULL,
    ESTADO BOOLEAN NOT NULL,
	PRIMARY KEY(PLAN_CONTABLE_COD,PERIODO_COD)
);

COMMENT ON TABLE "FINANZAS".LIBRO_MAYOR
    IS 'Tabla donde se almacenan EL LIBRO MAYOR';

COMMENT ON COLUMN "FINANZAS".LIBRO_MAYOR.PLAN_CONTABLE_COD is 'Código de la tabla plan_contable';
COMMENT ON COLUMN "FINANZAS".LIBRO_MAYOR.PERIODO_COD is 'Código del periodo contable';
COMMENT ON COLUMN "FINANZAS".LIBRO_MAYOR.DEBE is 'Valor total del debe (valores positivos) en la tabla libro_diario';
COMMENT ON COLUMN "FINANZAS".LIBRO_MAYOR.HABER is 'Valor total del haber (valores negativos) en la tabla libro_diario';
COMMENT ON COLUMN "FINANZAS".LIBRO_MAYOR.FECHA is 'Fecha de generación del libro mayor';
COMMENT ON COLUMN "FINANZAS".LIBRO_MAYOR.ESTADO is 'Activo (1), inactivo (0)';

ALTER TABLE "FINANZAS".LIBRO_MAYOR
   ADD CONSTRAINT "FK_PLANCONTABLE_LIBROMAYOR" FOREIGN KEY (PLAN_CONTABLE_COD)
        REFERENCES "FINANZAS".PLAN_CONTABLE(CODIGO);

ALTER TABLE "FINANZAS".LIBRO_MAYOR
   ADD CONSTRAINT "FK_PERIODO_LIBROMAYOR" FOREIGN KEY (PERIODO_COD)
        REFERENCES "FINANZAS".PERIODO(CODIGO);


/*==============================================================*/
/* Table: CONCEPTO                                              */
/*==============================================================*/
CREATE TABLE "FINANZAS".CONCEPTO
(
    CODIGO SERIAL NOT NULL PRIMARY KEY,
    NOMBRE CHARACTER VARYING(20) NOT NULL,
    DESCRPCION CHARACTER VARYING(100),
    TIPO BOOLEAN NOT NULL,
    ESTADO BOOLEAN NOT NULL,
    PLAN_CONTABLE_CODIGO INTEGER NOT NULL
);


ALTER TABLE "FINANZAS".CONCEPTO
   ADD CONSTRAINT "FK_PLANCONTABLE_CONCEPTO_PL" FOREIGN KEY (PLAN_CONTABLE_CODIGO)
        REFERENCES "FINANZAS".PLAN_CONTABLE(CODIGO);

COMMENT ON TABLE "FINANZAS".CONCEPTO
    IS 'Tabla donde se almacenan los datos de cada cargo o los CONCEPTOS ';

COMMENT ON COLUMN "FINANZAS".CONCEPTO.CODIGO
    IS 'Llave primaria de la tabla CONCEPTO, CODIGO del cargo';

COMMENT ON COLUMN "FINANZAS".CONCEPTO.DESCRPCION
    IS 'Funciones del cargo ';

COMMENT ON COLUMN "FINANZAS".CONCEPTO.TIPO
    IS 'Define el TIPO del cargo y Los valores son: (1)Debe (0)Haber';

COMMENT ON COLUMN "FINANZAS".CONCEPTO.ESTADO
    IS 'Este atributo define el ESTADO de actividad o inactividad del cargo donde: (1) Activo (0) Inactivo';

COMMENT ON COLUMN "FINANZAS".CONCEPTO.PLAN_CONTABLE_CODIGO
    IS 'CODIGO de la tabla plan contable';

COMMENT ON COLUMN "FINANZAS".CONCEPTO.NOMBRE
    IS 'NOMBRE del cargo';


/*==============================================================*/
/* Table: LIBRO_DIARIO                                          */
/*==============================================================*/
CREATE TABLE "FINANZAS".LIBRO_DIARIO(
	ASIENTO SERIAL PRIMARY KEY NOT NULL,
	FECHA DATE NOT NULL,
	VALOR DECIMAL NOT NULL,
	PERIODO_COD INTEGER NOT NULL,
	CONCEPTO_COD INTEGER NOT NULL,
	ESTADO BOOLEAN NOT NULL
);

COMMENT ON TABLE "FINANZAS".LIBRO_DIARIO
    IS 'Tabla donde se almacenan EL LIBRO DIARIO ';

COMMENT ON COLUMN "FINANZAS".LIBRO_DIARIO.ASIENTO IS 'Código secuencial del movimiento contable';
COMMENT ON COLUMN "FINANZAS".LIBRO_DIARIO.FECHA IS 'Fecha del movimiento contable';
COMMENT ON COLUMN "FINANZAS".LIBRO_DIARIO.VALOR  IS 'Valor del asiento contable';
COMMENT ON COLUMN "FINANZAS".LIBRO_DIARIO.PERIODO_COD IS 'Código del periodo contable';
COMMENT ON COLUMN "FINANZAS".LIBRO_DIARIO.CONCEPTO_COD IS 'Código del concepto contable';
COMMENT ON COLUMN "FINANZAS".LIBRO_DIARIO.ESTADO IS 'Activo (1), inactivo(0)';

ALTER TABLE "FINANZAS".LIBRO_DIARIO
   ADD CONSTRAINT "Fk_LIBRODIARIO_PERIODO" FOREIGN KEY (PERIODO_COD)
      	REFERENCES "FINANZAS".PERIODO(CODIGO);

ALTER TABLE "FINANZAS".LIBRO_DIARIO 
   ADD CONSTRAINT "Fk_LIBRODIARIO_CONCEPTO" FOREIGN KEY (CONCEPTO_COD) 
      REFERENCES "FINANZAS".CONCEPTO(CODIGO);
