import javafx.beans.binding.ObjectExpression;

import java.io.*;

/**
 * @author: alangong
 * @create: 2020-08-17 15:55
 * @description:
 **/
public class Student implements Cloneable, Serializable {
    transient String name;

    Parent parent;

    public Student(String name, Parent parent) {
        this.name = name;
        this.parent = parent;
    }

    public Object deepCopy() throws IOException, ClassNotFoundException {
        // 将对象写到流里
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        //OutputStream op = new ObjectOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(bo);
        oo.writeObject(this);

        // 从流里读出来
        InputStream bi = new ByteArrayInputStream(bo.toByteArray());
        ObjectInputStream oi = new ObjectInputStream(bi);
        return (oi.readObject());
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Parent p = new Parent("wenxia", "50");
        Student s = new Student("alangong", p);
        s.clone();
    }
}

class Parent implements Serializable{
    String name;

    String age;

    public Parent(String name, String age) {
        this.name = name;
        this.age = age;
    }
}
