/** Homework for Lesson 5. Using class (incapsulation)
 *
 * @author: Dmitry Zhuravlev
 * @version 1.0, date 06.12.2017
 * @link to github: https://github.com/Burgomistr/git
 */
class FifthLesson {

    public static void main (String[] args) {
        Person[] persArray = new Person[5];
        //Array initialization
        persArray[0] = new Person("Ivan Ivanov", "CEO", "ivan@gmail.com", "+7 (925) 555-55-55", 100000, 45);
        persArray[1] = new Person("Petr Petrov", "CEO's Friend", "petr@gmail.com", "+7 (925) 333-33-33", 80000, 33);
        persArray[2] = new Person("Sidor Sidorov", "CEO's Brother", "sidor@gmail.com", "+7 (977) 777-77-77", 900000, 39);
        persArray[3] = new Person("Michael Jackson", "CEO's singer", "misha@gmail.com", "+7 (925) 700-00-00", 50000, 60);
        persArray[4] = new Person("Little constructor", 100);
        //Checking the private "name"
        persArray[0].setName("Mr. Put In");
        //Checking the simple aasignment
        persArray[0].position = "USA clown";
        //The first way to see objects, where age > 40. The result will be printed under the line "--------------"
        System.out.println("----------------------");
        for (int i = 0; i < 5; i++)
            if (persArray[i].age > 40)
                System.out.println(persArray[i].getName() + " " + persArray[i].position + " " + persArray[i].email + " " + persArray[i].phone + " " + persArray[i].salary + " " + persArray[i].age);
    }
}

class Person{
    private String name;
    String position;
    String email;
    String phone;
    int salary;
    int age;
    //'Setter' only for one field
    public void setName(String name){
        this.name = name;
    }
    //'Getter' only for one field
    public String getName(){
        return name;
    }
    //"Little" constructor. It's result will be shown under the line "-------" with 'null' elements.
    Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    //"Full" constructor
    Person(String name, String position, String email, String phone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
        //The second way to see objects, where age > 40, using the constructor. It'll be the 1st result in console.
        //persArray[4] will not be printed by this constructor ("Short" array element).
        if (this.age > 40)
            System.out.println(name + " " + position + " " + email + " " + phone + " " + salary + " " + age);

    }
}

