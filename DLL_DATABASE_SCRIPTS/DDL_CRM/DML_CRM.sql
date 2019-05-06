-- ********** Data Manipulation Language - Schema 'CRM' - Database 'usta_empresarial' ********** --

-- Table 'TIPO_MEDIO' | Schema 'CRM'

INSERT INTO CRM.TIPO_MEDIO (NOMBRE, DESCRIPCION, VALOR_prom, ESTADO) VALUES
    ('Medios Televisivos', 'Publicidad paga en medios de TV.', 1950000, TRUE),
    ('Estaciones de Radio', 'Pautas pagas en estaciones de radio.', 1500000, FALSE),
    ('Campañas de Google AdWords', 'Publicidad paga en páginas web con AdWords.', 2000000, TRUE),
    ('Flyers publicitarios', 'Publicidad escrita entregable.', 1000000, TRUE),
    ('Pósters y pancartas', 'Publicidad escrita', 2500000, FALSE);

-- Table 'PERIODO' | Schema 'CRM'

INSERT INTO CRM.PERIODO(FECHA_INICIO, FECHA_FIN, ESTADO) VALUES
    ('2019/03/14', '2019/05/06', TRUE),
    ('2018/08/11', '2019/01/15', FALSE),
    ('2019/04/09', '2019/06/06', TRUE),
    ('2019/03/01', '2019/06/01', TRUE),
    ('2019/05/13', '2019/07/13', FALSE);

-- Table 'CAMPANIA' | Schema 'CRM'

INSERT INTO CRM.CAMPANIA(NOMBRE, DESCRIPCION, FECHA_INICIO, FECHA_FIN, PERIODO_COD, VALOR, ESTADO) VALUES
    ('Jus Do It', 'Mensaje motivador: sólo hazlo', '2018-09-04', '2038-09-04', 1 , 10000000, TRUE),
    ('HeForShe', 'Involucrar y generar cambio a toda la sociedad, para alcanzar la igualdad de género', '2014-06-20', '2034-06-20', 3 ,30000000, TRUE),
    ('Pick Me', 'Busca generar consciencia ante la cantidad de animales que llegan a refugios para ser adoptados', '2017-05-02','2037-05-02', 4 , 8000000, TRUE),
    ('We Can Do It!', 'Incentivar las metas de las mujeres.', '1980-01-01', '2030-01-01', 1, 15000000 , TRUE),
    ('The Best Men Can Be', 'Invitación a la reflexión ante las actitudes machistas', '2019-01-13', '2039-01-13', 2, 3000000 , TRUE);

-- Table 'EVENTO' | Schema 'CRM'

INSERT INTO CRM.EVENTO (NOMBRE, DESCRIPCION, FECHA, CAMPANIA_COD, ESTADO) VALUES
    ('Medio Fisico', 'Se realizara un EVENTO donde las personas podra ir a las instalaciones y podran conocer los diferentes servicios de la empresa', '2019/04/29', 4, TRUE),
    ('Television',' Se abrira un espacion en television donde se podran conocer los diferentes servicios de la empresa', '2019/06/18', 1, TRUE),
    ('Pancartas', 'Se realizara unas pancartas donde se podran conocer los diferentes servicios de la empresa', '2019/12/20', 4, FALSE),
    ('Redes Sociales', 'Se realizara una publicidad mediante Redes sociales como instagram donde se podran conocer los diferentes servicios de la empresa', '2018/10/20', '2', FALSE),
    ('Volantes', 'Se realizará un FIN de semana donde se entregaran volantes que permitiran conocer los diferentes servicios de la empresa', '2019/04/29', 4, TRUE);

-- Table 'RECURSO' | Schema 'CRM'

INSERT INTO CRM.RECURSO(NOMBRE, TIPO, DESCRIPCION, VALOR) VALUES
    ('Salones', 1 ,'Salones necesarios para el desarrollo empresarial', 5000000),
    ('Papeleria', 2 ,'Papeleria para realizar documentacion empresarial', 1000000),
    ('Computadores', 3 ,'Computadores necesarios para el desarrollo de software', 5000000),
    ('Salones', 1 ,'Salones necesarios para desarrollar el proyecto', 5000000),
    ('personal', 5 ,'Personal necesario para el correcto funcionamiento de los departamentos de la empresa', 10000000);

-- Table 'MEDIO' | Schema 'CRM'

INSERT INTO CRM.MEDIO(NOMBRE, DESCRIPCION, TIPO_medio_COD, EVENTO_COD, RECURSO_COD, VALOR, ESTADO) VALUES 
    ('Medio Publicitario en Línea', 'Medio Publicitario', 1, 1, 1, 399403, TRUE),
    ('Medio Publicitario Escrito', 'Medio Publicitario', 2, 2, 2, 399403, FALSE),
    ('Medio Publicitario Escrito', 'Medio Publicitario', 2, 2, 3, 399403, TRUE),
    ('Medio Publicitario en TV', 'Medio Publicitario', 3, 3, 1, 399403, TRUE),
    ('Medio Publicitario en Radio', 'Medio Publicitario', 4, 2, 3, 399403, TRUE);
                                                                                                          ;