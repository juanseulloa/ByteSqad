/*==============================================================*/
/* Table: USUARIO                                          */
/*==============================================================*/

INSERT INTO seguridad.usuario(codigo, nombre, email, password, fecha_inicio, fecha_fin, tipo)
VALUES (1, 'Federico Galeano', 'fedega@ferdr.com', 'er23fesrt43', '2018-01-1 03:56:14', '2019-05-3 03:56:14', 1),
       (2, 'Carla Garcia', 'carla@ferdr.com', 'er23fes1234', '2018-01-2 03:51:10', '2019-01-3 03:44:12', 1),
       (3, 'Maria Noria', 'maria@ferdr.com', 'er23231srt43', '2018-02-1 01:33:33', '2019-02-6 05:22:19', 1),
       (4, 'Masias Moreno', 'masiasm@ferd.com', 'er2311t43', '2018-02-3 07:56:56', '2019-06-7 06:11:22', 2),
       (5, 'Carlos Buitrago', 'carlosbb@ferdr.com', 'er23f2222t43', '2018-08-1 05:03:14', '2019-06-2 04:22:08', 2);

/*==============================================================*/
/* Table: PERMISO                                          */
/*==============================================================*/

INSERT INTO seguridad.permiso(codigo, nombre, descripcion, estado)
VALUES (1, 'NOMINA_INSERT_HV', 'permisos para ingresar una hoja de vida', 'TRUE'),
       (2, 'NOMINA_UPDATE_HV', 'permisos actualizar hoja de vida', 'TRUE'),
       (3, 'SEGURIDAD_DELETE_USER', 'permisos para eliminar a un usuario', 'TRUE'),
       (4, 'SEGURIDAD_CREATE_USER', 'permisos para crear a un usuario', 'TRUE'),
       (5, 'SEGURIDAD_READ_USER', 'permisos para visualizar datos de un usuario', 'TRUE'),
       (6, 'SEGURIDAD_UPDATE_USER', 'permisos para actualizar datos de un usuario', 'TRUE'),
       (7, 'FACTURACION_SELECT_PRODUCT', 'permisos para buscar por producto', 'TRUE'),
       (8, 'CRM_UPDATE_EVENT', 'permisos para actualizar un evento', 'TRUE');

/*==============================================================*/
/* Table: ROL                                          */
/*==============================================================*/

INSERT INTO seguridad.rol(codigo, nombre, descripcion, estado)
VALUES (1, 'Administrador', 'El administrador tiene control completo del sistema', 'TRUE'),
       (2, 'Secretari@', 'l@s secretari@s tienen control Crud a los 4 modulos ', 'TRUE'),
       (3, 'Cliente', 'El cliente puede visualizar los modulos facturación, crm y nómina', 'TRUE'),
       (4, 'Invitado', 'El invitado no tiene acceso a los módulos hasta que se halla registrado', 'TRUE');

/*==============================================================*/
/* Table: ROL_PERMISO                                          */
/*==============================================================*/

INSERT INTO seguridad.rol_permiso(permiso_cod, rol_cod, fecha)
VALUES (3, 1, '2018-01-1 09:33:11'),
       (4, 1, '2018-01-1 03:56:14'),
       (5, 1, '2018-01-1 04:14:23'),
       (6, 1, '2018-01-1 05:43:22'),
       (1, 2, '2018-01-2 01:42:11');

/*==============================================================*/
/* Table: ROL_USUARIO                                          */
/*==============================================================*/

INSERT INTO seguridad.rol_usuario(usuario_cod, rol_cod, fecha)
VALUES (1, 1, '2018-01-1 03:56:14'),
       (2, 2, '2018-01-2 14:23:12'),
       (3, 2, '2018-02-1 16:23:11'),
       (4, 3, '2018-02-3 22:13:11'),
       (5, 3, '2018-08-1 21:44:22');

/*==============================================================*/
/* Table: USUARIO_LOG                                          */
/*==============================================================*/

INSERT INTO seguridad.usuario_log(codigo, fecha, usuario_cod, proceso, dml)
VALUES (1, '2018-05-3 03:56:14', 2, 'FACTURACION_CREATE_CLIENTE', 'CREATE'),
       (2, '2018-05-1 08:22:02', 1, 'SEGURIDAD_UPDATE_USER', 'UPDATE'),
       (3, '2019-02-8 03:33:12', 3, 'NOMINA_CREATE_HV', 'CREATE'),
       (4, '2019-02-2 09:56:14', 2, 'CRM_UPDATE_EVENT', 'UPDATE'),
       (5, '2019-02-1 17:46:18', 4, 'NOMINA_READ_HV', 'READ');
