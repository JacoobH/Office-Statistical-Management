CREATE DATABASE  IF NOT EXISTS `xzldbgstjglxt` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `xzldbgstjglxt`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: xzldbgstjglxt
-- ------------------------------------------------------
-- Server version	5.7.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Temporary view structure for view `possession_num`
--

DROP TABLE IF EXISTS `possession_num`;
/*!50001 DROP VIEW IF EXISTS `possession_num`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `possession_num` AS SELECT 
 1 AS `com_name`,
 1 AS `room_num`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `possession_num`
--

/*!50001 DROP VIEW IF EXISTS `possession_num`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `possession_num` AS select `company_info`.`com_name` AS `com_name`,count(`room`.`off_id`) AS `room_num` from (`room` left join `company_info` on((`company_info`.`com_name` = `room`.`com_name`))) group by `company_info`.`com_name` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Dumping routines for database 'xzldbgstjglxt'
--
/*!50003 DROP PROCEDURE IF EXISTS `process_pay` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `process_pay`(
	IN cname varchar(20),
    OUT total_pay FLOAT
)
BEGIN
	DECLARE id DECIMAL(4,0);
	DECLARE pay_flag BOOLEAN DEFAULT 0;-- 检查是否需要缴费
	DECLARE done BOOLEAN DEFAULT 0;-- 循环变量
    DECLARE total FLOAT DEFAULT 0;
    
    DECLARE pay_flags CURSOR
    FOR
    SELECT room.off_id,room.off_situation
    FROM room
    WHERE room.com_name = cname;
    
    DECLARE CONTINUE HANDLER FOR SQLSTATE '02000' SET done=1;
    
    OPEN pay_flags;
    
    REPEAT
		FETCH pay_flags INTO id,pay_flag;
        IF (pay_flag && done = 0) THEN
			SELECT total +
            (
				SELECT room.off_money 
				FROM room
				WHERE room.off_id = id
            )
            INTO total;
		END IF;
    UNTIL done END REPEAT;
	
    CLOSE pay_flags;
    
SELECT total INTO total_pay;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-06 16:30:26
