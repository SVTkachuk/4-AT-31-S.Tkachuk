package case_4.Reflections;

public class Human {
    private Integer humanId;
    private String name;
    private Integer age;

    public Human(int humanId, String name, int age) {
        this.humanId = humanId;
        this.name = name;
        this.age = age;
    }

    public Integer getHumanId() {
        return humanId;
    }

    public void setHumanId(Integer humanId) {
        this.humanId = humanId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Human{" +
                "humanId=" + humanId +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
