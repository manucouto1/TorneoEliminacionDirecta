CREATE TABLE `Tipo_Jugador` (
  `id` int(9) NOT NULL,
  `code` varchar(15) DEFAULT NULL,
  `name` varchar(25) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `Estado_Partido` (
  `id` int(9) NOT NULL,
  `code` varchar(15) DEFAULT NULL,
  `name` varchar(25) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `Jugador` (
  `id` int(9) NOT NULL,
  `nombre` varchar(15) DEFAULT NULL,
  `edad` int(14) DEFAULT NULL,
  `tipo_jugador_id` int(9) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `tipo_jugador_id` (`tipo_jugador_id`),
  CONSTRAINT `tipo_jugadorfk_1` FOREIGN KEY (`tipo_jugador_id`) REFERENCES `tipo_jugador` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `Partido` (
  `id` int(9) NOT NULL,
  `code` varchar(15) DEFAULT NULL,
  `jugador_local_id` int(9) DEFAULT NULL,
  `jugador_visitante_id` int(9) DEFAULT NULL,
  `jugador_ganador_id` int(9) NOT NULL,
  `estado_partido_id` int(9) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `jugador_local_id` (`jugador_local_id`),
  CONSTRAINT `jugador_localfk_1` FOREIGN KEY (`jugador_local_id`) REFERENCES `jugador` (`id`),
  KEY `jugador_visitante_id` (`jugador_visitante_id`),
  CONSTRAINT `jugador_visitantefk_1` FOREIGN KEY (`jugador_visitante_id`) REFERENCES `jugador` (`id`),
  KEY `jugador_ganado_id` (`jugador_ganador_id`),
  CONSTRAINT `jugador_ganadorfk_1` FOREIGN KEY (`jugador_ganador_id`) REFERENCES `jugador` (`id`),
  KEY `estado_partido_id` (`estado_partido_id`),
  CONSTRAINT `estado_partidofk_1` FOREIGN KEY (`estado_partido_id`) REFERENCES `estado_partido` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `Torneo` (
  `id` int(9) NOT NULL,
  `code` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `Torneo_Partido` (
  `id_torneo` int(9) NOT NULL,
  `id_partido` int(9) NOT NULL,
  PRIMARY KEY (`id_torneo`,`id_partido`),
  KEY `id_torneo` (`id_torneo`),
  CONSTRAINT `id_torneofk_1` FOREIGN KEY (`id_torneo`) REFERENCES `torneo` (`id`),
  KEY `id_partido` (`id_partido`),
  CONSTRAINT `id_partidofk_1` FOREIGN KEY (`id_partido`) REFERENCES `partido` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8





