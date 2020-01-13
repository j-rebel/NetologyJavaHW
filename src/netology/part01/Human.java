package netology.part01;

public class Human {

        public String name;
        public String sex;
        public int age;
        public Human father;
        public Human mother;

        Human(String name, String sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String getInfo() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + this.sex;
            text += ", возраст: " + this.age;
            if (this.father != null)
                text += ", отец: " + this.father.name;
            if (this.mother != null)
                text += ", мать: " + this.mother.name;
            return text;
        }
}
