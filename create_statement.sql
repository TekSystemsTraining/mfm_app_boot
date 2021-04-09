-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.5.8-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.2.0.6213
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Dumping structure for table mfm_db.exercises
CREATE TABLE IF NOT EXISTS `exercises` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `primary_bodypart` varchar(255) DEFAULT NULL,
  `secondary_bodypart` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_c514au7a6fgk8ahyfws1y84jm` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=741261 DEFAULT CHARSET=latin1;

-- Dumping data for table mfm_db.exercises: ~6 rows (approximately)
/*!40000 ALTER TABLE `exercises` DISABLE KEYS */;
INSERT INTO `exercises` (`id`, `name`, `primary_bodypart`, `secondary_bodypart`) VALUES
	(30, 'cable crossover', 'chest', 'hamstrings'),
	(32, 'dips', 'chest', 'triceps'),
	(147852, 'bench press', 'chest', 'triceps'),
	(258741, 'seated row', 'back', 'biceps'),
	(369852, 'squat', 'legs', 'quads'),
	(741258, 'deadlift', 'legs', 'hamstrings');
/*!40000 ALTER TABLE `exercises` ENABLE KEYS */;

-- Dumping structure for table mfm_db.hibernate_sequence
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_not_cached_value` bigint(21) NOT NULL,
  `minimum_value` bigint(21) NOT NULL,
  `maximum_value` bigint(21) NOT NULL,
  `start_value` bigint(21) NOT NULL COMMENT 'start value when sequences is created or value if RESTART is used',
  `increment` bigint(21) NOT NULL COMMENT 'increment value',
  `cache_size` bigint(21) unsigned NOT NULL,
  `cycle_option` tinyint(1) unsigned NOT NULL COMMENT '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
  `cycle_count` bigint(21) NOT NULL COMMENT 'How many cycles have been done'
) ENGINE=InnoDB SEQUENCE=1;

-- Dumping data for table mfm_db.hibernate_sequence: ~1 rows (approximately)
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` (`next_not_cached_value`, `minimum_value`, `maximum_value`, `start_value`, `increment`, `cache_size`, `cycle_option`, `cycle_count`) VALUES
	(1001, 1, 9223372036854775806, 1, 1, 1000, 0, 0);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;

-- Dumping structure for table mfm_db.primary_bodypart_list
CREATE TABLE IF NOT EXISTS `primary_bodypart_list` (
  `id` bigint(20) NOT NULL,
  `primary_bodypart` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table mfm_db.primary_bodypart_list: ~3 rows (approximately)
/*!40000 ALTER TABLE `primary_bodypart_list` DISABLE KEYS */;
INSERT INTO `primary_bodypart_list` (`id`, `primary_bodypart`) VALUES
	(66, 'chest'),
	(77, 'back'),
	(88, 'legs');
/*!40000 ALTER TABLE `primary_bodypart_list` ENABLE KEYS */;

-- Dumping structure for table mfm_db.secondary_bodypart_list
CREATE TABLE IF NOT EXISTS `secondary_bodypart_list` (
  `id` bigint(20) NOT NULL,
  `secondary_bodypart` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table mfm_db.secondary_bodypart_list: ~4 rows (approximately)
/*!40000 ALTER TABLE `secondary_bodypart_list` DISABLE KEYS */;
INSERT INTO `secondary_bodypart_list` (`id`, `secondary_bodypart`) VALUES
	(99, 'triceps'),
	(101, 'biceps'),
	(111, 'quads'),
	(122, 'hamstrings');
/*!40000 ALTER TABLE `secondary_bodypart_list` ENABLE KEYS */;

-- Dumping structure for table mfm_db.users
CREATE TABLE IF NOT EXISTS `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `primary_bodypart_array` tinyblob DEFAULT NULL,
  `secondary_bodypart_array` tinyblob DEFAULT NULL,
  `total_weight_lifted` double DEFAULT NULL,
  `total_workouts` int(11) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table mfm_db.users: ~1 rows (approximately)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`username`, `password`, `primary_bodypart_array`, `secondary_bodypart_array`, `total_weight_lifted`, `total_workouts`) VALUES
	('adam', 'a', NULL, NULL, 432, 1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

-- Dumping structure for table mfm_db.users_workouts_completed
CREATE TABLE IF NOT EXISTS `users_workouts_completed` (
  `user_username` varchar(50) NOT NULL,
  `workouts_completed_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_df64halywyutwv3dks3dfw9e0` (`workouts_completed_id`),
  KEY `FKlq0arpawncatjmrl3ucq5gopg` (`user_username`),
  CONSTRAINT `FK3mcl74k8t6vpib3a9ea6w04w6` FOREIGN KEY (`workouts_completed_id`) REFERENCES `workouts` (`id`),
  CONSTRAINT `FKlq0arpawncatjmrl3ucq5gopg` FOREIGN KEY (`user_username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table mfm_db.users_workouts_completed: ~1 rows (approximately)
/*!40000 ALTER TABLE `users_workouts_completed` DISABLE KEYS */;
INSERT INTO `users_workouts_completed` (`user_username`, `workouts_completed_id`) VALUES
	('adam', 1);
/*!40000 ALTER TABLE `users_workouts_completed` ENABLE KEYS */;

-- Dumping structure for table mfm_db.workouts
CREATE TABLE IF NOT EXISTS `workouts` (
  `id` bigint(20) NOT NULL,
  `date` datetime(6) DEFAULT NULL,
  `exercise_one_completed` varchar(255) DEFAULT NULL,
  `exercise_three_completed` varchar(255) DEFAULT NULL,
  `exercise_two_completed` varchar(255) DEFAULT NULL,
  `total_weight_lifted` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table mfm_db.workouts: ~2 rows (approximately)
/*!40000 ALTER TABLE `workouts` DISABLE KEYS */;
INSERT INTO `workouts` (`id`, `date`, `exercise_one_completed`, `exercise_three_completed`, `exercise_two_completed`, `total_weight_lifted`) VALUES
	(1, '2021-04-09 14:29:30.891000', '', '', '', 432),
	(2, '2021-04-09 14:31:16.003000', '', '', '', 432);
/*!40000 ALTER TABLE `workouts` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
