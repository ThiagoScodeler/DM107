-- Database: dblogistica

CREATE TABLE IF NOT EXISTS `entregas` (
`id` integer NOT NULL auto_increment,
`numero_pedido` integer NOT NULL,
`id_cliente` integer NOT NULL,
`nome_recebedor` varchar(100) NOT NULL default '',
`cpf_recebedor` varchar(20) NOT NULL default '',
`data_hora_entrega` datetime default NULL,
PRIMARY KEY (`id`)
);

CREATE USER 'adminlogistica'@'localhost' IDENTIFIED BY 'adminlogistica';
GRANT ALL PRIVILEGES ON dblogistica.* TO 'adminlogistica'@'localhost';

INSERT INTO `entregas` (`id`, `numero_pedido`, `id_cliente`, `nome_recebedor`, `cpf_recebedor`, `data_hora_entrega`) VALUES
(1, 10, 1010, 'Thiago Scodeler', '09678554646', '2017-11-13 00:00:00'),
(2, 20, 2020, 'Camila Borges', '15379046379', '2017-11-23 00:00:00'),
(3, 30, 3030, 'Maria Antonia', '23577941034', '2017-11-20 00:00:00'),
(4, 40, 4040, 'Marcelo Carlos', '9874601234', '2017-11-02 00:00:00'),
(5, 50, 5050, 'Paulo Cesar', '78941201454', '2017-11-12 00:00:00');


CREATE TABLE IF NOT EXISTS `usuario` (
`id` integer NOT NULL auto_increment,
`usuario` varchar(100) NOT NULL default '',
`senha` varchar(20) NOT NULL default '',
PRIMARY KEY (`id`)
);

INSERT INTO `usuario` (`id`, `usuario`, `senha`) VALUES
(1, 'admin', 'admin'),
(2, 'thiago', 'thiago'),
(3, 'daniela', 'daniela');