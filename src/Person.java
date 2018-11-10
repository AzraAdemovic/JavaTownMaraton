public class Person {
    private  String name;
    private  double time;

    public Person () {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", time=" + time + "]";
    }
}
