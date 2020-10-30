package test;

class ThisEscapeSon extends ThisEscape {
    private final String name;

    public ThisEscapeSon() {
        this.name = "Hello Word";
        System.out.println("ThisEscapeSon");
    }

    public ThisEscapeSon(String name) {
        this.name = name;
        System.out.println("ThisEscapeSon");
    }

    /*
     * 在子类中重写Say方法
     */
    @Override
    public void Say() {
        System.out.println("ThisEscapeSon.Say()-->" + name);
    }
}