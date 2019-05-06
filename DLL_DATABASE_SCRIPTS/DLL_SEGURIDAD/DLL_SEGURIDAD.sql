/*
 Database 'usta_empresarial'
 Schema 'seguridad'
 Created by: jobless-team
 version: 1.0.1
 date: 29th April 2019
 */
 
CREATE SCHEMA seguridad;
/*==============================================================*/
/* Table: USUARIO                                          */
/*==============================================================*/
CREATE TABLE seguridad.USUARIO (
    codigo       SERIAL                              NOT NULL,
    nombre       CHARACTER VARYING(40)               NOT NULL,
    email        CHARACTER VARYING(30)               NOT NULL,
    password     CHARACTER VARYING(75)              NOT NULL,
    fecha_inicio TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    fecha_fin    TIMESTAMP,
    tipo         INTEGER                             NOT NULL,
    PRIMARY KEY (codigo)
);
COMMENT ON TABLE seguridad.USUARIO IS 'Personas registradas en el sistema';

COMMENT ON COLUMN seguridad.USUARIO.codigo IS 'Código del usuario';
COMMENT ON COLUMN seguridad.USUARIO.nombre IS 'Nombre del usuario';
COMMENT ON COLUMN seguridad.USUARIO.emaIl IS 'Email del usuario ';
COMMENT ON COLUMN seguridad.USUARIO.password IS 'Contraseña encriptada del usuario';
COMMENT ON COLUMN seguridad.USUARIO.fecha_inicio IS 'Fecha inicio acceso al sistema';
COMMENT ON COLUMN seguridad.USUARIO.fecha_fin IS 'Fecha final acceso al sistema';
COMMENT ON COLUMN seguridad.USUARIO.tipo IS 'Interno(1), LDAP(2)';

/*==============================================================*/
/* Table: ROL                                            */
/*==============================================================*/
CREATE TABLE seguridad.ROL (
    codigo      SERIAL                 NOT NULL,
    nombre      CHARACTER VARYING(30)  NOT NULL,
    descripcion CHARACTER VARYING(250),
    estado      BOOLEAN DEFAULT 'true' NOT NULL,
    PRIMARY KEY (codigo)
);
COMMENT ON TABLE seguridad.ROL IS 'Roles de acceso al sistema';

COMMENT ON COLUMN seguridad.ROL.codigo IS 'Código del rol';
COMMENT ON COLUMN seguridad.ROL.nombre IS 'Nombre del Rol';
COMMENT ON COLUMN seguridad.ROL.descripcion IS 'Descripción del Rol';
COMMENT ON COLUMN seguridad.ROL.estado IS 'Activo(1), Inactivo(0)';

/*==============================================================*/
/* Table: PERMISO                                            */
/*==============================================================*/
CREATE TABLE seguridad.PERMISO (
    codigo      SERIAL                 NOT NULL,
    nombre      CHARACTER VARYING(30)  NOT NULL,
    descripcion CHARACTER VARYING(250) NOT NULL,
    estado      BOOLEAN DEFAULT 'true' NOT NULL,
    PRIMARY KEY (codigo)
);
COMMENT ON TABLE seguridad.PERMISO IS 'Permisos de acceso a módulos';

COMMENT ON COLUMN seguridad.PERMISO.codigo IS 'Código del permiso';
COMMENT ON COLUMN seguridad.PERMISO.nombre IS 'Nombre del permiso';
COMMENT ON COLUMN seguridad.PERMISO.descripcion IS 'Descripción del permiso';
COMMENT ON COLUMN seguridad.PERMISO.estado IS 'Activo(1), Inactivo(0)';

/*==============================================================*/
/* Table: USUARIO_LOG                                        */
/*==============================================================*/
CREATE table seguridad.USUARIO_LOG (
    codigo      SERIAL                              NOT NULL,
    fecha       TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    usuario_cod INTEGER                             NOT NULL,
    proceso     CHARACTER VARYING(50)               NOT NULL,
    dml         CHARACTER VARYING(50)               NOT NULL,
    PRIMARY KEY ("codigo")
);
COMMENT ON TABLE seguridad.USUARIO_LOG IS 'Historial de acciones de un usuario';

COMMENT ON COLUMN seguridad.USUARIO_LOG.codigo IS 'Código secuencial del log';
COMMENT ON COLUMN seguridad.USUARIO_LOG.fecha IS 'Fecha de log';
COMMENT ON COLUMN seguridad.USUARIO_LOG.usuario_cod IS 'Codigo del usuario';
COMMENT ON COLUMN seguridad.USUARIO_LOG.proceso IS 'Nombre del proceso que ejecuto el log';
COMMENT ON COLUMN seguridad.USUARIO_LOG.dml IS 'Operación DML que realizo el usuario';

ALTER TABLE seguridad.USUARIO_LOG
    ADD CONSTRAINT "FK_USUARIO_USUARIO_LOG" FOREIGN KEY ("usuario_cod") REFERENCES seguridad.USUARIO ("codigo");

/*==============================================================*/
/* Table: ROL_USUARIO                                            */
/*==============================================================*/
CREATE TABLE seguridad.ROL_USUARIO (
    usuario_cod INTEGER                             NOT NULL,
    rol_cod     INTEGER                             NOT NULL,
    fecha       TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    Primary key (usuario_cod, rol_cod)
);
COMMENT ON TABLE seguridad.ROL_USUARIO IS 'Asociación de un Rol con un usuario';

COMMENT ON COLUMN seguridad.ROL_USUARIO.usuario_cod IS 'Código de usuario';
COMMENT ON COLUMN seguridad.ROL_USUARIO.rol_cod IS 'Código del rol';
COMMENT ON COLUMN seguridad.ROL_USUARIO.fecha IS 'Fecha de asignado del rol al usuario';

ALTER TABLE seguridad.ROL_USUARIO
    ADD CONSTRAINT "FK_USUARIO_ROL_USUARIO" FOREIGN KEY ("usuario_cod") REFERENCES seguridad.USUARIO ("codigo");
ALTER TABLE seguridad.ROL_USUARIO
    ADD CONSTRAINT "FK_ROL_ROL_USUARIO" FOREIGN KEY ("rol_cod") REFERENCES seguridad.ROL ("codigo");

/*==============================================================*/
/* Table: ROL_PERMISO                                         */
/*==============================================================*/
CREATE TABLE seguridad.ROL_PERMISO (
    permiso_cod INTEGER                             NOT NULL,
    rol_cod     INTEGER                             NOT NULL,
    fecha       TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    Primary key (permiso_cod, rol_cod)
);
COMMENT ON TABLE seguridad.ROL_PERMISO IS 'Asociación de un Rol con un permiso';

COMMENT ON COLUMN seguridad.ROL_PERMISO.PERMISO_COD IS 'Código del permiso';
COMMENT ON COLUMN seguridad.ROL_PERMISO.ROL_COD IS 'Código del rol';
COMMENT ON COLUMN seguridad.ROL_PERMISO.FECHA IS 'fecha de asignación del rol al usuario';

ALTER TABLE seguridad.ROL_PERMISO
    ADD CONSTRAINT "FK_PERMISO_ROL_PERMISO" FOREIGN KEY (permiso_cod) REFERENCES seguridad.PERMISO (codigo);
ALTER TABLE seguridad.ROL_PERMISO
    ADD CONSTRAINT "FK_ROL_ROL_PERMISO" FOREIGN KEY (rol_cod) REFERENCES seguridad.ROL (codigo);

