package core.directory;
 
/*
1. Создать классы Собака и Кот с наследованием от класса Животное.
2. Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия. Результатом выполнения действия будет печать в консоль.
3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
4. * Добавить подсчёт созданных котов, собак и животных.
 */
 
// Класс "Животное", являющийся основой для остальных классов
 
class Animal {
    // Создаются одинаковые для всех животных параметры: Имя, дальность плавания и бега, а также количество.
    // Если дальность плавания или бега инициирована как -1 - животное может бегать/плавать неограниченно. 0 - Не умеет бегать/плавать.
 
    public String name;
    public int run_max = -1;
    public int swim_max = -1;
    public static int count = 0; // Счётчик созданных животных всего
 
    public Animal(String name) {
        this.name = name;
        count++; // При создании животного увеличиваем счётчик
    }
 
    // Методы бега и плавания, одинаковые для всех животных с проверками на возможную дальность препятствия.
    public void run(int distance) {
        if(run_max == 0) {
            System.out.println(this.name + " не может бегать.");
            return;
        }
        if(distance <= run_max || run_max == -1) {
            System.out.println(this.name + " пробежал " + distance + " метров.");
        } else {
            System.out.println(this.name + " не может столько пробежать. Его максимум: " + run_max + " метров.");
        }
    }
    public void swim(int distance) {
        if(swim_max == 0) {
            System.out.println(this.name + " не может плавать.");
            return;
        }
        if(distance <= swim_max || swim_max == -1) {
            System.out.println(this.name + " проплыл " + distance + " метров.");
        }
        else {
            System.out.println(this.name + " не может столько проплыть. Его максимум: " + swim_max + " метров.");
        }
    }
}
 
// подкласс Кот, наследуемый от класса Животное
 
class Cat extends Animal {
    // задаём свой счётчик для котов
    public static int cat_count = 0;
    public Cat(String name){
        super(name); // Вызываем конструктор родительского класса (Животное), в котором инициализируется имя и прибавляется общий счётчик для животных
        run_max = 200;
        swim_max = 0;
        cat_count++; // Прибавляем счётчик отдельно котов
    }
 
}
 
// подкласс Собака, наследуемый от класса Животное
 
class Dog extends Animal {
    // Как и в случае с котом, задаём ему персональные параметры бега и плавания, а также свой счётчик
    public static int dog_count = 0;
    public Dog(String name){
        super(name);
        run_max = 500;
        swim_max = 10;
        dog_count++;
    }
}
 
 