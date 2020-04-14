# Учебный проект Fitness club
### Дисциплина "Базы данных"
##### Лабораторная работа №5, вариант №19
\
Предметная область: "Расписание фитнес-клуба"
Программа позволяет просматривать расписание занятий, загруженность залов по дням недели и просматривать клиентов в каждой из групп (есть возможность поиска клиетнов по ФИО).
 \
 В качестве СУБД используется PostgreSQL.
 
# Тестовые данные в локальной БД

![Текущие данные в Базе данных](https://github.com/VitalyPeryatin/FitnessClub/blob/master/images/Screenshot8.png)

  - Расписание (занятия): сверху слева
  - Группы: сверху справа
  - Клиенты: снизу слева
  - Тренера: снизу справа
 
### Главный экран
![Главный экран](https://github.com/VitalyPeryatin/FitnessClub/blob/master/images/Screenshot1.png)

### Занятия
![Занятия](https://github.com/VitalyPeryatin/FitnessClub/blob/master/images/Screenshot1.png)

### Загруженность зала - зал 'Flower'
![Загруженность зала - зал 'Flower](https://github.com/VitalyPeryatin/FitnessClub/blob/master/images/Screenshot3.png)

### Загруженность зала - зал 'PingPong'
![Загруженность зала - зал 'PingPong'](https://github.com/VitalyPeryatin/FitnessClub/blob/master/images/Screenshot7.png)

### Клиенты по группам - группа 'BallroomDance'
![Клиенты по группам - группа 'BallroomDance'](https://github.com/VitalyPeryatin/FitnessClub/blob/master/images/Screenshot4.png)

### Клиенты по группам - группа 'BrakeDance'
![Клиенты по группам - группа 'BrakeDance'](https://github.com/VitalyPeryatin/FitnessClub/blob/master/images/Screenshot6.png)

### Клиенты по группам - Поиск '...Man...'
![Клиенты по группам - Поиск '...Man...'](https://github.com/VitalyPeryatin/FitnessClub/blob/master/images/Screenshot5.png)

### Необходимо для запуска
 
- JDK 11
- JavaFX 11.0.2
- СУБД PostgreSQL
- Прописать в параметрах VM: 
--module-path /Library/Java/JavaVirtualMachines/javafx-sdk-11.0.2/lib 
--add-modules=javafx.controls,javafx.fxml