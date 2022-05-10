
CREATE TABLE `employee` (
  `id` int(10) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `email` varchar(100) NOT NULL,
  `user_role` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `employee` (`id`, `first_name`, `last_name`, `email`, `user_role`, `password`) VALUES
(10, 'kavindi', 'gayaththri', 'kavindhigayaththri@gmail.com', 'admin', 'kavindi123'),
(11, 'hiruni', 'apsara', 'kavindhigayaththri@gmail.com', 'registercustomer', '123'),
(12, 'koltha', 'kasun', 'kolithakasun@gmail.com', 'registerresearch', 'k123');

ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `employee`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

