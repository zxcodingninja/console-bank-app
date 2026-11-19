package inheritance;

public class InheritanceTester {


    static void main(String[] args) {
//        Person person = new Person();
        Employee employee = new Employee();
        Square square = new Square();
        square.setSides(4);
        square.setLength(100);
        System.out.println(square.calculatePerimeter());
    }
}
