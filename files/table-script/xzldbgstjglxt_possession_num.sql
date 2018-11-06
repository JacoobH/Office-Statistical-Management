CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `possession_num` AS
    SELECT 
        `company_info`.`com_name` AS `com_name`,
        COUNT(`room`.`off_id`) AS `room_num`
    FROM
        (`room`
        LEFT JOIN `company_info` ON ((`company_info`.`com_name` = `room`.`com_name`)))
    GROUP BY `company_info`.`com_name`