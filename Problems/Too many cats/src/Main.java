class Cat {

    //Static
    public static int counter = 0;

    //Instance
    private final String name;
    private final int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;

        if (++counter > 5) {
            System.out.println("You have too many cats");
        }

        getNumberOfCats();
    }

    public static int getNumberOfCats() {
        return counter;
    }
}