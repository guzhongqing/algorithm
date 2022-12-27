package EntityClass;

public class Student {
    public int age;
    public String name;

    public Student() {
    }

    public Student(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public void setInfo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "{name=" + name + ",age=" + age + '}';
    }
}
